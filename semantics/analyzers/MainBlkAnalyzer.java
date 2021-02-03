package semantics.analyzers;

import model.CUSTOMParser.MainBlockContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;
import model.CUSTOMParser.CompoundStatementContext;;

public class MainBlkAnalyzer implements AnalyzerInterface{

	private MainBlockContext mainCtx;

  public MainBlkAnalyzer(MainBlockContext mainCtx){
		this.mainCtx = mainCtx;
	}

	@Override
  public void analyze(){
    CompoundStatementContext compCtx = mainCtx.compoundStatement();

		if(compCtx != null){
			CstmLocalScope mainScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
			GlobalScopeManager.getInstance().setCurrentScope(mainScope);
			System.out.println("Main Scope Opened");
			
			CompStmtAnalyzer cmpAnalyzer = new CompStmtAnalyzer(compCtx);
			cmpAnalyzer.analyze();
		}	
  }
}
