package execution.commands;

import java.math.BigDecimal;

import org.antlr.v4.runtime.tree.TerminalNode;

import builder.errorcheckers.CstmUnDecChecker;
import model.CUSTOMParser.SimpleExpressionContext;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class VarInitCommand implements CommandInterface {

    private EvaluationCommand evalCommand;

    private CstmLocalScope cstmScope;
    private SimpleExpressionContext exprCtx;
    private TerminalNode identifier;

    public VarInitCommand(TerminalNode identifier, SimpleExpressionContext exprCtx){
        this.cstmScope = GlobalScopeManager.getInstance().getCurrentScope();
        this.exprCtx = exprCtx;
        this.identifier = identifier;

        CstmUnDecChecker undecChecker = new CstmUnDecChecker(exprCtx);
        undecChecker.verify();

        evalCommand = new EvaluationCommand(this.exprCtx, this.cstmScope);
    }

    @Override
    public void execute() {
        evalCommand.execute();
        
        CstmValue cstmValue = cstmScope.getVariableWithinScope(identifier.getText());
        BigDecimal evalResult = evalCommand.getResult();

        if(cstmValue != null){
            if(cstmValue.getPrimitiveType() == PrimitiveType.INT){
                cstmValue.setValue(evalResult.intValue());
            } else if(cstmValue.getPrimitiveType() == PrimitiveType.FLOAT){
                cstmValue.setValue(evalResult.floatValue());
            } else if(cstmValue.getPrimitiveType() == PrimitiveType.STRING){
                cstmValue.setValue(exprCtx.getText().replaceAll("\"", ""));
            } else if(cstmValue.getPrimitiveType() == PrimitiveType.BOOLEAN){
                switch(evalResult.intValue()){
                    case 0:
                        cstmValue.setValue(false);
                        break;
                    case 1:
                        cstmValue.setValue(true);
                        break;
                }
            }
        }
    }
    
}
