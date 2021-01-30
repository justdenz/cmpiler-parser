package builder.errorcheckers;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import console.Console;
import model.CUSTOMParser.ArrayDeclarationInitializeContext;
import model.CUSTOMParser.DeclarationContext;
import model.CUSTOMParser.VariableDeclarationInitializeContext;
import semantics.representations.CstmValue;
import semantics.representations.CstmFunction;
import semantics.symboltable.GlobalScopeManager;

public class CstmMulVarDecChecker implements CstmErrCheckerInterface, ParseTreeListener{
    
    private DeclarationContext decCtx;
    private int lineNumber;
    
    public CstmMulVarDecChecker(DeclarationContext decCtx){
        this.decCtx = decCtx;
		Token firstToken = this.decCtx.getStart();
		this.lineNumber = firstToken.getLine();
    }

    @Override
	public void verify() {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, this.decCtx);
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		if(ctx instanceof VariableDeclarationInitializeContext) {
			VariableDeclarationInitializeContext varDecCtx = (VariableDeclarationInitializeContext) ctx;
			if(GlobalScopeManager.getInstance().searchScopedVariable(varDecCtx.IDENTIFIER().getText()) != null){
				Console.log(String.valueOf(this.lineNumber) , "Found multiple variable declaration");
			}

		} else if(ctx instanceof ArrayDeclarationInitializeContext) {
			ArrayDeclarationInitializeContext arrDecCtx = (ArrayDeclarationInitializeContext) ctx;
			if(GlobalScopeManager.getInstance().searchScopedVariable(arrDecCtx.IDENTIFIER().getText()) != null){
				Console.log(String.valueOf(this.lineNumber) , "Found multiple array declaration");
			}
		}
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
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
}
