package ru.deucalion.test.whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import ru.deucalion.labwork.parser.DigitOrInBracket;
import ru.deucalion.labwork.parser.ParserContext;

public class DigitOrInBracketTest {

	@Test
	public void inBracketAllOk()
	{
		ParserContext ctx = new ParserContext("(35)");
		DigitOrInBracket exp = new DigitOrInBracket();
		
		try {
			exp.parse(ctx);
			assertTrue(ctx.atLastChar());
		}
		catch (IOException e) {
			fail("Exception has thrown : " + e.getMessage());
		}
	}
	@Test 
	public void inBracketNotEnoughCloseAtEnd()
	{
		ParserContext ctx = new ParserContext("(35");
		DigitOrInBracket exp = new DigitOrInBracket();
		
		try {
			exp.parse(ctx);
			fail("Expected IOException");
		}
		catch (IOException e) {
			assertEquals(e.getMessage(), "Expected ')' after 2 but got EOW");
		}
	}
	@Test 
	public void inBracketNotEnoughCloseAtCenter()
	{
		ParserContext ctx = new ParserContext("(35.");
		DigitOrInBracket exp = new DigitOrInBracket();
		
		try {
			exp.parse(ctx);
			fail("Expected IOException");
		}
		catch (IOException e) {
			assertEquals(e.getMessage(), "Expected ')' at 3 but got '.'");
		}
	}
	
	@Test
	public void negativeExpression()
	{
		ParserContext ctx = new ParserContext("-35");
		DigitOrInBracket exp = new DigitOrInBracket();
		
		try {
			exp.parse(ctx);
			assertTrue(ctx.atLastChar());
		}
		catch (IOException e) {
			fail("Exception has thrown : " + e.getMessage());
		}
	}
	
	@Test
	public void digit()
	{
		ParserContext ctx = new ParserContext("35");
		DigitOrInBracket exp = new DigitOrInBracket();
		
		try {
			exp.parse(ctx);
			assertTrue(ctx.atLastChar());
		}
		catch (IOException e) {
			fail("Exception has thrown : " + e.getMessage());
		}
	}
}
