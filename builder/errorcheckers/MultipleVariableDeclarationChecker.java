package builder.errorcheckers;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import builder.BuildChecker;
import builder.ErrorRepository;
import model.CUSTOMParser.VariableDeclarationContext;
import semantics.representations.Value;
import semantics.representations.Function;
import semantics.symboltable.SymbolTable;
import semantics.symboltable.scopes.ClassScope;
import semantics.symboltable.scopes.LocalScopeCreator;

public class MultipleVariableDeclarationChecker implements ErrorCheckerInterface, ParseTreeListener{
    
    private VariableDeclarationContext varDecCtx;
    private int lineNumber;
    
    public MultipleVariableDeclarationChecker(VariableDeclarationContext varDecCtx){
        this.varDecCtx = varDecCtx;
		
		Token firstToken = this.varDecCtx.getStart();
		this.lineNumber = firstToken.getLine();
    }

    @Override
	public void verify() {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, this.varDecCtx);
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		if(ctx instanceof VariableDeclarationContext) {
			VariableDeclarationContext varDecCtx = (VariableDeclarationContext) ctx;
			this.verifyVariableOrConst(varDecCtx.getText());
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
	
	private void verifyVariableOrConst(String identifierString) {
		Value mobiValue = null;
		
		// if(ExecutionManager.getInstance().isInFunctionExecution()) {
		// 	Function function = ExecutionManager.getInstance().getCurrentFunction();
		// 	mobiValue = VariableSearcher.searchVariableInFunction(function, identifierString);
		// }
		
		//if after function finding, mobi value is still null, search local scope
		if(mobiValue == null) {
			mobiValue = LocalScopeCreator.searchVariableInLocalIterative(identifierString, LocalScopeCreator.getInstance().getActiveLocalScope());
		}
		
		//if mobi value is still null, search class
		// if(mobiValue == null) {
		// 	ClassScope classScope = SymbolTable.getInstance().getClassScope();
		// 	mobiValue = VariableSearcher.searchVariableInClass(classScope, identifierString);
		// }
		
		if(mobiValue != null) {
			BuildChecker.reportCustomError(ErrorRepository.MULTIPLE_VARIABLE, "", identifierString, this.lineNumber);
		}
	}
}
