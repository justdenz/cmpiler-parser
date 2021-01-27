package builder;

import console.Console;

import java.util.BitSet;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class CstmBuildChecker implements ANTLRErrorListener{
	
	private static CstmBuildChecker sharedInstance = null;
	
	private boolean successful = true;
	
	public static CstmBuildChecker getInstance() {
		return sharedInstance;
	}
	
	private CstmBuildChecker() {
		
	}
	
	public static void initialize() {
		sharedInstance = new CstmBuildChecker();
		CstmErrorRepo.initialize();
	}
	
	public static void reset() {
		sharedInstance.successful  = true;
		CstmErrorRepo.reset();
	}
	
	public boolean canExecute() {
		return this.successful;
	}

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer,
			Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		Console.log("Syntax error at line " +line+ ". " +msg);
		
		this.successful = false;
	}

	@Override
	public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex,
			int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportAttemptingFullContext(Parser recognizer, DFA dfa,
			int startIndex, int stopIndex, BitSet conflictingAlts,
			ATNConfigSet configs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportContextSensitivity(Parser recognizer, DFA dfa,
			int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
		// TODO Auto-generated method stub
		
	}
	
	public static void reportCustomError(int errorCode, String additionalMessage) {
		String errorMessage = CstmErrorRepo.getErrorMessage(errorCode) + " " + additionalMessage;
		Console.log(errorMessage);
		
		sharedInstance.successful = false;
	}
	
	public static void reportCustomError(int errorCode, String additionalMessage, Object... parameters) {
		String errorMessage = String.format(CstmErrorRepo.getErrorMessage(errorCode) + " " + additionalMessage, parameters);
		Console.log(errorMessage);
		
		sharedInstance.successful = false;
	}
}
