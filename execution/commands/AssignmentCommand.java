package execution.commands;

import model.CUSTOMParser.ExpressionContext;
// import builder.errorcheckers.CstmUnDecChecker;
// import builder.errorcheckers.CstmConstChecker;
// import builder.errorcheckers.CstmTypeChecker;

public class AssignmentCommand implements CommandInterface{

  // private ExpressionContext leftContext;
  // private ExpressionContext righContext;

  public AssignmentCommand(ExpressionContext leftContext, ExpressionContext righContext){
    // this.leftContext = leftContext;
    // this.righContext = righContext;

    // if(this.leftContext.mutable() != null){
    //   CstmConstChecker constChecker = new CstmConstChecker(this.leftContext.mutable());
    //   constChecker.verify();
    // }

    // if(this.righContext.simpleExpression() != null){
    //   CstmUnDecChecker unDecChecker = new CstmUnDecChecker(this.righContext.simpleExpression());
    //   unDecChecker.verify();
    // }else if(this.righContext.arrayExpression() != null){

    // }
  }

  @Override
  public void execute() {
    
  }  
}
