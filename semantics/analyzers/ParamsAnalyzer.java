package semantics.analyzers;

import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

import java.util.List;

import console.Console;
import model.CUSTOMParser.ParamListContext;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.utils.CstmKeywords;
import semantics.representations.CstmFunction;
import semantics.representations.CstmArray;


public class ParamsAnalyzer implements ParseTreeListener{
    
    private CstmFunction function;

    public ParamsAnalyzer(CstmFunction func){
        this.function = func;
    }

    public void analyze(List<ParamListContext> params){
        for(ParamListContext paramCtx : params){
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(this, paramCtx);
        }
    }

    @Override
	public void enterEveryRule(ParserRuleContext ctx) {
        if(ctx instanceof ParamListContext){
            ParamListContext paramCtx = (ParamListContext) ctx;
            // check if duplicate parameter
            String paramName = paramCtx.IDENTIFIER().getText();
            if(function.getParameter(paramName) != null){
                Console.log(String.valueOf(paramCtx.getStart().getLine()) , "Found duplicate parameter");
            } 
            // check if variable type specifier
            if(paramCtx.typeSpecifier() != null){
                if(paramCtx.typeSpecifier().Int() != null){
                    CstmValue cstmValue = new CstmValue(null, CstmKeywords.IS_INT);
                    this.function.addParameter(paramName, cstmValue);
                } else if(paramCtx.typeSpecifier().Float() != null){
                    CstmValue cstmValue = new CstmValue(null, CstmKeywords.IS_FLOAT);
                    this.function.addParameter(paramName, cstmValue);
                } else if(paramCtx.typeSpecifier().Boolean() != null){
                    CstmValue cstmValue = new CstmValue(null, CstmKeywords.IS_BOOLEAN);
                    this.function.addParameter(paramName, cstmValue);
                } else if(paramCtx.typeSpecifier().String() != null){
                    CstmValue cstmValue = new CstmValue(null, CstmKeywords.IS_STRING);
                    this.function.addParameter(paramName, cstmValue);
                }
            }
            // check if array type specifier
            else if(paramCtx.arrayTypeSpecifier().typeSpecifier() != null){
                CstmArray cstmArray = null;
                if(paramCtx.arrayTypeSpecifier().typeSpecifier().Int() != null){
                    cstmArray = new CstmArray(PrimitiveType.INT, paramName);
                } else if(paramCtx.arrayTypeSpecifier().typeSpecifier().Float() != null){
                    cstmArray = new CstmArray(PrimitiveType.FLOAT, paramName);
                } else if(paramCtx.arrayTypeSpecifier().typeSpecifier().Boolean() != null){
                    cstmArray = new CstmArray(PrimitiveType.BOOLEAN, paramName);
                } else if(paramCtx.arrayTypeSpecifier().typeSpecifier().String() != null){
                    cstmArray = new CstmArray(PrimitiveType.STRING, paramName);
                }
                CstmValue cstmValue = new CstmValue(cstmArray, CstmKeywords.IS_ARRAY);
                this.function.addParameter(paramCtx.IDENTIFIER().getText(), cstmValue);
            }
		}
	}

    @Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}

    @Override
	public void visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub
		
	}
}
