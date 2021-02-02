package execution.commands;

import java.math.BigDecimal;

import org.antlr.v4.runtime.tree.TerminalNode;

import builder.errorcheckers.CstmConstChecker;
import builder.errorcheckers.CstmTypeChecker;
import builder.errorcheckers.CstmUnDecChecker;
import model.CUSTOMParser.SimpleExpressionContext;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;
import semantics.utils.CstmKeywords;

public class IterationAssignCommand implements CommandInterface{

  private TerminalNode identifier;
  private SimpleExpressionContext simpleExprCtx;
  private EvaluationCommand evalCmd;
  private CstmLocalScope cstmScope;

  public IterationAssignCommand(TerminalNode identifier, SimpleExpressionContext simpleExprCtx){
    this.identifier = identifier;
    this.simpleExprCtx = simpleExprCtx;
    this.cstmScope = GlobalScopeManager.getInstance().getCurrentScope();

    CstmUnDecChecker unDecChecker = new CstmUnDecChecker(simpleExprCtx);
    unDecChecker.verify();

    CstmValue idenValue = GlobalScopeManager.getInstance().getCurrentScope().getVariableWithinScope(identifier.getText());
    if(idenValue.getPrimitiveType() != PrimitiveType.ARRAY){
      CstmConstChecker constChecker = new CstmConstChecker(identifier);
      constChecker.verify();
    }

    CstmValue tempVal = new CstmValue(null, CstmKeywords.IS_INT);
    CstmTypeChecker typeChecker = new CstmTypeChecker(tempVal, simpleExprCtx);
    typeChecker.verify();

    evalCmd = new EvaluationCommand(simpleExprCtx, cstmScope);
  }

  @Override
  public void execute() {
    evalCmd.execute();
    
    CstmValue cstmValue = cstmScope.getVariableWithinScope(identifier.getText());
    BigDecimal evalResult = evalCmd.getResult();

    if(cstmValue != null){
        if(cstmValue.getPrimitiveType() == PrimitiveType.INT){
            cstmValue.setValue(evalResult.intValue());
        } else if(cstmValue.getPrimitiveType() == PrimitiveType.FLOAT){
            cstmValue.setValue(evalResult.floatValue());
        } else if(cstmValue.getPrimitiveType() == PrimitiveType.STRING){
            cstmValue.setValue(simpleExprCtx.getText().replaceAll("\"", ""));
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
