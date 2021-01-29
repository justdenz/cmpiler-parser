package model;


import semantics.analyzers.ProgramAnalyzer;

public class ProgramCustomListener extends CUSTOMBaseListener{
    @Override
    public void enterProgram(CUSTOMParser.ProgramContext ctx){
        ProgramAnalyzer analyzer = new ProgramAnalyzer();
        analyzer.analyze(ctx);
    }
}
