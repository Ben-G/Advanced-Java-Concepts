package valueVSreference;

import java.util.ArrayList;
import java.util.List;

public class ComplexCloneObject_WrongImplementation implements Cloneable {

	/*
	 * Falsche Clone()-Implementierung eines Objekts mit Objektreferenzen.
	 */
	
	private List<Integer> integerValues;

	{
		/* Dies ist ein so genannter 'Initializer Block'.
		 * Dieser wird durch den Konstruktor aufgerufen.
		 * Der Aufruf dieses Blocks ist die erste Anweisung im Konstruktor,
		 * nach dem Aufruf des Konstruktors der Superklasse*/
		integerValues = new ArrayList<Integer>();
	}
	
	static {
		/*
		 * Dies ist ein 'Static Initializeer Block'.
		 * Dieser Block wird ausgeführt, wenn die Klasse vom ClassLoader geladen wird.
		 */
		System.out.println("Klasse 'ComplexCloneObject_WrongImplementation' geladen!");
	}
	
	public List<Integer> getIntegerValues() {
		return integerValues;
	}

	public void setIntegerValues(List<Integer> integerValues) {
		this.integerValues = integerValues;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("My Int-Values: \n");
		
		for (Integer intValue : this.integerValues)	{
			sb.append("\t ");
			sb.append(intValue);
			sb.append("\n");
		}

		String s = sb.toString();
		return s;
	}
	
	public ComplexCloneObject_WrongImplementation clone() {
		try {
			return (ComplexCloneObject_WrongImplementation) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;		
	}
}
