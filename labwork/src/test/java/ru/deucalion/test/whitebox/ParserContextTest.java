package ru.deucalion.test.whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import ru.deucalion.labwork.parser.ParserContext;

public class ParserContextTest {

	@Test
	public void readNormal()
	{
		ParserContext ctx = new ParserContext("qfasa");
		try {			
			char c = ctx.read();
			assertEquals(c, 'q');
			assertEquals(0, ctx.getCurrentPosition());
		} catch (IOException e) {
			fail("Exception has thrown : " + e.getMessage());
		}
	}
	
	@Test
	public void readAtEnd()
	{
		ParserContext ctx = new ParserContext("q");
		
		try {
			ctx.read();
		} catch (IOException e1) {
			fail("ParserContext::read works invalid");
		}

		try {			
			ctx.read();
			fail("Expected IOException");
		} catch (IOException e) {
			assertEquals("Cannot read further!", e.getMessage());
		}
	}
	
	@Test
	public void peekNormal()
	{
		ParserContext ctx = new ParserContext("qfasa");
		try {			
			char c = ctx.peek();
			assertEquals(c, 'q');
			assertEquals(-1, ctx.getCurrentPosition());
		} catch (IOException e) {
			fail("Exception has thrown : " + e.getMessage());
		}
	}
	
	@Test
	public void peekAtEnd()
	{
		ParserContext ctx = new ParserContext("q");
		
		try {
			ctx.read();
		} catch (IOException e1) {
			fail("ParserContext::read works invalid");
		}

		try {			
			ctx.peek();
			fail("Expected IOException");
		} catch (IOException e) {
			assertEquals("Cannot read further!", e.getMessage());
		}
	}
}
