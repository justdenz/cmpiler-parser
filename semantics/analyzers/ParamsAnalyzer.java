package semantics.analyzers;

import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

import model.CUSTOMParser.ParamsContext;
import model.CUSTOMParser.ParamListContext;
import semantics.representations.CstmFunction;

import org.antlr.v4.runtime.tree.ErrorNode;

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
        if(ctx instanceof ParamsContext){
			// ParamsContext paramCtx = (ParamsContext) ctx;
			// ParamsAnalyzer paramsAnalyzer = new ParamsAnalyzer();
			// paramsAnalyzer.analyze(paramCtx);
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
