// Generated from CUSTOM.g4 by ANTLR 4.9
package model;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CUSTOMParser}.
 */
public interface CUSTOMListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CUSTOMParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CUSTOMParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#mainBlock}.
	 * @param ctx the parse tree
	 */
	void enterMainBlock(CUSTOMParser.MainBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#mainBlock}.
	 * @param ctx the parse tree
	 */
	void exitMainBlock(CUSTOMParser.MainBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#funcBlock}.
	 * @param ctx the parse tree
	 */
	void enterFuncBlock(CUSTOMParser.FuncBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#funcBlock}.
	 * @param ctx the parse tree
	 */
	void exitFuncBlock(CUSTOMParser.FuncBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#funcTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterFuncTypeSpecifier(CUSTOMParser.FuncTypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#funcTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitFuncTypeSpecifier(CUSTOMParser.FuncTypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(CUSTOMParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(CUSTOMParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclaration(CUSTOMParser.ArrayDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclaration(CUSTOMParser.ArrayDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#arrayDeclarationInitialize}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclarationInitialize(CUSTOMParser.ArrayDeclarationInitializeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#arrayDeclarationInitialize}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclarationInitialize(CUSTOMParser.ArrayDeclarationInitializeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(CUSTOMParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(CUSTOMParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#variableDeclarationInitialize}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationInitialize(CUSTOMParser.VariableDeclarationInitializeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#variableDeclarationInitialize}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationInitialize(CUSTOMParser.VariableDeclarationInitializeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(CUSTOMParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(CUSTOMParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#arrayTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterArrayTypeSpecifier(CUSTOMParser.ArrayTypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#arrayTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitArrayTypeSpecifier(CUSTOMParser.ArrayTypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(CUSTOMParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(CUSTOMParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(CUSTOMParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(CUSTOMParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CUSTOMParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CUSTOMParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#scanStatement}.
	 * @param ctx the parse tree
	 */
	void enterScanStatement(CUSTOMParser.ScanStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#scanStatement}.
	 * @param ctx the parse tree
	 */
	void exitScanStatement(CUSTOMParser.ScanStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(CUSTOMParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(CUSTOMParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#printStatementList}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatementList(CUSTOMParser.PrintStatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#printStatementList}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatementList(CUSTOMParser.PrintStatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#printParameters}.
	 * @param ctx the parse tree
	 */
	void enterPrintParameters(CUSTOMParser.PrintParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#printParameters}.
	 * @param ctx the parse tree
	 */
	void exitPrintParameters(CUSTOMParser.PrintParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#illegalSymbols}.
	 * @param ctx the parse tree
	 */
	void enterIllegalSymbols(CUSTOMParser.IllegalSymbolsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#illegalSymbols}.
	 * @param ctx the parse tree
	 */
	void exitIllegalSymbols(CUSTOMParser.IllegalSymbolsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(CUSTOMParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(CUSTOMParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(CUSTOMParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(CUSTOMParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#compoundStatementList}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatementList(CUSTOMParser.CompoundStatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#compoundStatementList}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatementList(CUSTOMParser.CompoundStatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectionStatement(CUSTOMParser.SelectionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectionStatement(CUSTOMParser.SelectionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(CUSTOMParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(CUSTOMParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatement(CUSTOMParser.IterationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatement(CUSTOMParser.IterationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(CUSTOMParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(CUSTOMParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(CUSTOMParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(CUSTOMParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void enterForCondition(CUSTOMParser.ForConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void exitForCondition(CUSTOMParser.ForConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(CUSTOMParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(CUSTOMParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CUSTOMParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CUSTOMParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#experssionStandAlone}.
	 * @param ctx the parse tree
	 */
	void enterExperssionStandAlone(CUSTOMParser.ExperssionStandAloneContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#experssionStandAlone}.
	 * @param ctx the parse tree
	 */
	void exitExperssionStandAlone(CUSTOMParser.ExperssionStandAloneContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(CUSTOMParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(CUSTOMParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpression(CUSTOMParser.SimpleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpression(CUSTOMParser.SimpleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#arrayExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpression(CUSTOMParser.ArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#arrayExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpression(CUSTOMParser.ArrayExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(CUSTOMParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(CUSTOMParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#unaryRelExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryRelExpression(CUSTOMParser.UnaryRelExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#unaryRelExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryRelExpression(CUSTOMParser.UnaryRelExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#relExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelExpression(CUSTOMParser.RelExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#relExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelExpression(CUSTOMParser.RelExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#relop}.
	 * @param ctx the parse tree
	 */
	void enterRelop(CUSTOMParser.RelopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#relop}.
	 * @param ctx the parse tree
	 */
	void exitRelop(CUSTOMParser.RelopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#sumExpression}.
	 * @param ctx the parse tree
	 */
	void enterSumExpression(CUSTOMParser.SumExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#sumExpression}.
	 * @param ctx the parse tree
	 */
	void exitSumExpression(CUSTOMParser.SumExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#sumop}.
	 * @param ctx the parse tree
	 */
	void enterSumop(CUSTOMParser.SumopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#sumop}.
	 * @param ctx the parse tree
	 */
	void exitSumop(CUSTOMParser.SumopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#mulExpression}.
	 * @param ctx the parse tree
	 */
	void enterMulExpression(CUSTOMParser.MulExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#mulExpression}.
	 * @param ctx the parse tree
	 */
	void exitMulExpression(CUSTOMParser.MulExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(CUSTOMParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(CUSTOMParser.MulopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(CUSTOMParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(CUSTOMParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#unaryop}.
	 * @param ctx the parse tree
	 */
	void enterUnaryop(CUSTOMParser.UnaryopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#unaryop}.
	 * @param ctx the parse tree
	 */
	void exitUnaryop(CUSTOMParser.UnaryopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(CUSTOMParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(CUSTOMParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#mutable}.
	 * @param ctx the parse tree
	 */
	void enterMutable(CUSTOMParser.MutableContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#mutable}.
	 * @param ctx the parse tree
	 */
	void exitMutable(CUSTOMParser.MutableContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#immutable}.
	 * @param ctx the parse tree
	 */
	void enterImmutable(CUSTOMParser.ImmutableContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#immutable}.
	 * @param ctx the parse tree
	 */
	void exitImmutable(CUSTOMParser.ImmutableContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(CUSTOMParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(CUSTOMParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(CUSTOMParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(CUSTOMParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CUSTOMParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(CUSTOMParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link CUSTOMParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(CUSTOMParser.ConstantContext ctx);
}