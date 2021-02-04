package semantics.analyzers;

import java.util.List;

import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.CompoundStatementListContext;
import semantics.symboltable.GlobalScopeManager;

public class CompStmtAnalyzer implements AnalyzerInterface{

    CompoundStatementContext ctx;

    public CompStmtAnalyzer(CompoundStatementContext ctx){
        this.ctx = ctx;
    }

    @Override
    public void analyze(){
        List<CompoundStatementListContext> compoundStatementListContext = this.ctx.compoundStatementList();

        for(CompoundStatementListContext compoundStatementContext: compoundStatementListContext){
            if(compoundStatementContext.statement() != null){
                StmtAnalyzer stmtAnalyzer = new StmtAnalyzer(compoundStatementContext.statement());
                stmtAnalyzer.analyze();
            }else if(compoundStatementContext.declaration() != null){
                DecListAnalyzer decAnalyzer = new DecListAnalyzer(compoundStatementContext.declaration());
                decAnalyzer.analyze();
            }
        }

        GlobalScopeManager.getInstance().goToParentScope();
    }

}
