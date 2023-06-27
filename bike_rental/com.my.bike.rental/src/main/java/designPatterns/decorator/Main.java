package designPatterns.decorator;

import org.apache.logging.log4j.LogManager;

public class Main {
	public static void main(String[] args) {
		// Create a concrete string
		StringComponent string = new ConcreteString("string to be decorated");
		// Decorate the string
		StringComponent decorator = new UpperCaseStringDecorator(string);

		LogManager.getLogger().info("Decorated string: " + decorator.getString());
	}
}
