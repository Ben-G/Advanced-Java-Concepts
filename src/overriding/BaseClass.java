package overriding;

import java.io.IOException;

public class BaseClass {
	
	protected Object exceptionMethod() throws IOException {
		return null;
	}
	
	private Object invisibleMethod() {
		return null;
	}
	
	final public Object finalMethod() {
		return null;
	}
}
