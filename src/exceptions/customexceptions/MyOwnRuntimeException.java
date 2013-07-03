package exceptions.customexceptions;

public class MyOwnRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7113698532297260092L;

	public MyOwnRuntimeException() {
		// TODO Auto-generated constructor stub
	}
	
	public MyOwnRuntimeException(String message) {
		super(message);
	}

}
