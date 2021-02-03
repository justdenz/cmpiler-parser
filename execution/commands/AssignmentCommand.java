package execution.commands;

import org.antlr.v4.runtime.tree.TerminalNode;

import builder.errorcheckers.CstmConstChecker;
import builder.errorcheckers.CstmTypeChecker;
import builder.errorcheckers.CstmUnDecChecker;
import console.Console;
import console.Printer;
import execution.ExecutionManager;
import model.CUSTOMParser.MutableContext;
import model.CUSTOMParser.SimpleExpressionContext;
import semantics.representations.CstmArray;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class AssignmentCommand implements CommandInterface{

  private MutableContext leftContext;
  private SimpleExpressionContext righContext;
  private CstmLocalScope scope;
  private EvaluationCommand evalCommand;
  private TerminalNode identifier;

  public AssignmentCommand(MutableContext leftContext, SimpleExpressionContext righContext){
    this.leftContext = leftContext;
    this.identifier = leftContext.IDENTIFIER();
    this.righContext = righContext;
    this.scope = GlobalScopeManager.getInstance().getCurrentScope();
    this.evalCommand = new EvaluationCommand(righContext, this.scope);

    CstmUnDecChecker unDecChecker = new CstmUnDecChecker(righContext);
    unDecChecker.verify();

    CstmValue cstmValue = scope.getVariableWithinScope(identifier.getText());

    if(leftContext.LeftBracket() != null && cstmValue.getPrimitiveType() != PrimitiveType.ARRAY){
      Console.log(String.valueOf(leftContext.getStart().getLine()), "Found a variable that is not an array.");
    }

    if(cstmValue.getPrimitiveType() != PrimitiveType.ARRAY){
      CstmConstChecker constChecker = new CstmConstChecker(this.identifier);
      constChecker.verify();
    }

    CstmTypeChecker typeChecker = new CstmTypeChecker(cstmValue, righContext);
    typeChecker.verify();
  }

  @Override
  public void execute() {

    // if variable
    if(leftContext.LeftBracket() == null || leftContext.RightBracket() ==  null){
      this.evalCommand.execute();

      CstmValue cstmValue = this.scope.getVariableWithinScope(this.leftContext.getText());

      if(cstmValue != null){
        if(cstmValue.getPrimitiveType() == PrimitiveType.STRING){
          cstmValue.setValue(righContext.getText().replaceAll("\"", ""));
        }else if(cstmValue.getPrimitiveType() == PrimitiveType.INT){
          cstmValue.setValue(this.evalCommand.getResult().intValue());
        }else if(cstmValue.getPrimitiveType() == PrimitiveType.FLOAT){
          cstmValue.setValue(this.evalCommand.getResult().floatValue());
        }
      }
    } 
    // if array
    else {
      EvaluationCommand arrEvalCmd = new EvaluationCommand(leftContext.simpleExpression(), this.scope);
      arrEvalCmd.execute();
      this.evalCommand.execute();

      int arrIndex = arrEvalCmd.getResult().intValue();

      CstmValue cstmValue = scope.getVariableWithinScope(this.identifier.getText());
      CstmArray cstmArr = (CstmArray) cstmValue.getValue();

      if (cstmArr.isInitialized()) {
          CstmValue curValue = cstmArr.getValueAt(arrIndex);
      
          if (curValue != null) {
            if(curValue.getPrimitiveType() == PrimitiveType.STRING){
              curValue.setValue(righContext.getText().replaceAll("\"", ""));
            } else if(curValue.getPrimitiveType() == PrimitiveType.INT){
              curValue.setValue(this.evalCommand.getResult().intValue());
            } else if(curValue.getPrimitiveType() == PrimitiveType.FLOAT){
              curValue.setValue(this.evalCommand.getResult().floatValue());
            }
            cstmArr.updateValueAt(curValue, arrIndex);
          } else {
              Printer.getInstance().display("Program Terminated. Array Index is out of bounds.");
              ExecutionManager.getInstance().stopExecution();
          }
          
      } else {
        Printer.getInstance().display("Program Terminated. Array is not initialized.");
          ExecutionManager.getInstance().stopExecution();
      }  
    }
  }  
}
