package semantics.analyzers;

import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.StatementContext;

public class StatementAnalyzer {
    public StatementAnalyzer() {
		
    }
    
    public void analyze(StatementContext ctx){
        if(ctx.printStatement() != null){
            // handle print statement
        }else if (ctx.scanStatement() != null){
            // handle scan statement   
        }else if(ctx.expressionStatement() != null){

        }else if(ctx.compoundStatement() != null){
            CompoundStatementContext compoundStatementContext = ctx.compoundStatement();

            
        }else if(ctx.selectionStatement() != null){

        }else if(ctx.compoundStatement() != null){

        }else if(ctx.iterationStatement() != null){

        }else if(ctx.returnStatement() != null){

        }
    }
    
}
