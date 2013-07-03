package constructors;

public class MyExtendedObject extends MyObject {
	
	private String name;

	static {
		System.out.println("<MyExtendedObject>: Static Initializer Block");
	}
	
	{
		System.out.println("<MyExtendedObject>: Instance Initializer Block");
		this.name = "a";
	}
	
	public MyExtendedObject() {
		System.out.println("<MyExtendedObject>: Constructor");
	}
	
	public MyExtendedObject(String name) {
		/* ruft einen weiteren Konstruktor auf. MUSS an erster Stelle im Konstruktor stehen.*/
		this();
		this.name = name;
		System.out.println("<MyExtendedObject>: Constructor With String!");
	}

}
