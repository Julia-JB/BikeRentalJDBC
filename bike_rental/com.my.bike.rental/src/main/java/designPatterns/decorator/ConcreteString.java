package designPatterns.decorator;

public class ConcreteString implements StringComponent{

	private String string;

	public ConcreteString(String string) {
		this.string = string;
	}

	@Override
	public String getString() {
		return string;
	}
}
