package semantics.analyzers;

import java.util.List;

import console.Console;
import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.CompoundStatementListContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class CompStmtAnalyzer {
    public CompStmtAnalyzer(){
    }

    public void analyze(CompoundStatementContext ctx){
        List<CompoundStatementListContext> compoundStatementListContext = ctx.compoundStatementList();

        for(CompoundStatementListContext compoundStatementContext: compoundStatementListContext){
            if(compoundStatementContext.statement() != null){
                StmtAnalyzer stmtAnalyzer = new StmtAnalyzer();
                stmtAnalyzer.analyze(compoundStatementContext.statement());
                System.out.println("In line "+compoundStatementContext.statement().getStart().getLine()+": Found statement");
            }else if(compoundStatementContext.declaration() != null){
                DecListAnalyzer decAnalyzer = new DecListAnalyzer();
                decAnalyzer.analyze(compoundStatementContext.declaration());
                System.out.println("In line "+compoundStatementContext.declaration().getStart().getLine()+": Found local declaration");
            }
        }

        GlobalScopeManager.getInstance().goToParentScope();;
        System.out.println("Closed Scope");
    }

}
