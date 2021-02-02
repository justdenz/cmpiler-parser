package semantics.analyzers;

import model.CUSTOMParser.PrintStatementListContext;
import semantics.symboltable.GlobalScopeManager;
import execution.ExecutionManager;
import execution.StmtCmdTracker;
import execution.commands.PrintCommand;
import execution.commands.SelectCommandInterface;

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

        if(StmtCmdTracker.getInstance().isSelectionCommand()){
          SelectCommandInterface ifCommand = (SelectCommandInterface) StmtCmdTracker.getInstance().getActiveCommand();

          if(StmtCmdTracker.getInstance().isInsideIf()){
            ifCommand.addIfCommand(printCmd);
          } else {
            ExecutionManager.getInstance().addCommand(printCmd);
          }
        }
      }
    }
  }
}
