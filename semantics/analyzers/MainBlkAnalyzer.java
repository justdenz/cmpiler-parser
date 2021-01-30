package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import model.CUSTOMParser.MainBlockContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;
import model.CUSTOMParser.CompoundStatementContext;;


public class MainBlkAnalyzer implements ParseTreeListener{
  public MainBlkAnalyzer(){}

  public void analyze(MainBlockContext ctx){
    ParseTreeWalker treeWalker = new ParseTreeWalker();
    treeWalker.walk(this, ctx);
  }

  @Override
  public void enterEveryRule(ParserRuleContext ctx) {
    if(ctx instanceof CompoundStatementContext){
      System.out.println("Opened Main Scope");
      CompoundStatementContext compoundCtx = (CompoundStatementContext) ctx;
      CompStmtAnalyzer compoundStmtAnalyzer = new CompStmtAnalyzer();
      compoundStmtAnalyzer.analyze(compoundCtx);
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
