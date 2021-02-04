package execution.commands;

import java.math.BigDecimal;

import org.antlr.v4.runtime.tree.TerminalNode;

import builder.errorcheckers.CstmUnDecChecker;
import console.Printer;
import execution.ExecutionManager;
import model.CUSTOMParser.SimpleExpressionContext;
import model.CUSTOMParser.VariableDeclarationContext;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class VarInitCommand implements CommandInterface {

    private EvaluationCommand evalCommand;

    private CstmLocalScope cstmScope;
    private SimpleExpressionContext exprCtx;
    private VariableDeclarationContext varDecCtx;

    public VarInitCommand(VariableDeclarationContext varDecCtx, SimpleExpressionContext exprCtx){
        this.cstmScope = GlobalScopeManager.getInstance().getCurrentScope();
        this.exprCtx = exprCtx;
        this.varDecCtx = varDecCtx;

        CstmUnDecChecker undecChecker = new CstmUnDecChecker(exprCtx);
        undecChecker.verify();

        evalCommand = new EvaluationCommand(this.exprCtx, this.cstmScope);
    }

    @Override
    public void execute() {

        if(varDecCtx.typeSpecifier().getText().contains("String")){
            System.out.println("IT WENT HERE 1!");
            if(varDecCtx.variableDeclarationInitialize().simpleExpression().getText().replaceAll("\".+?\"", "").contains("+")){
                Printer.getInstance().display("In line "+String.valueOf(varDecCtx.getStart().getLine())+": Concatenation of strings is not possible in intialization.");
                ExecutionManager.getInstance().stopExecution();
            } else {
                System.out.println("IT WENT HERE 2!");
                String stringValue = varDecCtx.variableDeclarationInitialize().IDENTIFIER().getText();
                CstmValue cstmValue = this.cstmScope.getVariableWithinScope(stringValue);
                cstmValue.setValue(varDecCtx.variableDeclarationInitialize().simpleExpression().getText().replaceAll("^\"+|\"+$", ""));
            }
        } else {
            evalCommand.execute();
            String stringValue = varDecCtx.variableDeclarationInitialize().IDENTIFIER().getText();
            CstmValue cstmValue = cstmScope.getVariableWithinScope(stringValue);
            BigDecimal evalResult = evalCommand.getResult();

            if(cstmValue != null){
                if(cstmValue.getPrimitiveType() == PrimitiveType.INT){
                    cstmValue.setValue(evalResult.intValue());
                } else if(cstmValue.getPrimitiveType() == PrimitiveType.FLOAT){
                    cstmValue.setValue(evalResult.floatValue());
                } else if(cstmValue.getPrimitiveType() == PrimitiveType.BOOLEAN){
                    switch(evalResult.intValue()){
                        case 0:
                            cstmValue.setValue('F');
                            break;
                        case 1:
                            cstmValue.setValue('T');
                            break;
                    }
                }
            }
        }
    }
}
