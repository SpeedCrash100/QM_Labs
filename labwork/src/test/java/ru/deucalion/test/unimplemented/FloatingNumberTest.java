package ru.deucalion.test.unimplemented;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import ru.deucalion.labwork.parser.FloatingNumber;
import ru.deucalion.labwork.parser.ParserContext;

public class FloatingNumberTest {
	
	@Test
	public void withoutPoint()
	{
		ParserContext ctx = new ParserContext("567");
		FloatingNumber nmb = new FloatingNumber();
		
		try
		{
			nmb.parse(ctx);
			assertTrue(ctx.atLastChar());
		} catch (IOException e) {
			fail("Exceprion has thrown: " + e.getMessage());
		}
	}
	
	@Test
	public void withPoint()
	{
		ParserContext ctx = new ParserContext("567.758");
		FloatingNumber nmb = new FloatingNumber();
		
		try
		{
			nmb.parse(ctx);
			assertTrue(ctx.atLastChar());
		} catch (IOException e) {
			fail("Exceprion has thrown: " + e.getMessage());
		}
	}
	
	@Test
	public void withComma()
	{
		ParserContext ctx = new ParserContext("567,758");
		FloatingNumber nmb = new FloatingNumber();
		
		try
		{
			nmb.parse(ctx);
			assertTrue(ctx.atLastChar());
		} catch (IOException e) {
			fail("Exceprion has thrown: " + e.getMessage());
		}
	}
	
	@Test
	public void negative()
	{
		ParserContext ctx = new ParserContext("-567,758");
		FloatingNumber nmb = new FloatingNumber();
		
		try
		{
			nmb.parse(ctx);
			assertTrue(ctx.atLastChar());
		} catch (IOException e) {
			fail("Exceprion has thrown: " + e.getMessage());
		}
	}
	
	@Test
	public void notADigit()
	{
		ParserContext ctx = new ParserContext("n2");
		FloatingNumber nmb = new FloatingNumber();
		
		try
		{
			nmb.parse(ctx);
			fail("Expected IOException");
		} catch (IOException e) {
			assertEquals("Expected floating number after 0", e.getMessage());
		}
	}

}
