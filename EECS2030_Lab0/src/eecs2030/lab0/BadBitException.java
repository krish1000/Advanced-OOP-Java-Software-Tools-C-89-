package eecs2030.lab0;

/**
 * An exception class used in Lab 0 of EECS2030 Fall 2019-20.
 *
 */
public class BadBitException extends RuntimeException {

	/**
	 * Used for serializing exceptions.
	 */
	private static final long serialVersionUID = -1208991100878180584L;

	/**
	 * Initializes an exception with no detail message.
	 */
	public BadBitException() {
		super();
	}
	
	/**
	 * Initializes an exception with the specified detail message.
	 * 
	 * @param message the detail message
	 */
	public BadBitException(String message) {
		super(message);
	}
	
	/**
	 * Initializes an exception with the specified detail message
	 * and cause.
	 * 
	 * <p>
	 * Note that the detail message associated with cause is not automatically 
	 * incorporated in this exception's detail message.
	 * 
	 * @param message the detail message
	 * @param cause the cause
	 */
	public BadBitException(String message, Throwable cause) {
		super(message, cause);
	}

}
