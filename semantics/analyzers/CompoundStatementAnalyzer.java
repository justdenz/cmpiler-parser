package semantics.analyzers;

import java.util.List;

import console.Console;
import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.CompoundStatementListContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class CompoundStatementAnalyzer {
    public CompoundStatementAnalyzer(){
    }

    public void analyze(CompoundStatementContext ctx){
        List<CompoundStatementListContext> compoundStatementListContext = ctx.compoundStatementList();

        for(CompoundStatementListContext compoundStatementContext: compoundStatementListContext){
            if(compoundStatementContext.statement() != null){
                StatementAnalyzer stmtAnalyzer = new StatementAnalyzer();
                stmtAnalyzer.analyze(compoundStatementContext.statement());
                System.out.println("In line "+compoundStatementContext.statement().getStart().getLine()+": Found statement");
            }else if(compoundStatementContext.declaration() != null){
                DeclarationListAnalyzer decAnalyzer = new DeclarationListAnalyzer();
                decAnalyzer.analyze(compoundStatementContext.declaration());
                System.out.println("In line "+compoundStatementContext.declaration().getStart().getLine()+": Found local declaration");
            }
        }
        
        CstmLocalScope parentScope = GlobalScopeManager.getInstance().getCurrentScope().getParent();
        GlobalScopeManager.getInstance().setCurrentScope(parentScope);
        System.out.println("Closed Scope");
    }

}
