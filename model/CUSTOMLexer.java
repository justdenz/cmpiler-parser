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
		ConstantKey=1, Int=2, Float=3, String=4, Boolean=5, Do=6, Else=7, For=8, 
		If=9, ElseIf=10, Then=11, Return=12, Void=13, While=14, Create=15, Main=16, 
		Func=17, Scan=18, Print=19, LeftParen=20, RightParen=21, LeftBracket=22, 
		RightBracket=23, LeftBrace=24, RightBrace=25, Less=26, LessEqual=27, Greater=28, 
		GreaterEqual=29, Plus=30, Minus=31, Star=32, Div=33, Mod=34, AndAnd=35, 
		OrOr=36, Not=37, Colon=38, Semi=39, Comma=40, Assign=41, Equal=42, NotEqual=43, 
		Dot=44, Ellipsis=45, Up=46, Down=47, To=48, True=49, False=50, Break=51, 
		DoubleQuotation=52, INTEGERCONSTANT=53, FLOATCONSTANT=54, BOOLCONSTANT=55, 
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
			"ConstantKey", "Int", "Float", "String", "Boolean", "Do", "Else", "For", 
			"If", "ElseIf", "Then", "Return", "Void", "While", "Create", "Main", 
			"Func", "Scan", "Print", "LeftParen", "RightParen", "LeftBracket", "RightBracket", 
			"LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", "GreaterEqual", 
			"Plus", "Minus", "Star", "Div", "Mod", "AndAnd", "OrOr", "Not", "Colon", 
			"Semi", "Comma", "Assign", "Equal", "NotEqual", "Dot", "Ellipsis", "Up", 
			"Down", "To", "True", "False", "Break", "DoubleQuotation", "Letter", 
			"Digit", "DigitSequence", "FloatSuffix", "FractionalConstant", "DecimalFloatingConstant", 
			"EscapeSequence", "SimpleEscapeSequence", "SChar", "SCharSequence", "StringLiteral", 
			"INTEGERCONSTANT", "FLOATCONSTANT", "BOOLCONSTANT", "STRINGCONSTANT", 
			"IDENTIFIER", "WHITSPACE", "NEWLINE", "BLOCKCOMMENT", "LINECOMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'constant'", "'int'", "'float'", "'String'", "'bool'", "'do'", 
			"'else'", "'for'", "'if'", "'else if'", "'then'", "'return'", "'void'", 
			"'while'", "'create'", "'main'", "'func'", "'scan'", "'print'", "'('", 
			"')'", "'['", "']'", "'{'", "'}'", "'<'", "'<='", "'>'", "'>='", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'&&'", "'||'", "'!'", "':'", "';'", "','", 
			"'='", "'=='", "'!='", "'.'", "'...'", "'up'", "'down'", "'to'", "'T'", 
			"'F'", "'break'", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ConstantKey", "Int", "Float", "String", "Boolean", "Do", "Else", 
			"For", "If", "ElseIf", "Then", "Return", "Void", "While", "Create", "Main", 
			"Func", "Scan", "Print", "LeftParen", "RightParen", "LeftBracket", "RightBracket", 
			"LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", "GreaterEqual", 
			"Plus", "Minus", "Star", "Div", "Mod", "AndAnd", "OrOr", "Not", "Colon", 
			"Semi", "Comma", "Assign", "Equal", "NotEqual", "Dot", "Ellipsis", "Up", 
			"Down", "To", "True", "False", "Break", "DoubleQuotation", "INTEGERCONSTANT", 
			"FLOATCONSTANT", "BOOLCONSTANT", "STRINGCONSTANT", "IDENTIFIER", "WHITSPACE", 
			"NEWLINE", "BLOCKCOMMENT", "LINECOMMENT"
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
		"\tI\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3%\3"+
		"%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3.\3.\3."+
		"\3.\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\63\3"+
		"\63\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\68"+
		"\u0155\n8\r8\168\u0156\39\39\3:\5:\u015c\n:\3:\3:\3:\3:\3:\5:\u0163\n"+
		":\3;\3;\3;\3<\3<\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\5>\u0174\n>\3?\6?\u0177"+
		"\n?\r?\16?\u0178\3@\3@\5@\u017d\n@\3@\3@\3A\3A\3B\3B\3C\3C\5C\u0187\n"+
		"C\3D\3D\3E\3E\3E\7E\u018e\nE\fE\16E\u0191\13E\3F\6F\u0194\nF\rF\16F\u0195"+
		"\3F\3F\3G\3G\5G\u019c\nG\3G\5G\u019f\nG\3G\3G\3H\3H\3H\3H\7H\u01a7\nH"+
		"\fH\16H\u01aa\13H\3H\3H\3H\3H\3H\3I\3I\3I\3I\7I\u01b5\nI\fI\16I\u01b8"+
		"\13I\3I\3I\3\u01a8\2J\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63"+
		"e\64g\65i\66k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\67\u00838\u0085"+
		"9\u0087:\u0089;\u008b<\u008d=\u008f>\u0091?\3\2\b\5\2C\\aac|\3\2\62;\f"+
		"\2$$))AA^^cdhhppttvvxx\6\2\f\f\17\17$$^^\4\2\13\13\"\"\4\2\f\f\17\17\2"+
		"\u01bf\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2"+
		"\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2\u0081\3\2"+
		"\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2"+
		"\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\3\u0093"+
		"\3\2\2\2\5\u009c\3\2\2\2\7\u00a0\3\2\2\2\t\u00a6\3\2\2\2\13\u00ad\3\2"+
		"\2\2\r\u00b2\3\2\2\2\17\u00b5\3\2\2\2\21\u00ba\3\2\2\2\23\u00be\3\2\2"+
		"\2\25\u00c1\3\2\2\2\27\u00c9\3\2\2\2\31\u00ce\3\2\2\2\33\u00d5\3\2\2\2"+
		"\35\u00da\3\2\2\2\37\u00e0\3\2\2\2!\u00e7\3\2\2\2#\u00ec\3\2\2\2%\u00f1"+
		"\3\2\2\2\'\u00f6\3\2\2\2)\u00fc\3\2\2\2+\u00fe\3\2\2\2-\u0100\3\2\2\2"+
		"/\u0102\3\2\2\2\61\u0104\3\2\2\2\63\u0106\3\2\2\2\65\u0108\3\2\2\2\67"+
		"\u010a\3\2\2\29\u010d\3\2\2\2;\u010f\3\2\2\2=\u0112\3\2\2\2?\u0114\3\2"+
		"\2\2A\u0116\3\2\2\2C\u0118\3\2\2\2E\u011a\3\2\2\2G\u011c\3\2\2\2I\u011f"+
		"\3\2\2\2K\u0122\3\2\2\2M\u0124\3\2\2\2O\u0126\3\2\2\2Q\u0128\3\2\2\2S"+
		"\u012a\3\2\2\2U\u012c\3\2\2\2W\u012f\3\2\2\2Y\u0132\3\2\2\2[\u0134\3\2"+
		"\2\2]\u0138\3\2\2\2_\u013b\3\2\2\2a\u0140\3\2\2\2c\u0143\3\2\2\2e\u0145"+
		"\3\2\2\2g\u0147\3\2\2\2i\u014d\3\2\2\2k\u014f\3\2\2\2m\u0151\3\2\2\2o"+
		"\u0154\3\2\2\2q\u0158\3\2\2\2s\u0162\3\2\2\2u\u0164\3\2\2\2w\u0167\3\2"+
		"\2\2y\u0169\3\2\2\2{\u0173\3\2\2\2}\u0176\3\2\2\2\177\u017a\3\2\2\2\u0081"+
		"\u0180\3\2\2\2\u0083\u0182\3\2\2\2\u0085\u0186\3\2\2\2\u0087\u0188\3\2"+
		"\2\2\u0089\u018a\3\2\2\2\u008b\u0193\3\2\2\2\u008d\u019e\3\2\2\2\u008f"+
		"\u01a2\3\2\2\2\u0091\u01b0\3\2\2\2\u0093\u0094\7e\2\2\u0094\u0095\7q\2"+
		"\2\u0095\u0096\7p\2\2\u0096\u0097\7u\2\2\u0097\u0098\7v\2\2\u0098\u0099"+
		"\7c\2\2\u0099\u009a\7p\2\2\u009a\u009b\7v\2\2\u009b\4\3\2\2\2\u009c\u009d"+
		"\7k\2\2\u009d\u009e\7p\2\2\u009e\u009f\7v\2\2\u009f\6\3\2\2\2\u00a0\u00a1"+
		"\7h\2\2\u00a1\u00a2\7n\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4\7c\2\2\u00a4"+
		"\u00a5\7v\2\2\u00a5\b\3\2\2\2\u00a6\u00a7\7U\2\2\u00a7\u00a8\7v\2\2\u00a8"+
		"\u00a9\7t\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7p\2\2\u00ab\u00ac\7i\2\2"+
		"\u00ac\n\3\2\2\2\u00ad\u00ae\7d\2\2\u00ae\u00af\7q\2\2\u00af\u00b0\7q"+
		"\2\2\u00b0\u00b1\7n\2\2\u00b1\f\3\2\2\2\u00b2\u00b3\7f\2\2\u00b3\u00b4"+
		"\7q\2\2\u00b4\16\3\2\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8"+
		"\7u\2\2\u00b8\u00b9\7g\2\2\u00b9\20\3\2\2\2\u00ba\u00bb\7h\2\2\u00bb\u00bc"+
		"\7q\2\2\u00bc\u00bd\7t\2\2\u00bd\22\3\2\2\2\u00be\u00bf\7k\2\2\u00bf\u00c0"+
		"\7h\2\2\u00c0\24\3\2\2\2\u00c1\u00c2\7g\2\2\u00c2\u00c3\7n\2\2\u00c3\u00c4"+
		"\7u\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7\"\2\2\u00c6\u00c7\7k\2\2\u00c7"+
		"\u00c8\7h\2\2\u00c8\26\3\2\2\2\u00c9\u00ca\7v\2\2\u00ca\u00cb\7j\2\2\u00cb"+
		"\u00cc\7g\2\2\u00cc\u00cd\7p\2\2\u00cd\30\3\2\2\2\u00ce\u00cf\7t\2\2\u00cf"+
		"\u00d0\7g\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2\7w\2\2\u00d2\u00d3\7t\2\2"+
		"\u00d3\u00d4\7p\2\2\u00d4\32\3\2\2\2\u00d5\u00d6\7x\2\2\u00d6\u00d7\7"+
		"q\2\2\u00d7\u00d8\7k\2\2\u00d8\u00d9\7f\2\2\u00d9\34\3\2\2\2\u00da\u00db"+
		"\7y\2\2\u00db\u00dc\7j\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de\7n\2\2\u00de"+
		"\u00df\7g\2\2\u00df\36\3\2\2\2\u00e0\u00e1\7e\2\2\u00e1\u00e2\7t\2\2\u00e2"+
		"\u00e3\7g\2\2\u00e3\u00e4\7c\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6\7g\2\2"+
		"\u00e6 \3\2\2\2\u00e7\u00e8\7o\2\2\u00e8\u00e9\7c\2\2\u00e9\u00ea\7k\2"+
		"\2\u00ea\u00eb\7p\2\2\u00eb\"\3\2\2\2\u00ec\u00ed\7h\2\2\u00ed\u00ee\7"+
		"w\2\2\u00ee\u00ef\7p\2\2\u00ef\u00f0\7e\2\2\u00f0$\3\2\2\2\u00f1\u00f2"+
		"\7u\2\2\u00f2\u00f3\7e\2\2\u00f3\u00f4\7c\2\2\u00f4\u00f5\7p\2\2\u00f5"+
		"&\3\2\2\2\u00f6\u00f7\7r\2\2\u00f7\u00f8\7t\2\2\u00f8\u00f9\7k\2\2\u00f9"+
		"\u00fa\7p\2\2\u00fa\u00fb\7v\2\2\u00fb(\3\2\2\2\u00fc\u00fd\7*\2\2\u00fd"+
		"*\3\2\2\2\u00fe\u00ff\7+\2\2\u00ff,\3\2\2\2\u0100\u0101\7]\2\2\u0101."+
		"\3\2\2\2\u0102\u0103\7_\2\2\u0103\60\3\2\2\2\u0104\u0105\7}\2\2\u0105"+
		"\62\3\2\2\2\u0106\u0107\7\177\2\2\u0107\64\3\2\2\2\u0108\u0109\7>\2\2"+
		"\u0109\66\3\2\2\2\u010a\u010b\7>\2\2\u010b\u010c\7?\2\2\u010c8\3\2\2\2"+
		"\u010d\u010e\7@\2\2\u010e:\3\2\2\2\u010f\u0110\7@\2\2\u0110\u0111\7?\2"+
		"\2\u0111<\3\2\2\2\u0112\u0113\7-\2\2\u0113>\3\2\2\2\u0114\u0115\7/\2\2"+
		"\u0115@\3\2\2\2\u0116\u0117\7,\2\2\u0117B\3\2\2\2\u0118\u0119\7\61\2\2"+
		"\u0119D\3\2\2\2\u011a\u011b\7\'\2\2\u011bF\3\2\2\2\u011c\u011d\7(\2\2"+
		"\u011d\u011e\7(\2\2\u011eH\3\2\2\2\u011f\u0120\7~\2\2\u0120\u0121\7~\2"+
		"\2\u0121J\3\2\2\2\u0122\u0123\7#\2\2\u0123L\3\2\2\2\u0124\u0125\7<\2\2"+
		"\u0125N\3\2\2\2\u0126\u0127\7=\2\2\u0127P\3\2\2\2\u0128\u0129\7.\2\2\u0129"+
		"R\3\2\2\2\u012a\u012b\7?\2\2\u012bT\3\2\2\2\u012c\u012d\7?\2\2\u012d\u012e"+
		"\7?\2\2\u012eV\3\2\2\2\u012f\u0130\7#\2\2\u0130\u0131\7?\2\2\u0131X\3"+
		"\2\2\2\u0132\u0133\7\60\2\2\u0133Z\3\2\2\2\u0134\u0135\7\60\2\2\u0135"+
		"\u0136\7\60\2\2\u0136\u0137\7\60\2\2\u0137\\\3\2\2\2\u0138\u0139\7w\2"+
		"\2\u0139\u013a\7r\2\2\u013a^\3\2\2\2\u013b\u013c\7f\2\2\u013c\u013d\7"+
		"q\2\2\u013d\u013e\7y\2\2\u013e\u013f\7p\2\2\u013f`\3\2\2\2\u0140\u0141"+
		"\7v\2\2\u0141\u0142\7q\2\2\u0142b\3\2\2\2\u0143\u0144\7V\2\2\u0144d\3"+
		"\2\2\2\u0145\u0146\7H\2\2\u0146f\3\2\2\2\u0147\u0148\7d\2\2\u0148\u0149"+
		"\7t\2\2\u0149\u014a\7g\2\2\u014a\u014b\7c\2\2\u014b\u014c\7m\2\2\u014c"+
		"h\3\2\2\2\u014d\u014e\7$\2\2\u014ej\3\2\2\2\u014f\u0150\t\2\2\2\u0150"+
		"l\3\2\2\2\u0151\u0152\t\3\2\2\u0152n\3\2\2\2\u0153\u0155\5m\67\2\u0154"+
		"\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2"+
		"\2\2\u0157p\3\2\2\2\u0158\u0159\7h\2\2\u0159r\3\2\2\2\u015a\u015c\5o8"+
		"\2\u015b\u015a\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e"+
		"\7\60\2\2\u015e\u0163\5o8\2\u015f\u0160\5o8\2\u0160\u0161\7\60\2\2\u0161"+
		"\u0163\3\2\2\2\u0162\u015b\3\2\2\2\u0162\u015f\3\2\2\2\u0163t\3\2\2\2"+
		"\u0164\u0165\5s:\2\u0165\u0166\5q9\2\u0166v\3\2\2\2\u0167\u0168\5y=\2"+
		"\u0168x\3\2\2\2\u0169\u016a\7^\2\2\u016a\u016b\t\4\2\2\u016bz\3\2\2\2"+
		"\u016c\u0174\n\5\2\2\u016d\u0174\5w<\2\u016e\u016f\7^\2\2\u016f\u0174"+
		"\7\f\2\2\u0170\u0171\7^\2\2\u0171\u0172\7\17\2\2\u0172\u0174\7\f\2\2\u0173"+
		"\u016c\3\2\2\2\u0173\u016d\3\2\2\2\u0173\u016e\3\2\2\2\u0173\u0170\3\2"+
		"\2\2\u0174|\3\2\2\2\u0175\u0177\5{>\2\u0176\u0175\3\2\2\2\u0177\u0178"+
		"\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179~\3\2\2\2\u017a"+
		"\u017c\5i\65\2\u017b\u017d\5}?\2\u017c\u017b\3\2\2\2\u017c\u017d\3\2\2"+
		"\2\u017d\u017e\3\2\2\2\u017e\u017f\5i\65\2\u017f\u0080\3\2\2\2\u0180\u0181"+
		"\5o8\2\u0181\u0082\3\2\2\2\u0182\u0183\5u;\2\u0183\u0084\3\2\2\2\u0184"+
		"\u0187\5c\62\2\u0185\u0187\5e\63\2\u0186\u0184\3\2\2\2\u0186\u0185\3\2"+
		"\2\2\u0187\u0086\3\2\2\2\u0188\u0189\5\177@\2\u0189\u0088\3\2\2\2\u018a"+
		"\u018f\5k\66\2\u018b\u018e\5m\67\2\u018c\u018e\5k\66\2\u018d\u018b\3\2"+
		"\2\2\u018d\u018c\3\2\2\2\u018e\u0191\3\2\2\2\u018f\u018d\3\2\2\2\u018f"+
		"\u0190\3\2\2\2\u0190\u008a\3\2\2\2\u0191\u018f\3\2\2\2\u0192\u0194\t\6"+
		"\2\2\u0193\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0193\3\2\2\2\u0195"+
		"\u0196\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0198\bF\2\2\u0198\u008c\3\2"+
		"\2\2\u0199\u019b\7\17\2\2\u019a\u019c\7\f\2\2\u019b\u019a\3\2\2\2\u019b"+
		"\u019c\3\2\2\2\u019c\u019f\3\2\2\2\u019d\u019f\7\f\2\2\u019e\u0199\3\2"+
		"\2\2\u019e\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a1\bG\2\2\u01a1"+
		"\u008e\3\2\2\2\u01a2\u01a3\7\61\2\2\u01a3\u01a4\7,\2\2\u01a4\u01a8\3\2"+
		"\2\2\u01a5\u01a7\13\2\2\2\u01a6\u01a5\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8"+
		"\u01a9\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a9\u01ab\3\2\2\2\u01aa\u01a8\3\2"+
		"\2\2\u01ab\u01ac\7,\2\2\u01ac\u01ad\7\61\2\2\u01ad\u01ae\3\2\2\2\u01ae"+
		"\u01af\bH\2\2\u01af\u0090\3\2\2\2\u01b0\u01b1\7\61\2\2\u01b1\u01b2\7\61"+
		"\2\2\u01b2\u01b6\3\2\2\2\u01b3\u01b5\n\7\2\2\u01b4\u01b3\3\2\2\2\u01b5"+
		"\u01b8\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b9\3\2"+
		"\2\2\u01b8\u01b6\3\2\2\2\u01b9\u01ba\bI\2\2\u01ba\u0092\3\2\2\2\21\2\u0156"+
		"\u015b\u0162\u0173\u0178\u017c\u0186\u018d\u018f\u0195\u019b\u019e\u01a8"+
		"\u01b6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}