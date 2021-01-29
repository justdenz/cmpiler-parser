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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, AndAnd=7, Assign=8, Boolean=9, 
		Break=10, Colon=11, Comma=12, ConstantKey=13, Create=14, Div=15, Do=16, 
		Dot=17, DoubleQuotation=18, Down=19, Ellipsis=20, Else=21, Equal=22, False=23, 
		Float=24, For=25, Func=26, Greater=27, GreaterEqual=28, If=29, Int=30, 
		LeftBrace=31, LeftBracket=32, LeftParen=33, Less=34, LessEqual=35, Main=36, 
		Minus=37, Mod=38, Not=39, NotEqual=40, OrOr=41, Plus=42, Print=43, Return=44, 
		RightBrace=45, RightBracket=46, RightParen=47, Scan=48, Semi=49, Star=50, 
		String=51, Then=52, To=53, True=54, Up=55, Void=56, While=57, INTEGERCONSTANT=58, 
		FLOATCONSTANT=59, BOOLCONSTANT=60, STRINGCONSTANT=61, IDENTIFIER=62, WHITSPACE=63, 
		NEWLINE=64, BLOCKCOMMENT=65, LINECOMMENT=66;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "AndAnd", "Assign", "Boolean", 
			"Break", "Colon", "Comma", "ConstantKey", "Create", "Div", "Do", "Dot", 
			"DoubleQuotation", "Down", "Ellipsis", "Else", "Equal", "False", "Float", 
			"For", "Func", "Greater", "GreaterEqual", "If", "Int", "LeftBrace", "LeftBracket", 
			"LeftParen", "Less", "LessEqual", "Main", "Minus", "Mod", "Not", "NotEqual", 
			"OrOr", "Plus", "Print", "Return", "RightBrace", "RightBracket", "RightParen", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2D\u01c9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3"+
		"$\3%\3%\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3,\3,\3,"+
		"\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\61\3"+
		"\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3"+
		"\65\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\38\38\38\39\39\39\39\39\3"+
		":\3:\3:\3:\3:\3:\3;\3;\3<\3<\3=\6=\u0163\n=\r=\16=\u0164\3>\3>\3?\5?\u016a"+
		"\n?\3?\3?\3?\3?\3?\5?\u0171\n?\3@\3@\3@\3A\3A\3B\3B\3B\3C\3C\3C\3C\3C"+
		"\3C\3C\5C\u0182\nC\3D\6D\u0185\nD\rD\16D\u0186\3E\3E\5E\u018b\nE\3E\3"+
		"E\3F\3F\3G\3G\3H\3H\5H\u0195\nH\3I\3I\3J\3J\3J\7J\u019c\nJ\fJ\16J\u019f"+
		"\13J\3K\6K\u01a2\nK\rK\16K\u01a3\3K\3K\3L\3L\5L\u01aa\nL\3L\5L\u01ad\n"+
		"L\3L\3L\3M\3M\3M\3M\7M\u01b5\nM\fM\16M\u01b8\13M\3M\3M\3M\3M\3M\3N\3N"+
		"\3N\3N\7N\u01c3\nN\fN\16N\u01c6\13N\3N\3N\3\u01b6\2O\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u\2w\2y\2{\2}"+
		"\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b<\u008d=\u008f>"+
		"\u0091?\u0093@\u0095A\u0097B\u0099C\u009bD\3\2\b\5\2C\\aac|\3\2\62;\f"+
		"\2$$))AA^^cdhhppttvvxx\6\2\f\f\17\17$$^^\4\2\13\13\"\"\4\2\f\f\17\17\2"+
		"\u01cd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2"+
		"\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2"+
		"m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2"+
		"\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2"+
		"\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\3\u009d\3\2\2\2\5\u009f"+
		"\3\2\2\2\7\u00a1\3\2\2\2\t\u00a3\3\2\2\2\13\u00a5\3\2\2\2\r\u00a7\3\2"+
		"\2\2\17\u00a9\3\2\2\2\21\u00ac\3\2\2\2\23\u00ae\3\2\2\2\25\u00b3\3\2\2"+
		"\2\27\u00b9\3\2\2\2\31\u00bb\3\2\2\2\33\u00bd\3\2\2\2\35\u00c6\3\2\2\2"+
		"\37\u00cd\3\2\2\2!\u00cf\3\2\2\2#\u00d2\3\2\2\2%\u00d4\3\2\2\2\'\u00d6"+
		"\3\2\2\2)\u00db\3\2\2\2+\u00df\3\2\2\2-\u00e4\3\2\2\2/\u00e7\3\2\2\2\61"+
		"\u00e9\3\2\2\2\63\u00ef\3\2\2\2\65\u00f3\3\2\2\2\67\u00f8\3\2\2\29\u00fa"+
		"\3\2\2\2;\u00fd\3\2\2\2=\u0100\3\2\2\2?\u0104\3\2\2\2A\u0106\3\2\2\2C"+
		"\u0108\3\2\2\2E\u010a\3\2\2\2G\u010c\3\2\2\2I\u010f\3\2\2\2K\u0114\3\2"+
		"\2\2M\u0116\3\2\2\2O\u0118\3\2\2\2Q\u011a\3\2\2\2S\u011d\3\2\2\2U\u0120"+
		"\3\2\2\2W\u0122\3\2\2\2Y\u0128\3\2\2\2[\u012f\3\2\2\2]\u0131\3\2\2\2_"+
		"\u0133\3\2\2\2a\u0135\3\2\2\2c\u013a\3\2\2\2e\u013c\3\2\2\2g\u013e\3\2"+
		"\2\2i\u0145\3\2\2\2k\u014a\3\2\2\2m\u014d\3\2\2\2o\u014f\3\2\2\2q\u0152"+
		"\3\2\2\2s\u0157\3\2\2\2u\u015d\3\2\2\2w\u015f\3\2\2\2y\u0162\3\2\2\2{"+
		"\u0166\3\2\2\2}\u0170\3\2\2\2\177\u0172\3\2\2\2\u0081\u0175\3\2\2\2\u0083"+
		"\u0177\3\2\2\2\u0085\u0181\3\2\2\2\u0087\u0184\3\2\2\2\u0089\u0188\3\2"+
		"\2\2\u008b\u018e\3\2\2\2\u008d\u0190\3\2\2\2\u008f\u0194\3\2\2\2\u0091"+
		"\u0196\3\2\2\2\u0093\u0198\3\2\2\2\u0095\u01a1\3\2\2\2\u0097\u01ac\3\2"+
		"\2\2\u0099\u01b0\3\2\2\2\u009b\u01be\3\2\2\2\u009d\u009e\7A\2\2\u009e"+
		"\4\3\2\2\2\u009f\u00a0\7`\2\2\u00a0\6\3\2\2\2\u00a1\u00a2\7B\2\2\u00a2"+
		"\b\3\2\2\2\u00a3\u00a4\7%\2\2\u00a4\n\3\2\2\2\u00a5\u00a6\7b\2\2\u00a6"+
		"\f\3\2\2\2\u00a7\u00a8\7\u0080\2\2\u00a8\16\3\2\2\2\u00a9\u00aa\7(\2\2"+
		"\u00aa\u00ab\7(\2\2\u00ab\20\3\2\2\2\u00ac\u00ad\7?\2\2\u00ad\22\3\2\2"+
		"\2\u00ae\u00af\7d\2\2\u00af\u00b0\7q\2\2\u00b0\u00b1\7q\2\2\u00b1\u00b2"+
		"\7n\2\2\u00b2\24\3\2\2\2\u00b3\u00b4\7d\2\2\u00b4\u00b5\7t\2\2\u00b5\u00b6"+
		"\7g\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7m\2\2\u00b8\26\3\2\2\2\u00b9\u00ba"+
		"\7<\2\2\u00ba\30\3\2\2\2\u00bb\u00bc\7.\2\2\u00bc\32\3\2\2\2\u00bd\u00be"+
		"\7e\2\2\u00be\u00bf\7q\2\2\u00bf\u00c0\7p\2\2\u00c0\u00c1\7u\2\2\u00c1"+
		"\u00c2\7v\2\2\u00c2\u00c3\7c\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5\7v\2\2"+
		"\u00c5\34\3\2\2\2\u00c6\u00c7\7e\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7"+
		"g\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb\7v\2\2\u00cb\u00cc\7g\2\2\u00cc\36"+
		"\3\2\2\2\u00cd\u00ce\7\61\2\2\u00ce \3\2\2\2\u00cf\u00d0\7f\2\2\u00d0"+
		"\u00d1\7q\2\2\u00d1\"\3\2\2\2\u00d2\u00d3\7\60\2\2\u00d3$\3\2\2\2\u00d4"+
		"\u00d5\7$\2\2\u00d5&\3\2\2\2\u00d6\u00d7\7f\2\2\u00d7\u00d8\7q\2\2\u00d8"+
		"\u00d9\7y\2\2\u00d9\u00da\7p\2\2\u00da(\3\2\2\2\u00db\u00dc\7\60\2\2\u00dc"+
		"\u00dd\7\60\2\2\u00dd\u00de\7\60\2\2\u00de*\3\2\2\2\u00df\u00e0\7g\2\2"+
		"\u00e0\u00e1\7n\2\2\u00e1\u00e2\7u\2\2\u00e2\u00e3\7g\2\2\u00e3,\3\2\2"+
		"\2\u00e4\u00e5\7?\2\2\u00e5\u00e6\7?\2\2\u00e6.\3\2\2\2\u00e7\u00e8\7"+
		"H\2\2\u00e8\60\3\2\2\2\u00e9\u00ea\7h\2\2\u00ea\u00eb\7n\2\2\u00eb\u00ec"+
		"\7q\2\2\u00ec\u00ed\7c\2\2\u00ed\u00ee\7v\2\2\u00ee\62\3\2\2\2\u00ef\u00f0"+
		"\7h\2\2\u00f0\u00f1\7q\2\2\u00f1\u00f2\7t\2\2\u00f2\64\3\2\2\2\u00f3\u00f4"+
		"\7h\2\2\u00f4\u00f5\7w\2\2\u00f5\u00f6\7p\2\2\u00f6\u00f7\7e\2\2\u00f7"+
		"\66\3\2\2\2\u00f8\u00f9\7@\2\2\u00f98\3\2\2\2\u00fa\u00fb\7@\2\2\u00fb"+
		"\u00fc\7?\2\2\u00fc:\3\2\2\2\u00fd\u00fe\7k\2\2\u00fe\u00ff\7h\2\2\u00ff"+
		"<\3\2\2\2\u0100\u0101\7k\2\2\u0101\u0102\7p\2\2\u0102\u0103\7v\2\2\u0103"+
		">\3\2\2\2\u0104\u0105\7}\2\2\u0105@\3\2\2\2\u0106\u0107\7]\2\2\u0107B"+
		"\3\2\2\2\u0108\u0109\7*\2\2\u0109D\3\2\2\2\u010a\u010b\7>\2\2\u010bF\3"+
		"\2\2\2\u010c\u010d\7>\2\2\u010d\u010e\7?\2\2\u010eH\3\2\2\2\u010f\u0110"+
		"\7o\2\2\u0110\u0111\7c\2\2\u0111\u0112\7k\2\2\u0112\u0113\7p\2\2\u0113"+
		"J\3\2\2\2\u0114\u0115\7/\2\2\u0115L\3\2\2\2\u0116\u0117\7\'\2\2\u0117"+
		"N\3\2\2\2\u0118\u0119\7#\2\2\u0119P\3\2\2\2\u011a\u011b\7#\2\2\u011b\u011c"+
		"\7?\2\2\u011cR\3\2\2\2\u011d\u011e\7~\2\2\u011e\u011f\7~\2\2\u011fT\3"+
		"\2\2\2\u0120\u0121\7-\2\2\u0121V\3\2\2\2\u0122\u0123\7r\2\2\u0123\u0124"+
		"\7t\2\2\u0124\u0125\7k\2\2\u0125\u0126\7p\2\2\u0126\u0127\7v\2\2\u0127"+
		"X\3\2\2\2\u0128\u0129\7t\2\2\u0129\u012a\7g\2\2\u012a\u012b\7v\2\2\u012b"+
		"\u012c\7w\2\2\u012c\u012d\7t\2\2\u012d\u012e\7p\2\2\u012eZ\3\2\2\2\u012f"+
		"\u0130\7\177\2\2\u0130\\\3\2\2\2\u0131\u0132\7_\2\2\u0132^\3\2\2\2\u0133"+
		"\u0134\7+\2\2\u0134`\3\2\2\2\u0135\u0136\7u\2\2\u0136\u0137\7e\2\2\u0137"+
		"\u0138\7c\2\2\u0138\u0139\7p\2\2\u0139b\3\2\2\2\u013a\u013b\7=\2\2\u013b"+
		"d\3\2\2\2\u013c\u013d\7,\2\2\u013df\3\2\2\2\u013e\u013f\7U\2\2\u013f\u0140"+
		"\7v\2\2\u0140\u0141\7t\2\2\u0141\u0142\7k\2\2\u0142\u0143\7p\2\2\u0143"+
		"\u0144\7i\2\2\u0144h\3\2\2\2\u0145\u0146\7v\2\2\u0146\u0147\7j\2\2\u0147"+
		"\u0148\7g\2\2\u0148\u0149\7p\2\2\u0149j\3\2\2\2\u014a\u014b\7v\2\2\u014b"+
		"\u014c\7q\2\2\u014cl\3\2\2\2\u014d\u014e\7V\2\2\u014en\3\2\2\2\u014f\u0150"+
		"\7w\2\2\u0150\u0151\7r\2\2\u0151p\3\2\2\2\u0152\u0153\7x\2\2\u0153\u0154"+
		"\7q\2\2\u0154\u0155\7k\2\2\u0155\u0156\7f\2\2\u0156r\3\2\2\2\u0157\u0158"+
		"\7y\2\2\u0158\u0159\7j\2\2\u0159\u015a\7k\2\2\u015a\u015b\7n\2\2\u015b"+
		"\u015c\7g\2\2\u015ct\3\2\2\2\u015d\u015e\t\2\2\2\u015ev\3\2\2\2\u015f"+
		"\u0160\t\3\2\2\u0160x\3\2\2\2\u0161\u0163\5w<\2\u0162\u0161\3\2\2\2\u0163"+
		"\u0164\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165z\3\2\2\2"+
		"\u0166\u0167\7h\2\2\u0167|\3\2\2\2\u0168\u016a\5y=\2\u0169\u0168\3\2\2"+
		"\2\u0169\u016a\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c\7\60\2\2\u016c"+
		"\u0171\5y=\2\u016d\u016e\5y=\2\u016e\u016f\7\60\2\2\u016f\u0171\3\2\2"+
		"\2\u0170\u0169\3\2\2\2\u0170\u016d\3\2\2\2\u0171~\3\2\2\2\u0172\u0173"+
		"\5}?\2\u0173\u0174\5{>\2\u0174\u0080\3\2\2\2\u0175\u0176\5\u0083B\2\u0176"+
		"\u0082\3\2\2\2\u0177\u0178\7^\2\2\u0178\u0179\t\4\2\2\u0179\u0084\3\2"+
		"\2\2\u017a\u0182\n\5\2\2\u017b\u0182\5\u0081A\2\u017c\u017d\7^\2\2\u017d"+
		"\u0182\7\f\2\2\u017e\u017f\7^\2\2\u017f\u0180\7\17\2\2\u0180\u0182\7\f"+
		"\2\2\u0181\u017a\3\2\2\2\u0181\u017b\3\2\2\2\u0181\u017c\3\2\2\2\u0181"+
		"\u017e\3\2\2\2\u0182\u0086\3\2\2\2\u0183\u0185\5\u0085C\2\u0184\u0183"+
		"\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187"+
		"\u0088\3\2\2\2\u0188\u018a\5%\23\2\u0189\u018b\5\u0087D\2\u018a\u0189"+
		"\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d\5%\23\2\u018d"+
		"\u008a\3\2\2\2\u018e\u018f\5y=\2\u018f\u008c\3\2\2\2\u0190\u0191\5\177"+
		"@\2\u0191\u008e\3\2\2\2\u0192\u0195\5m\67\2\u0193\u0195\5/\30\2\u0194"+
		"\u0192\3\2\2\2\u0194\u0193\3\2\2\2\u0195\u0090\3\2\2\2\u0196\u0197\5\u0089"+
		"E\2\u0197\u0092\3\2\2\2\u0198\u019d\5u;\2\u0199\u019c\5w<\2\u019a\u019c"+
		"\5u;\2\u019b\u0199\3\2\2\2\u019b\u019a\3\2\2\2\u019c\u019f\3\2\2\2\u019d"+
		"\u019b\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u0094\3\2\2\2\u019f\u019d\3\2"+
		"\2\2\u01a0\u01a2\t\6\2\2\u01a1\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3"+
		"\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\bK"+
		"\2\2\u01a6\u0096\3\2\2\2\u01a7\u01a9\7\17\2\2\u01a8\u01aa\7\f\2\2\u01a9"+
		"\u01a8\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ad\3\2\2\2\u01ab\u01ad\7\f"+
		"\2\2\u01ac\u01a7\3\2\2\2\u01ac\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae"+
		"\u01af\bL\2\2\u01af\u0098\3\2\2\2\u01b0\u01b1\7\61\2\2\u01b1\u01b2\7,"+
		"\2\2\u01b2\u01b6\3\2\2\2\u01b3\u01b5\13\2\2\2\u01b4\u01b3\3\2\2\2\u01b5"+
		"\u01b8\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b7\u01b9\3\2"+
		"\2\2\u01b8\u01b6\3\2\2\2\u01b9\u01ba\7,\2\2\u01ba\u01bb\7\61\2\2\u01bb"+
		"\u01bc\3\2\2\2\u01bc\u01bd\bM\2\2\u01bd\u009a\3\2\2\2\u01be\u01bf\7\61"+
		"\2\2\u01bf\u01c0\7\61\2\2\u01c0\u01c4\3\2\2\2\u01c1\u01c3\n\7\2\2\u01c2"+
		"\u01c1\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2"+
		"\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01c8\bN\2\2\u01c8"+
		"\u009c\3\2\2\2\21\2\u0164\u0169\u0170\u0181\u0186\u018a\u0194\u019b\u019d"+
		"\u01a3\u01a9\u01ac\u01b6\u01c4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}