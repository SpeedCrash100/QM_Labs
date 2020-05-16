package ru.deucalion.test.unimplemented.system;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import ru.deucalion.labwork.parser.MathExpression;
import ru.deucalion.labwork.parser.ParserContext;

public class FloatingNumberParsingTest {
	
	MathExpression expr;
	
	@Before
	public void setup()
	{
		expr = new MathExpression();
	}
	
	@Test
	public void readsPositiveFloat()
	{
		ParserContext ctx = new ParserContext("123.456");
		
		try {
			expr.parse(ctx);
		} catch (IOException e) {
			fail("Parser must reads float number without exception");
			e.printStackTrace();
		}
	}
	
	@Test
	public void readsNegativeFloat()
	{
		ParserContext ctx = new ParserContext("-123.456");
		
		try {
			expr.parse(ctx);
		} catch (IOException e) {
			fail("Parser must reads float number without exception");
			e.printStackTrace();
		}
	}
	
	@Test
	public void NotReadsDelimitedFloat()
	{
		ParserContext ctx = new ParserContext("123. 456");
		
		try {
			expr.parse(ctx);
			fail("Expected failed parsing here");
		} catch (IOException e) {
			
		}
	}

}
