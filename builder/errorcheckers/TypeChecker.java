package builder.errorcheckers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import semantics.representations.Value;
import semantics.representations.Value.PrimitiveType;

public class TypeChecker implements ErrorCheckerInterface, ParseTreeListener{

	private Value value;
	private ExpressionContext expressionContext;
	private int lineNumber;

    public TypeChecker(Value assignmentValue, ExpressionContext expressionContext) {
		this.value = assignmentValue;
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
		if(ctx instanceof LiteralContext) {
			if(this.value == null) {
				return;
			}
			LiteralContext literalCtx = (LiteralContext) ctx;
			String expressionString = literalCtx.getText();
			
			if(this.value.getPrimitiveType() == PrimitiveType.ARRAY) {
				
			}
			else if(this.value.getPrimitiveType() == PrimitiveType.BOOLEAN) {
				if(literalCtx.BooleanLiteral() == null) {
					String additionalMessage = "Expected bool.";
					BuildChecker.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
				}
			}
			else if(this.value.getPrimitiveType() == PrimitiveType.INT) {
				if(literalCtx.IntegerLiteral() == null) {
					String additionalMessage = "Expected int.";
					BuildChecker.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
				}
			}
			else if(this.value.getPrimitiveType() == PrimitiveType.FLOAT || this.value.getPrimitiveType() == PrimitiveType.DOUBLE) {
				if(literalCtx.FloatingPointLiteral() == null) {
					String additionalMessage = "Expected floating point.";
					BuildChecker.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
				}
			}
			
			else if(this.value.getPrimitiveType() == PrimitiveType.STRING) {
				if(expressionString.charAt(0) != '\"' && expressionString.charAt(expressionString.length() - 1) != '\"') {
					String additionalMessage = "Expected string.";
					BuildChecker.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
				}
				
				else if(literalCtx.StringLiteral() == null) {
					String additionalMessage = "Expected string.";
					BuildChecker.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
				}
			}
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
}
