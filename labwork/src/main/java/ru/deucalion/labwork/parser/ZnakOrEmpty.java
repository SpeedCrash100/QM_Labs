package ru.deucalion.labwork.parser;

import java.io.IOException;

public class ZnakOrEmpty extends AbstractExpression {

	@Override
	public void parse(ParserContext context) throws IOException {
		char peeked = context.peek();
		if(peeked == '+')
		{
			context.read();
			return;
		}
		if(peeked == '-')
		{
			context.read();
			return;
		}
	}

}
