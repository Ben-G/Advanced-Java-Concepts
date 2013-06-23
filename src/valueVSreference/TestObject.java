package valueVSreference;

public class TestObject implements Cloneable {

	private int someValue;

	public int getSomeValue() {
		return someValue;
	}

	public void setSomeValue(int someValue) {
		this.someValue = someValue;
	}
	
	public TestObject clone() {
		try {
			return (TestObject) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	
		return null;
	}
	
} 
