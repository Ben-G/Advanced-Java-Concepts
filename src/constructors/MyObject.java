package constructors;

public class MyObject {

	/* Dieser 'static-Initializer' Block wird aufgerufen wenn die Klasse vom Java-Class-Loader geladen wird*/
	static {
		System.out.println("<MyObject>: Static Initializer Block");
	}
	
	/* Dieser 'Initializer' Block wird vor dem Konstruktor aufgerufen.
	 * Streng genommen wird er VOM Konstruktor aufgerufen. Dieser Aufruf geschieht im Konstruktor als erstes,
	 * bevor der Code innerhalb des Konstruktors ausgeführt wird. (Lässt sich im Debugger analysieren).*/
	{
		System.out.println("<MyObject>: Instance Initializer Block");
	}
	
	public MyObject() {
		System.out.println("<MyObject>: Constructor!");
	}
	
}
