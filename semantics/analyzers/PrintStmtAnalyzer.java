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
        ExecutionManager.getInstance().addCommand(printCmd);
      }
    }
  }
}
