package ru.deucalion.test.rich;

import static org.junit.Assert.assertFalse;

import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.deucalion.labwork.MainWindow;

public class MainWindowTest {
	private FrameFixture window;
	
	@Before
	public void setUp()
	{
		MainWindow frame = new MainWindow();
		window = new FrameFixture(frame);
		window.show();
	}
	
	@After
	public void tearDown()
	{
		window.cleanUp();
	}
	
	@Test
	public void CalcProduceAOutput()
	{
		window.textBox("textField_input").enterText("5");
		window.button("btnCalc").requireEnabled();
		window.button("btnCalc").click();
		
		String text = window.textBox("textField_output").text();
		assertFalse(text.isBlank());
	}
	
	@Test
	public void CannotCalcWhileInputBlank()
	{
		window.textBox("textField_input").enterText("");
		window.button("btnCalc").requireDisabled();
		
		window.textBox("textField_input").enterText(" ");
		window.button("btnCalc").requireDisabled();
		
		window.textBox("textField_input").enterText("5");
		window.button("btnCalc").requireEnabled();
	}
	
	@Test
	public void CannotCancelIfNoActions()
	{
		window.button("btnCancel").requireDisabled();
		
		window.textBox("textField_input").enterText("5+3");
		window.button("btnCalc").click();
		
		window.button("btnCancel").requireEnabled();
		window.button("btnCancel").click();
		window.button("btnCancel").requireDisabled();
	}
	
	@Test
	public void CancelActuallyRevert()
	{
		window.textBox("textField_input").enterText("5+3");
		window.button("btnCalc").click();
		
		window.textBox("textField_input").enterText("5+3)");
		window.button("btnCalc").click();
		
		window.button("btnCancel").click();
		window.textBox("textField_input").requireText("5+3)");
		
		window.button("btnCancel").click();
		window.textBox("textField_input").requireText("5+3");
		window.textBox("textField_output").requireText("Valid math expression!");
	}

}
