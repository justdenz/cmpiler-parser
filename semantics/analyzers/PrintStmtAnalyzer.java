package semantics.analyzers;

import model.CUSTOMParser.PrintStatementListContext;
import builder.errorcheckers.CstmUnDecChecker;

public class PrintStmtAnalyzer {
  public void analyze(PrintStatementListContext ctx){
    if(ctx instanceof PrintStatementListContext){

      if(ctx.printParameters() != null){
        CstmUnDecChecker unDecChecker = new CstmUnDecChecker(ctx.printParameters().simpleExpression());
        unDecChecker.verify();
      
      }
    }
  }
}