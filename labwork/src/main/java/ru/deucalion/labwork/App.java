package ru.deucalion.labwork;

import ru.deucalion.labwork.parser.MathExpression;
import ru.deucalion.labwork.parser.ParserContext;

/**
 * Hello world!
 *
 */
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
	
	
    public static void main( String[] args )
    {
        String testExpression = "(21+345)*4-5*7-(3*---4/16854)";
        System.out.println("Testing expression: " + testExpression);
        String result = parse(testExpression);
        System.out.println("Result: " + result);
        
    }
}
