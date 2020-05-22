package ru.deucalion.test.unimplemented.system;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import ru.deucalion.labwork.parser.MathExpression;
import ru.deucalion.labwork.parser.ParserContext;

public class TrigFunctionsTest {
	
	MathExpression expr;
	
	@Before
	public void setup()
	{
		expr = new MathExpression();
	}
	
	@Test
	public void sin()
	{
		ParserContext ctx = new ParserContext("sin(1)");
		
		try {
			expr.parse(ctx);
			assertTrue(ctx.atLastChar());
		} catch (IOException e) {
			fail("Expected read function without errors");
			e.printStackTrace();
		}
	}
	
	@Test
	public void cos()
	{
		ParserContext ctx = new ParserContext("cos(1)");
		
		try {
			expr.parse(ctx);
			assertTrue(ctx.atLastChar());
		} catch (IOException e) {
			fail("Expected read function without errors");
			e.printStackTrace();
		}
	}
	
	@Test
	public void tg()
	{
		ParserContext ctx = new ParserContext("tg(1)");
		
		try {
			expr.parse(ctx);
			assertTrue(ctx.atLastChar());
		} catch (IOException e) {
			fail("Expected read function without errors");
			e.printStackTrace();
		}
	}
	
	@Test
	public void ctg()
	{
		ParserContext ctx = new ParserContext("ctg(1)");
		
		try {
			expr.parse(ctx);
			assertTrue(ctx.atLastChar());
		} catch (IOException e) {
			fail("Expected read function without errors");
			e.printStackTrace();
		}
	}
	
	@Test
	public void function_noClose()
	{
		ParserContext ctx = new ParserContext("ctg(1");
		
		try {
			expr.parse(ctx);
			fail("Expected Exception here");
		} catch (IOException e) {
		}
	}

}
