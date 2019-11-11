package ru.deucalion.labwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import ru.deucalion.labwork.parser.MathExpression;
import ru.deucalion.labwork.parser.ParserContext;

@ComponentScan
@EnableAutoConfiguration
@EnableWebSecurity
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
		SpringApplication.run(App.class, args);
	}
}

