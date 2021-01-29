package semantics.analyzers;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import model.CUSTOMParser.FuncBlockContext;
import model.CUSTOMParser.MainBlockContext;
import model.CUSTOMParser.ProgramContext;
import semantics.symboltable.GlobalScopeManager;

public class ProgramAnalyzer implements ParseTreeListener{
    
    public ProgramAnalyzer() {}

    public void analyze(ProgramContext ctx) {
		GlobalScopeManager.getInstance();
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
			FuncBlockContext funcCtx = (FuncBlockContext) ctx;
			FuncBlkAnalyzer funcAnalyzer = new FuncBlkAnalyzer();
			funcAnalyzer.analyze(funcCtx);
        } else if(ctx instanceof MainBlockContext) {
			MainBlockContext mainCtx = (MainBlockContext) ctx;
			MainBlkAnalyzer mainAnalyzer = new MainBlkAnalyzer();
			mainAnalyzer.analyze(mainCtx);
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
}
