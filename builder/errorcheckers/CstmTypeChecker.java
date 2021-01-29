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
import model.CUSTOMParser.CallContext;
import model.CUSTOMParser.ConstantContext;
import model.CUSTOMParser.ExpressionContext;
import model.CUSTOMParser.MutableContext;
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

	@Override
	public void visitTerminal(TerminalNode node) {
		
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		// TypeChecker for assignment with ConstantKey (constant)
		if(ctx instanceof ConstantContext){
			if(this.cstmValue == null)
				return;
			ConstantContext constCtx = (ConstantContext) ctx;
			if(this.cstmValue.getPrimitiveType() == PrimitiveType.ARRAY) {
				
			}
			else if(this.cstmValue.getPrimitiveType() == PrimitiveType.BOOLEAN) {
				if(constCtx.BOOLCONSTANT() == null) {
					Console.log("In line " + this.lineNumber + " : Expected boolean type");
				}
			}
			else if(this.cstmValue.getPrimitiveType() == PrimitiveType.INT) {
				if(constCtx.INTEGERCONSTANT() == null) {
					Console.log("In line " + this.lineNumber + " : Expected int type");
				}
			}
			else if(this.cstmValue.getPrimitiveType() == PrimitiveType.FLOAT) {
				if(constCtx.FLOATCONSTANT() == null) {
					Console.log("In line " + this.lineNumber + " : Expected float type");
				}
			}
			else if(this.cstmValue.getPrimitiveType() == PrimitiveType.STRING) {
				if(constCtx.STRINGCONSTANT() == null) {
					Console.log("In line " + this.lineNumber + " : Expected string type");
				}
			}
		} 
		// TypeChecker for regular assignment 
		else if(ctx instanceof MutableContext){

		} 
		// TypeChecker for function call assignment
		else if(ctx instanceof CallContext){

		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
}
