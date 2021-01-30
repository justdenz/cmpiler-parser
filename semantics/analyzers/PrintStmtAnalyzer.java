package semantics.analyzers;

import model.CUSTOMParser.PrintStatementListContext;
import builder.errorcheckers.CstmUnDecChecker;
import execution.ExecutionManager;
import execution.commands.PrintCommand;

public class PrintStmtAnalyzer {
  public void analyze(PrintStatementListContext ctx){
    if(ctx instanceof PrintStatementListContext){

      if(ctx.printParameters() != null){
        CstmUnDecChecker unDecChecker = new CstmUnDecChecker(ctx.printParameters().simpleExpression());
        unDecChecker.verify();
        PrintCommand printCmd = new PrintCommand(ctx);
        ExecutionManager.getInstance().addCommand(printCmd);
      }
    }
  }
}
