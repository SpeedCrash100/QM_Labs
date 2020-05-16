package ru.deucalion.test.unimplemented.system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import ru.deucalion.labwork.parser.CalcContext;
import ru.deucalion.labwork.parser.MathExpression;
import ru.deucalion.labwork.parser.ParserContext;

public class EvaluateTest {
	
	MathExpression expr;
	
	@Before
	public void setup()
	{
		expr = new MathExpression();
	}
	
	@Test
	public void simpleDigit()
	{
		ParserContext ctx = new ParserContext("123");
		
		try {
			expr.parse(ctx);
		} catch (IOException e) {
			fail("Digit failed to read");
			e.printStackTrace();
			return;
		}
		
		CalcContext calcctx = ctx.getCalculationContext();
		assertNotNull(calcctx);
		
		assertTrue(calcctx.isResultReady());
		
		float res = calcctx.getResult();
		assertEquals(123, res, 0.0001);
		
	}
	
	@Test
	public void plusOp()
	{
		ParserContext ctx = new ParserContext("1+2");
		
		try {
			expr.parse(ctx);
		} catch (IOException e) {
			fail("Digit failed to read");
			e.printStackTrace();
			return;
		}
		
		CalcContext calcctx = ctx.getCalculationContext();
		assertNotNull(calcctx);
		
		assertTrue(calcctx.isResultReady());
		
		float res = calcctx.getResult();
		assertEquals(3, res, 0.0001);
		
	}
	
	@Test
	public void minusOp()
	{
		ParserContext ctx = new ParserContext("1-2");
		
		try {
			expr.parse(ctx);
		} catch (IOException e) {
			fail("Digit failed to read");
			e.printStackTrace();
			return;
		}
		
		CalcContext calcctx = ctx.getCalculationContext();
		assertNotNull(calcctx);
		
		assertTrue(calcctx.isResultReady());
		
		float res = calcctx.getResult();
		assertEquals(-1, res, 0.0001);
		
	}
	
	@Test
	public void multiplyOp()
	{
		ParserContext ctx = new ParserContext("1*2");
		
		try {
			expr.parse(ctx);
		} catch (IOException e) {
			fail("Digit failed to read");
			e.printStackTrace();
			return;
		}
		
		CalcContext calcctx = ctx.getCalculationContext();
		assertNotNull(calcctx);
		
		assertTrue(calcctx.isResultReady());
		
		float res = calcctx.getResult();
		assertEquals(2, res, 0.0001);
		
	}
	
	@Test
	public void divideOp()
	{
		ParserContext ctx = new ParserContext("1/2");
		
		try {
			expr.parse(ctx);
		} catch (IOException e) {
			fail("Digit failed to read");
			e.printStackTrace();
			return;
		}
		
		CalcContext calcctx = ctx.getCalculationContext();
		assertNotNull(calcctx);
		
		assertTrue(calcctx.isResultReady());
		
		float res = calcctx.getResult();
		assertEquals(0.5, res, 0.0001);
		
	}
	

}
