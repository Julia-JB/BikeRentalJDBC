package designPatterns.decorator;

public abstract class StringDecorator implements StringComponent {
	protected StringComponent component;
	public StringDecorator(StringComponent component) {
		this.component = component;
	}
	public String getString() {
		return component.getString();
	}
}
