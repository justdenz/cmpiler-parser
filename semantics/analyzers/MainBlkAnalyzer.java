package semantics.analyzers;

import model.CUSTOMParser.MainBlockContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;
import model.CUSTOMParser.CompoundStatementContext;;

public class MainBlkAnalyzer {
  public MainBlkAnalyzer(){}

  public void analyze(MainBlockContext mainCtx){
    CompoundStatementContext compCtx = mainCtx.compoundStatement();

			if(compCtx != null){
				CstmLocalScope mainScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
				GlobalScopeManager.getInstance().setCurrentScope(mainScope);;
				
				CompStmtAnalyzer cmpAnalyzer = new CompStmtAnalyzer();
				cmpAnalyzer.analyze(compCtx);
			}	
  }
}
