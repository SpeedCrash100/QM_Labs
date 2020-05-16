package ru.deucalion.test.implemented.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import ru.deucalion.labwork.parser.ParserContext;
import ru.deucalion.labwork.parser.ZnakOrEmpty;

public class ZnakOrEmptyTest {
	
	@Test
	public void noZnak()
	{
		ParserContext ctx = new ParserContext("5");
		ZnakOrEmpty exp = new ZnakOrEmpty();
		
		try {
			int oldPos = ctx.getCurrentPosition();
			exp.parse(ctx);
			assertEquals(oldPos, ctx.getCurrentPosition());
		} catch (IOException e) {
			fail("Exception has thrown : " + e.getMessage());
		}
	}
	
	@Test
	public void znakPlus()
	{
		ParserContext ctx = new ParserContext("+5");
		ZnakOrEmpty exp = new ZnakOrEmpty();
		
		try {
			int oldPos = ctx.getCurrentPosition();
			exp.parse(ctx);
			assertEquals(oldPos+1, ctx.getCurrentPosition());
		} catch (IOException e) {
			fail("Exception has thrown : " + e.getMessage());
		}
	}
	
	@Test
	public void znakMinus()
	{
		ParserContext ctx = new ParserContext("-5");
		ZnakOrEmpty exp = new ZnakOrEmpty();
		
		try {
			int oldPos = ctx.getCurrentPosition();
			exp.parse(ctx);
			assertEquals(oldPos+1, ctx.getCurrentPosition());
		} catch (IOException e) {
			fail("Exception has thrown : " + e.getMessage());
		}
	}
}
