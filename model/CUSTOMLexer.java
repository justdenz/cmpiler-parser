// Generated from CUSTOM.g4 by ANTLR 4.9
package model;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CUSTOMLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AndAnd=1, Assign=2, Boolean=3, Break=4, Colon=5, Comma=6, ConstantKey=7, 
		Create=8, Div=9, Do=10, Dot=11, DoubleQuotation=12, Down=13, Ellipsis=14, 
		Else=15, ElseIf=16, Equal=17, False=18, Float=19, For=20, Func=21, Greater=22, 
		GreaterEqual=23, If=24, Int=25, LeftBrace=26, LeftBracket=27, LeftParen=28, 
		Less=29, LessEqual=30, Main=31, Minus=32, Mod=33, Not=34, NotEqual=35, 
		OrOr=36, Plus=37, Print=38, Return=39, RightBrace=40, RightBracket=41, 
		RightParen=42, Scan=43, Semi=44, Star=45, String=46, Then=47, To=48, True=49, 
		Up=50, Void=51, While=52, INTEGERCONSTANT=53, FLOATCONSTANT=54, BOOLCONSTANT=55, 
		STRINGCONSTANT=56, IDENTIFIER=57, WHITSPACE=58, NEWLINE=59, BLOCKCOMMENT=60, 
		LINECOMMENT=61;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"AndAnd", "Assign", "Boolean", "Break", "Colon", "Comma", "ConstantKey", 
			"Create", "Div", "Do", "Dot", "DoubleQuotation", "Down", "Ellipsis", 
			"Else", "ElseIf", "Equal", "False", "Float", "For", "Func", "Greater", 
			"GreaterEqual", "If", "Int", "LeftBrace", "LeftBracket", "LeftParen", 
			"Less", "LessEqual", "Main", "Minus", "Mod", "Not", "NotEqual", "OrOr", 
			"Plus", "Print", "Return", "RightBrace", "RightBracket", "RightParen", 
			"Scan", "Semi", "Star", "String", "Then", "To", "True", "Up", "Void", 
			"While", "Letter", "Digit", "DigitSequence", "FloatSuffix", "FractionalConstant", 
			"DecimalFloatingConstant", "EscapeSequence", "SimpleEscapeSequence", 
			"SChar", "SCharSequence", "StringLiteral", "INTEGERCONSTANT", "FLOATCONSTANT", 
			"BOOLCONSTANT", "STRINGCONSTANT", "IDENTIFIER", "WHITSPACE", "NEWLINE", 
			"BLOCKCOMMENT", "LINECOMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'&&'", "'='", "'bool'", "'break'", "':'", "','", "'constant'", 
			"'create'", "'/'", "'do'", "'.'", "'\"'", "'down'", "'...'", "'else'", 
			"'else if'", "'=='", "'F'", "'float'", "'for'", "'func'", "'>'", "'>='", 
			"'if'", "'int'", "'{'", "'['", "'('", "'<'", "'<='", "'main'", "'-'", 
			"'%'", "'!'", "'!='", "'||'", "'+'", "'print'", "'return'", "'}'", "']'", 
			"')'", "'scan'", "';'", "'*'", "'String'", "'then'", "'to'", "'T'", "'up'", 
			"'void'", "'while'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AndAnd", "Assign", "Boolean", "Break", "Colon", "Comma", "ConstantKey", 
			"Create", "Div", "Do", "Dot", "DoubleQuotation", "Down", "Ellipsis", 
			"Else", "ElseIf", "Equal", "False", "Float", "For", "Func", "Greater", 
			"GreaterEqual", "If", "Int", "LeftBrace", "LeftBracket", "LeftParen", 
			"Less", "LessEqual", "Main", "Minus", "Mod", "Not", "NotEqual", "OrOr", 
			"Plus", "Print", "Return", "RightBrace", "RightBracket", "RightParen", 
			"Scan", "Semi", "Star", "String", "Then", "To", "True", "Up", "Void", 
			"While", "INTEGERCONSTANT", "FLOATCONSTANT", "BOOLCONSTANT", "STRINGCONSTANT", 
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


	public CUSTOMLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CUSTOM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2?\u01bb\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3"+
		"\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3"+
		"%\3%\3%\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3)\3*\3"+
		"*\3+\3+\3,\3,\3,\3,\3,\3-\3-\3.\3.\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60"+
		"\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\64"+
		"\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\67\3\67\38\68\u0155\n"+
		"8\r8\168\u0156\39\39\3:\5:\u015c\n:\3:\3:\3:\3:\3:\5:\u0163\n:\3;\3;\3"+
		";\3<\3<\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\5>\u0174\n>\3?\6?\u0177\n?\r?\16"+
		"?\u0178\3@\3@\5@\u017d\n@\3@\3@\3A\3A\3B\3B\3C\3C\5C\u0187\nC\3D\3D\3"+
		"E\3E\3E\7E\u018e\nE\fE\16E\u0191\13E\3F\6F\u0194\nF\rF\16F\u0195\3F\3"+
		"F\3G\3G\5G\u019c\nG\3G\5G\u019f\nG\3G\3G\3H\3H\3H\3H\7H\u01a7\nH\fH\16"+
		"H\u01aa\13H\3H\3H\3H\3H\3H\3I\3I\3I\3I\7I\u01b5\nI\fI\16I\u01b8\13I\3"+
		"I\3I\3\u01a8\2J\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64"+
		"g\65i\66k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\67\u00838\u00859\u0087"+
		":\u0089;\u008b<\u008d=\u008f>\u0091?\3\2\b\5\2C\\aac|\3\2\62;\f\2$$))"+
		"AA^^cdhhppttvvxx\6\2\f\f\17\17$$^^\4\2\13\13\"\"\4\2\f\f\17\17\2\u01bf"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2\u0081\3\2\2\2\2\u0083"+
		"\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2"+
		"\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\3\u0093\3\2\2\2\5\u0096"+
		"\3\2\2\2\7\u0098\3\2\2\2\t\u009d\3\2\2\2\13\u00a3\3\2\2\2\r\u00a5\3\2"+
		"\2\2\17\u00a7\3\2\2\2\21\u00b0\3\2\2\2\23\u00b7\3\2\2\2\25\u00b9\3\2\2"+
		"\2\27\u00bc\3\2\2\2\31\u00be\3\2\2\2\33\u00c0\3\2\2\2\35\u00c5\3\2\2\2"+
		"\37\u00c9\3\2\2\2!\u00ce\3\2\2\2#\u00d6\3\2\2\2%\u00d9\3\2\2\2\'\u00db"+
		"\3\2\2\2)\u00e1\3\2\2\2+\u00e5\3\2\2\2-\u00ea\3\2\2\2/\u00ec\3\2\2\2\61"+
		"\u00ef\3\2\2\2\63\u00f2\3\2\2\2\65\u00f6\3\2\2\2\67\u00f8\3\2\2\29\u00fa"+
		"\3\2\2\2;\u00fc\3\2\2\2=\u00fe\3\2\2\2?\u0101\3\2\2\2A\u0106\3\2\2\2C"+
		"\u0108\3\2\2\2E\u010a\3\2\2\2G\u010c\3\2\2\2I\u010f\3\2\2\2K\u0112\3\2"+
		"\2\2M\u0114\3\2\2\2O\u011a\3\2\2\2Q\u0121\3\2\2\2S\u0123\3\2\2\2U\u0125"+
		"\3\2\2\2W\u0127\3\2\2\2Y\u012c\3\2\2\2[\u012e\3\2\2\2]\u0130\3\2\2\2_"+
		"\u0137\3\2\2\2a\u013c\3\2\2\2c\u013f\3\2\2\2e\u0141\3\2\2\2g\u0144\3\2"+
		"\2\2i\u0149\3\2\2\2k\u014f\3\2\2\2m\u0151\3\2\2\2o\u0154\3\2\2\2q\u0158"+
		"\3\2\2\2s\u0162\3\2\2\2u\u0164\3\2\2\2w\u0167\3\2\2\2y\u0169\3\2\2\2{"+
		"\u0173\3\2\2\2}\u0176\3\2\2\2\177\u017a\3\2\2\2\u0081\u0180\3\2\2\2\u0083"+
		"\u0182\3\2\2\2\u0085\u0186\3\2\2\2\u0087\u0188\3\2\2\2\u0089\u018a\3\2"+
		"\2\2\u008b\u0193\3\2\2\2\u008d\u019e\3\2\2\2\u008f\u01a2\3\2\2\2\u0091"+
		"\u01b0\3\2\2\2\u0093\u0094\7(\2\2\u0094\u0095\7(\2\2\u0095\4\3\2\2\2\u0096"+
		"\u0097\7?\2\2\u0097\6\3\2\2\2\u0098\u0099\7d\2\2\u0099\u009a\7q\2\2\u009a"+
		"\u009b\7q\2\2\u009b\u009c\7n\2\2\u009c\b\3\2\2\2\u009d\u009e\7d\2\2\u009e"+
		"\u009f\7t\2\2\u009f\u00a0\7g\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7m\2\2"+
		"\u00a2\n\3\2\2\2\u00a3\u00a4\7<\2\2\u00a4\f\3\2\2\2\u00a5\u00a6\7.\2\2"+
		"\u00a6\16\3\2\2\2\u00a7\u00a8\7e\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa\7"+
		"p\2\2\u00aa\u00ab\7u\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7c\2\2\u00ad\u00ae"+
		"\7p\2\2\u00ae\u00af\7v\2\2\u00af\20\3\2\2\2\u00b0\u00b1\7e\2\2\u00b1\u00b2"+
		"\7t\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7c\2\2\u00b4\u00b5\7v\2\2\u00b5"+
		"\u00b6\7g\2\2\u00b6\22\3\2\2\2\u00b7\u00b8\7\61\2\2\u00b8\24\3\2\2\2\u00b9"+
		"\u00ba\7f\2\2\u00ba\u00bb\7q\2\2\u00bb\26\3\2\2\2\u00bc\u00bd\7\60\2\2"+
		"\u00bd\30\3\2\2\2\u00be\u00bf\7$\2\2\u00bf\32\3\2\2\2\u00c0\u00c1\7f\2"+
		"\2\u00c1\u00c2\7q\2\2\u00c2\u00c3\7y\2\2\u00c3\u00c4\7p\2\2\u00c4\34\3"+
		"\2\2\2\u00c5\u00c6\7\60\2\2\u00c6\u00c7\7\60\2\2\u00c7\u00c8\7\60\2\2"+
		"\u00c8\36\3\2\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7n\2\2\u00cb\u00cc\7"+
		"u\2\2\u00cc\u00cd\7g\2\2\u00cd \3\2\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0"+
		"\7n\2\2\u00d0\u00d1\7u\2\2\u00d1\u00d2\7g\2\2\u00d2\u00d3\7\"\2\2\u00d3"+
		"\u00d4\7k\2\2\u00d4\u00d5\7h\2\2\u00d5\"\3\2\2\2\u00d6\u00d7\7?\2\2\u00d7"+
		"\u00d8\7?\2\2\u00d8$\3\2\2\2\u00d9\u00da\7H\2\2\u00da&\3\2\2\2\u00db\u00dc"+
		"\7h\2\2\u00dc\u00dd\7n\2\2\u00dd\u00de\7q\2\2\u00de\u00df\7c\2\2\u00df"+
		"\u00e0\7v\2\2\u00e0(\3\2\2\2\u00e1\u00e2\7h\2\2\u00e2\u00e3\7q\2\2\u00e3"+
		"\u00e4\7t\2\2\u00e4*\3\2\2\2\u00e5\u00e6\7h\2\2\u00e6\u00e7\7w\2\2\u00e7"+
		"\u00e8\7p\2\2\u00e8\u00e9\7e\2\2\u00e9,\3\2\2\2\u00ea\u00eb\7@\2\2\u00eb"+
		".\3\2\2\2\u00ec\u00ed\7@\2\2\u00ed\u00ee\7?\2\2\u00ee\60\3\2\2\2\u00ef"+
		"\u00f0\7k\2\2\u00f0\u00f1\7h\2\2\u00f1\62\3\2\2\2\u00f2\u00f3\7k\2\2\u00f3"+
		"\u00f4\7p\2\2\u00f4\u00f5\7v\2\2\u00f5\64\3\2\2\2\u00f6\u00f7\7}\2\2\u00f7"+
		"\66\3\2\2\2\u00f8\u00f9\7]\2\2\u00f98\3\2\2\2\u00fa\u00fb\7*\2\2\u00fb"+
		":\3\2\2\2\u00fc\u00fd\7>\2\2\u00fd<\3\2\2\2\u00fe\u00ff\7>\2\2\u00ff\u0100"+
		"\7?\2\2\u0100>\3\2\2\2\u0101\u0102\7o\2\2\u0102\u0103\7c\2\2\u0103\u0104"+
		"\7k\2\2\u0104\u0105\7p\2\2\u0105@\3\2\2\2\u0106\u0107\7/\2\2\u0107B\3"+
		"\2\2\2\u0108\u0109\7\'\2\2\u0109D\3\2\2\2\u010a\u010b\7#\2\2\u010bF\3"+
		"\2\2\2\u010c\u010d\7#\2\2\u010d\u010e\7?\2\2\u010eH\3\2\2\2\u010f\u0110"+
		"\7~\2\2\u0110\u0111\7~\2\2\u0111J\3\2\2\2\u0112\u0113\7-\2\2\u0113L\3"+
		"\2\2\2\u0114\u0115\7r\2\2\u0115\u0116\7t\2\2\u0116\u0117\7k\2\2\u0117"+
		"\u0118\7p\2\2\u0118\u0119\7v\2\2\u0119N\3\2\2\2\u011a\u011b\7t\2\2\u011b"+
		"\u011c\7g\2\2\u011c\u011d\7v\2\2\u011d\u011e\7w\2\2\u011e\u011f\7t\2\2"+
		"\u011f\u0120\7p\2\2\u0120P\3\2\2\2\u0121\u0122\7\177\2\2\u0122R\3\2\2"+
		"\2\u0123\u0124\7_\2\2\u0124T\3\2\2\2\u0125\u0126\7+\2\2\u0126V\3\2\2\2"+
		"\u0127\u0128\7u\2\2\u0128\u0129\7e\2\2\u0129\u012a\7c\2\2\u012a\u012b"+
		"\7p\2\2\u012bX\3\2\2\2\u012c\u012d\7=\2\2\u012dZ\3\2\2\2\u012e\u012f\7"+
		",\2\2\u012f\\\3\2\2\2\u0130\u0131\7U\2\2\u0131\u0132\7v\2\2\u0132\u0133"+
		"\7t\2\2\u0133\u0134\7k\2\2\u0134\u0135\7p\2\2\u0135\u0136\7i\2\2\u0136"+
		"^\3\2\2\2\u0137\u0138\7v\2\2\u0138\u0139\7j\2\2\u0139\u013a\7g\2\2\u013a"+
		"\u013b\7p\2\2\u013b`\3\2\2\2\u013c\u013d\7v\2\2\u013d\u013e\7q\2\2\u013e"+
		"b\3\2\2\2\u013f\u0140\7V\2\2\u0140d\3\2\2\2\u0141\u0142\7w\2\2\u0142\u0143"+
		"\7r\2\2\u0143f\3\2\2\2\u0144\u0145\7x\2\2\u0145\u0146\7q\2\2\u0146\u0147"+
		"\7k\2\2\u0147\u0148\7f\2\2\u0148h\3\2\2\2\u0149\u014a\7y\2\2\u014a\u014b"+
		"\7j\2\2\u014b\u014c\7k\2\2\u014c\u014d\7n\2\2\u014d\u014e\7g\2\2\u014e"+
		"j\3\2\2\2\u014f\u0150\t\2\2\2\u0150l\3\2\2\2\u0151\u0152\t\3\2\2\u0152"+
		"n\3\2\2\2\u0153\u0155\5m\67\2\u0154\u0153\3\2\2\2\u0155\u0156\3\2\2\2"+
		"\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157p\3\2\2\2\u0158\u0159\7"+
		"h\2\2\u0159r\3\2\2\2\u015a\u015c\5o8\2\u015b\u015a\3\2\2\2\u015b\u015c"+
		"\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\7\60\2\2\u015e\u0163\5o8\2\u015f"+
		"\u0160\5o8\2\u0160\u0161\7\60\2\2\u0161\u0163\3\2\2\2\u0162\u015b\3\2"+
		"\2\2\u0162\u015f\3\2\2\2\u0163t\3\2\2\2\u0164\u0165\5s:\2\u0165\u0166"+
		"\5q9\2\u0166v\3\2\2\2\u0167\u0168\5y=\2\u0168x\3\2\2\2\u0169\u016a\7^"+
		"\2\2\u016a\u016b\t\4\2\2\u016bz\3\2\2\2\u016c\u0174\n\5\2\2\u016d\u0174"+
		"\5w<\2\u016e\u016f\7^\2\2\u016f\u0174\7\f\2\2\u0170\u0171\7^\2\2\u0171"+
		"\u0172\7\17\2\2\u0172\u0174\7\f\2\2\u0173\u016c\3\2\2\2\u0173\u016d\3"+
		"\2\2\2\u0173\u016e\3\2\2\2\u0173\u0170\3\2\2\2\u0174|\3\2\2\2\u0175\u0177"+
		"\5{>\2\u0176\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0176\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179~\3\2\2\2\u017a\u017c\5\31\r\2\u017b\u017d\5}?\2\u017c"+
		"\u017b\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f\5\31"+
		"\r\2\u017f\u0080\3\2\2\2\u0180\u0181\5o8\2\u0181\u0082\3\2\2\2\u0182\u0183"+
		"\5u;\2\u0183\u0084\3\2\2\2\u0184\u0187\5c\62\2\u0185\u0187\5%\23\2\u0186"+
		"\u0184\3\2\2\2\u0186\u0185\3\2\2\2\u0187\u0086\3\2\2\2\u0188\u0189\5\177"+
		"@\2\u0189\u0088\3\2\2\2\u018a\u018f\5k\66\2\u018b\u018e\5m\67\2\u018c"+
		"\u018e\5k\66\2\u018d\u018b\3\2\2\2\u018d\u018c\3\2\2\2\u018e\u0191\3\2"+
		"\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u008a\3\2\2\2\u0191"+
		"\u018f\3\2\2\2\u0192\u0194\t\6\2\2\u0193\u0192\3\2\2\2\u0194\u0195\3\2"+
		"\2\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\3\2\2\2\u0197"+
		"\u0198\bF\2\2\u0198\u008c\3\2\2\2\u0199\u019b\7\17\2\2\u019a\u019c\7\f"+
		"\2\2\u019b\u019a\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019f\3\2\2\2\u019d"+
		"\u019f\7\f\2\2\u019e\u0199\3\2\2\2\u019e\u019d\3\2\2\2\u019f\u01a0\3\2"+
		"\2\2\u01a0\u01a1\bG\2\2\u01a1\u008e\3\2\2\2\u01a2\u01a3\7\61\2\2\u01a3"+
		"\u01a4\7,\2\2\u01a4\u01a8\3\2\2\2\u01a5\u01a7\13\2\2\2\u01a6\u01a5\3\2"+
		"\2\2\u01a7\u01aa\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a9"+
		"\u01ab\3\2\2\2\u01aa\u01a8\3\2\2\2\u01ab\u01ac\7,\2\2\u01ac\u01ad\7\61"+
		"\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01af\bH\2\2\u01af\u0090\3\2\2\2\u01b0"+
		"\u01b1\7\61\2\2\u01b1\u01b2\7\61\2\2\u01b2\u01b6\3\2\2\2\u01b3\u01b5\n"+
		"\7\2\2\u01b4\u01b3\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6"+
		"\u01b7\3\2\2\2\u01b7\u01b9\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b9\u01ba\bI"+
		"\2\2\u01ba\u0092\3\2\2\2\21\2\u0156\u015b\u0162\u0173\u0178\u017c\u0186"+
		"\u018d\u018f\u0195\u019b\u019e\u01a8\u01b6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}