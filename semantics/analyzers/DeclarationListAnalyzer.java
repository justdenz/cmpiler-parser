package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import console.Console;
import builder.errorcheckers.CstmMulVarDecChecker;
import builder.errorcheckers.CstmTypeChecker;
import semantics.utils.CstmIdentifiedTokens;
import model.CUSTOMParser.DeclarationContext;
import model.CUSTOMParser.ExpressionContext;
import model.CUSTOMParser.VariableDeclarationContext;
import model.CUSTOMParser.ArrayDeclarationContext;
import model.CUSTOMParser.ConstantContext;
import semantics.utils.CstmKeywords;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;
import semantics.representations.CstmValue;

public class DeclarationListAnalyzer implements ParseTreeListener{
	
	public DeclarationListAnalyzer() {}
	
	public void analyze(DeclarationContext decListCtx) {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, decListCtx);
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		if(ctx instanceof DeclarationContext){
			DeclarationContext decCtx = (DeclarationContext) ctx;

			// check muna if may multiple declaration ng var or array

			if(ctx instanceof ArrayDeclarationContext){
				ArrayDeclarationContext arrDecCtx = (ArrayDeclarationContext) ctx;
				//ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(this.identifiedTokens, GlobalScopeManager.getInstance().getCurrentScope());
				//arrayAnalyzer.analyze(ctx.getParent());
			}
        else if(ctx instanceof VariableDeclarationContext){

        }
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
