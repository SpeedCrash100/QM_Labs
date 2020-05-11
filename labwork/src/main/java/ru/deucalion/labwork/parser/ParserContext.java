package ru.deucalion.labwork.parser;

import java.io.IOException;

public class ParserContext {
	String inputString;
	int currentPos;
	
	public ParserContext(String str) {
		inputString = str;
		currentPos = -1;
	}
	
	public char read() throws IOException {
		if(!canRead())
			throw new IOException("Cannot read further!");
		
		currentPos++;
		return inputString.charAt(currentPos);
	}
	
	public char peek() throws IOException
	{
		if(!canRead())
			throw new IOException("Cannot read further!");
		
		return inputString.charAt(currentPos + 1);
	}
	
	public int getCurrentPosition()
	{
		return currentPos;
	}
	
	public boolean atLastChar()
	{
		return currentPos == inputString.length() - 1;
	}
	
	private boolean canRead()
	{
		//Check if we can move to next
		return !atLastChar();
	}
	
	public void setCalculationContext(CalcContext ctx)
	{
		//TODO! Create field for CalcContext and assign ctx
		return;
	}
	
	public CalcContext getCalculationContext()
	{
		//TODO! Create field for CalcContext
		return null;
	}
}
