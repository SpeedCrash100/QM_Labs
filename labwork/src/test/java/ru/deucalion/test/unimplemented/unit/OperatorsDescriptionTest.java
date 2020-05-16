package ru.deucalion.test.unimplemented.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.deucalion.labwork.parser.OperatorDescription;
import ru.deucalion.labwork.parser.operators.DivideOperatorDescription;
import ru.deucalion.labwork.parser.operators.MinusOperatorDescription;
import ru.deucalion.labwork.parser.operators.MultiplyOperatorDescription;
import ru.deucalion.labwork.parser.operators.PlusOperatorDescription;

public class OperatorsDescriptionTest {
	
	@Test
	public void plus()
	{
		OperatorDescription desc = new PlusOperatorDescription();
		assertEquals('+', desc.getSymbolic());
		assertEquals(2, desc.getPriority());
		
		float answer = desc.execute(3, 5);
		assertEquals(8, answer, 0.0001);
	}
	
	@Test
	public void minus()
	{
		OperatorDescription desc = new MinusOperatorDescription();
		assertEquals('-', desc.getSymbolic());
		assertEquals(2, desc.getPriority());
		
		float answer = desc.execute(3, 5);
		assertEquals(-2, answer, 0.0001);
	}
	
	@Test
	public void multiply()
	{
		OperatorDescription desc = new MultiplyOperatorDescription();
		assertEquals('*', desc.getSymbolic());
		assertEquals(1, desc.getPriority());
		
		float answer = desc.execute(3, 5);
		assertEquals(15, answer, 0.0001);
	}
	
	@Test
	public void divide()
	{
		OperatorDescription desc = new DivideOperatorDescription();
		assertEquals('/', desc.getSymbolic());
		assertEquals(1, desc.getPriority());
		
		float answer = desc.execute(3, 5);
		assertEquals(0.6, answer, 0.0001);
	}

}
