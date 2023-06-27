package designPatterns;

public class InvalidServiceException extends IllegalArgumentException {
	public InvalidServiceException() {
	super("Unknown service requested. For user service implementation enter " +
			"\"mybatis\" or \"dao\"");}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
