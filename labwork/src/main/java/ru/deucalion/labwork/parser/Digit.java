package ru.deucalion.labwork.parser;

import java.io.IOException;

public class Digit extends AbstractExpression {

	@Override
	public void parse(ParserContext context) throws IOException {
		if(context.atLastChar())
			throw new IOException("Expected digit after " + context.getCurrentPosition());
		
		char peeked = context.peek();
		
		String strValue = "";
		
		while(Character.isDigit(peeked))
		{
			context.read();
			strValue += peeked;
			
			if(context.atLastChar())
				break;
			
			peeked = context.peek();
		}
		
		if(strValue.isEmpty())
			throw new IOException("Expected digit after " + context.getCurrentPosition());
		
	}

}
