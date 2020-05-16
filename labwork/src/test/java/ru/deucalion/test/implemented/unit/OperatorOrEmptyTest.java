package ru.deucalion.test.implemented.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import ru.deucalion.labwork.parser.OperatorOrEmpty;
import ru.deucalion.labwork.parser.ParserContext;

public class OperatorOrEmptyTest {

	@Test
	public void noOperatorAtEnd()
	{
		ParserContext ctx = new ParserContext("5");
		
		try {
			ctx.read();
		} catch (IOException e) {
			fail("ParserContex::read() works invalid");
		}
		
		OperatorOrEmpty exp = new OperatorOrEmpty();
		
		try {
			exp.parse(ctx);
			assertTrue(ctx.atLastChar());
		} catch (IOException e) {
			fail("Exception has thrown : " + e.getMessage());
		}
	}
	
	@Test
	public void noOperatorAtCenter()
	{
		ParserContext ctx = new ParserContext("5");
		OperatorOrEmpty exp = new OperatorOrEmpty();
		
		try {
			int oldPos = ctx.getCurrentPosition();
			exp.parse(ctx);
			assertEquals(oldPos, ctx.getCurrentPosition());
		} catch (IOException e) {
			fail("Exception has thrown : " + e.getMessage());
		}
	}
	
	@Test
	public void operatorPlus()
	{
		ParserContext ctx = new ParserContext("+1");
		OperatorOrEmpty exp = new OperatorOrEmpty();
		
		try {
			int oldPos = ctx.getCurrentPosition();
			exp.parse(ctx);
			assertEquals(oldPos + 2, ctx.getCurrentPosition());
		} catch (IOException e) {
			fail("Exception has thrown : " + e.getMessage());
		}
	}
	
	@Test
	public void operatorMinus()
	{
		ParserContext ctx = new ParserContext("-1");
		OperatorOrEmpty exp = new OperatorOrEmpty();
		
		try {
			int oldPos = ctx.getCurrentPosition();
			exp.parse(ctx);
			assertEquals(oldPos + 2, ctx.getCurrentPosition());
		} catch (IOException e) {
			fail("Exception has thrown : " + e.getMessage());
		}
	}
	
	@Test
	public void operatorMul()
	{
		ParserContext ctx = new ParserContext("*1");
		OperatorOrEmpty exp = new OperatorOrEmpty();
		
		try {
			int oldPos = ctx.getCurrentPosition();
			exp.parse(ctx);
			assertEquals(oldPos + 2, ctx.getCurrentPosition());
		} catch (IOException e) {
			fail("Exception has thrown : " + e.getMessage());
		}
	}
	
	@Test
	public void operatorDiv()
	{
		ParserContext ctx = new ParserContext("/1");
		OperatorOrEmpty exp = new OperatorOrEmpty();
		
		try {
			int oldPos = ctx.getCurrentPosition();
			exp.parse(ctx);
			assertEquals(oldPos + 2, ctx.getCurrentPosition());
		} catch (IOException e) {
			fail("Exception has thrown : " + e.getMessage());
		}
	}
}
