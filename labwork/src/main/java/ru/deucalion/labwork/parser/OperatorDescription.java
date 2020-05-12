package ru.deucalion.labwork.parser;

public abstract class OperatorDescription {
	public char getSymbolic() {
		return '\0';
	}

	public int getPriority() {
		return 0;
	}
	
	public abstract float execute(float left, float right);
	
}
