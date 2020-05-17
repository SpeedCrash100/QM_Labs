package ru.deucalion.test.unimplemented.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ru.deucalion.labwork.parser.CalcContext;
import ru.deucalion.labwork.parser.OperatorDescription;

public class CalcContextTest {
	
	CalcContext ctx;
	
	class PlusOpDesc extends OperatorDescription
	{
		@Override
		public char getSymbolic() {
			return '+';
		}
		
		@Override
		public int getPriority() {
			return 2;
		}

		@Override
		public float execute(float left, float right) {
			return left + right;
		}
		
	}
	
	class MulOpDesc extends OperatorDescription
	{
		@Override
		public char getSymbolic() {
			return '*';
		}
		
		@Override
		public int getPriority() {
			return 1;
		}

		@Override
		public float execute(float left, float right) {
			return left * right;
		}
		
	}
	
	@Before
	public void setup()
	{
		ctx = new CalcContext();
	}
	
	@Test
	public void simpleDigit()
	{
		ctx.addOperand(2);
		
		assertTrue(ctx.isResultReady());
		float res = ctx.getResult();
		
		assertEquals(2, res, 0.0001);
	}
	
	@Test
	public void operatorExecute()
	{
		ctx.addOperand(2);
		ctx.addOperator(new PlusOpDesc());
		ctx.addOperand(3);
		
		assertTrue(ctx.isResultReady());
		float res = ctx.getResult();
		
		assertEquals(5, res, 0.0001);
	}
	
	@Test
	public void operatorPriorityExecute()
	{
		ctx.addOperand(2);
		ctx.addOperator(new PlusOpDesc());
		ctx.addOperand(3);
		ctx.addOperator(new MulOpDesc());
		ctx.addOperand(2);
		
		assertTrue(ctx.isResultReady());
		float res = ctx.getResult();
		
		assertEquals(8, res, 0.0001);
	}
	

}
