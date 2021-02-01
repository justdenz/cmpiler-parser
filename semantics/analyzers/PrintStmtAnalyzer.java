package semantics.analyzers;

import model.CUSTOMParser.PrintStatementListContext;
import semantics.symboltable.GlobalScopeManager;
import execution.ExecutionManager;
import execution.commands.PrintCommand;

public class PrintStmtAnalyzer implements AnalyzerInterface{

  private PrintStatementListContext ctx;

  public PrintStmtAnalyzer(PrintStatementListContext ctx){
    this.ctx = ctx;
  }

  @Override
  public void analyze(){
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
