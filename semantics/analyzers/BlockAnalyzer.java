package semantics.analyzers;

import java.util.List;

import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.CompoundStatementListContext;
import model.CUSTOMParser.StatementListContext;
import model.CUSTOMParser.FuncBlockContext;
import model.CUSTOMParser.ProgramContext;
import model.CUSTOMParser.DeclarationListContext;
import semantics.representations.CstmValue;
import semantics.representations.CstmFunction;
import semantics.symboltable.CstmSymbolTable;
import semantics.symboltable.scopes.CstmClassScope;
import semantics.symboltable.scopes.CstmLocalScope;
import semantics.symboltable.scopes.CstmLocalScopeCreator;

public class BlockAnalyzer {
    public BlockAnalyzer() {
		CstmLocalScopeCreator.getInstance().openLocalScope();
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
		
		CstmLocalScopeCreator.getInstance().closeLocalScope();
	}
}
