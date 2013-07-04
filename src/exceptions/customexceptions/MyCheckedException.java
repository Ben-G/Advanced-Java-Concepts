package exceptions.customexceptions;

public class MyCheckedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5557440558815789601L;

	public MyCheckedException() {
	}

	public MyCheckedException(String message) {
		super(message);
	}
}
