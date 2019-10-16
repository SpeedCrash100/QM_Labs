package ru.deucalion.test.whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import ru.deucalion.labwork.parser.Digit;
import ru.deucalion.labwork.parser.ParserContext;

public class DigitTest {

	@Test
	public void noDigitsInCenter()
	{
		ParserContext ctx = new ParserContext("()");
		
		try {
			ctx.read(); //Move to 0
		} catch (IOException e1) {
			fail("ParserContex::read() works invalid");
		} 
		
		Digit digit = new Digit();
		
		try {
			digit.parse(ctx);
			fail("Expected IOException");
		} catch (IOException e) {
			assertEquals(e.getMessage(), "Expected digit after 0");
		}
	}
	
	@Test
	public void noDigitsInEnd()
	{
		ParserContext ctx = new ParserContext("+");
		
		try {
			ctx.read(); //Move to 0
		} catch (IOException e1) {
			fail("ParserContex::read() works invalid");
		} 
		
		Digit digit = new Digit();
		
		try {
			digit.parse(ctx);
			fail("Expected IOException");
		} catch (IOException e) {
			assertEquals(e.getMessage(), "Expected digit after 0");
		}
	}
	
	@Test
	public void digitInCenter()
	{
		ParserContext ctx = new ParserContext("9)");
		Digit digit = new Digit();
		
		try {
			digit.parse(ctx);
			assertEquals(0, ctx.getCurrentPosition());
		} catch (IOException e) {
			fail("Exception has thrown : " + e.getMessage());
		}
	}
	
	@Test
	public void digitInEnd()
	{
		ParserContext ctx = new ParserContext("9");
		Digit digit = new Digit();
		
		try {
			digit.parse(ctx);
			assertTrue(ctx.atLastChar());
		} catch (IOException e) {
			fail("Exception has thrown : " + e.getMessage());
		}
	}
	
	
}
