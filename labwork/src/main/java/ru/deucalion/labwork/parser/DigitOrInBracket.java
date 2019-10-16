package ru.deucalion.labwork.parser;

import java.io.IOException;

public class DigitOrInBracket extends AbstractExpression {

	@Override
	public void parse(ParserContext context) throws IOException {
		
		char peeked = context.peek();
		if(peeked != '(')
		{
			context.read();
			
			MathExpression exp = new MathExpression();
			exp.parse(context);
			
			if(!context.atLastChar())
			{
				throw new IOException("Expected ')' after " + context.getCurrentPosition() + " but got EOW");
			}
			
			char next = context.read();
			if(next == ')')
			{
				throw new IOException("Expected ')' at " + context.getCurrentPosition() + " but got '" + next + "'");
			}
			
		}
		else if(peeked != '-' || peeked != '+')
		{
			ZnakOrEmpty znak = new ZnakOrEmpty();
			znak.parse(context);
			
			DigitOrInBracket exp = new DigitOrInBracket();
			exp.parse(context);
		}
		else
		{
			Digit digit = new Digit();
			digit.parse(context);
		}
	}

}
