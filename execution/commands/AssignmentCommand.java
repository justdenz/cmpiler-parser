package execution.commands;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import builder.errorcheckers.CstmConstChecker;
import builder.errorcheckers.CstmTypeChecker;
import builder.errorcheckers.CstmUnDecChecker;
import console.Console;
import console.Printer;
import execution.ExecutionManager;
import model.CUSTOMParser.ConstantContext;
import model.CUSTOMParser.MutableContext;
import model.CUSTOMParser.SimpleExpressionContext;
import semantics.representations.CstmArray;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class AssignmentCommand implements CommandInterface, ParseTreeListener {

  private MutableContext leftContext;
  private SimpleExpressionContext righContext;
  private CstmLocalScope scope;
  private EvaluationCommand evalCommand;
  private TerminalNode identifier;
  private String evaluatedString = "";
  private List<String> removedStrings = new ArrayList<>();

  public AssignmentCommand(MutableContext leftContext, SimpleExpressionContext righContext) {
    this.leftContext = leftContext;
    this.identifier = leftContext.IDENTIFIER();
    this.righContext = righContext;
    this.scope = GlobalScopeManager.getInstance().getCurrentScope();
    this.evalCommand = new EvaluationCommand(righContext, this.scope);

    CstmUnDecChecker unDecChecker = new CstmUnDecChecker(righContext);
    unDecChecker.verify();

    CstmValue cstmValue = scope.getVariableWithinScope(identifier.getText());

    if (leftContext.LeftBracket() != null && cstmValue.getPrimitiveType() != PrimitiveType.ARRAY) {
      Console.log(String.valueOf(leftContext.getStart().getLine()), "Found a variable that is not an array.");
    }

    if (cstmValue.getPrimitiveType() != PrimitiveType.ARRAY) {
      CstmConstChecker constChecker = new CstmConstChecker(this.identifier);
      constChecker.verify();
    }

    if (leftContext.LeftBracket() != null && cstmValue.getPrimitiveType() == PrimitiveType.ARRAY) {
      CstmArray cstmArr = (CstmArray) cstmValue.getValue();

      CstmTypeChecker typeChecker = new CstmTypeChecker(new CstmValue(null, cstmArr.getPrimitiveType()), righContext);
      typeChecker.verify();
    } else {
      CstmTypeChecker typeChecker = new CstmTypeChecker(cstmValue, righContext);
      typeChecker.verify();
    }
  }

  @Override
  public void execute() {

    // if variable
    if (leftContext.LeftBracket() == null || leftContext.RightBracket() == null) {

      CstmValue cstmValue = scope.getVariableWithinScope(this.identifier.getText());

      if(cstmValue.getPrimitiveType() != PrimitiveType.STRING){
        this.evalCommand.execute();
        BigDecimal evalResult = evalCommand.getResult();

        if (cstmValue != null) {
          if (cstmValue.getPrimitiveType() == PrimitiveType.INT) {
            cstmValue.setValue(evalResult.intValue());
          } else if (cstmValue.getPrimitiveType() == PrimitiveType.FLOAT) {
            cstmValue.setValue(evalResult.floatValue());
          } else if (cstmValue.getPrimitiveType() == PrimitiveType.BOOLEAN) {
            switch (evalResult.intValue()) {
              case 0:
                cstmValue.setValue('F');
                break;
              case 1:
                cstmValue.setValue('T');
                break;
            }
          }
        }
      } else {
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, this.righContext);
        cstmValue.setValue(evaluatedString);
      }
    }
    // if array
    else {
      EvaluationCommand arrEvalCmd = new EvaluationCommand(leftContext.simpleExpression(), this.scope);
      arrEvalCmd.execute();

      int arrIndex = arrEvalCmd.getResult().intValue();

      CstmValue cstmValue = scope.getVariableWithinScope(this.identifier.getText());
      CstmArray cstmArr = (CstmArray) cstmValue.getValue();

      if(cstmArr.getPrimitiveType() != PrimitiveType.STRING){
        this.evalCommand.execute();
        BigDecimal evalResult = evalCommand.getResult();

        if (cstmArr.isInitialized()) {
          CstmValue curValue = cstmArr.getValueAt(arrIndex);

          if (curValue != null) {
            if (curValue.getPrimitiveType() == PrimitiveType.INT) {
              curValue.setValue(evalResult.intValue());
            } else if (curValue.getPrimitiveType() == PrimitiveType.FLOAT) {
              curValue.setValue(evalResult.floatValue());
            } else if (curValue.getPrimitiveType() == PrimitiveType.BOOLEAN) {
              switch (evalResult.intValue()) {
                case 0:
                  curValue.setValue('F');
                  break;
                case 1:
                  curValue.setValue('T');
                  break;
              }
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
      } else {
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, this.righContext);

        if(cstmArr.isInitialized()){
          CstmValue curValue = cstmArr.getValueAt(arrIndex);

          if(curValue != null){
            curValue.setValue(this.evaluatedString);
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

    this.evaluatedString = "";
  }

  @Override
  public void enterEveryRule(ParserRuleContext ctx) {
    if(ctx instanceof ConstantContext){
      ConstantContext constCtx = (ConstantContext) ctx;
      if(!isRemoved(constCtx.getText())){
        if(constCtx.StringLiteral() != null)
          this.evaluatedString += constCtx.StringLiteral().getText().replaceAll("^\"+|\"+$", "");
        else 
          this.evaluatedString += constCtx.getText();
      }
    }

    else if(ctx instanceof MutableContext){
      MutableContext muteCtx = (MutableContext) ctx;

      if(muteCtx.LeftBracket() == null){
        CstmValue cstmValue = scope.getVariableWithinScope(muteCtx.IDENTIFIER().getText());
        if(!isRemoved(muteCtx.getText()))
          this.evaluatedString += cstmValue.getValue().toString();
      }

      else {
        removedStrings.add(muteCtx.getText());
        EvaluationCommand arrEvalCmd = new EvaluationCommand(leftContext.simpleExpression(), this.scope);
        arrEvalCmd.execute();

        int arrIndex = arrEvalCmd.getResult().intValue();

        CstmValue cstmValue = scope.getVariableWithinScope(this.identifier.getText());
        CstmArray cstmArr = (CstmArray) cstmValue.getValue();

        if (cstmArr.isInitialized()) {
          CstmValue curValue = cstmArr.getValueAt(arrIndex);

          if (curValue != null) {
            this.evaluatedString += curValue.getValue().toString();
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

  @Override
  public void exitEveryRule(ParserRuleContext arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void visitErrorNode(ErrorNode arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void visitTerminal(TerminalNode arg0) {
    // TODO Auto-generated method stub

  }

  private boolean isRemoved(String str){
    for(String temp : removedStrings){
      if(temp.contains(str))
        return true;
    }
    return false;
  }
}
