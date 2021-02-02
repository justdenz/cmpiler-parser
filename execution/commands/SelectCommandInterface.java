package execution.commands;

public interface SelectCommandInterface extends CommandInterface{
  public abstract void addIfCommand(CommandInterface command);
  public abstract void addElseCommand(CommandInterface command);
}
