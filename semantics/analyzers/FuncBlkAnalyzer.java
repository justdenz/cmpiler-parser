package semantics.analyzers;

import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

import builder.errorcheckers.CstmMulFuncDecChecker;
import console.Console;
import execution.ExecutionManager;
import execution.FuncReturnTracker;
import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.FuncBlockContext;
import model.CUSTOMParser.ParamsContext;
import model.CUSTOMParser.TypeSpecifierContext;
import semantics.representations.CstmFunction;
import semantics.representations.CstmFunction.FunctionType;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class FuncBlkAnalyzer implements AnalyzerInterface, ParseTreeListener{

	private FuncBlockContext ctx;
	private CstmFunction function = new CstmFunction();
	private boolean opened = false;

  public FuncBlkAnalyzer(FuncBlockContext ctx) {
		this.ctx = ctx;
	}
	
	@Override
	public void analyze() {
		CstmMulFuncDecChecker mulFuncChecker = new CstmMulFuncDecChecker(ctx);
		mulFuncChecker.verify();

		function.setFunctionName(ctx.IDENTIFIER().getText());
		
		if(ctx.funcTypeSpecifier().typeSpecifier() != null){
			TypeSpecifierContext typeSpecifier = ctx.funcTypeSpecifier().typeSpecifier();
			if (typeSpecifier.Int() != null){
					function.setReturnType(FunctionType.INT_TYPE);
			} else if (typeSpecifier.Boolean() != null){
					function.setReturnType(FunctionType.BOOLEAN_TYPE);
			} else if (typeSpecifier.String() != null){
					function.setReturnType(FunctionType.STRING_TYPE);
			} else if (typeSpecifier.Float() != null){
					function.setReturnType(FunctionType.FLOAT_TYPE);
			}
		} else if(ctx.funcTypeSpecifier().arrayTypeSpecifier() != null){
			TypeSpecifierContext arrayTypeSpecifier = ctx.funcTypeSpecifier().arrayTypeSpecifier().typeSpecifier();
			boolean isArray = true;
			if (arrayTypeSpecifier.Int() != null){
					function.setReturnType(FunctionType.INT_TYPE, isArray);
			} else if (arrayTypeSpecifier.Boolean() != null){
					function.setReturnType(FunctionType.BOOLEAN_TYPE, isArray);
			} else if (arrayTypeSpecifier.String() != null){
					function.setReturnType(FunctionType.STRING_TYPE, isArray);
			} else if (arrayTypeSpecifier.Float() != null){
					function.setReturnType(FunctionType.FLOAT_TYPE, isArray);
			}
		} else if(ctx.funcTypeSpecifier().getText() == "void"){
			function.setReturnType(FunctionType.VOID_TYPE);
		}

		GlobalScopeManager.getInstance().addFunction(function.getFunctionName(), function);
		
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(this, ctx);
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
    if(ctx instanceof ParamsContext){
			ParamsContext paramCtx = (ParamsContext) ctx;

			function.getFunctionLocalScope().setParent(GlobalScopeManager.getInstance().getCurrentScope());
			GlobalScopeManager.getInstance().setCurrentScope(function.getFunctionLocalScope());

			if(paramCtx.paramList() != null){
				ParamsAnalyzer paramsAnalyzer = new ParamsAnalyzer(this.function);
				paramsAnalyzer.analyze(paramCtx.paramList());
			}

		} else if (ctx instanceof CompoundStatementContext && !opened){
			opened = true;

			ExecutionManager.getInstance().enterFunction(function);
			FuncReturnTracker.getInstance().setCurFunction(function);

			CompoundStatementContext compoundCtx = (CompoundStatementContext) ctx;

			CompStmtAnalyzer compoundStmtAnalyzer = new CompStmtAnalyzer(compoundCtx);
			compoundStmtAnalyzer.analyze();
			
			if(!FuncReturnTracker.getInstance().funcHasReturned() && function.getReturnType() != FunctionType.VOID_TYPE){
				Console.log(String.valueOf(compoundCtx.getStart().getLine()), "Found a missing return value for this function.");
			}

			ExecutionManager.getInstance().exitFunction();
			FuncReturnTracker.getInstance().reset();
		}
	}

    @Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}

    @Override
	public void visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub
		
	}
}
