package semantics.analyzers;

import model.CUSTOMParser.CompoundStatementContext;
import semantics.symboltable.GlobalScopeManager;

public class CompoundStatementAnalyzer {
    public CompoundStatementAnalyzer(){
        GlobalScopeManager.getInstance().getCurrentScope();
    }

    public void analyze(CompoundStatementContext ctx){
        
    }
}
