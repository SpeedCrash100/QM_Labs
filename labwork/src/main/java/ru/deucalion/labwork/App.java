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
		String testexpression = "5+(4*-3/4)";
		
		int counts = 100000;
		for (int i = 0; i < counts; i++)
		{
			System.out.println(i);
			parse(testexpression);
		}
	}
}
