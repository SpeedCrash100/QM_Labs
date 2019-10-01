package ru.deucalion.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathExpTest {

	@Test
	public void manyBrackets() {
		String testExp = "(((((123)))))";
		String result = ru.deucalion.labwork.App.parse(testExp);
		assertTrue(result.startsWith("Valid"));
	}
	
	@Test
	public void notEnoughOperand()
	{
		String testExp = "324+";
		String result = ru.deucalion.labwork.App.parse(testExp);
		assertTrue(result.startsWith("Invalid"));
		
		testExp = "+145";
		result = ru.deucalion.labwork.App.parse(testExp);
		assertTrue(result.startsWith("Invalid"));
	}
	
	@Test
	public void negativeValue()
	{
		String testExp = "-----145";
		String result = ru.deucalion.labwork.App.parse(testExp);
		assertTrue(result.startsWith("Valid"));
	}
	
	@Test
	public void notEnoughBracket()
	{
		String testExp = "(-145";
		String result = ru.deucalion.labwork.App.parse(testExp);
		assertTrue(result.startsWith("Invalid"));
	}

}
