package ru.deucalion.labwork.parser;

import java.util.List;

public abstract class FunctionDescription {
	
	public String getName() {
		return "";
	}
	
	public abstract float execute(List<Float> arguments);
	
}
