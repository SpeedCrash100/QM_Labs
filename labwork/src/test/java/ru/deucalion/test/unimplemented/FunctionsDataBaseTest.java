package ru.deucalion.test.unimplemented;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ru.deucalion.labwork.parser.FunctionDescription;
import ru.deucalion.labwork.parser.FunctionsDataBase;

public class FunctionsDataBaseTest {
	
	FunctionsDataBase db;
	
	class TestFunctionDesc extends FunctionDescription
	{
		@Override
		public String getName() {
			return "test";
		}

		@Override
		public float execute(List<Float> arguments) throws IllegalArgumentException {
			return 0;
		}
		
	}
	
	@Before
	public void setup()
	{
		db = new FunctionsDataBase();
	}
	
	@Test
	public void register()
	{
		assertNotEquals(null, db.getFunctionNames());
		assertEquals(0, db.getFunctionNames().length);
		
		db.register(new TestFunctionDesc());
		
		assertNotEquals(null, db.getFunctionNames());
		assertEquals(1, db.getFunctionNames().length);
		
		FunctionDescription desc = db.getFunction("test");
		assertNotEquals(null, desc);
		assertEquals("test", desc.getName());
	}

}
