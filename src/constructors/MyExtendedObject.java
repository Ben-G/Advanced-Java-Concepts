package constructors;

public class MyExtendedObject extends MyObject {
	
	private String name;

	/* Dieser 'static-Initializer' Block wird aufgerufen wenn die Klasse vom Java-Class-Loader geladen wird*/
	static {
		System.out.println("<MyExtendedObject>: Static Initializer Block");
	}
	
	/* Dieser 'Initializer' Block wird vor dem Konstruktor aufgerufen.
	 * Streng genommen wird er VOM Konstruktor aufgerufen. Dieser Aufruf geschieht im Konstruktor als erstes,
	 * bevor der Code innerhalb des Konstruktors ausgeführt wird. (Lässt sich im Debugger analysieren).*/
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
