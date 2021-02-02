// Generated from CUSTOM.g4 by ANTLR 4.9
package model;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CUSTOMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, AndAnd=7, Assign=8, Boolean=9, 
		Break=10, Colon=11, Comma=12, ConstantKey=13, Create=14, Div=15, Do=16, 
		Dot=17, DoubleQuotation=18, Down=19, Ellipsis=20, Else=21, Equal=22, False=23, 
		Float=24, For=25, Func=26, Greater=27, GreaterEqual=28, If=29, Int=30, 
		LeftBrace=31, LeftBracket=32, LeftParen=33, Less=34, LessEqual=35, Main=36, 
		Minus=37, Mod=38, Not=39, NotEqual=40, OrOr=41, Plus=42, Print=43, Return=44, 
		RightBrace=45, RightBracket=46, RightParen=47, Scan=48, Semi=49, Star=50, 
		String=51, Then=52, To=53, True=54, Up=55, Void=56, While=57, StringLiteral=58, 
		INTEGERCONSTANT=59, FLOATCONSTANT=60, BOOLCONSTANT=61, IDENTIFIER=62, 
		WHITSPACE=63, NEWLINE=64, BLOCKCOMMENT=65, LINECOMMENT=66;
	public static final int
		RULE_program = 0, RULE_mainBlock = 1, RULE_funcBlock = 2, RULE_funcTypeSpecifier = 3, 
		RULE_declaration = 4, RULE_arrayDeclaration = 5, RULE_arrayDeclarationInitialize = 6, 
		RULE_variableDeclaration = 7, RULE_variableDeclarationInitialize = 8, 
		RULE_typeSpecifier = 9, RULE_arrayTypeSpecifier = 10, RULE_params = 11, 
		RULE_paramList = 12, RULE_statement = 13, RULE_scanStatement = 14, RULE_printStatement = 15, 
		RULE_printStatementList = 16, RULE_printParameters = 17, RULE_illegalSymbols = 18, 
		RULE_expressionStatement = 19, RULE_compoundStatement = 20, RULE_compoundStatementList = 21, 
		RULE_selectionStatement = 22, RULE_elseStatement = 23, RULE_iterationStatement = 24, 
		RULE_whileStatement = 25, RULE_forStatement = 26, RULE_forCondition = 27, 
		RULE_forDeclaration = 28, RULE_forExpression = 29, RULE_returnStatement = 30, 
		RULE_expression = 31, RULE_experssionStandAlone = 32, RULE_conditionalExpression = 33, 
		RULE_simpleExpression = 34, RULE_arrayExpression = 35, RULE_andExpression = 36, 
		RULE_unaryRelExpression = 37, RULE_relExpression = 38, RULE_relop = 39, 
		RULE_sumExpression = 40, RULE_sumop = 41, RULE_mulExpression = 42, RULE_mulop = 43, 
		RULE_unaryExpression = 44, RULE_unaryop = 45, RULE_factor = 46, RULE_mutable = 47, 
		RULE_immutable = 48, RULE_call = 49, RULE_args = 50, RULE_constant = 51;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "mainBlock", "funcBlock", "funcTypeSpecifier", "declaration", 
			"arrayDeclaration", "arrayDeclarationInitialize", "variableDeclaration", 
			"variableDeclarationInitialize", "typeSpecifier", "arrayTypeSpecifier", 
			"params", "paramList", "statement", "scanStatement", "printStatement", 
			"printStatementList", "printParameters", "illegalSymbols", "expressionStatement", 
			"compoundStatement", "compoundStatementList", "selectionStatement", "elseStatement", 
			"iterationStatement", "whileStatement", "forStatement", "forCondition", 
			"forDeclaration", "forExpression", "returnStatement", "expression", "experssionStandAlone", 
			"conditionalExpression", "simpleExpression", "arrayExpression", "andExpression", 
			"unaryRelExpression", "relExpression", "relop", "sumExpression", "sumop", 
			"mulExpression", "mulop", "unaryExpression", "unaryop", "factor", "mutable", 
			"immutable", "call", "args", "constant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'?'", "'^'", "'@'", "'#'", "'`'", "'~'", "'&&'", "'='", "'bool'", 
			"'break'", "':'", "','", "'constant'", "'create'", "'/'", "'do'", "'.'", 
			"'\"'", "'down'", "'...'", "'else'", "'=='", "'F'", "'float'", "'for'", 
			"'func'", "'>'", "'>='", "'if'", "'int'", "'{'", "'['", "'('", "'<'", 
			"'<='", "'main'", "'-'", "'%'", "'!'", "'!='", "'||'", "'+'", "'print'", 
			"'return'", "'}'", "']'", "')'", "'scan'", "';'", "'*'", "'String'", 
			"'then'", "'to'", "'T'", "'up'", "'void'", "'while'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "AndAnd", "Assign", "Boolean", 
			"Break", "Colon", "Comma", "ConstantKey", "Create", "Div", "Do", "Dot", 
			"DoubleQuotation", "Down", "Ellipsis", "Else", "Equal", "False", "Float", 
			"For", "Func", "Greater", "GreaterEqual", "If", "Int", "LeftBrace", "LeftBracket", 
			"LeftParen", "Less", "LessEqual", "Main", "Minus", "Mod", "Not", "NotEqual", 
			"OrOr", "Plus", "Print", "Return", "RightBrace", "RightBracket", "RightParen", 
			"Scan", "Semi", "Star", "String", "Then", "To", "True", "Up", "Void", 
			"While", "StringLiteral", "INTEGERCONSTANT", "FLOATCONSTANT", "BOOLCONSTANT", 
			"IDENTIFIER", "WHITSPACE", "NEWLINE", "BLOCKCOMMENT", "LINECOMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CUSTOM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CUSTOMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public MainBlockContext mainBlock() {
			return getRuleContext(MainBlockContext.class,0);
		}
		public List<FuncBlockContext> funcBlock() {
			return getRuleContexts(FuncBlockContext.class);
		}
		public FuncBlockContext funcBlock(int i) {
			return getRuleContext(FuncBlockContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Func) {
				{
				{
				setState(104);
				funcBlock();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110);
			mainBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainBlockContext extends ParserRuleContext {
		public TerminalNode Main() { return getToken(CUSTOMParser.Main, 0); }
		public TerminalNode LeftParen() { return getToken(CUSTOMParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CUSTOMParser.RightParen, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CUSTOMParser.EOF, 0); }
		public MainBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterMainBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitMainBlock(this);
		}
	}

	public final MainBlockContext mainBlock() throws RecognitionException {
		MainBlockContext _localctx = new MainBlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(Main);
			setState(113);
			match(LeftParen);
			setState(114);
			match(RightParen);
			setState(115);
			compoundStatement();
			setState(116);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncBlockContext extends ParserRuleContext {
		public TerminalNode Func() { return getToken(CUSTOMParser.Func, 0); }
		public FuncTypeSpecifierContext funcTypeSpecifier() {
			return getRuleContext(FuncTypeSpecifierContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(CUSTOMParser.IDENTIFIER, 0); }
		public TerminalNode LeftParen() { return getToken(CUSTOMParser.LeftParen, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CUSTOMParser.RightParen, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public FuncBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterFuncBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitFuncBlock(this);
		}
	}

	public final FuncBlockContext funcBlock() throws RecognitionException {
		FuncBlockContext _localctx = new FuncBlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(Func);
			setState(119);
			funcTypeSpecifier();
			setState(120);
			match(IDENTIFIER);
			setState(121);
			match(LeftParen);
			setState(122);
			params();
			setState(123);
			match(RightParen);
			setState(124);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncTypeSpecifierContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public ArrayTypeSpecifierContext arrayTypeSpecifier() {
			return getRuleContext(ArrayTypeSpecifierContext.class,0);
		}
		public TerminalNode Void() { return getToken(CUSTOMParser.Void, 0); }
		public FuncTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcTypeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterFuncTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitFuncTypeSpecifier(this);
		}
	}

	public final FuncTypeSpecifierContext funcTypeSpecifier() throws RecognitionException {
		FuncTypeSpecifierContext _localctx = new FuncTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcTypeSpecifier);
		try {
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				typeSpecifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				arrayTypeSpecifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				match(Void);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public ArrayDeclarationContext arrayDeclaration() {
			return getRuleContext(ArrayDeclarationContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaration);
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				arrayDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				variableDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayDeclarationContext extends ParserRuleContext {
		public ArrayTypeSpecifierContext arrayTypeSpecifier() {
			return getRuleContext(ArrayTypeSpecifierContext.class,0);
		}
		public ArrayDeclarationInitializeContext arrayDeclarationInitialize() {
			return getRuleContext(ArrayDeclarationInitializeContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CUSTOMParser.Semi, 0); }
		public TerminalNode ConstantKey() { return getToken(CUSTOMParser.ConstantKey, 0); }
		public ArrayDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterArrayDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitArrayDeclaration(this);
		}
	}

	public final ArrayDeclarationContext arrayDeclaration() throws RecognitionException {
		ArrayDeclarationContext _localctx = new ArrayDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arrayDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ConstantKey) {
				{
				setState(135);
				match(ConstantKey);
				}
			}

			setState(138);
			arrayTypeSpecifier();
			setState(139);
			arrayDeclarationInitialize();
			setState(140);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayDeclarationInitializeContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CUSTOMParser.IDENTIFIER, 0); }
		public TerminalNode Assign() { return getToken(CUSTOMParser.Assign, 0); }
		public ArrayExpressionContext arrayExpression() {
			return getRuleContext(ArrayExpressionContext.class,0);
		}
		public MutableContext mutable() {
			return getRuleContext(MutableContext.class,0);
		}
		public ArrayDeclarationInitializeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDeclarationInitialize; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterArrayDeclarationInitialize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitArrayDeclarationInitialize(this);
		}
	}

	public final ArrayDeclarationInitializeContext arrayDeclarationInitialize() throws RecognitionException {
		ArrayDeclarationInitializeContext _localctx = new ArrayDeclarationInitializeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arrayDeclarationInitialize);
		int _la;
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(IDENTIFIER);
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Assign) {
					{
					setState(143);
					match(Assign);
					setState(144);
					arrayExpression();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				match(IDENTIFIER);
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Assign) {
					{
					setState(148);
					match(Assign);
					setState(149);
					mutable();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public VariableDeclarationInitializeContext variableDeclarationInitialize() {
			return getRuleContext(VariableDeclarationInitializeContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CUSTOMParser.Semi, 0); }
		public TerminalNode ConstantKey() { return getToken(CUSTOMParser.ConstantKey, 0); }
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitVariableDeclaration(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ConstantKey) {
				{
				setState(154);
				match(ConstantKey);
				}
			}

			setState(157);
			typeSpecifier();
			setState(158);
			variableDeclarationInitialize();
			setState(159);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclarationInitializeContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CUSTOMParser.IDENTIFIER, 0); }
		public TerminalNode Assign() { return getToken(CUSTOMParser.Assign, 0); }
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public VariableDeclarationInitializeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationInitialize; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterVariableDeclarationInitialize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitVariableDeclarationInitialize(this);
		}
	}

	public final VariableDeclarationInitializeContext variableDeclarationInitialize() throws RecognitionException {
		VariableDeclarationInitializeContext _localctx = new VariableDeclarationInitializeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variableDeclarationInitialize);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(IDENTIFIER);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(162);
				match(Assign);
				setState(163);
				simpleExpression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeSpecifierContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(CUSTOMParser.Int, 0); }
		public TerminalNode Boolean() { return getToken(CUSTOMParser.Boolean, 0); }
		public TerminalNode String() { return getToken(CUSTOMParser.String, 0); }
		public TerminalNode Float() { return getToken(CUSTOMParser.Float, 0); }
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitTypeSpecifier(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typeSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Boolean) | (1L << Float) | (1L << Int) | (1L << String))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayTypeSpecifierContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(CUSTOMParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CUSTOMParser.RightBracket, 0); }
		public ArrayTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayTypeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterArrayTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitArrayTypeSpecifier(this);
		}
	}

	public final ArrayTypeSpecifierContext arrayTypeSpecifier() throws RecognitionException {
		ArrayTypeSpecifierContext _localctx = new ArrayTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arrayTypeSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			typeSpecifier();
			setState(169);
			match(LeftBracket);
			setState(170);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamListContext> paramList() {
			return getRuleContexts(ParamListContext.class);
		}
		public ParamListContext paramList(int i) {
			return getRuleContext(ParamListContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CUSTOMParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CUSTOMParser.Comma, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_params);
		int _la;
		try {
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Boolean:
			case Float:
			case Int:
			case String:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				paramList();
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(173);
					match(Comma);
					setState(174);
					paramList();
					}
					}
					setState(179);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case RightParen:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamListContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CUSTOMParser.IDENTIFIER, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public ArrayTypeSpecifierContext arrayTypeSpecifier() {
			return getRuleContext(ArrayTypeSpecifierContext.class,0);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitParamList(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_paramList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(183);
				typeSpecifier();
				}
				break;
			case 2:
				{
				setState(184);
				arrayTypeSpecifier();
				}
				break;
			}
			setState(187);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public ScanStatementContext scanStatement() {
			return getRuleContext(ScanStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statement);
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Scan:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				scanStatement();
				}
				break;
			case Print:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				printStatement();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				expressionStatement();
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 4);
				{
				setState(192);
				compoundStatement();
				}
				break;
			case If:
				enterOuterAlt(_localctx, 5);
				{
				setState(193);
				selectionStatement();
				}
				break;
			case For:
			case While:
				enterOuterAlt(_localctx, 6);
				{
				setState(194);
				iterationStatement();
				}
				break;
			case Return:
				enterOuterAlt(_localctx, 7);
				{
				setState(195);
				returnStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScanStatementContext extends ParserRuleContext {
		public TerminalNode Scan() { return getToken(CUSTOMParser.Scan, 0); }
		public TerminalNode LeftParen() { return getToken(CUSTOMParser.LeftParen, 0); }
		public TerminalNode StringLiteral() { return getToken(CUSTOMParser.StringLiteral, 0); }
		public TerminalNode Comma() { return getToken(CUSTOMParser.Comma, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CUSTOMParser.IDENTIFIER, 0); }
		public TerminalNode RightParen() { return getToken(CUSTOMParser.RightParen, 0); }
		public TerminalNode Semi() { return getToken(CUSTOMParser.Semi, 0); }
		public ScanStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scanStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterScanStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitScanStatement(this);
		}
	}

	public final ScanStatementContext scanStatement() throws RecognitionException {
		ScanStatementContext _localctx = new ScanStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_scanStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(Scan);
			setState(199);
			match(LeftParen);
			setState(200);
			match(StringLiteral);
			setState(201);
			match(Comma);
			setState(202);
			match(IDENTIFIER);
			setState(203);
			match(RightParen);
			setState(204);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStatementContext extends ParserRuleContext {
		public TerminalNode Print() { return getToken(CUSTOMParser.Print, 0); }
		public TerminalNode LeftParen() { return getToken(CUSTOMParser.LeftParen, 0); }
		public PrintStatementListContext printStatementList() {
			return getRuleContext(PrintStatementListContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CUSTOMParser.RightParen, 0); }
		public TerminalNode Semi() { return getToken(CUSTOMParser.Semi, 0); }
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitPrintStatement(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(Print);
			setState(207);
			match(LeftParen);
			setState(208);
			printStatementList(0);
			setState(209);
			match(RightParen);
			setState(210);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStatementListContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(CUSTOMParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(CUSTOMParser.IDENTIFIER, i);
		}
		public List<TerminalNode> INTEGERCONSTANT() { return getTokens(CUSTOMParser.INTEGERCONSTANT); }
		public TerminalNode INTEGERCONSTANT(int i) {
			return getToken(CUSTOMParser.INTEGERCONSTANT, i);
		}
		public List<IllegalSymbolsContext> illegalSymbols() {
			return getRuleContexts(IllegalSymbolsContext.class);
		}
		public IllegalSymbolsContext illegalSymbols(int i) {
			return getRuleContext(IllegalSymbolsContext.class,i);
		}
		public List<PrintParametersContext> printParameters() {
			return getRuleContexts(PrintParametersContext.class);
		}
		public PrintParametersContext printParameters(int i) {
			return getRuleContext(PrintParametersContext.class,i);
		}
		public List<TerminalNode> Plus() { return getTokens(CUSTOMParser.Plus); }
		public TerminalNode Plus(int i) {
			return getToken(CUSTOMParser.Plus, i);
		}
		public PrintStatementListContext printStatementList() {
			return getRuleContext(PrintStatementListContext.class,0);
		}
		public PrintStatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterPrintStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitPrintStatementList(this);
		}
	}

	public final PrintStatementListContext printStatementList() throws RecognitionException {
		return printStatementList(0);
	}

	private PrintStatementListContext printStatementList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrintStatementListContext _localctx = new PrintStatementListContext(_ctx, _parentState);
		PrintStatementListContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_printStatementList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(216);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(213);
					match(IDENTIFIER);
					}
					break;
				case INTEGERCONSTANT:
					{
					setState(214);
					match(INTEGERCONSTANT);
					}
					break;
				case T__0:
				case T__1:
				case T__2:
				case T__3:
				case T__4:
				case T__5:
				case Colon:
				case Comma:
				case LeftBrace:
				case LeftBracket:
				case Minus:
				case Mod:
				case Not:
				case RightBrace:
				case RightBracket:
				case Semi:
				case Star:
					{
					setState(215);
					illegalSymbols();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(221); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(221);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case IDENTIFIER:
							{
							setState(218);
							match(IDENTIFIER);
							}
							break;
						case INTEGERCONSTANT:
							{
							setState(219);
							match(INTEGERCONSTANT);
							}
							break;
						case T__0:
						case T__1:
						case T__2:
						case T__3:
						case T__4:
						case T__5:
						case Colon:
						case Comma:
						case LeftBrace:
						case LeftBracket:
						case Minus:
						case Mod:
						case Not:
						case RightBrace:
						case RightBracket:
						case Semi:
						case Star:
							{
							setState(220);
							illegalSymbols();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(223); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				notifyErrorListeners("Missing double quotes in print statement. Consider wrapping it with double quotes.");
				}
				break;
			case 2:
				{
				setState(226);
				printParameters();
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(227);
						match(Plus);
						setState(228);
						printParameters();
						}
						} 
					}
					setState(233);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(241);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PrintStatementListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_printStatementList);
					setState(236);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(237);
					match(Plus);
					notifyErrorListeners("Excess '+' found in print statement. Consider removing it or concatenate with a variable.");
					}
					} 
				}
				setState(243);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrintParametersContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(CUSTOMParser.StringLiteral, 0); }
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(CUSTOMParser.IDENTIFIER, 0); }
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public PrintParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterPrintParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitPrintParameters(this);
		}
	}

	public final PrintParametersContext printParameters() throws RecognitionException {
		PrintParametersContext _localctx = new PrintParametersContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_printParameters);
		try {
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				match(StringLiteral);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				call();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
				match(IDENTIFIER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(247);
				simpleExpression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IllegalSymbolsContext extends ParserRuleContext {
		public TerminalNode Not() { return getToken(CUSTOMParser.Not, 0); }
		public TerminalNode Comma() { return getToken(CUSTOMParser.Comma, 0); }
		public TerminalNode Colon() { return getToken(CUSTOMParser.Colon, 0); }
		public TerminalNode Minus() { return getToken(CUSTOMParser.Minus, 0); }
		public TerminalNode Semi() { return getToken(CUSTOMParser.Semi, 0); }
		public TerminalNode Star() { return getToken(CUSTOMParser.Star, 0); }
		public TerminalNode LeftBrace() { return getToken(CUSTOMParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CUSTOMParser.RightBrace, 0); }
		public TerminalNode LeftBracket() { return getToken(CUSTOMParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CUSTOMParser.RightBracket, 0); }
		public TerminalNode Mod() { return getToken(CUSTOMParser.Mod, 0); }
		public IllegalSymbolsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_illegalSymbols; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterIllegalSymbols(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitIllegalSymbols(this);
		}
	}

	public final IllegalSymbolsContext illegalSymbols() throws RecognitionException {
		IllegalSymbolsContext _localctx = new IllegalSymbolsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_illegalSymbols);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << Colon) | (1L << Comma) | (1L << LeftBrace) | (1L << LeftBracket) | (1L << Minus) | (1L << Mod) | (1L << Not) | (1L << RightBrace) | (1L << RightBracket) | (1L << Semi) | (1L << Star))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionStatementContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(CUSTOMParser.Semi, 0); }
		public ExperssionStandAloneContext experssionStandAlone() {
			return getRuleContext(ExperssionStandAloneContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitExpressionStatement(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(252);
				experssionStandAlone();
				}
				break;
			case 2:
				{
				setState(253);
				call();
				}
				break;
			}
			setState(256);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundStatementContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(CUSTOMParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CUSTOMParser.RightBrace, 0); }
		public List<CompoundStatementListContext> compoundStatementList() {
			return getRuleContexts(CompoundStatementListContext.class);
		}
		public CompoundStatementListContext compoundStatementList(int i) {
			return getRuleContext(CompoundStatementListContext.class,i);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitCompoundStatement(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(LeftBrace);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Boolean) | (1L << ConstantKey) | (1L << Float) | (1L << For) | (1L << If) | (1L << Int) | (1L << LeftBrace) | (1L << Print) | (1L << Return) | (1L << Scan) | (1L << String) | (1L << While) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(259);
				compoundStatementList();
				}
				}
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(265);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundStatementListContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public CompoundStatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterCompoundStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitCompoundStatementList(this);
		}
	}

	public final CompoundStatementListContext compoundStatementList() throws RecognitionException {
		CompoundStatementListContext _localctx = new CompoundStatementListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_compoundStatementList);
		try {
			setState(269);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Boolean:
			case ConstantKey:
			case Float:
			case Int:
			case String:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				declaration();
				}
				break;
			case For:
			case If:
			case LeftBrace:
			case Print:
			case Return:
			case Scan:
			case While:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectionStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(CUSTOMParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(CUSTOMParser.LeftParen, 0); }
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CUSTOMParser.RightParen, 0); }
		public TerminalNode Then() { return getToken(CUSTOMParser.Then, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public SelectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterSelectionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitSelectionStatement(this);
		}
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_selectionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(If);
			setState(272);
			match(LeftParen);
			setState(273);
			simpleExpression(0);
			setState(274);
			match(RightParen);
			setState(275);
			match(Then);
			setState(276);
			compoundStatement();
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Else) {
				{
				setState(277);
				elseStatement();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(CUSTOMParser.Else, 0); }
		public TerminalNode Then() { return getToken(CUSTOMParser.Then, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitElseStatement(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_elseStatement);
		try {
			setState(285);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				match(Else);
				setState(281);
				match(Then);
				setState(282);
				compoundStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(283);
				match(Else);
				setState(284);
				selectionStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IterationStatementContext extends ParserRuleContext {
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterIterationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitIterationStatement(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_iterationStatement);
		try {
			setState(289);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				whileStatement();
				}
				break;
			case For:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				forStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(CUSTOMParser.While, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CUSTOMParser.IDENTIFIER, 0); }
		public TerminalNode Up() { return getToken(CUSTOMParser.Up, 0); }
		public TerminalNode To() { return getToken(CUSTOMParser.To, 0); }
		public RelExpressionContext relExpression() {
			return getRuleContext(RelExpressionContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public TerminalNode Down() { return getToken(CUSTOMParser.Down, 0); }
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_whileStatement);
		try {
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				match(While);
				setState(292);
				match(IDENTIFIER);
				setState(293);
				match(Up);
				setState(294);
				match(To);
				setState(295);
				relExpression();
				setState(296);
				compoundStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				match(While);
				setState(299);
				match(IDENTIFIER);
				setState(300);
				match(Down);
				setState(301);
				match(To);
				setState(302);
				relExpression();
				setState(303);
				compoundStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode For() { return getToken(CUSTOMParser.For, 0); }
		public ForConditionContext forCondition() {
			return getRuleContext(ForConditionContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(For);
			setState(308);
			forCondition();
			setState(309);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForConditionContext extends ParserRuleContext {
		public ForDeclarationContext forDeclaration() {
			return getRuleContext(ForDeclarationContext.class,0);
		}
		public ForExpressionContext forExpression() {
			return getRuleContext(ForExpressionContext.class,0);
		}
		public ForConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterForCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitForCondition(this);
		}
	}

	public final ForConditionContext forCondition() throws RecognitionException {
		ForConditionContext _localctx = new ForConditionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_forCondition);
		try {
			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				forDeclaration();
				setState(312);
				forExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				forDeclaration();
				notifyErrorListeners("Expecting 'up to' or 'down to' then expression");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForDeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CUSTOMParser.IDENTIFIER, 0); }
		public TerminalNode Assign() { return getToken(CUSTOMParser.Assign, 0); }
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public TerminalNode Int() { return getToken(CUSTOMParser.Int, 0); }
		public ForDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterForDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitForDeclaration(this);
		}
	}

	public final ForDeclarationContext forDeclaration() throws RecognitionException {
		ForDeclarationContext _localctx = new ForDeclarationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_forDeclaration);
		int _la;
		try {
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(319);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Int) {
					{
					setState(320);
					match(Int);
					}
				}

				setState(323);
				match(IDENTIFIER);
				setState(324);
				match(Assign);
				setState(325);
				simpleExpression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForExpressionContext extends ParserRuleContext {
		public TerminalNode To() { return getToken(CUSTOMParser.To, 0); }
		public SumExpressionContext sumExpression() {
			return getRuleContext(SumExpressionContext.class,0);
		}
		public TerminalNode Up() { return getToken(CUSTOMParser.Up, 0); }
		public TerminalNode Down() { return getToken(CUSTOMParser.Down, 0); }
		public ForExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterForExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitForExpression(this);
		}
	}

	public final ForExpressionContext forExpression() throws RecognitionException {
		ForExpressionContext _localctx = new ForExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_forExpression);
		int _la;
		try {
			setState(337);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				_la = _input.LA(1);
				if ( !(_la==Down || _la==Up) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(329);
				match(To);
				setState(330);
				sumExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				notifyErrorListeners("Expecting the word 'up' or 'down'");
				setState(332);
				match(To);
				setState(333);
				sumExpression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(334);
				_la = _input.LA(1);
				if ( !(_la==Down || _la==Up) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				notifyErrorListeners("Expecting the word 'to'");
				setState(336);
				sumExpression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(CUSTOMParser.Return, 0); }
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CUSTOMParser.Semi, 0); }
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(Return);
			setState(340);
			simpleExpression(0);
			setState(341);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public MutableContext mutable() {
			return getRuleContext(MutableContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CUSTOMParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public ArrayExpressionContext arrayExpression() {
			return getRuleContext(ArrayExpressionContext.class,0);
		}
		public SumExpressionContext sumExpression() {
			return getRuleContext(SumExpressionContext.class,0);
		}
		public MulExpressionContext mulExpression() {
			return getRuleContext(MulExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_expression);
		try {
			setState(351);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(343);
				mutable();
				setState(344);
				match(Assign);
				setState(345);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				simpleExpression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(348);
				arrayExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(349);
				sumExpression(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(350);
				mulExpression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExperssionStandAloneContext extends ParserRuleContext {
		public MutableContext mutable() {
			return getRuleContext(MutableContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CUSTOMParser.Assign, 0); }
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public ArrayExpressionContext arrayExpression() {
			return getRuleContext(ArrayExpressionContext.class,0);
		}
		public ExperssionStandAloneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_experssionStandAlone; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterExperssionStandAlone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitExperssionStandAlone(this);
		}
	}

	public final ExperssionStandAloneContext experssionStandAlone() throws RecognitionException {
		ExperssionStandAloneContext _localctx = new ExperssionStandAloneContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_experssionStandAlone);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			mutable();
			setState(354);
			match(Assign);
			setState(357);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
			case Minus:
			case Not:
			case StringLiteral:
			case INTEGERCONSTANT:
			case FLOATCONSTANT:
			case BOOLCONSTANT:
			case IDENTIFIER:
				{
				setState(355);
				simpleExpression(0);
				}
				break;
			case Create:
				{
				setState(356);
				arrayExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalExpressionContext extends ParserRuleContext {
		public RelExpressionContext relExpression() {
			return getRuleContext(RelExpressionContext.class,0);
		}
		public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitConditionalExpression(this);
		}
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_conditionalExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			relExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleExpressionContext extends ParserRuleContext {
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public List<SimpleExpressionContext> simpleExpression() {
			return getRuleContexts(SimpleExpressionContext.class);
		}
		public SimpleExpressionContext simpleExpression(int i) {
			return getRuleContext(SimpleExpressionContext.class,i);
		}
		public TerminalNode OrOr() { return getToken(CUSTOMParser.OrOr, 0); }
		public SimpleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterSimpleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitSimpleExpression(this);
		}
	}

	public final SimpleExpressionContext simpleExpression() throws RecognitionException {
		return simpleExpression(0);
	}

	private SimpleExpressionContext simpleExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SimpleExpressionContext _localctx = new SimpleExpressionContext(_ctx, _parentState);
		SimpleExpressionContext _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_simpleExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(362);
			andExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(377);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(375);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						_localctx = new SimpleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_simpleExpression);
						setState(364);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(365);
						match(OrOr);
						setState(366);
						andExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new SimpleExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_simpleExpression);
						setState(367);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(369); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(368);
								simpleExpression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(371); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						notifyErrorListeners("missing valid operators");
						}
						break;
					}
					} 
				}
				setState(379);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArrayExpressionContext extends ParserRuleContext {
		public TerminalNode Create() { return getToken(CUSTOMParser.Create, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(CUSTOMParser.LeftBracket, 0); }
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(CUSTOMParser.RightBracket, 0); }
		public ArrayExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterArrayExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitArrayExpression(this);
		}
	}

	public final ArrayExpressionContext arrayExpression() throws RecognitionException {
		ArrayExpressionContext _localctx = new ArrayExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_arrayExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(Create);
			setState(381);
			typeSpecifier();
			setState(382);
			match(LeftBracket);
			setState(383);
			simpleExpression(0);
			setState(384);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndExpressionContext extends ParserRuleContext {
		public UnaryRelExpressionContext unaryRelExpression() {
			return getRuleContext(UnaryRelExpressionContext.class,0);
		}
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public TerminalNode AndAnd() { return getToken(CUSTOMParser.AndAnd, 0); }
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitAndExpression(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		return andExpression(0);
	}

	private AndExpressionContext andExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, _parentState);
		AndExpressionContext _prevctx = _localctx;
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_andExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(387);
			unaryRelExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(394);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andExpression);
					setState(389);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(390);
					match(AndAnd);
					setState(391);
					unaryRelExpression();
					}
					} 
				}
				setState(396);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryRelExpressionContext extends ParserRuleContext {
		public TerminalNode Not() { return getToken(CUSTOMParser.Not, 0); }
		public UnaryRelExpressionContext unaryRelExpression() {
			return getRuleContext(UnaryRelExpressionContext.class,0);
		}
		public RelExpressionContext relExpression() {
			return getRuleContext(RelExpressionContext.class,0);
		}
		public UnaryRelExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryRelExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterUnaryRelExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitUnaryRelExpression(this);
		}
	}

	public final UnaryRelExpressionContext unaryRelExpression() throws RecognitionException {
		UnaryRelExpressionContext _localctx = new UnaryRelExpressionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_unaryRelExpression);
		try {
			setState(400);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Not:
				enterOuterAlt(_localctx, 1);
				{
				setState(397);
				match(Not);
				setState(398);
				unaryRelExpression();
				}
				break;
			case LeftParen:
			case Minus:
			case StringLiteral:
			case INTEGERCONSTANT:
			case FLOATCONSTANT:
			case BOOLCONSTANT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(399);
				relExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelExpressionContext extends ParserRuleContext {
		public List<SumExpressionContext> sumExpression() {
			return getRuleContexts(SumExpressionContext.class);
		}
		public SumExpressionContext sumExpression(int i) {
			return getRuleContext(SumExpressionContext.class,i);
		}
		public RelopContext relop() {
			return getRuleContext(RelopContext.class,0);
		}
		public RelExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterRelExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitRelExpression(this);
		}
	}

	public final RelExpressionContext relExpression() throws RecognitionException {
		RelExpressionContext _localctx = new RelExpressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_relExpression);
		try {
			setState(407);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(402);
				sumExpression(0);
				setState(403);
				relop();
				setState(404);
				sumExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(406);
				sumExpression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelopContext extends ParserRuleContext {
		public TerminalNode LessEqual() { return getToken(CUSTOMParser.LessEqual, 0); }
		public TerminalNode Less() { return getToken(CUSTOMParser.Less, 0); }
		public TerminalNode Greater() { return getToken(CUSTOMParser.Greater, 0); }
		public TerminalNode GreaterEqual() { return getToken(CUSTOMParser.GreaterEqual, 0); }
		public TerminalNode Equal() { return getToken(CUSTOMParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(CUSTOMParser.NotEqual, 0); }
		public RelopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterRelop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitRelop(this);
		}
	}

	public final RelopContext relop() throws RecognitionException {
		RelopContext _localctx = new RelopContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_relop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Equal) | (1L << Greater) | (1L << GreaterEqual) | (1L << Less) | (1L << LessEqual) | (1L << NotEqual))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SumExpressionContext extends ParserRuleContext {
		public SumopContext g;
		public MulExpressionContext mulExpression() {
			return getRuleContext(MulExpressionContext.class,0);
		}
		public SumExpressionContext sumExpression() {
			return getRuleContext(SumExpressionContext.class,0);
		}
		public List<SumopContext> sumop() {
			return getRuleContexts(SumopContext.class);
		}
		public SumopContext sumop(int i) {
			return getRuleContext(SumopContext.class,i);
		}
		public SumExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sumExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterSumExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitSumExpression(this);
		}
	}

	public final SumExpressionContext sumExpression() throws RecognitionException {
		return sumExpression(0);
	}

	private SumExpressionContext sumExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SumExpressionContext _localctx = new SumExpressionContext(_ctx, _parentState);
		SumExpressionContext _prevctx = _localctx;
		int _startState = 80;
		enterRecursionRule(_localctx, 80, RULE_sumExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(412);
			mulExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(430);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(428);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
					case 1:
						{
						_localctx = new SumExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_sumExpression);
						setState(414);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(415);
						sumop();
						setState(416);
						mulExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new SumExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_sumExpression);
						setState(418);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(419);
						sumop();
						setState(421); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(420);
								((SumExpressionContext)_localctx).g = sumop();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(423); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(425);
						mulExpression(0);
						notifyErrorListeners("Mismatched input " + (((SumExpressionContext)_localctx).g!=null?_input.getText(((SumExpressionContext)_localctx).g.start,((SumExpressionContext)_localctx).g.stop):null) + ". Expecting '+', '-', '*', or '/' as operator only.");
						}
						break;
					}
					} 
				}
				setState(432);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SumopContext extends ParserRuleContext {
		public TerminalNode Plus() { return getToken(CUSTOMParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(CUSTOMParser.Minus, 0); }
		public SumopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sumop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterSumop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitSumop(this);
		}
	}

	public final SumopContext sumop() throws RecognitionException {
		SumopContext _localctx = new SumopContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_sumop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			_la = _input.LA(1);
			if ( !(_la==Minus || _la==Plus) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MulExpressionContext extends ParserRuleContext {
		public MulopContext g;
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public MulExpressionContext mulExpression() {
			return getRuleContext(MulExpressionContext.class,0);
		}
		public List<MulopContext> mulop() {
			return getRuleContexts(MulopContext.class);
		}
		public MulopContext mulop(int i) {
			return getRuleContext(MulopContext.class,i);
		}
		public MulExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterMulExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitMulExpression(this);
		}
	}

	public final MulExpressionContext mulExpression() throws RecognitionException {
		return mulExpression(0);
	}

	private MulExpressionContext mulExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulExpressionContext _localctx = new MulExpressionContext(_ctx, _parentState);
		MulExpressionContext _prevctx = _localctx;
		int _startState = 84;
		enterRecursionRule(_localctx, 84, RULE_mulExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(436);
			unaryExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(454);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(452);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
					case 1:
						{
						_localctx = new MulExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_mulExpression);
						setState(438);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(439);
						mulop();
						setState(440);
						unaryExpression();
						}
						break;
					case 2:
						{
						_localctx = new MulExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_mulExpression);
						setState(442);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(443);
						mulop();
						setState(445); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(444);
							((MulExpressionContext)_localctx).g = mulop();
							}
							}
							setState(447); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==Div || _la==Star );
						setState(449);
						unaryExpression();
						notifyErrorListeners("Mismatched input " + (((MulExpressionContext)_localctx).g!=null?_input.getText(((MulExpressionContext)_localctx).g.start,((MulExpressionContext)_localctx).g.stop):null) + ". Expecting '+', '-', '*', or '/' as operator only.");
						}
						break;
					}
					} 
				}
				setState(456);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MulopContext extends ParserRuleContext {
		public TerminalNode Star() { return getToken(CUSTOMParser.Star, 0); }
		public TerminalNode Div() { return getToken(CUSTOMParser.Div, 0); }
		public MulopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterMulop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitMulop(this);
		}
	}

	public final MulopContext mulop() throws RecognitionException {
		MulopContext _localctx = new MulopContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_mulop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			_la = _input.LA(1);
			if ( !(_la==Div || _la==Star) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends ParserRuleContext {
		public UnaryopContext unaryop() {
			return getRuleContext(UnaryopContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitUnaryExpression(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_unaryExpression);
		try {
			setState(463);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Minus:
				enterOuterAlt(_localctx, 1);
				{
				setState(459);
				unaryop();
				setState(460);
				unaryExpression();
				}
				break;
			case LeftParen:
			case StringLiteral:
			case INTEGERCONSTANT:
			case FLOATCONSTANT:
			case BOOLCONSTANT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(462);
				factor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryopContext extends ParserRuleContext {
		public TerminalNode Minus() { return getToken(CUSTOMParser.Minus, 0); }
		public UnaryopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterUnaryop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitUnaryop(this);
		}
	}

	public final UnaryopContext unaryop() throws RecognitionException {
		UnaryopContext _localctx = new UnaryopContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_unaryop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			match(Minus);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public ImmutableContext immutable() {
			return getRuleContext(ImmutableContext.class,0);
		}
		public MutableContext mutable() {
			return getRuleContext(MutableContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_factor);
		try {
			setState(469);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(467);
				immutable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(468);
				mutable();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MutableContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CUSTOMParser.IDENTIFIER, 0); }
		public TerminalNode LeftBracket() { return getToken(CUSTOMParser.LeftBracket, 0); }
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(CUSTOMParser.RightBracket, 0); }
		public MutableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mutable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterMutable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitMutable(this);
		}
	}

	public final MutableContext mutable() throws RecognitionException {
		MutableContext _localctx = new MutableContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_mutable);
		try {
			setState(477);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(471);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(472);
				match(IDENTIFIER);
				setState(473);
				match(LeftBracket);
				setState(474);
				simpleExpression(0);
				setState(475);
				match(RightBracket);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImmutableContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(CUSTOMParser.LeftParen, 0); }
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CUSTOMParser.RightParen, 0); }
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ImmutableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_immutable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterImmutable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitImmutable(this);
		}
	}

	public final ImmutableContext immutable() throws RecognitionException {
		ImmutableContext _localctx = new ImmutableContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_immutable);
		try {
			setState(485);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
				enterOuterAlt(_localctx, 1);
				{
				setState(479);
				match(LeftParen);
				setState(480);
				simpleExpression(0);
				setState(481);
				match(RightParen);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(483);
				call();
				}
				break;
			case StringLiteral:
			case INTEGERCONSTANT:
			case FLOATCONSTANT:
			case BOOLCONSTANT:
				enterOuterAlt(_localctx, 3);
				{
				setState(484);
				constant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CUSTOMParser.IDENTIFIER, 0); }
		public TerminalNode LeftParen() { return getToken(CUSTOMParser.LeftParen, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CUSTOMParser.RightParen, 0); }
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitCall(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			match(IDENTIFIER);
			setState(488);
			match(LeftParen);
			setState(489);
			args();
			setState(490);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<SimpleExpressionContext> simpleExpression() {
			return getRuleContexts(SimpleExpressionContext.class);
		}
		public SimpleExpressionContext simpleExpression(int i) {
			return getRuleContext(SimpleExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CUSTOMParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CUSTOMParser.Comma, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_args);
		int _la;
		try {
			setState(501);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
			case Minus:
			case Not:
			case StringLiteral:
			case INTEGERCONSTANT:
			case FLOATCONSTANT:
			case BOOLCONSTANT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(492);
				simpleExpression(0);
				setState(497);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(493);
					match(Comma);
					setState(494);
					simpleExpression(0);
					}
					}
					setState(499);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case RightParen:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode INTEGERCONSTANT() { return getToken(CUSTOMParser.INTEGERCONSTANT, 0); }
		public TerminalNode FLOATCONSTANT() { return getToken(CUSTOMParser.FLOATCONSTANT, 0); }
		public TerminalNode StringLiteral() { return getToken(CUSTOMParser.StringLiteral, 0); }
		public TerminalNode BOOLCONSTANT() { return getToken(CUSTOMParser.BOOLCONSTANT, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CUSTOMListener ) ((CUSTOMListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << StringLiteral) | (1L << INTEGERCONSTANT) | (1L << FLOATCONSTANT) | (1L << BOOLCONSTANT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return printStatementList_sempred((PrintStatementListContext)_localctx, predIndex);
		case 34:
			return simpleExpression_sempred((SimpleExpressionContext)_localctx, predIndex);
		case 36:
			return andExpression_sempred((AndExpressionContext)_localctx, predIndex);
		case 40:
			return sumExpression_sempred((SumExpressionContext)_localctx, predIndex);
		case 42:
			return mulExpression_sempred((MulExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean printStatementList_sempred(PrintStatementListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean simpleExpression_sempred(SimpleExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean andExpression_sempred(AndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean sumExpression_sempred(SumExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean mulExpression_sempred(MulExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3D\u01fc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\3\2\7\2l\n\2\f\2\16\2o\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\5\5\u0084\n\5\3\6\3\6"+
		"\5\6\u0088\n\6\3\7\5\7\u008b\n\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\5\b\u0094"+
		"\n\b\3\b\3\b\3\b\5\b\u0099\n\b\5\b\u009b\n\b\3\t\5\t\u009e\n\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\5\n\u00a7\n\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\7\r\u00b2\n\r\f\r\16\r\u00b5\13\r\3\r\5\r\u00b8\n\r\3\16\3\16\5\16"+
		"\u00bc\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00c7\n"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\5\22\u00db\n\22\3\22\3\22\3\22\6\22\u00e0\n\22"+
		"\r\22\16\22\u00e1\3\22\3\22\3\22\3\22\7\22\u00e8\n\22\f\22\16\22\u00eb"+
		"\13\22\5\22\u00ed\n\22\3\22\3\22\3\22\7\22\u00f2\n\22\f\22\16\22\u00f5"+
		"\13\22\3\23\3\23\3\23\3\23\5\23\u00fb\n\23\3\24\3\24\3\25\3\25\5\25\u0101"+
		"\n\25\3\25\3\25\3\26\3\26\7\26\u0107\n\26\f\26\16\26\u010a\13\26\3\26"+
		"\3\26\3\27\3\27\5\27\u0110\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u0119\n\30\3\31\3\31\3\31\3\31\3\31\5\31\u0120\n\31\3\32\3\32\5\32\u0124"+
		"\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\5\33\u0134\n\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\5\35\u0140\n\35\3\36\3\36\5\36\u0144\n\36\3\36\3\36\3\36\5\36\u0149\n"+
		"\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0154\n\37\3 \3"+
		" \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\5!\u0162\n!\3\"\3\"\3\"\3\"\5\"\u0168"+
		"\n\"\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\6$\u0174\n$\r$\16$\u0175\3$\3$\7$\u017a"+
		"\n$\f$\16$\u017d\13$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\7&\u018b\n&\f"+
		"&\16&\u018e\13&\3\'\3\'\3\'\5\'\u0193\n\'\3(\3(\3(\3(\3(\5(\u019a\n(\3"+
		")\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\6*\u01a8\n*\r*\16*\u01a9\3*\3*\3*\7"+
		"*\u01af\n*\f*\16*\u01b2\13*\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\6,\u01c0"+
		"\n,\r,\16,\u01c1\3,\3,\3,\7,\u01c7\n,\f,\16,\u01ca\13,\3-\3-\3.\3.\3."+
		"\3.\5.\u01d2\n.\3/\3/\3\60\3\60\5\60\u01d8\n\60\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\5\61\u01e0\n\61\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u01e8\n\62"+
		"\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\7\64\u01f2\n\64\f\64\16\64\u01f5"+
		"\13\64\3\64\5\64\u01f8\n\64\3\65\3\65\3\65\2\7\"FJRV\66\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd"+
		"fh\2\t\6\2\13\13\32\32  \65\65\b\2\3\b\r\16!\"\')/\60\63\64\4\2\25\25"+
		"99\6\2\30\30\35\36$%**\4\2\'\',,\4\2\21\21\64\64\3\2<?\2\u0209\2m\3\2"+
		"\2\2\4r\3\2\2\2\6x\3\2\2\2\b\u0083\3\2\2\2\n\u0087\3\2\2\2\f\u008a\3\2"+
		"\2\2\16\u009a\3\2\2\2\20\u009d\3\2\2\2\22\u00a3\3\2\2\2\24\u00a8\3\2\2"+
		"\2\26\u00aa\3\2\2\2\30\u00b7\3\2\2\2\32\u00bb\3\2\2\2\34\u00c6\3\2\2\2"+
		"\36\u00c8\3\2\2\2 \u00d0\3\2\2\2\"\u00ec\3\2\2\2$\u00fa\3\2\2\2&\u00fc"+
		"\3\2\2\2(\u0100\3\2\2\2*\u0104\3\2\2\2,\u010f\3\2\2\2.\u0111\3\2\2\2\60"+
		"\u011f\3\2\2\2\62\u0123\3\2\2\2\64\u0133\3\2\2\2\66\u0135\3\2\2\28\u013f"+
		"\3\2\2\2:\u0148\3\2\2\2<\u0153\3\2\2\2>\u0155\3\2\2\2@\u0161\3\2\2\2B"+
		"\u0163\3\2\2\2D\u0169\3\2\2\2F\u016b\3\2\2\2H\u017e\3\2\2\2J\u0184\3\2"+
		"\2\2L\u0192\3\2\2\2N\u0199\3\2\2\2P\u019b\3\2\2\2R\u019d\3\2\2\2T\u01b3"+
		"\3\2\2\2V\u01b5\3\2\2\2X\u01cb\3\2\2\2Z\u01d1\3\2\2\2\\\u01d3\3\2\2\2"+
		"^\u01d7\3\2\2\2`\u01df\3\2\2\2b\u01e7\3\2\2\2d\u01e9\3\2\2\2f\u01f7\3"+
		"\2\2\2h\u01f9\3\2\2\2jl\5\6\4\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2"+
		"\2np\3\2\2\2om\3\2\2\2pq\5\4\3\2q\3\3\2\2\2rs\7&\2\2st\7#\2\2tu\7\61\2"+
		"\2uv\5*\26\2vw\7\2\2\3w\5\3\2\2\2xy\7\34\2\2yz\5\b\5\2z{\7@\2\2{|\7#\2"+
		"\2|}\5\30\r\2}~\7\61\2\2~\177\5*\26\2\177\7\3\2\2\2\u0080\u0084\5\24\13"+
		"\2\u0081\u0084\5\26\f\2\u0082\u0084\7:\2\2\u0083\u0080\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0082\3\2\2\2\u0084\t\3\2\2\2\u0085\u0088\5\f\7\2\u0086"+
		"\u0088\5\20\t\2\u0087\u0085\3\2\2\2\u0087\u0086\3\2\2\2\u0088\13\3\2\2"+
		"\2\u0089\u008b\7\17\2\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008d\5\26\f\2\u008d\u008e\5\16\b\2\u008e\u008f\7"+
		"\63\2\2\u008f\r\3\2\2\2\u0090\u0093\7@\2\2\u0091\u0092\7\n\2\2\u0092\u0094"+
		"\5H%\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u009b\3\2\2\2\u0095"+
		"\u0098\7@\2\2\u0096\u0097\7\n\2\2\u0097\u0099\5`\61\2\u0098\u0096\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a\u0090\3\2\2\2\u009a"+
		"\u0095\3\2\2\2\u009b\17\3\2\2\2\u009c\u009e\7\17\2\2\u009d\u009c\3\2\2"+
		"\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\5\24\13\2\u00a0"+
		"\u00a1\5\22\n\2\u00a1\u00a2\7\63\2\2\u00a2\21\3\2\2\2\u00a3\u00a6\7@\2"+
		"\2\u00a4\u00a5\7\n\2\2\u00a5\u00a7\5F$\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\23\3\2\2\2\u00a8\u00a9\t\2\2\2\u00a9\25\3\2\2\2\u00aa\u00ab"+
		"\5\24\13\2\u00ab\u00ac\7\"\2\2\u00ac\u00ad\7\60\2\2\u00ad\27\3\2\2\2\u00ae"+
		"\u00b3\5\32\16\2\u00af\u00b0\7\16\2\2\u00b0\u00b2\5\32\16\2\u00b1\u00af"+
		"\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b8\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00ae\3\2"+
		"\2\2\u00b7\u00b6\3\2\2\2\u00b8\31\3\2\2\2\u00b9\u00bc\5\24\13\2\u00ba"+
		"\u00bc\5\26\f\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3"+
		"\2\2\2\u00bd\u00be\7@\2\2\u00be\33\3\2\2\2\u00bf\u00c7\5\36\20\2\u00c0"+
		"\u00c7\5 \21\2\u00c1\u00c7\5(\25\2\u00c2\u00c7\5*\26\2\u00c3\u00c7\5."+
		"\30\2\u00c4\u00c7\5\62\32\2\u00c5\u00c7\5> \2\u00c6\u00bf\3\2\2\2\u00c6"+
		"\u00c0\3\2\2\2\u00c6\u00c1\3\2\2\2\u00c6\u00c2\3\2\2\2\u00c6\u00c3\3\2"+
		"\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\35\3\2\2\2\u00c8\u00c9"+
		"\7\62\2\2\u00c9\u00ca\7#\2\2\u00ca\u00cb\7<\2\2\u00cb\u00cc\7\16\2\2\u00cc"+
		"\u00cd\7@\2\2\u00cd\u00ce\7\61\2\2\u00ce\u00cf\7\63\2\2\u00cf\37\3\2\2"+
		"\2\u00d0\u00d1\7-\2\2\u00d1\u00d2\7#\2\2\u00d2\u00d3\5\"\22\2\u00d3\u00d4"+
		"\7\61\2\2\u00d4\u00d5\7\63\2\2\u00d5!\3\2\2\2\u00d6\u00da\b\22\1\2\u00d7"+
		"\u00db\7@\2\2\u00d8\u00db\7=\2\2\u00d9\u00db\5&\24\2\u00da\u00d7\3\2\2"+
		"\2\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db\u00df\3\2\2\2\u00dc\u00e0"+
		"\7@\2\2\u00dd\u00e0\7=\2\2\u00de\u00e0\5&\24\2\u00df\u00dc\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2"+
		"\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00ed\b\22\1\2\u00e4"+
		"\u00e9\5$\23\2\u00e5\u00e6\7,\2\2\u00e6\u00e8\5$\23\2\u00e7\u00e5\3\2"+
		"\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00d6\3\2\2\2\u00ec\u00e4\3\2"+
		"\2\2\u00ed\u00f3\3\2\2\2\u00ee\u00ef\f\3\2\2\u00ef\u00f0\7,\2\2\u00f0"+
		"\u00f2\b\22\1\2\u00f1\u00ee\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3"+
		"\2\2\2\u00f3\u00f4\3\2\2\2\u00f4#\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00fb"+
		"\7<\2\2\u00f7\u00fb\5d\63\2\u00f8\u00fb\7@\2\2\u00f9\u00fb\5F$\2\u00fa"+
		"\u00f6\3\2\2\2\u00fa\u00f7\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00f9\3\2"+
		"\2\2\u00fb%\3\2\2\2\u00fc\u00fd\t\3\2\2\u00fd\'\3\2\2\2\u00fe\u0101\5"+
		"B\"\2\u00ff\u0101\5d\63\2\u0100\u00fe\3\2\2\2\u0100\u00ff\3\2\2\2\u0101"+
		"\u0102\3\2\2\2\u0102\u0103\7\63\2\2\u0103)\3\2\2\2\u0104\u0108\7!\2\2"+
		"\u0105\u0107\5,\27\2\u0106\u0105\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106"+
		"\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010b\3\2\2\2\u010a\u0108\3\2\2\2\u010b"+
		"\u010c\7/\2\2\u010c+\3\2\2\2\u010d\u0110\5\n\6\2\u010e\u0110\5\34\17\2"+
		"\u010f\u010d\3\2\2\2\u010f\u010e\3\2\2\2\u0110-\3\2\2\2\u0111\u0112\7"+
		"\37\2\2\u0112\u0113\7#\2\2\u0113\u0114\5F$\2\u0114\u0115\7\61\2\2\u0115"+
		"\u0116\7\66\2\2\u0116\u0118\5*\26\2\u0117\u0119\5\60\31\2\u0118\u0117"+
		"\3\2\2\2\u0118\u0119\3\2\2\2\u0119/\3\2\2\2\u011a\u011b\7\27\2\2\u011b"+
		"\u011c\7\66\2\2\u011c\u0120\5*\26\2\u011d\u011e\7\27\2\2\u011e\u0120\5"+
		".\30\2\u011f\u011a\3\2\2\2\u011f\u011d\3\2\2\2\u0120\61\3\2\2\2\u0121"+
		"\u0124\5\64\33\2\u0122\u0124\5\66\34\2\u0123\u0121\3\2\2\2\u0123\u0122"+
		"\3\2\2\2\u0124\63\3\2\2\2\u0125\u0126\7;\2\2\u0126\u0127\7@\2\2\u0127"+
		"\u0128\79\2\2\u0128\u0129\7\67\2\2\u0129\u012a\5N(\2\u012a\u012b\5*\26"+
		"\2\u012b\u0134\3\2\2\2\u012c\u012d\7;\2\2\u012d\u012e\7@\2\2\u012e\u012f"+
		"\7\25\2\2\u012f\u0130\7\67\2\2\u0130\u0131\5N(\2\u0131\u0132\5*\26\2\u0132"+
		"\u0134\3\2\2\2\u0133\u0125\3\2\2\2\u0133\u012c\3\2\2\2\u0134\65\3\2\2"+
		"\2\u0135\u0136\7\33\2\2\u0136\u0137\58\35\2\u0137\u0138\5*\26\2\u0138"+
		"\67\3\2\2\2\u0139\u013a\5:\36\2\u013a\u013b\5<\37\2\u013b\u0140\3\2\2"+
		"\2\u013c\u013d\5:\36\2\u013d\u013e\b\35\1\2\u013e\u0140\3\2\2\2\u013f"+
		"\u0139\3\2\2\2\u013f\u013c\3\2\2\2\u01409\3\2\2\2\u0141\u0149\7@\2\2\u0142"+
		"\u0144\7 \2\2\u0143\u0142\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\3\2"+
		"\2\2\u0145\u0146\7@\2\2\u0146\u0147\7\n\2\2\u0147\u0149\5F$\2\u0148\u0141"+
		"\3\2\2\2\u0148\u0143\3\2\2\2\u0149;\3\2\2\2\u014a\u014b\t\4\2\2\u014b"+
		"\u014c\7\67\2\2\u014c\u0154\5R*\2\u014d\u014e\b\37\1\2\u014e\u014f\7\67"+
		"\2\2\u014f\u0154\5R*\2\u0150\u0151\t\4\2\2\u0151\u0152\b\37\1\2\u0152"+
		"\u0154\5R*\2\u0153\u014a\3\2\2\2\u0153\u014d\3\2\2\2\u0153\u0150\3\2\2"+
		"\2\u0154=\3\2\2\2\u0155\u0156\7.\2\2\u0156\u0157\5F$\2\u0157\u0158\7\63"+
		"\2\2\u0158?\3\2\2\2\u0159\u015a\5`\61\2\u015a\u015b\7\n\2\2\u015b\u015c"+
		"\5@!\2\u015c\u0162\3\2\2\2\u015d\u0162\5F$\2\u015e\u0162\5H%\2\u015f\u0162"+
		"\5R*\2\u0160\u0162\5V,\2\u0161\u0159\3\2\2\2\u0161\u015d\3\2\2\2\u0161"+
		"\u015e\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0160\3\2\2\2\u0162A\3\2\2\2"+
		"\u0163\u0164\5`\61\2\u0164\u0167\7\n\2\2\u0165\u0168\5F$\2\u0166\u0168"+
		"\5H%\2\u0167\u0165\3\2\2\2\u0167\u0166\3\2\2\2\u0168C\3\2\2\2\u0169\u016a"+
		"\5N(\2\u016aE\3\2\2\2\u016b\u016c\b$\1\2\u016c\u016d\5J&\2\u016d\u017b"+
		"\3\2\2\2\u016e\u016f\f\4\2\2\u016f\u0170\7+\2\2\u0170\u017a\5J&\2\u0171"+
		"\u0173\f\3\2\2\u0172\u0174\5F$\2\u0173\u0172\3\2\2\2\u0174\u0175\3\2\2"+
		"\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178"+
		"\b$\1\2\u0178\u017a\3\2\2\2\u0179\u016e\3\2\2\2\u0179\u0171\3\2\2\2\u017a"+
		"\u017d\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017cG\3\2\2\2"+
		"\u017d\u017b\3\2\2\2\u017e\u017f\7\20\2\2\u017f\u0180\5\24\13\2\u0180"+
		"\u0181\7\"\2\2\u0181\u0182\5F$\2\u0182\u0183\7\60\2\2\u0183I\3\2\2\2\u0184"+
		"\u0185\b&\1\2\u0185\u0186\5L\'\2\u0186\u018c\3\2\2\2\u0187\u0188\f\3\2"+
		"\2\u0188\u0189\7\t\2\2\u0189\u018b\5L\'\2\u018a\u0187\3\2\2\2\u018b\u018e"+
		"\3\2\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018dK\3\2\2\2\u018e"+
		"\u018c\3\2\2\2\u018f\u0190\7)\2\2\u0190\u0193\5L\'\2\u0191\u0193\5N(\2"+
		"\u0192\u018f\3\2\2\2\u0192\u0191\3\2\2\2\u0193M\3\2\2\2\u0194\u0195\5"+
		"R*\2\u0195\u0196\5P)\2\u0196\u0197\5R*\2\u0197\u019a\3\2\2\2\u0198\u019a"+
		"\5R*\2\u0199\u0194\3\2\2\2\u0199\u0198\3\2\2\2\u019aO\3\2\2\2\u019b\u019c"+
		"\t\5\2\2\u019cQ\3\2\2\2\u019d\u019e\b*\1\2\u019e\u019f\5V,\2\u019f\u01b0"+
		"\3\2\2\2\u01a0\u01a1\f\5\2\2\u01a1\u01a2\5T+\2\u01a2\u01a3\5V,\2\u01a3"+
		"\u01af\3\2\2\2\u01a4\u01a5\f\4\2\2\u01a5\u01a7\5T+\2\u01a6\u01a8\5T+\2"+
		"\u01a7\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa"+
		"\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ac\5V,\2\u01ac\u01ad\b*\1\2\u01ad"+
		"\u01af\3\2\2\2\u01ae\u01a0\3\2\2\2\u01ae\u01a4\3\2\2\2\u01af\u01b2\3\2"+
		"\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1S\3\2\2\2\u01b2\u01b0"+
		"\3\2\2\2\u01b3\u01b4\t\6\2\2\u01b4U\3\2\2\2\u01b5\u01b6\b,\1\2\u01b6\u01b7"+
		"\5Z.\2\u01b7\u01c8\3\2\2\2\u01b8\u01b9\f\5\2\2\u01b9\u01ba\5X-\2\u01ba"+
		"\u01bb\5Z.\2\u01bb\u01c7\3\2\2\2\u01bc\u01bd\f\4\2\2\u01bd\u01bf\5X-\2"+
		"\u01be\u01c0\5X-\2\u01bf\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01bf"+
		"\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c4\5Z.\2\u01c4"+
		"\u01c5\b,\1\2\u01c5\u01c7\3\2\2\2\u01c6\u01b8\3\2\2\2\u01c6\u01bc\3\2"+
		"\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9"+
		"W\3\2\2\2\u01ca\u01c8\3\2\2\2\u01cb\u01cc\t\7\2\2\u01ccY\3\2\2\2\u01cd"+
		"\u01ce\5\\/\2\u01ce\u01cf\5Z.\2\u01cf\u01d2\3\2\2\2\u01d0\u01d2\5^\60"+
		"\2\u01d1\u01cd\3\2\2\2\u01d1\u01d0\3\2\2\2\u01d2[\3\2\2\2\u01d3\u01d4"+
		"\7\'\2\2\u01d4]\3\2\2\2\u01d5\u01d8\5b\62\2\u01d6\u01d8\5`\61\2\u01d7"+
		"\u01d5\3\2\2\2\u01d7\u01d6\3\2\2\2\u01d8_\3\2\2\2\u01d9\u01e0\7@\2\2\u01da"+
		"\u01db\7@\2\2\u01db\u01dc\7\"\2\2\u01dc\u01dd\5F$\2\u01dd\u01de\7\60\2"+
		"\2\u01de\u01e0\3\2\2\2\u01df\u01d9\3\2\2\2\u01df\u01da\3\2\2\2\u01e0a"+
		"\3\2\2\2\u01e1\u01e2\7#\2\2\u01e2\u01e3\5F$\2\u01e3\u01e4\7\61\2\2\u01e4"+
		"\u01e8\3\2\2\2\u01e5\u01e8\5d\63\2\u01e6\u01e8\5h\65\2\u01e7\u01e1\3\2"+
		"\2\2\u01e7\u01e5\3\2\2\2\u01e7\u01e6\3\2\2\2\u01e8c\3\2\2\2\u01e9\u01ea"+
		"\7@\2\2\u01ea\u01eb\7#\2\2\u01eb\u01ec\5f\64\2\u01ec\u01ed\7\61\2\2\u01ed"+
		"e\3\2\2\2\u01ee\u01f3\5F$\2\u01ef\u01f0\7\16\2\2\u01f0\u01f2\5F$\2\u01f1"+
		"\u01ef\3\2\2\2\u01f2\u01f5\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f3\u01f4\3\2"+
		"\2\2\u01f4\u01f8\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f6\u01f8\3\2\2\2\u01f7"+
		"\u01ee\3\2\2\2\u01f7\u01f6\3\2\2\2\u01f8g\3\2\2\2\u01f9\u01fa\t\b\2\2"+
		"\u01fai\3\2\2\2\65m\u0083\u0087\u008a\u0093\u0098\u009a\u009d\u00a6\u00b3"+
		"\u00b7\u00bb\u00c6\u00da\u00df\u00e1\u00e9\u00ec\u00f3\u00fa\u0100\u0108"+
		"\u010f\u0118\u011f\u0123\u0133\u013f\u0143\u0148\u0153\u0161\u0167\u0175"+
		"\u0179\u017b\u018c\u0192\u0199\u01a9\u01ae\u01b0\u01c1\u01c6\u01c8\u01d1"+
		"\u01d7\u01df\u01e7\u01f3\u01f7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}