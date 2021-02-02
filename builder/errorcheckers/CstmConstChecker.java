package builder.errorcheckers;

import org.antlr.v4.runtime.tree.TerminalNode;

import console.Console;
import semantics.representations.CstmValue;

import semantics.symboltable.GlobalScopeManager;

public class CstmConstChecker implements CstmErrCheckerInterface {
	
	private TerminalNode termCtx;
	private int lineNumber;
	
	public CstmConstChecker(TerminalNode termCtx) {
		this.termCtx = termCtx;
		this.lineNumber = this.termCtx.getSymbol().getLine();
	}
	
	@Override
	public void verify() {
		CstmValue cstmValue = GlobalScopeManager.getInstance().searchScopedVariable(termCtx.getText());

		if(cstmValue != null && cstmValue.isConstant()){
			Console.log(String.valueOf(this.lineNumber), "Found a reassignment for a constant variable.");
		}
	}
}
