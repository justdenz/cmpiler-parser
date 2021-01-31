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
		String=51, Then=52, To=53, True=54, Up=55, Void=56, While=57, StringLiteral=58, 
		INTEGERCONSTANT=59, FLOATCONSTANT=60, BOOLCONSTANT=61, IDENTIFIER=62, 
		WHITSPACE=63, NEWLINE=64, BLOCKCOMMENT=65, LINECOMMENT=66;
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
			"BOOLCONSTANT", "IDENTIFIER", "WHITSPACE", "NEWLINE", "BLOCKCOMMENT", 
			"LINECOMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2D\u01c5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3%"+
		"\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3,\3,\3,\3,\3,\3,\3"+
		"-\3-\3-\3-\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62"+
		"\3\62\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65"+
		"\3\65\3\66\3\66\3\66\3\67\3\67\38\38\38\39\39\39\39\39\3:\3:\3:\3:\3:"+
		"\3:\3;\3;\3<\3<\3=\6=\u0161\n=\r=\16=\u0162\3>\3>\3?\5?\u0168\n?\3?\3"+
		"?\3?\3?\3?\5?\u016f\n?\3@\3@\3@\3A\3A\3B\3B\3B\3C\3C\3C\3C\3C\3C\3C\5"+
		"C\u0180\nC\3D\6D\u0183\nD\rD\16D\u0184\3E\3E\5E\u0189\nE\3E\3E\3F\3F\3"+
		"G\3G\3H\3H\5H\u0193\nH\3I\3I\3I\7I\u0198\nI\fI\16I\u019b\13I\3J\6J\u019e"+
		"\nJ\rJ\16J\u019f\3J\3J\3K\3K\5K\u01a6\nK\3K\5K\u01a9\nK\3K\3K\3L\3L\3"+
		"L\3L\7L\u01b1\nL\fL\16L\u01b4\13L\3L\3L\3L\3L\3L\3M\3M\3M\3M\7M\u01bf"+
		"\nM\fM\16M\u01c2\13M\3M\3M\3\u01b2\2N\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u\2w\2y\2{\2}\2\177\2\u0081\2"+
		"\u0083\2\u0085\2\u0087\2\u0089<\u008b=\u008d>\u008f?\u0091@\u0093A\u0095"+
		"B\u0097C\u0099D\3\2\b\5\2C\\aac|\3\2\62;\f\2$$))AA^^cdhhppttvvxx\6\2\f"+
		"\f\17\17$$^^\4\2\13\13\"\"\4\2\f\f\17\17\2\u01ca\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2"+
		"\2\2s\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f"+
		"\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2"+
		"\2\2\u0099\3\2\2\2\3\u009b\3\2\2\2\5\u009d\3\2\2\2\7\u009f\3\2\2\2\t\u00a1"+
		"\3\2\2\2\13\u00a3\3\2\2\2\r\u00a5\3\2\2\2\17\u00a7\3\2\2\2\21\u00aa\3"+
		"\2\2\2\23\u00ac\3\2\2\2\25\u00b1\3\2\2\2\27\u00b7\3\2\2\2\31\u00b9\3\2"+
		"\2\2\33\u00bb\3\2\2\2\35\u00c4\3\2\2\2\37\u00cb\3\2\2\2!\u00cd\3\2\2\2"+
		"#\u00d0\3\2\2\2%\u00d2\3\2\2\2\'\u00d4\3\2\2\2)\u00d9\3\2\2\2+\u00dd\3"+
		"\2\2\2-\u00e2\3\2\2\2/\u00e5\3\2\2\2\61\u00e7\3\2\2\2\63\u00ed\3\2\2\2"+
		"\65\u00f1\3\2\2\2\67\u00f6\3\2\2\29\u00f8\3\2\2\2;\u00fb\3\2\2\2=\u00fe"+
		"\3\2\2\2?\u0102\3\2\2\2A\u0104\3\2\2\2C\u0106\3\2\2\2E\u0108\3\2\2\2G"+
		"\u010a\3\2\2\2I\u010d\3\2\2\2K\u0112\3\2\2\2M\u0114\3\2\2\2O\u0116\3\2"+
		"\2\2Q\u0118\3\2\2\2S\u011b\3\2\2\2U\u011e\3\2\2\2W\u0120\3\2\2\2Y\u0126"+
		"\3\2\2\2[\u012d\3\2\2\2]\u012f\3\2\2\2_\u0131\3\2\2\2a\u0133\3\2\2\2c"+
		"\u0138\3\2\2\2e\u013a\3\2\2\2g\u013c\3\2\2\2i\u0143\3\2\2\2k\u0148\3\2"+
		"\2\2m\u014b\3\2\2\2o\u014d\3\2\2\2q\u0150\3\2\2\2s\u0155\3\2\2\2u\u015b"+
		"\3\2\2\2w\u015d\3\2\2\2y\u0160\3\2\2\2{\u0164\3\2\2\2}\u016e\3\2\2\2\177"+
		"\u0170\3\2\2\2\u0081\u0173\3\2\2\2\u0083\u0175\3\2\2\2\u0085\u017f\3\2"+
		"\2\2\u0087\u0182\3\2\2\2\u0089\u0186\3\2\2\2\u008b\u018c\3\2\2\2\u008d"+
		"\u018e\3\2\2\2\u008f\u0192\3\2\2\2\u0091\u0194\3\2\2\2\u0093\u019d\3\2"+
		"\2\2\u0095\u01a8\3\2\2\2\u0097\u01ac\3\2\2\2\u0099\u01ba\3\2\2\2\u009b"+
		"\u009c\7A\2\2\u009c\4\3\2\2\2\u009d\u009e\7`\2\2\u009e\6\3\2\2\2\u009f"+
		"\u00a0\7B\2\2\u00a0\b\3\2\2\2\u00a1\u00a2\7%\2\2\u00a2\n\3\2\2\2\u00a3"+
		"\u00a4\7b\2\2\u00a4\f\3\2\2\2\u00a5\u00a6\7\u0080\2\2\u00a6\16\3\2\2\2"+
		"\u00a7\u00a8\7(\2\2\u00a8\u00a9\7(\2\2\u00a9\20\3\2\2\2\u00aa\u00ab\7"+
		"?\2\2\u00ab\22\3\2\2\2\u00ac\u00ad\7d\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af"+
		"\7q\2\2\u00af\u00b0\7n\2\2\u00b0\24\3\2\2\2\u00b1\u00b2\7d\2\2\u00b2\u00b3"+
		"\7t\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7c\2\2\u00b5\u00b6\7m\2\2\u00b6"+
		"\26\3\2\2\2\u00b7\u00b8\7<\2\2\u00b8\30\3\2\2\2\u00b9\u00ba\7.\2\2\u00ba"+
		"\32\3\2\2\2\u00bb\u00bc\7e\2\2\u00bc\u00bd\7q\2\2\u00bd\u00be\7p\2\2\u00be"+
		"\u00bf\7u\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1\7c\2\2\u00c1\u00c2\7p\2\2"+
		"\u00c2\u00c3\7v\2\2\u00c3\34\3\2\2\2\u00c4\u00c5\7e\2\2\u00c5\u00c6\7"+
		"t\2\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7c\2\2\u00c8\u00c9\7v\2\2\u00c9\u00ca"+
		"\7g\2\2\u00ca\36\3\2\2\2\u00cb\u00cc\7\61\2\2\u00cc \3\2\2\2\u00cd\u00ce"+
		"\7f\2\2\u00ce\u00cf\7q\2\2\u00cf\"\3\2\2\2\u00d0\u00d1\7\60\2\2\u00d1"+
		"$\3\2\2\2\u00d2\u00d3\7$\2\2\u00d3&\3\2\2\2\u00d4\u00d5\7f\2\2\u00d5\u00d6"+
		"\7q\2\2\u00d6\u00d7\7y\2\2\u00d7\u00d8\7p\2\2\u00d8(\3\2\2\2\u00d9\u00da"+
		"\7\60\2\2\u00da\u00db\7\60\2\2\u00db\u00dc\7\60\2\2\u00dc*\3\2\2\2\u00dd"+
		"\u00de\7g\2\2\u00de\u00df\7n\2\2\u00df\u00e0\7u\2\2\u00e0\u00e1\7g\2\2"+
		"\u00e1,\3\2\2\2\u00e2\u00e3\7?\2\2\u00e3\u00e4\7?\2\2\u00e4.\3\2\2\2\u00e5"+
		"\u00e6\7H\2\2\u00e6\60\3\2\2\2\u00e7\u00e8\7h\2\2\u00e8\u00e9\7n\2\2\u00e9"+
		"\u00ea\7q\2\2\u00ea\u00eb\7c\2\2\u00eb\u00ec\7v\2\2\u00ec\62\3\2\2\2\u00ed"+
		"\u00ee\7h\2\2\u00ee\u00ef\7q\2\2\u00ef\u00f0\7t\2\2\u00f0\64\3\2\2\2\u00f1"+
		"\u00f2\7h\2\2\u00f2\u00f3\7w\2\2\u00f3\u00f4\7p\2\2\u00f4\u00f5\7e\2\2"+
		"\u00f5\66\3\2\2\2\u00f6\u00f7\7@\2\2\u00f78\3\2\2\2\u00f8\u00f9\7@\2\2"+
		"\u00f9\u00fa\7?\2\2\u00fa:\3\2\2\2\u00fb\u00fc\7k\2\2\u00fc\u00fd\7h\2"+
		"\2\u00fd<\3\2\2\2\u00fe\u00ff\7k\2\2\u00ff\u0100\7p\2\2\u0100\u0101\7"+
		"v\2\2\u0101>\3\2\2\2\u0102\u0103\7}\2\2\u0103@\3\2\2\2\u0104\u0105\7]"+
		"\2\2\u0105B\3\2\2\2\u0106\u0107\7*\2\2\u0107D\3\2\2\2\u0108\u0109\7>\2"+
		"\2\u0109F\3\2\2\2\u010a\u010b\7>\2\2\u010b\u010c\7?\2\2\u010cH\3\2\2\2"+
		"\u010d\u010e\7o\2\2\u010e\u010f\7c\2\2\u010f\u0110\7k\2\2\u0110\u0111"+
		"\7p\2\2\u0111J\3\2\2\2\u0112\u0113\7/\2\2\u0113L\3\2\2\2\u0114\u0115\7"+
		"\'\2\2\u0115N\3\2\2\2\u0116\u0117\7#\2\2\u0117P\3\2\2\2\u0118\u0119\7"+
		"#\2\2\u0119\u011a\7?\2\2\u011aR\3\2\2\2\u011b\u011c\7~\2\2\u011c\u011d"+
		"\7~\2\2\u011dT\3\2\2\2\u011e\u011f\7-\2\2\u011fV\3\2\2\2\u0120\u0121\7"+
		"r\2\2\u0121\u0122\7t\2\2\u0122\u0123\7k\2\2\u0123\u0124\7p\2\2\u0124\u0125"+
		"\7v\2\2\u0125X\3\2\2\2\u0126\u0127\7t\2\2\u0127\u0128\7g\2\2\u0128\u0129"+
		"\7v\2\2\u0129\u012a\7w\2\2\u012a\u012b\7t\2\2\u012b\u012c\7p\2\2\u012c"+
		"Z\3\2\2\2\u012d\u012e\7\177\2\2\u012e\\\3\2\2\2\u012f\u0130\7_\2\2\u0130"+
		"^\3\2\2\2\u0131\u0132\7+\2\2\u0132`\3\2\2\2\u0133\u0134\7u\2\2\u0134\u0135"+
		"\7e\2\2\u0135\u0136\7c\2\2\u0136\u0137\7p\2\2\u0137b\3\2\2\2\u0138\u0139"+
		"\7=\2\2\u0139d\3\2\2\2\u013a\u013b\7,\2\2\u013bf\3\2\2\2\u013c\u013d\7"+
		"U\2\2\u013d\u013e\7v\2\2\u013e\u013f\7t\2\2\u013f\u0140\7k\2\2\u0140\u0141"+
		"\7p\2\2\u0141\u0142\7i\2\2\u0142h\3\2\2\2\u0143\u0144\7v\2\2\u0144\u0145"+
		"\7j\2\2\u0145\u0146\7g\2\2\u0146\u0147\7p\2\2\u0147j\3\2\2\2\u0148\u0149"+
		"\7v\2\2\u0149\u014a\7q\2\2\u014al\3\2\2\2\u014b\u014c\7V\2\2\u014cn\3"+
		"\2\2\2\u014d\u014e\7w\2\2\u014e\u014f\7r\2\2\u014fp\3\2\2\2\u0150\u0151"+
		"\7x\2\2\u0151\u0152\7q\2\2\u0152\u0153\7k\2\2\u0153\u0154\7f\2\2\u0154"+
		"r\3\2\2\2\u0155\u0156\7y\2\2\u0156\u0157\7j\2\2\u0157\u0158\7k\2\2\u0158"+
		"\u0159\7n\2\2\u0159\u015a\7g\2\2\u015at\3\2\2\2\u015b\u015c\t\2\2\2\u015c"+
		"v\3\2\2\2\u015d\u015e\t\3\2\2\u015ex\3\2\2\2\u015f\u0161\5w<\2\u0160\u015f"+
		"\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163"+
		"z\3\2\2\2\u0164\u0165\7h\2\2\u0165|\3\2\2\2\u0166\u0168\5y=\2\u0167\u0166"+
		"\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a\7\60\2\2"+
		"\u016a\u016f\5y=\2\u016b\u016c\5y=\2\u016c\u016d\7\60\2\2\u016d\u016f"+
		"\3\2\2\2\u016e\u0167\3\2\2\2\u016e\u016b\3\2\2\2\u016f~\3\2\2\2\u0170"+
		"\u0171\5}?\2\u0171\u0172\5{>\2\u0172\u0080\3\2\2\2\u0173\u0174\5\u0083"+
		"B\2\u0174\u0082\3\2\2\2\u0175\u0176\7^\2\2\u0176\u0177\t\4\2\2\u0177\u0084"+
		"\3\2\2\2\u0178\u0180\n\5\2\2\u0179\u0180\5\u0081A\2\u017a\u017b\7^\2\2"+
		"\u017b\u0180\7\f\2\2\u017c\u017d\7^\2\2\u017d\u017e\7\17\2\2\u017e\u0180"+
		"\7\f\2\2\u017f\u0178\3\2\2\2\u017f\u0179\3\2\2\2\u017f\u017a\3\2\2\2\u017f"+
		"\u017c\3\2\2\2\u0180\u0086\3\2\2\2\u0181\u0183\5\u0085C\2\u0182\u0181"+
		"\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185"+
		"\u0088\3\2\2\2\u0186\u0188\5%\23\2\u0187\u0189\5\u0087D\2\u0188\u0187"+
		"\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\5%\23\2\u018b"+
		"\u008a\3\2\2\2\u018c\u018d\5y=\2\u018d\u008c\3\2\2\2\u018e\u018f\5\177"+
		"@\2\u018f\u008e\3\2\2\2\u0190\u0193\5m\67\2\u0191\u0193\5/\30\2\u0192"+
		"\u0190\3\2\2\2\u0192\u0191\3\2\2\2\u0193\u0090\3\2\2\2\u0194\u0199\5u"+
		";\2\u0195\u0198\5w<\2\u0196\u0198\5u;\2\u0197\u0195\3\2\2\2\u0197\u0196"+
		"\3\2\2\2\u0198\u019b\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u019a\3\2\2\2\u019a"+
		"\u0092\3\2\2\2\u019b\u0199\3\2\2\2\u019c\u019e\t\6\2\2\u019d\u019c\3\2"+
		"\2\2\u019e\u019f\3\2\2\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\u01a1\3\2\2\2\u01a1\u01a2\bJ\2\2\u01a2\u0094\3\2\2\2\u01a3\u01a5\7\17"+
		"\2\2\u01a4\u01a6\7\f\2\2\u01a5\u01a4\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6"+
		"\u01a9\3\2\2\2\u01a7\u01a9\7\f\2\2\u01a8\u01a3\3\2\2\2\u01a8\u01a7\3\2"+
		"\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ab\bK\2\2\u01ab\u0096\3\2\2\2\u01ac"+
		"\u01ad\7\61\2\2\u01ad\u01ae\7,\2\2\u01ae\u01b2\3\2\2\2\u01af\u01b1\13"+
		"\2\2\2\u01b0\u01af\3\2\2\2\u01b1\u01b4\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b2"+
		"\u01b0\3\2\2\2\u01b3\u01b5\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b5\u01b6\7,"+
		"\2\2\u01b6\u01b7\7\61\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\bL\2\2\u01b9"+
		"\u0098\3\2\2\2\u01ba\u01bb\7\61\2\2\u01bb\u01bc\7\61\2\2\u01bc\u01c0\3"+
		"\2\2\2\u01bd\u01bf\n\7\2\2\u01be\u01bd\3\2\2\2\u01bf\u01c2\3\2\2\2\u01c0"+
		"\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c3\3\2\2\2\u01c2\u01c0\3\2"+
		"\2\2\u01c3\u01c4\bM\2\2\u01c4\u009a\3\2\2\2\21\2\u0162\u0167\u016e\u017f"+
		"\u0184\u0188\u0192\u0197\u0199\u019f\u01a5\u01a8\u01b2\u01c0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}