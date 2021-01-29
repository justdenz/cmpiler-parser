package semantics.analyzers;

import model.CUSTOMParser.PrintStatementListContext;
import builder.errorcheckers.CstmUnDecChecker;

public class PrintStatementAnalyzer {
  public void analyze(PrintStatementListContext ctx){
    if(ctx instanceof PrintStatementListContext){

      if(ctx.simpleExpression() != null){
        System.out.println("simpleExpression");
        CstmUnDecChecker unDecChecker = new CstmUnDecChecker(ctx.simpleExpression());
        unDecChecker.verify();
      
      } else if(ctx.printStatementList().simpleExpression() != null){
        System.out.println("printlist + simpleExpression");
        CstmUnDecChecker unDecChecker = new CstmUnDecChecker(ctx.printStatementList().simpleExpression());
        unDecChecker.verify();
      } 
    }
  }
}
