package ru.deucalion.test.unimplemented;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import ru.deucalion.labwork.parser.OperatorDescription;
import ru.deucalion.labwork.parser.OperatorsDataBase;

public class OperatorsDataBaseTest {
	
	OperatorsDataBase db;
	
	class PlusTestOperatorDesc extends OperatorDescription
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
			return 0;
		}
		
	}
	
	@Before
	public void setup()
	{
		db = new OperatorsDataBase();
	}
	
	@Test
	public void register()
	{
		assertNotEquals(null, db.getOperatorsLists());
		assertEquals(0, db.getOperatorsLists().length);
		db.registerOperator(new PlusTestOperatorDesc());
		assertNotEquals(null, db.getOperatorsLists());
		assertEquals(1, db.getOperatorsLists().length);
		
		char[] ops = db.getOperatorsLists();
		assertNotEquals(null, ops);
		assertEquals('+', ops[0]);
		
		OperatorDescription desc = db.getOperator('+');
		assertNotEquals(null, desc);
		assertEquals('+', desc.getSymbolic());
		assertEquals(2, desc.getPriority());
		
	}

}
