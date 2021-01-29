package builder.errorcheckers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import console.Console;
import builder.CstmBuildChecker;
import builder.CstmErrorRepo;
import model.CUSTOMParser.ExpressionContext;
import model.CUSTOMParser.SimpleExpressionContext;
import model.CUSTOMParser.TypeSpecifierContext;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.utils.CstmKeywords;

public class CstmTypeChecker implements CstmErrCheckerInterface, ParseTreeListener{

	private CstmValue cstmValue;
	private SimpleExpressionContext expressionContext;
	private int lineNumber;

    public CstmTypeChecker(CstmValue assignmentValue, SimpleExpressionContext expressionContext) {
		this.cstmValue = assignmentValue;
		this.expressionContext = expressionContext;
		
		Token firstToken = expressionContext.getStart();
		this.lineNumber = firstToken.getLine();
    }
    
    @Override
	public void verify() {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, this.expressionContext);
	}
	
	public static boolean isNumeric(String str) {
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		if(ctx instanceof TypeSpecifierContext) {
			if(this.cstmValue == null) {
				return;
			}
			TypeSpecifierContext typeSpecifierContext = (TypeSpecifierContext) ctx;
			String expressionString = typeSpecifierContext.getText();
			
			if(this.cstmValue.getPrimitiveType().toString() == CstmKeywords.IS_ARRAY) {
				
			}
			else if(this.cstmValue.getPrimitiveType().toString() == CstmKeywords.IS_BOOLEAN) {
				if(typeSpecifierContext.Boolean() == null) {
					Console.log("In line "+this.lineNumber+": Expected bool.");
				}
			}
			else if(this.cstmValue.getPrimitiveType().toString() == CstmKeywords.IS_INT) {
				if(typeSpecifierContext.Int() == null) {
					Console.log("In line "+this.lineNumber+": Expected int.");
				}
			}
			else if(this.cstmValue.getPrimitiveType().toString() == CstmKeywords.IS_FLOAT) {
				if(typeSpecifierContext.Float() == null) {
					Console.log("In line "+this.lineNumber+": Expected float.");
				}
			}
			else if(this.cstmValue.getPrimitiveType().toString() == CstmKeywords.IS_STRING) {
				if(expressionString.charAt(0) != '\"' && expressionString.charAt(expressionString.length() - 1) != '\"') {
					Console.log("In line "+this.lineNumber+": Expected string.");
				}
				
				else if(typeSpecifierContext.String() == null) {
					Console.log("In line "+this.lineNumber+": Expected string.");
				}
			}
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
}
