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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, BOOLCONSTANT=7, True=8, 
		False=9, AndAnd=10, Assign=11, Boolean=12, Break=13, Colon=14, Comma=15, 
		ConstantKey=16, Create=17, Div=18, Do=19, Dot=20, DoubleQuotation=21, 
		Down=22, Ellipsis=23, Else=24, Equal=25, Float=26, For=27, Func=28, Greater=29, 
		GreaterEqual=30, If=31, Int=32, LeftBrace=33, LeftBracket=34, LeftParen=35, 
		Less=36, LessEqual=37, Main=38, Minus=39, Mod=40, Not=41, NotEqual=42, 
		OrOr=43, Plus=44, Print=45, Return=46, RightBrace=47, RightBracket=48, 
		RightParen=49, Scan=50, Semi=51, Star=52, String=53, Then=54, To=55, Up=56, 
		Void=57, While=58, Upto=59, Downto=60, StringLiteral=61, INTEGERCONSTANT=62, 
		FLOATCONSTANT=63, IDENTIFIER=64, WHITSPACE=65, NEWLINE=66, BLOCKCOMMENT=67, 
		LINECOMMENT=68;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "BOOLCONSTANT", "True", 
			"False", "AndAnd", "Assign", "Boolean", "Break", "Colon", "Comma", "ConstantKey", 
			"Create", "Div", "Do", "Dot", "DoubleQuotation", "Down", "Ellipsis", 
			"Else", "Equal", "Float", "For", "Func", "Greater", "GreaterEqual", "If", 
			"Int", "LeftBrace", "LeftBracket", "LeftParen", "Less", "LessEqual", 
			"Main", "Minus", "Mod", "Not", "NotEqual", "OrOr", "Plus", "Print", "Return", 
			"RightBrace", "RightBracket", "RightParen", "Scan", "Semi", "Star", "String", 
			"Then", "To", "Up", "Void", "While", "Letter", "Digit", "Space", "DigitSequence", 
			"FloatSuffix", "FractionalConstant", "DecimalFloatingConstant", "EscapeSequence", 
			"SimpleEscapeSequence", "SChar", "SCharSequence", "Upto", "Downto", "StringLiteral", 
			"INTEGERCONSTANT", "FLOATCONSTANT", "IDENTIFIER", "WHITSPACE", "NEWLINE", 
			"BLOCKCOMMENT", "LINECOMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'?'", "'^'", "'@'", "'#'", "'`'", "'~'", null, "'T'", "'F'", "'&&'", 
			"'='", "'bool'", "'break'", "':'", "','", "'constant'", "'create'", "'/'", 
			"'do'", "'.'", "'\"'", "'down'", "'...'", "'else'", "'=='", "'float'", 
			"'for'", "'func'", "'>'", "'>='", "'if'", "'int'", "'{'", "'['", "'('", 
			"'<'", "'<='", "'main'", "'-'", "'%'", "'!'", "'!='", "'||'", "'+'", 
			"'print'", "'return'", "'}'", "']'", "')'", "'scan'", "';'", "'*'", "'String'", 
			"'then'", "'to'", "'up'", "'void'", "'while'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "BOOLCONSTANT", "True", "False", 
			"AndAnd", "Assign", "Boolean", "Break", "Colon", "Comma", "ConstantKey", 
			"Create", "Div", "Do", "Dot", "DoubleQuotation", "Down", "Ellipsis", 
			"Else", "Equal", "Float", "For", "Func", "Greater", "GreaterEqual", "If", 
			"Int", "LeftBrace", "LeftBracket", "LeftParen", "Less", "LessEqual", 
			"Main", "Minus", "Mod", "Not", "NotEqual", "OrOr", "Plus", "Print", "Return", 
			"RightBrace", "RightBracket", "RightParen", "Scan", "Semi", "Star", "String", 
			"Then", "To", "Up", "Void", "While", "Upto", "Downto", "StringLiteral", 
			"INTEGERCONSTANT", "FLOATCONSTANT", "IDENTIFIER", "WHITSPACE", "NEWLINE", 
			"BLOCKCOMMENT", "LINECOMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2F\u01dd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\5\b\u00b0\n\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3\""+
		"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*"+
		"\3+\3+\3+\3,\3,\3,\3-\3-\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3\60\3"+
		"\60\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\65\3\65\3"+
		"\66\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38\38\3"+
		"9\39\39\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3<\3<\3=\3=\3>\3>\3?\6?\u016d"+
		"\n?\r?\16?\u016e\3@\3@\3A\5A\u0174\nA\3A\3A\3A\3A\3A\5A\u017b\nA\3B\3"+
		"B\3B\3C\3C\3D\3D\3D\3E\3E\3E\3E\3E\3E\3E\5E\u018c\nE\3F\6F\u018f\nF\r"+
		"F\16F\u0190\3G\3G\6G\u0195\nG\rG\16G\u0196\3G\3G\3H\3H\6H\u019d\nH\rH"+
		"\16H\u019e\3H\3H\3I\3I\5I\u01a5\nI\3I\3I\3J\3J\3K\3K\3L\3L\3L\7L\u01b0"+
		"\nL\fL\16L\u01b3\13L\3M\6M\u01b6\nM\rM\16M\u01b7\3M\3M\3N\3N\5N\u01be"+
		"\nN\3N\5N\u01c1\nN\3N\3N\3O\3O\3O\3O\7O\u01c9\nO\fO\16O\u01cc\13O\3O\3"+
		"O\3O\3O\3O\3P\3P\3P\3P\7P\u01d7\nP\fP\16P\u01da\13P\3P\3P\3\u01ca\2Q\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9"+
		"q:s;u<w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b"+
		"\2\u008d=\u008f>\u0091?\u0093@\u0095A\u0097B\u0099C\u009bD\u009dE\u009f"+
		"F\3\2\t\5\2C\\aac|\3\2\62;\3\2\"\"\f\2$$))AA^^cdhhppttvvxx\6\2\f\f\17"+
		"\17$$^^\4\2\13\13\"\"\4\2\f\f\17\17\2\u01e3\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2"+
		"\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2"+
		"s\3\2\2\2\2u\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2"+
		"\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b"+
		"\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\3\u00a1\3\2\2\2\5\u00a3\3\2\2"+
		"\2\7\u00a5\3\2\2\2\t\u00a7\3\2\2\2\13\u00a9\3\2\2\2\r\u00ab\3\2\2\2\17"+
		"\u00af\3\2\2\2\21\u00b1\3\2\2\2\23\u00b3\3\2\2\2\25\u00b5\3\2\2\2\27\u00b8"+
		"\3\2\2\2\31\u00ba\3\2\2\2\33\u00bf\3\2\2\2\35\u00c5\3\2\2\2\37\u00c7\3"+
		"\2\2\2!\u00c9\3\2\2\2#\u00d2\3\2\2\2%\u00d9\3\2\2\2\'\u00db\3\2\2\2)\u00de"+
		"\3\2\2\2+\u00e0\3\2\2\2-\u00e2\3\2\2\2/\u00e7\3\2\2\2\61\u00eb\3\2\2\2"+
		"\63\u00f0\3\2\2\2\65\u00f3\3\2\2\2\67\u00f9\3\2\2\29\u00fd\3\2\2\2;\u0102"+
		"\3\2\2\2=\u0104\3\2\2\2?\u0107\3\2\2\2A\u010a\3\2\2\2C\u010e\3\2\2\2E"+
		"\u0110\3\2\2\2G\u0112\3\2\2\2I\u0114\3\2\2\2K\u0116\3\2\2\2M\u0119\3\2"+
		"\2\2O\u011e\3\2\2\2Q\u0120\3\2\2\2S\u0122\3\2\2\2U\u0124\3\2\2\2W\u0127"+
		"\3\2\2\2Y\u012a\3\2\2\2[\u012c\3\2\2\2]\u0132\3\2\2\2_\u0139\3\2\2\2a"+
		"\u013b\3\2\2\2c\u013d\3\2\2\2e\u013f\3\2\2\2g\u0144\3\2\2\2i\u0146\3\2"+
		"\2\2k\u0148\3\2\2\2m\u014f\3\2\2\2o\u0154\3\2\2\2q\u0157\3\2\2\2s\u015a"+
		"\3\2\2\2u\u015f\3\2\2\2w\u0165\3\2\2\2y\u0167\3\2\2\2{\u0169\3\2\2\2}"+
		"\u016c\3\2\2\2\177\u0170\3\2\2\2\u0081\u017a\3\2\2\2\u0083\u017c\3\2\2"+
		"\2\u0085\u017f\3\2\2\2\u0087\u0181\3\2\2\2\u0089\u018b\3\2\2\2\u008b\u018e"+
		"\3\2\2\2\u008d\u0192\3\2\2\2\u008f\u019a\3\2\2\2\u0091\u01a2\3\2\2\2\u0093"+
		"\u01a8\3\2\2\2\u0095\u01aa\3\2\2\2\u0097\u01ac\3\2\2\2\u0099\u01b5\3\2"+
		"\2\2\u009b\u01c0\3\2\2\2\u009d\u01c4\3\2\2\2\u009f\u01d2\3\2\2\2\u00a1"+
		"\u00a2\7A\2\2\u00a2\4\3\2\2\2\u00a3\u00a4\7`\2\2\u00a4\6\3\2\2\2\u00a5"+
		"\u00a6\7B\2\2\u00a6\b\3\2\2\2\u00a7\u00a8\7%\2\2\u00a8\n\3\2\2\2\u00a9"+
		"\u00aa\7b\2\2\u00aa\f\3\2\2\2\u00ab\u00ac\7\u0080\2\2\u00ac\16\3\2\2\2"+
		"\u00ad\u00b0\5\21\t\2\u00ae\u00b0\5\23\n\2\u00af\u00ad\3\2\2\2\u00af\u00ae"+
		"\3\2\2\2\u00b0\20\3\2\2\2\u00b1\u00b2\7V\2\2\u00b2\22\3\2\2\2\u00b3\u00b4"+
		"\7H\2\2\u00b4\24\3\2\2\2\u00b5\u00b6\7(\2\2\u00b6\u00b7\7(\2\2\u00b7\26"+
		"\3\2\2\2\u00b8\u00b9\7?\2\2\u00b9\30\3\2\2\2\u00ba\u00bb\7d\2\2\u00bb"+
		"\u00bc\7q\2\2\u00bc\u00bd\7q\2\2\u00bd\u00be\7n\2\2\u00be\32\3\2\2\2\u00bf"+
		"\u00c0\7d\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7g\2\2\u00c2\u00c3\7c\2\2"+
		"\u00c3\u00c4\7m\2\2\u00c4\34\3\2\2\2\u00c5\u00c6\7<\2\2\u00c6\36\3\2\2"+
		"\2\u00c7\u00c8\7.\2\2\u00c8 \3\2\2\2\u00c9\u00ca\7e\2\2\u00ca\u00cb\7"+
		"q\2\2\u00cb\u00cc\7p\2\2\u00cc\u00cd\7u\2\2\u00cd\u00ce\7v\2\2\u00ce\u00cf"+
		"\7c\2\2\u00cf\u00d0\7p\2\2\u00d0\u00d1\7v\2\2\u00d1\"\3\2\2\2\u00d2\u00d3"+
		"\7e\2\2\u00d3\u00d4\7t\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7c\2\2\u00d6"+
		"\u00d7\7v\2\2\u00d7\u00d8\7g\2\2\u00d8$\3\2\2\2\u00d9\u00da\7\61\2\2\u00da"+
		"&\3\2\2\2\u00db\u00dc\7f\2\2\u00dc\u00dd\7q\2\2\u00dd(\3\2\2\2\u00de\u00df"+
		"\7\60\2\2\u00df*\3\2\2\2\u00e0\u00e1\7$\2\2\u00e1,\3\2\2\2\u00e2\u00e3"+
		"\7f\2\2\u00e3\u00e4\7q\2\2\u00e4\u00e5\7y\2\2\u00e5\u00e6\7p\2\2\u00e6"+
		".\3\2\2\2\u00e7\u00e8\7\60\2\2\u00e8\u00e9\7\60\2\2\u00e9\u00ea\7\60\2"+
		"\2\u00ea\60\3\2\2\2\u00eb\u00ec\7g\2\2\u00ec\u00ed\7n\2\2\u00ed\u00ee"+
		"\7u\2\2\u00ee\u00ef\7g\2\2\u00ef\62\3\2\2\2\u00f0\u00f1\7?\2\2\u00f1\u00f2"+
		"\7?\2\2\u00f2\64\3\2\2\2\u00f3\u00f4\7h\2\2\u00f4\u00f5\7n\2\2\u00f5\u00f6"+
		"\7q\2\2\u00f6\u00f7\7c\2\2\u00f7\u00f8\7v\2\2\u00f8\66\3\2\2\2\u00f9\u00fa"+
		"\7h\2\2\u00fa\u00fb\7q\2\2\u00fb\u00fc\7t\2\2\u00fc8\3\2\2\2\u00fd\u00fe"+
		"\7h\2\2\u00fe\u00ff\7w\2\2\u00ff\u0100\7p\2\2\u0100\u0101\7e\2\2\u0101"+
		":\3\2\2\2\u0102\u0103\7@\2\2\u0103<\3\2\2\2\u0104\u0105\7@\2\2\u0105\u0106"+
		"\7?\2\2\u0106>\3\2\2\2\u0107\u0108\7k\2\2\u0108\u0109\7h\2\2\u0109@\3"+
		"\2\2\2\u010a\u010b\7k\2\2\u010b\u010c\7p\2\2\u010c\u010d\7v\2\2\u010d"+
		"B\3\2\2\2\u010e\u010f\7}\2\2\u010fD\3\2\2\2\u0110\u0111\7]\2\2\u0111F"+
		"\3\2\2\2\u0112\u0113\7*\2\2\u0113H\3\2\2\2\u0114\u0115\7>\2\2\u0115J\3"+
		"\2\2\2\u0116\u0117\7>\2\2\u0117\u0118\7?\2\2\u0118L\3\2\2\2\u0119\u011a"+
		"\7o\2\2\u011a\u011b\7c\2\2\u011b\u011c\7k\2\2\u011c\u011d\7p\2\2\u011d"+
		"N\3\2\2\2\u011e\u011f\7/\2\2\u011fP\3\2\2\2\u0120\u0121\7\'\2\2\u0121"+
		"R\3\2\2\2\u0122\u0123\7#\2\2\u0123T\3\2\2\2\u0124\u0125\7#\2\2\u0125\u0126"+
		"\7?\2\2\u0126V\3\2\2\2\u0127\u0128\7~\2\2\u0128\u0129\7~\2\2\u0129X\3"+
		"\2\2\2\u012a\u012b\7-\2\2\u012bZ\3\2\2\2\u012c\u012d\7r\2\2\u012d\u012e"+
		"\7t\2\2\u012e\u012f\7k\2\2\u012f\u0130\7p\2\2\u0130\u0131\7v\2\2\u0131"+
		"\\\3\2\2\2\u0132\u0133\7t\2\2\u0133\u0134\7g\2\2\u0134\u0135\7v\2\2\u0135"+
		"\u0136\7w\2\2\u0136\u0137\7t\2\2\u0137\u0138\7p\2\2\u0138^\3\2\2\2\u0139"+
		"\u013a\7\177\2\2\u013a`\3\2\2\2\u013b\u013c\7_\2\2\u013cb\3\2\2\2\u013d"+
		"\u013e\7+\2\2\u013ed\3\2\2\2\u013f\u0140\7u\2\2\u0140\u0141\7e\2\2\u0141"+
		"\u0142\7c\2\2\u0142\u0143\7p\2\2\u0143f\3\2\2\2\u0144\u0145\7=\2\2\u0145"+
		"h\3\2\2\2\u0146\u0147\7,\2\2\u0147j\3\2\2\2\u0148\u0149\7U\2\2\u0149\u014a"+
		"\7v\2\2\u014a\u014b\7t\2\2\u014b\u014c\7k\2\2\u014c\u014d\7p\2\2\u014d"+
		"\u014e\7i\2\2\u014el\3\2\2\2\u014f\u0150\7v\2\2\u0150\u0151\7j\2\2\u0151"+
		"\u0152\7g\2\2\u0152\u0153\7p\2\2\u0153n\3\2\2\2\u0154\u0155\7v\2\2\u0155"+
		"\u0156\7q\2\2\u0156p\3\2\2\2\u0157\u0158\7w\2\2\u0158\u0159\7r\2\2\u0159"+
		"r\3\2\2\2\u015a\u015b\7x\2\2\u015b\u015c\7q\2\2\u015c\u015d\7k\2\2\u015d"+
		"\u015e\7f\2\2\u015et\3\2\2\2\u015f\u0160\7y\2\2\u0160\u0161\7j\2\2\u0161"+
		"\u0162\7k\2\2\u0162\u0163\7n\2\2\u0163\u0164\7g\2\2\u0164v\3\2\2\2\u0165"+
		"\u0166\t\2\2\2\u0166x\3\2\2\2\u0167\u0168\t\3\2\2\u0168z\3\2\2\2\u0169"+
		"\u016a\t\4\2\2\u016a|\3\2\2\2\u016b\u016d\5y=\2\u016c\u016b\3\2\2\2\u016d"+
		"\u016e\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f~\3\2\2\2"+
		"\u0170\u0171\7h\2\2\u0171\u0080\3\2\2\2\u0172\u0174\5}?\2\u0173\u0172"+
		"\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0176\7\60\2\2"+
		"\u0176\u017b\5}?\2\u0177\u0178\5}?\2\u0178\u0179\7\60\2\2\u0179\u017b"+
		"\3\2\2\2\u017a\u0173\3\2\2\2\u017a\u0177\3\2\2\2\u017b\u0082\3\2\2\2\u017c"+
		"\u017d\5\u0081A\2\u017d\u017e\5\177@\2\u017e\u0084\3\2\2\2\u017f\u0180"+
		"\5\u0087D\2\u0180\u0086\3\2\2\2\u0181\u0182\7^\2\2\u0182\u0183\t\5\2\2"+
		"\u0183\u0088\3\2\2\2\u0184\u018c\n\6\2\2\u0185\u018c\5\u0085C\2\u0186"+
		"\u0187\7^\2\2\u0187\u018c\7\f\2\2\u0188\u0189\7^\2\2\u0189\u018a\7\17"+
		"\2\2\u018a\u018c\7\f\2\2\u018b\u0184\3\2\2\2\u018b\u0185\3\2\2\2\u018b"+
		"\u0186\3\2\2\2\u018b\u0188\3\2\2\2\u018c\u008a\3\2\2\2\u018d\u018f\5\u0089"+
		"E\2\u018e\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u018e\3\2\2\2\u0190"+
		"\u0191\3\2\2\2\u0191\u008c\3\2\2\2\u0192\u0194\5q9\2\u0193\u0195\5{>\2"+
		"\u0194\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0197"+
		"\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u0199\5o8\2\u0199\u008e\3\2\2\2\u019a"+
		"\u019c\5-\27\2\u019b\u019d\5{>\2\u019c\u019b\3\2\2\2\u019d\u019e\3\2\2"+
		"\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a1"+
		"\5o8\2\u01a1\u0090\3\2\2\2\u01a2\u01a4\5+\26\2\u01a3\u01a5\5\u008bF\2"+
		"\u01a4\u01a3\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7"+
		"\5+\26\2\u01a7\u0092\3\2\2\2\u01a8\u01a9\5}?\2\u01a9\u0094\3\2\2\2\u01aa"+
		"\u01ab\5\u0083B\2\u01ab\u0096\3\2\2\2\u01ac\u01b1\5w<\2\u01ad\u01b0\5"+
		"y=\2\u01ae\u01b0\5w<\2\u01af\u01ad\3\2\2\2\u01af\u01ae\3\2\2\2\u01b0\u01b3"+
		"\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u0098\3\2\2\2\u01b3"+
		"\u01b1\3\2\2\2\u01b4\u01b6\t\7\2\2\u01b5\u01b4\3\2\2\2\u01b6\u01b7\3\2"+
		"\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9"+
		"\u01ba\bM\2\2\u01ba\u009a\3\2\2\2\u01bb\u01bd\7\17\2\2\u01bc\u01be\7\f"+
		"\2\2\u01bd\u01bc\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf"+
		"\u01c1\7\f\2\2\u01c0\u01bb\3\2\2\2\u01c0\u01bf\3\2\2\2\u01c1\u01c2\3\2"+
		"\2\2\u01c2\u01c3\bN\2\2\u01c3\u009c\3\2\2\2\u01c4\u01c5\7\61\2\2\u01c5"+
		"\u01c6\7,\2\2\u01c6\u01ca\3\2\2\2\u01c7\u01c9\13\2\2\2\u01c8\u01c7\3\2"+
		"\2\2\u01c9\u01cc\3\2\2\2\u01ca\u01cb\3\2\2\2\u01ca\u01c8\3\2\2\2\u01cb"+
		"\u01cd\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cd\u01ce\7,\2\2\u01ce\u01cf\7\61"+
		"\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1\bO\2\2\u01d1\u009e\3\2\2\2\u01d2"+
		"\u01d3\7\61\2\2\u01d3\u01d4\7\61\2\2\u01d4\u01d8\3\2\2\2\u01d5\u01d7\n"+
		"\b\2\2\u01d6\u01d5\3\2\2\2\u01d7\u01da\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d8"+
		"\u01d9\3\2\2\2\u01d9\u01db\3\2\2\2\u01da\u01d8\3\2\2\2\u01db\u01dc\bP"+
		"\2\2\u01dc\u00a0\3\2\2\2\23\2\u00af\u016e\u0173\u017a\u018b\u0190\u0196"+
		"\u019e\u01a4\u01af\u01b1\u01b7\u01bd\u01c0\u01ca\u01d8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}