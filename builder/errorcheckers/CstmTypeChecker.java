package builder.errorcheckers;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import console.Console;
import model.CUSTOMParser.ArgsContext;
import model.CUSTOMParser.CallContext;
import model.CUSTOMParser.ConstantContext;
import model.CUSTOMParser.ExpressionContext;
import model.CUSTOMParser.MutableContext;
import model.CUSTOMParser.SimpleExpressionContext;
import model.CUSTOMParser.TypeSpecifierContext;
import semantics.representations.CstmArray;
import semantics.representations.CstmFunction;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.GlobalScopeManager;
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
					Console.log(String.valueOf(this.lineNumber) , "Expected boolean type.");
				}
			}
			else if(this.cstmValue.getPrimitiveType() == PrimitiveType.INT) {
				if(constCtx.INTEGERCONSTANT() == null) {
					Console.log(String.valueOf(this.lineNumber) , "Expected int type.");
				}
			}
			else if(this.cstmValue.getPrimitiveType() == PrimitiveType.FLOAT) {
				if(constCtx.FLOATCONSTANT() == null) {
					Console.log(String.valueOf(this.lineNumber) , "Expected float type.");
				}
			}
			else if(this.cstmValue.getPrimitiveType() == PrimitiveType.STRING) {
				if(constCtx.STRINGCONSTANT() == null) {
					Console.log(String.valueOf(this.lineNumber) , "Expected string type.");
				}
			}
		} 
		// TypeChecker for regular assignment 
		else if(ctx instanceof MutableContext){
			MutableContext mutCtx = (MutableContext) ctx;
			if (mutCtx.LeftBracket() == null){
				CstmValue cstmValue = GlobalScopeManager.getInstance().searchScopedVariable(mutCtx.IDENTIFIER().getText());
				if(cstmValue != null) {
					if(this.cstmValue.getPrimitiveType() == PrimitiveType.BOOLEAN && cstmValue.getPrimitiveType() != PrimitiveType.BOOLEAN) {
						Console.log(String.valueOf(this.lineNumber) , "Expected boolean type.");
					}
					else if(this.cstmValue.getPrimitiveType() == PrimitiveType.INT && cstmValue.getPrimitiveType() != PrimitiveType.INT) {
						Console.log(String.valueOf(this.lineNumber) , "Expected int type.");
					}
					else if(this.cstmValue.getPrimitiveType() == PrimitiveType.FLOAT && cstmValue.getPrimitiveType() != PrimitiveType.FLOAT) {
						Console.log(String.valueOf(this.lineNumber) , "Expected float type.");
					}
					else if(this.cstmValue.getPrimitiveType() == PrimitiveType.STRING && cstmValue.getPrimitiveType() != PrimitiveType.STRING) {
						Console.log(String.valueOf(this.lineNumber) , "Expected string type.");
					} else if(this.cstmValue.getPrimitiveType() == PrimitiveType.ARRAY) {
						if (cstmValue.getPrimitiveType() != PrimitiveType.ARRAY) {
							Console.log(String.valueOf(this.lineNumber) , "Expected array type.");
						} else {
							CstmArray pa = (CstmArray)this.cstmValue.getValue();
							CstmArray pa1 = (CstmArray)cstmValue.getValue();
							if(pa.getPrimitiveType() == PrimitiveType.BOOLEAN && pa1.getPrimitiveType() != PrimitiveType.BOOLEAN) {
								Console.log(String.valueOf(this.lineNumber) , "Expected boolean type.");
							}
							else if(pa.getPrimitiveType() == PrimitiveType.INT && pa1.getPrimitiveType() != PrimitiveType.INT) {
								Console.log(String.valueOf(this.lineNumber) , "Expected int type.");
							}
							else if(pa.getPrimitiveType() == PrimitiveType.FLOAT && pa1.getPrimitiveType() != PrimitiveType.FLOAT) {
								Console.log(String.valueOf(this.lineNumber) , "Expected float type.");
							}
							else if(pa.getPrimitiveType() == PrimitiveType.STRING && pa1.getPrimitiveType() != PrimitiveType.STRING) {
								Console.log(String.valueOf(this.lineNumber) , "Expected string type.");
							}
						}
					}
				}
			}
		} 
		// TypeChecker for function call assignment
		else if(ctx instanceof CallContext){
			CallContext callCtx = (CallContext) ctx;

			String functionName = callCtx.IDENTIFIER().getText();
			CstmFunction cstmFunc = GlobalScopeManager.getInstance().getFunction(functionName);

			ArgsContext callArgsCtx = callCtx.args();

			CstmParamChecker paramChecker = new CstmParamChecker(cstmFunc, callArgsCtx);
			paramChecker.verify();

			// check if the arguments exist
			List<SimpleExpressionContext> callArgsList = callArgsCtx.simpleExpression();
			
			for (SimpleExpressionContext exprCtx : callArgsList) {
				CstmUnDecChecker undeclaredSemCheck = new CstmUnDecChecker(exprCtx);
				undeclaredSemCheck.verify();
			}
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
}
