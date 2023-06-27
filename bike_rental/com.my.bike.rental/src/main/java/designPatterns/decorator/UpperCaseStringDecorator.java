package designPatterns.decorator;

public class UpperCaseStringDecorator extends StringDecorator{
	public UpperCaseStringDecorator(StringComponent component) {
		super(component);
	}
	public String getString() {
		return super.getString().toUpperCase();
	}
}
