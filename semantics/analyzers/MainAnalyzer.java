package semantics.analyzers;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.FuncBlockContext;
import model.CUSTOMParser.ProgramContext;
import semantics.representations.CstmValue;
import semantics.representations.CstmFunction;
import semantics.symboltable.CstmSymbolTable;
import semantics.symboltable.scopes.CstmClassScope;
import semantics.symboltable.scopes.CstmLocalScope;
import semantics.symboltable.scopes.CstmLocalScopeCreator;

public class MainAnalyzer implements ParseTreeListener{
    
    public MainAnalyzer() {}

    public void analyze(ProgramContext ctx) {
		CstmClassScope classScope = CstmSymbolTable.getInstance().getClassScope();
        CstmLocalScope localScope = CstmLocalScopeCreator.getInstance().openLocalScope();
        localScope.setParent(classScope);
        classScope.setParentLocalScope(localScope);
			
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, ctx);
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
		if(ctx instanceof FuncBlockContext) {
			CompoundStatementContext blockCtx = ((FuncBlockContext) ctx).compoundStatement();
			BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
			blockAnalyzer.analyze(blockCtx);
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
}
