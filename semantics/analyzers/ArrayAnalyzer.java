package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import model.CUSTOMParser.ArrayDeclarationContext;
import model.CUSTOMParser.ArrayTypeSpecifierContext;
import semantics.representations.CstmArray;
import semantics.symboltable.scopes.CstmClassScope;
import semantics.symboltable.scopes.CstmLocalScope;

public class ArrayAnalyzer implements ParseTreeListener {
    private final static String ARRAY_PRIMITIVE_KEY = "ARRAY_PRIMITIVE_KEY";
	private final static String ARRAY_IDENTIFIER_KEY = "ARRAY_IDENTIFIER_KEY";
	
	private IdentifiedTokens identifiedTokens;
	private CstmClassScope declaredClassScope;
	private CstmLocalScope localScope;
    private CstmArray declaredArray;
    
    public ArrayAnalyzer( IdentifiedTokens identifiedTokens, CstmClassScope declaredClassScope) {
		this.identifiedTokens = identifiedTokens;
		this.declaredClassScope = declaredClassScope;
	}
	
	public ArrayAnalyzer( IdentifiedTokens identifiedTokens, CstmLocalScope localScope) {
		this.identifiedTokens = identifiedTokens;
		this.localScope = localScope;
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
		if(ctx instanceof PrimitiveTypeContext) {
			PrimitiveTypeContext primitiveCtx = (PrimitiveTypeContext) ctx;
			this.identifiedTokens.addToken(ARRAY_PRIMITIVE_KEY, primitiveCtx.getText());
		}
		else if(ctx instanceof ArrayTypeSpecifierContext) {
			ArrayTypeSpecifierContext varDecIdCtx = (ArrayTypeSpecifierContext) ctx;
			this.identifiedTokens.addToken(ARRAY_IDENTIFIER_KEY, varDecIdCtx.getText());
			
			this.analyzeArray();
		}
		else if(ctx instanceof CreatedNameContext) {
			CreatedNameContext createdNameCtx = (CreatedNameContext) ctx;
			Console.log(LogType.DEBUG, "Array created name: " +createdNameCtx.getText());
		}
		
		else if(ctx instanceof ArrayCreatorRestContext) {
			ArrayCreatorRestContext arrayCreatorCtx = (ArrayCreatorRestContext) ctx;
			this.createInitializeCommand(arrayCreatorCtx);
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
	
	}
	
	private void analyzeArray() {
		
		if(this.declaredClassScope != null) {
			if(this.identifiedTokens.containsTokens(ClassAnalyzer.ACCESS_CONTROL_KEY, ARRAY_PRIMITIVE_KEY, ARRAY_IDENTIFIER_KEY)) {
				String accessControlString = this.identifiedTokens.getToken(ClassAnalyzer.ACCESS_CONTROL_KEY);
				String arrayTypeString = this.identifiedTokens.getToken(ARRAY_PRIMITIVE_KEY);
				String arrayIdentifierString = this.identifiedTokens.getToken(ARRAY_IDENTIFIER_KEY);
				
				//initialize an array mobivalue
				this.declaredArray = MobiArray.createArray(arrayTypeString, arrayIdentifierString);
				MobiValue mobiValue = new MobiValue(this.declaredArray, PrimitiveType.ARRAY);
				
				this.declaredClassScope.addMobiValue(accessControlString, arrayIdentifierString, mobiValue);
				Console.log(LogType.DEBUG, "Creating array with type " +arrayTypeString+ " variable " +arrayIdentifierString);
				
				this.identifiedTokens.clearTokens();
			}
		}
		else if(this.localScope != null) {
			if(this.identifiedTokens.containsTokens(ARRAY_PRIMITIVE_KEY, ARRAY_IDENTIFIER_KEY)) {
				String arrayTypeString = this.identifiedTokens.getToken(ARRAY_PRIMITIVE_KEY);
				String arrayIdentifierString = this.identifiedTokens.getToken(ARRAY_IDENTIFIER_KEY);
				
				//initialize an array mobivalue
				this.declaredArray = MobiArray.createArray(arrayTypeString, arrayIdentifierString);
				MobiValue mobiValue = new MobiValue(this.declaredArray, PrimitiveType.ARRAY);
				
				this.localScope.addMobiValue(arrayIdentifierString, mobiValue);
				Console.log(LogType.DEBUG, "Creating array with type " +arrayTypeString+ " variable " +arrayIdentifierString);
				
				this.identifiedTokens.clearTokens();
			}
		}
		
	}
	
	private void createInitializeCommand(ArrayCreatorRestContext arrayCreatorCtx) {
		ArrayInitializeCommand arrayInitializeCommand = new ArrayInitializeCommand(this.declaredArray, arrayCreatorCtx);
		ExecutionManager.getInstance().addCommand(arrayInitializeCommand);
	}
}
