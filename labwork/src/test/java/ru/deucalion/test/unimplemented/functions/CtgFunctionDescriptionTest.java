package ru.deucalion.test.unimplemented.functions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import ru.deucalion.labwork.parser.FunctionDescription;
import ru.deucalion.labwork.parser.functions.CtgFunctionDescription;

public class CtgFunctionDescriptionTest {
	FunctionDescription desc;
	
	@Before
	public void setup()
	{
		desc = new CtgFunctionDescription();
	}
	
	@Test
	public void calculation()
	{
		assertEquals("ctg", desc.getName());
		
		LinkedList<Float> args = new LinkedList<Float>();
		args.add(1.0f);
		
		try {
			float answer = desc.execute(args);
			assertEquals(0.6420926, answer, 0.00001);
		} catch (Exception ex)
		{
			fail("Exception has thrown: " + ex.getMessage());
		}
	}
	
	@Test
	public void notEnoughArgs()
	{	
		LinkedList<Float> args = new LinkedList<Float>();
		
		try {
			desc.execute(args);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException ex)
		{
			assertEquals("Not enough arguments", ex.getMessage());
		}
		catch(Exception ex)
		{
			fail("Invalid exception has thrown: " + ex.getMessage());
		}

	}
	
	@Test
	public void tooManyArgs()
	{
		LinkedList<Float> args = new LinkedList<Float>();
		args.add(5.0f);
		args.add(1.0f);
		
		try {
			desc.execute(args);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException ex)
		{
			assertEquals("Too many arguments", ex.getMessage());
		}
		catch(Exception ex)
		{
			fail("Invalid exception has thrown: " + ex.getMessage());
		}

	}
}
