package builder.errorcheckers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import builder.CstmBuildChecker;
import builder.CstmErrorRepo;
import model.CUSTOMParser.ExpressionContext;
import model.CUSTOMParser.TypeSpecifierContext;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;

public class CstmTypeChecker implements CstmErrCheckerInterface, ParseTreeListener{

	private CstmValue cstmValue;
	private ExpressionContext expressionContext;
	private int lineNumber;

    public CstmTypeChecker(CstmValue assignmentValue, ExpressionContext expressionContext) {
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
			
			if(this.cstmValue.getPrimitiveType() == PrimitiveType.ARRAY) {
				
			}
			else if(this.cstmValue.getPrimitiveType() == PrimitiveType.BOOLEAN) {
				if(typeSpecifierContext.Boolean() == null) {
					String additionalMessage = "Expected bool.";
					CstmBuildChecker.reportCustomError(CstmErrorRepo.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
				}
			}
			else if(this.cstmValue.getPrimitiveType() == PrimitiveType.INT) {
				if(typeSpecifierContext.Int() == null) {
					String additionalMessage = "Expected int.";
					CstmBuildChecker.reportCustomError(CstmErrorRepo.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
				}
			}
			else if(this.cstmValue.getPrimitiveType() == PrimitiveType.FLOAT) {
				if(typeSpecifierContext.Float() == null) {
					String additionalMessage = "Expected floating point.";
					CstmBuildChecker.reportCustomError(CstmErrorRepo.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
				}
			}
			else if(this.cstmValue.getPrimitiveType() == PrimitiveType.STRING) {
				if(expressionString.charAt(0) != '\"' && expressionString.charAt(expressionString.length() - 1) != '\"') {
					String additionalMessage = "Expected string.";
					CstmBuildChecker.reportCustomError(CstmErrorRepo.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
				}
				
				else if(typeSpecifierContext.String() == null) {
					String additionalMessage = "Expected string.";
					CstmBuildChecker.reportCustomError(CstmErrorRepo.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
				}
			}
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
}
