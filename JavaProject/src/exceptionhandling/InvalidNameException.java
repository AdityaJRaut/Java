package exceptionhandling;

public class InvalidNameException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidNameException(String message) {
		super(message);
	}
}
