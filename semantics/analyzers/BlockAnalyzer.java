package semantics.analyzers;

import java.util.List;

import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.CompoundStatementListContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class BlockAnalyzer {
    public BlockAnalyzer() {
		GlobalScopeManager.getInstance().getCurrentScope();
	}
	
	public void analyze(CompoundStatementContext ctx) {
		
		List<CompoundStatementListContext> blockListCtx = ctx.compoundStatementList();
		
		for(CompoundStatementListContext blockStatementCtx : blockListCtx) {
			if(blockStatementCtx.statementList() != null) {
				// StatementListContext statementListCtx = blockStatementCtx.statementList();
				// StatementAnalyzer statementAnalyzer = new StatementAnalyzer();
				// statementAnalyzer.analyze(statementListCtx);
            }
			else if(blockStatementCtx.declarationList() != null) {
				// DeclarationListContext declarationListCtx = blockStatementCtx.declarationList();
				// DeclarationAnalyzer declarationAnalyzer = new DeclarationAnalyzer();
				// declarationAnalyzer.analyze(declarationListCtx.localVariableDeclaration());
			}
		}
        
        CstmLocalScope currScope = GlobalScopeManager.getInstance().getCurrentScope();
        CstmLocalScope parentScope = currScope.getParent();
		GlobalScopeManager.getInstance().setCurrentScope(parentScope);
	}
}
