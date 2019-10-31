package ru.deucalion.labwork;

import ru.deucalion.labwork.parser.MathExpression;
import ru.deucalion.labwork.parser.ParserContext;

public class App 
{
	public static String parse(String mathStr)
	{
		ParserContext context = new ParserContext(mathStr);
        MathExpression exp = new MathExpression();
        
        try
        {
        	exp.parse(context);
        	return "Valid math expression!";
        }
        catch (Exception e) {
        	return "Invalid expression: " + e.getMessage();
		}
	}
	
	public static void main(String[] args)
	{
		MainWindow wnd = new MainWindow();
		wnd.setVisible(true);
	}
}
