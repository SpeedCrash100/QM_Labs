package ru.deucalion.test.blackbox;

import static org.junit.Assert.*;
import ru.deucalion.labwork.App;

import org.junit.Test;

public class MathExpTest {

	@Test
	public void operators()
	{
		String testExp = "1+2-3*4/5";
		String result = App.parse(testExp);
		assertTrue(result.startsWith("Valid"));
	}
	
	@Test
	public void manyBrackets() 
	{
		String testExp = "(((123*(7-(3*4)))))";
		String result = App.parse(testExp);
		assertTrue(result.startsWith("Valid"));
	}
	
	@Test
	public void notEnoughOperandAfter()
	{
		String testExp = "324+";
		String result = App.parse(testExp);
		assertTrue(result.startsWith("Invalid"));
	}
	
	@Test
	public void notEnoughOperandBefore()
	{
		String testExp = "*145";
		String result = App.parse(testExp);
		assertTrue(result.startsWith("Invalid"));
	}
	
	@Test
	public void negativeValue()
	{
		String testExp = "-----145";
		String result = App.parse(testExp);
		assertTrue(result.startsWith("Valid"));
	}
	
	@Test
	public void notEnoughBracket()
	{
		String testExp = "(-145";
		String result = App.parse(testExp);
		assertTrue(result.startsWith("Invalid"));
	}

}
