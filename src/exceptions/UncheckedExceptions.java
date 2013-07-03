package exceptions;

import exceptions.customexceptions.MyOwnRuntimeException;

public class UncheckedExceptions {

	public void throwsAnUncheckedException() {
		throw new RuntimeException("My specific error reason.");
	}
	
	public void throwsMyOwnRuntimeException() {
		throw new MyOwnRuntimeException("Don't like what you are doing!");
	}
}
