package ru.deucalion.labwork.parser;

import java.io.IOException;

public class OperatorOrEmpty extends AbstractExpression {

	@Override
	public void parse(ParserContext context) throws IOException {
		if(context.atLastChar())
			return;
		
		char peeked = context.peek();
		
		char[] operators = {'+', '-', '*', '/'};
		
		for (int i = 0; i < operators.length; i++) {
			if(peeked == operators[i])
			{
				context.read();
				
				MathExpression exp = new MathExpression();
				exp.parse(context);
				return;
			}
		}
	}

}
