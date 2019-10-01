package ru.deucalion.labwork.parser;

import java.io.IOException;

public abstract class AbstractExpression {
	
	public abstract void parse(ParserContext context) throws IOException;
}
