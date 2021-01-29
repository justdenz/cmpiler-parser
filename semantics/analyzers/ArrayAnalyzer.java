package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import console.Console;
import model.CUSTOMParser.ArrayDeclarationContext;
import model.CUSTOMParser.ArrayTypeSpecifierContext;
import model.CUSTOMParser.ConstantContext;
import semantics.representations.CstmArray;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.scopes.CstmLocalScope;
import semantics.utils.CstmIdentifiedTokens;
import semantics.utils.CstmKeywords;

public class ArrayAnalyzer implements ParseTreeListener {
    private final static String ARRAY_PRIMITIVE_KEY = "ARRAY_PRIMITIVE_KEY";
	private final static String ARRAY_IDENTIFIER_KEY = "ARRAY_IDENTIFIER_KEY";
	
	private CstmIdentifiedTokens identifiedTokens;
	private CstmLocalScope declaredLocalScope;
	private CstmLocalScope localScope;
    private CstmArray declaredArray;
    
    public ArrayAnalyzer(CstmLocalScope declaredLocalScope) {
		this.declaredLocalScope = declaredLocalScope;
	}
	
	public void analyze(ParserRuleContext ctx) {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk((ParseTreeListener) this, ctx);
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
		// if(ctx instanceof ConstantContext) {
		// ConstantContext constantContext = (ConstantContext) ctx;
		// 	this.identifiedTokens.addToken(ARRAY_PRIMITIVE_KEY, constantContext.getText());
		// }
		if(ctx instanceof ArrayTypeSpecifierContext) {
			ArrayTypeSpecifierContext varDecIdCtx = (ArrayTypeSpecifierContext) ctx;
			this.identifiedTokens.addToken(ARRAY_IDENTIFIER_KEY, varDecIdCtx.getText());
			
			this.analyzeArray();
		}
		// else if(ctx instanceof CreatedNameContext) {
		// 	CreatedNameContext createdNameCtx = (CreatedNameContext) ctx;
		// 	Console.log(LogType.DEBUG, "Array created name: " +createdNameCtx.getText());
		// }
		
		// else if(ctx instanceof ArrayCreatorRestContext) {
		// 	ArrayCreatorRestContext arrayCreatorCtx = (ArrayCreatorRestContext) ctx;
		// 	this.createInitializeCommand(arrayCreatorCtx);
		// }
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
	
	}
	
	private void analyzeArray() {
		
		if(this.localScope != null) {
			if(this.identifiedTokens.containsTokens(ARRAY_PRIMITIVE_KEY, ARRAY_IDENTIFIER_KEY)) {
				String arrayTypeString = this.identifiedTokens.getToken(ARRAY_PRIMITIVE_KEY);
				String arrayIdentifierString = this.identifiedTokens.getToken(ARRAY_IDENTIFIER_KEY);
				
				//initialize an array mobivalue
				this.declaredArray = CstmArray.createArray(arrayTypeString, arrayIdentifierString);
				CstmValue mobiValue = new CstmValue(this.declaredArray, CstmKeywords.IS_ARRAY);
				
				this.localScope.addVariable(arrayIdentifierString, mobiValue);
				Console.log("Creating array with type " +arrayTypeString+ " variable " +arrayIdentifierString);
				
				this.identifiedTokens.clearTokens();
			}
		}
		
	}
	
	// private void createInitializeCommand(ArrayCreatorRestContext arrayCreatorCtx) {
	// 	ArrayInitializeCommand arrayInitializeCommand = new ArrayInitializeCommand(this.declaredArray, arrayCreatorCtx);
	// 	ExecutionManager.getInstance().addCommand(arrayInitializeCommand);
	// }
}
