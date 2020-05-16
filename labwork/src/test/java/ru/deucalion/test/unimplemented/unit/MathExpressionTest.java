package ru.deucalion.test.unimplemented.unit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ru.deucalion.labwork.App;

public class MathExpressionTest {
	
	@Test
	public void noOpenningBracket()
	{
		String testExp = "5+3)";
		String result = App.parse(testExp);
		assertTrue(result.startsWith("Invalid"));
	}
	
	@Test
	public void invalidSymbol()
	{
		String testExp = "5+3x-4";
		String result = App.parse(testExp);
		assertTrue(result.startsWith("Invalid"));
	}

}
