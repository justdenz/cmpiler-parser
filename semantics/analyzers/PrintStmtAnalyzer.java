package semantics.analyzers;

import model.CUSTOMParser.PrintStatementListContext;
import semantics.symboltable.GlobalScopeManager;
import builder.errorcheckers.CstmUnDecChecker;
import execution.ExecutionManager;
import execution.commands.PrintCommand;

public class PrintStmtAnalyzer {
  public void analyze(PrintStatementListContext ctx){
    if(ctx instanceof PrintStatementListContext){

      if(ctx.printParameters() != null){
        PrintCommand printCmd = new PrintCommand(ctx);
        if(GlobalScopeManager.getInstance().getIsInFunction()){
          String currentFunctionName = GlobalScopeManager.getInstance().getCurrentFunctionName();
          GlobalScopeManager.getInstance().getFunction(currentFunctionName).addCommand(printCmd);
        } else {
          ExecutionManager.getInstance().addCommand(printCmd);
        }
      }
    }
  }
}
