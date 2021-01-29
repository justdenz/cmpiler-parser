package semantics.analyzers;

import java.util.List;

import console.Console;
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
            if(compoundStatementContext.statement() != null){
                StatementAnalyzer stmtAnalyzer = new StatementAnalyzer();
                stmtAnalyzer.analyze(compoundStatementContext.statement());
                Console.log("In line "+compoundStatementContext.statement().getStart().getLine()+": Found statement");
            }else if(compoundStatementContext.declaration() != null){
                DeclarationListAnalyzer decAnalyzer = new DeclarationListAnalyzer();
                decAnalyzer.analyze(compoundStatementContext.declaration());
                Console.log("In line "+compoundStatementContext.declaration().getStart().getLine()+": Found local declaration");
            }
        }
        
        CstmLocalScope parentScope = GlobalScopeManager.getInstance().getCurrentScope().getParent();
        GlobalScopeManager.getInstance().setCurrentScope(parentScope);
    }

}
