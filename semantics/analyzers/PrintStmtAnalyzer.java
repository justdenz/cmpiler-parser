package semantics.analyzers;

import model.CUSTOMParser.PrintStatementListContext;
import semantics.symboltable.GlobalScopeManager;
import execution.ExecutionManager;
import execution.StmtCmdTracker;
import execution.commands.CommandInterface;
import execution.commands.IterCommandInterface;
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
        addCommand(printCmd);
      }

    }
  }

  public void addCommand(CommandInterface command){
    StmtCmdTracker stmtCmdTracker = StmtCmdTracker.getInstance();

    if (stmtCmdTracker.isSelectionCommand()) {
      SelectCommandInterface ifCommand = (SelectCommandInterface) stmtCmdTracker.getActiveCommand();

      if (stmtCmdTracker.isInsideIf()) {
        ifCommand.addIfCommand(command);
      } else {
        ifCommand.addElseCommand(command);
      } 

  } else if (stmtCmdTracker.isIterationCommand()) {
      IterCommandInterface iterationCommand = (IterCommandInterface) stmtCmdTracker.getActiveCommand();
      iterationCommand.addCommand(command);
  }  else {
      ExecutionManager.getInstance().addCommand(command);
  }
  }
}
