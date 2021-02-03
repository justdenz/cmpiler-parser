package semantics.analyzers;

import builder.errorcheckers.CstmUnDecChecker;
import execution.StmtCmdTracker;
import execution.commands.ConditionalCommand;
import model.CUSTOMParser.SelectionStatementContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class SelectionAnalyzer implements AnalyzerInterface{

  private SelectionStatementContext selectStmtCtx;

  public SelectionAnalyzer(SelectionStatementContext selectStmtCtx){
    this.selectStmtCtx = selectStmtCtx;
  }

  @Override
  public void analyze() {
    CstmUnDecChecker undecChecker = new CstmUnDecChecker(selectStmtCtx.simpleExpression());
    undecChecker.verify();

    CstmLocalScope ifScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
    GlobalScopeManager.getInstance().setCurrentScope(ifScope);
    System.out.println("Opened if/else if scope");

    ConditionalCommand conditionalCommand = new ConditionalCommand(selectStmtCtx.simpleExpression());
    StmtCmdTracker.getInstance().openSelectionCommand(conditionalCommand);
    
    CompStmtAnalyzer compoundStatementAnalyzer = new CompStmtAnalyzer(selectStmtCtx.compoundStatement());
    compoundStatementAnalyzer.analyze();

    StmtCmdTracker.getInstance().exitIfCommand();

    if(selectStmtCtx.elseStatement() != null){
        if(selectStmtCtx.elseStatement().compoundStatement() != null){
            CstmLocalScope elseScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
            GlobalScopeManager.getInstance().setCurrentScope(elseScope);
            System.out.println("Opened else scope");
            
            CompStmtAnalyzer elseStatementAnalyzer = new CompStmtAnalyzer(selectStmtCtx.elseStatement().compoundStatement());
            elseStatementAnalyzer.analyze();
        } else {
            StmtAnalyzer stmtAnalyzer = new StmtAnalyzer(selectStmtCtx.elseStatement().selectionStatement());
            stmtAnalyzer.analyze();
        }
        
    } 
    StmtCmdTracker.getInstance().closeIterationCommand();
  }
}
