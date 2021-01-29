package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import console.Console;
import builder.errorcheckers.CstmMulVarDecChecker;
import builder.errorcheckers.CstmTypeChecker;
import semantics.utils.CstmIdentifiedTokens;
import model.CUSTOMParser.DeclarationListContext;
import model.CUSTOMParser.ExpressionContext;
import model.CUSTOMParser.VariableDeclarationContext;
import model.CUSTOMParser.ArrayDeclarationContext;
import model.CUSTOMParser.ConstantContext;
import semantics.utils.CstmRecognizedKeywords;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;
import semantics.representations.CstmValue;

public class DeclarationListAnalyzer implements ParseTreeListener{
    
    private final static String PRIMITIVE_TYPE_KEY = "PRIMITIVE_TYPE_KEY";
	private final static String IDENTIFIER_KEY = "IDENTIFIER_KEY";
	private final static String IDENTIFIER_VALUE_KEY = "IDENTIFIER_VALUE_KEY";
	
	private CstmIdentifiedTokens identifiedTokens;
	private boolean executeMappingImmediate = false;
	private boolean hasPassedArrayDeclaration = false;
	
	public DeclarationListAnalyzer() {
		
	}
	
	public void analyze(DeclarationListContext decListCtx) {
		this.identifiedTokens = new CstmIdentifiedTokens();
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, decListCtx);
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		this.analyzeVariables(ctx);
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
    }
	
	private void analyzeVariables(ParserRuleContext ctx) {

        if(ctx instanceof ArrayDeclarationContext){
            ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(this.identifiedTokens, GlobalScopeManager.getInstance().getCurrentScope());
            arrayAnalyzer.analyze(ctx.getParent());
            this.hasPassedArrayDeclaration = true;
        }
        else if(ctx instanceof VariableDeclarationContext){
            VariableDeclarationContext varCtx = (VariableDeclarationContext) ctx;
            ExpressionContext varExprCtx = (ExpressionContext) ctx;
			
			if(this.hasPassedArrayDeclaration) {
				return;
			}
			
			//check for duplicate declarations
			if(this.executeMappingImmediate == false) {
				CstmMulVarDecChecker multipleDeclaredChecker = new CstmMulVarDecChecker(varCtx);
				multipleDeclaredChecker.verify();
			}
			
			this.identifiedTokens.addToken(IDENTIFIER_KEY, varCtx.typeSpecifier().toString());
			this.createCstmValue();
			
			if(varCtx.variableDeclarationList().variableDeclarationInitialize() != null) {
				
				//we do not evaluate strings.
				if(this.identifiedTokens.containsTokens(PRIMITIVE_TYPE_KEY)) {
					String primitiveTypeString = this.identifiedTokens.getToken(PRIMITIVE_TYPE_KEY);
					if(primitiveTypeString.contains(CstmRecognizedKeywords.PRIMITIVE_TYPE_STRING)) {
						this.identifiedTokens.addToken(IDENTIFIER_VALUE_KEY, varCtx.variableDeclarationList().variableDeclarationInitialize().variableDeclarationIdentifier().getText()); 
					}
				}
				
				this.processMapping(varCtx);
				
				CstmLocalScope localScope = GlobalScopeManager.getInstance().getCurrentScope();
				CstmValue declaredCstmValue = localScope.getVariable(varCtx.variableDeclarationList().variableDeclarationInitialize().variableDeclarationIdentifier().getText());
				
				//type check the cstmvalue
				CstmTypeChecker typeChecker = new CstmTypeChecker(declaredCstmValue, varExprCtx);
				typeChecker.verify();
			}
        }
	}
	
	/*
	 * Local variable analyzer is also used for loops. Whenever there is a loop,
	 * mapping command should be executed immediately to update the value in the symbol table.
	 * Otherwise, it proceeds normally.
	 */
	private void processMapping(VariableDeclarationContext varCtx) {
		// if(this.executeMappingImmediate) {
		// 	MappingCommand mappingCommand = new MappingCommand(varCtx.variableDeclaratorId().getText(), varCtx.variableInitializer().expression());
		// 	mappingCommand.execute();
		// }
		// else {
		// 	MappingCommand mappingCommand = new MappingCommand(varCtx.variableDeclaratorId().getText(), varCtx.variableInitializer().expression());
		// 	ExecutionManager.getInstance().addCommand(mappingCommand);
		// }
	}
	
	public void markImmediateExecution() {
		this.executeMappingImmediate = true;
	}
	
	/*
	 * Attempts to create an intermediate representation of the variable once a sufficient amount of info has been retrieved.
	 */
	private void createCstmValue() {
		
		if(this.identifiedTokens.containsTokens(PRIMITIVE_TYPE_KEY, IDENTIFIER_KEY)) {
			
			String primitiveTypeString = this.identifiedTokens.getToken(PRIMITIVE_TYPE_KEY);
			String identifierString = this.identifiedTokens.getToken(IDENTIFIER_KEY);
			String identifierValueString = null;
			
			CstmLocalScope localScope = GlobalScopeManager.getInstance().getCurrentScope();
			
			if(this.identifiedTokens.containsTokens(IDENTIFIER_VALUE_KEY)) {
				identifierValueString = this.identifiedTokens.getToken(IDENTIFIER_VALUE_KEY);

				CstmValue cstmValue = CstmValue.createEmptyVariableFromKeywords(primitiveTypeString);
				cstmValue.setValue(identifierValueString);
				localScope.addVariable(identifierString, cstmValue);
				
			}
			else {
				CstmValue cstmValue = CstmValue.createEmptyVariableFromKeywords(primitiveTypeString);
				localScope.addVariable(identifierString, cstmValue);
			}
			
			//remove the following tokens
			this.identifiedTokens.removeToken(IDENTIFIER_KEY);
            this.identifiedTokens.removeToken(IDENTIFIER_VALUE_KEY);
            
		}
	}
}
