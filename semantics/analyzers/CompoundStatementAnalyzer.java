package semantics.analyzers;

import java.util.List;

import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.CompoundStatementListContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class CompoundStatementAnalyzer {
    public CompoundStatementAnalyzer(){
        GlobalScopeManager.getInstance().getCurrentScope();
    }

    public void analyze(CompoundStatementContext ctx){
        List<CompoundStatementListContext> compoundStatementListContext = ctx.compoundStatementList();

        for(CompoundStatementListContext compoundStatementContext: compoundStatementListContext){
            if(compoundStatementContext.statementList() != null){

            }else if(compoundStatementContext.declarationList() != null){

            }
        }

        
        CstmLocalScope parentScope = GlobalScopeManager.getInstance().getCurrentScope().getParent();
        GlobalScopeManager.getInstance().setCurrentScope(parentScope);
    }

}
