package ru.deucalion.test.implemented.system;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ru.deucalion.labwork.App;

public class MathExpressionTest {
	@Test
	public void validExpression()
	{
		String out = App.parse("3+(1*3)");
		assertTrue(out.startsWith("Valid"));
	}
	@Test
	public void invalidExpression()
	{
		String out = App.parse("3+(1*3)+");
		assertTrue(out.startsWith("Invalid"));
	}
}
