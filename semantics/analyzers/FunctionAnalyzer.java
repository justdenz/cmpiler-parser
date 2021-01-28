package semantics.analyzers;

import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

import builder.errorcheckers.CstmMulFuncDecChecker;
import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.FuncBlockContext;
import model.CUSTOMParser.ParamsContext;
import model.CUSTOMParser.TypeSpecifierContext;
import semantics.representations.CstmFunction;
import semantics.representations.CstmFunction.FunctionType;

public class FunctionAnalyzer implements ParseTreeListener{

	private CstmFunction function = new CstmFunction();

    public FunctionAnalyzer() {}
	
	public void analyze(FuncBlockContext ctx) {
		
		CstmMulFuncDecChecker mulFuncChecker = new CstmMulFuncDecChecker(ctx);
		mulFuncChecker.verify();

		function.setFunctionName(ctx.IDENTIFIER().getText());
		
		if(ctx.funcTypeSpecifier().typeSpecifier() != null){
			TypeSpecifierContext typeSpecifier = ctx.funcTypeSpecifier().typeSpecifier();
			if (typeSpecifier.Int()!= null){
                function.setReturnType(FunctionType.INT_TYPE);
            } else if (typeSpecifier.Boolean()!= null){
                function.setReturnType(FunctionType.BOOLEAN_TYPE);
            } else if (typeSpecifier.String()!= null){
                function.setReturnType(FunctionType.STRING_TYPE);
            } else if (typeSpecifier.Float()!= null){
                function.setReturnType(FunctionType.FLOAT_TYPE);
            }
		} else if(ctx.funcTypeSpecifier().arrayTypeSpecifier() != null){
			TypeSpecifierContext arrayTypeSpecifier = ctx.funcTypeSpecifier().arrayTypeSpecifier().typeSpecifier();
			if (arrayTypeSpecifier.Int()!= null){
                function.setReturnType(FunctionType.INT_TYPE);
            } else if (arrayTypeSpecifier.Boolean()!= null){
                function.setReturnType(FunctionType.BOOLEAN_TYPE);
            } else if (arrayTypeSpecifier.String()!= null){
                function.setReturnType(FunctionType.STRING_TYPE);
            } else if (arrayTypeSpecifier.Float()!= null){
                function.setReturnType(FunctionType.FLOAT_TYPE);
            }
		}
		
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, ctx);
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
        if(ctx instanceof ParamsContext){
			ParamsContext paramCtx = (ParamsContext) ctx;
			ParamsAnalyzer paramsAnalyzer = new ParamsAnalyzer(this.function);
			paramsAnalyzer.analyze(paramCtx.paramList());
		}
		else if (ctx instanceof CompoundStatementContext){
			// compound statement analyzer
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
