package ru.deucalion.labwork.parser;

import java.io.IOException;

public class MathExpression extends AbstractExpression {

	@Override
	public void parse(ParserContext context) throws IOException {
		DigitOrInBracket dig = new DigitOrInBracket();
		dig.parse(context);
		
		OperatorOrEmpty op = new OperatorOrEmpty();
		op.parse(context);
	}

}
