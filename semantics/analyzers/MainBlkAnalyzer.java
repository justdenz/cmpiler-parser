package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import model.CUSTOMParser.MainBlockContext;
import model.CUSTOMParser.CompoundStatementContext;;


public class MainBlkAnalyzer implements ParseTreeListener{
  public MainBlkAnalyzer(){

  }

  public void analyze(MainBlockContext ctx){

    ParseTreeWalker treeWalker = new ParseTreeWalker();
    treeWalker.walk(this, ctx);
  
  }

  @Override
  public void enterEveryRule(ParserRuleContext ctx) {
    if(ctx instanceof CompoundStatementContext){
      CompoundStatementContext compoundCtx = (CompoundStatementContext) ctx;
			if(compoundCtx.compoundStatementList() != null){
				CompoundStatementAnalyzer compoundStmtAnalyzer = new CompoundStatementAnalyzer();
				compoundStmtAnalyzer.analyze(compoundCtx);
			}
    }
    
  }

  @Override
  public void exitEveryRule(ParserRuleContext arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void visitErrorNode(ErrorNode arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void visitTerminal(TerminalNode arg0) {
    // TODO Auto-generated method stub
    
  }

}
