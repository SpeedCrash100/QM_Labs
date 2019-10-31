package ru.deucalion.labwork;

public class MathExpCommand {

	private String argument;
	private String result;
	
	public MathExpCommand() {
		argument = "";
		result = "";
	}
	
	public MathExpCommand(String arg) {
		argument = arg;
		result = "";
	}
	
	public void execute()
	{
		result = ru.deucalion.labwork.App.parse(argument);
	}

	public String getResult() {
		return result;
	}

	public String getArgument() {
		return argument;
	}

	public void setArgument(String argument) {
		this.argument = argument;
	}
	
	
	
}
