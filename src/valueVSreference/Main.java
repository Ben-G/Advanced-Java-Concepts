package valueVSreference;

import static java.lang.System.out;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		out.println("\n************ 1- Primitive Types ***********\n");
		Main.primitiveTypes();
		out.println("\n************ 2- Object Types ***********\n");
		Main.objectTypes();
		out.println("\n************ 3- Clone Wrong ***********\n");
		Main.cloneComplexWrong();
		out.println("\n************ 4- Clone Correct ***********\n");
		Main.cloneComplexCorrect();
	}

	public static void primitiveTypes() {
		/*
		 * Primitive Datentypen werden implizit immer als 'Value' an Methoden
		 * übergeben. Bei jeder Zuweisung einer Variable wird eine neue Kopie
		 * des Werts auf dem Stack angelegt.
		 */
		// erster Eintrag auf dem Stack -> i = 3
		int i = 3;

		// Wert in i wird kopiert. Zweiter Eintrag auf dem Stack -> j = 3
		int j = i;

		System.out.println("ZUVOR primitiv--------------");
		System.out.println("i:" + i);
		System.out.println("j:" + j);

		// Die Bearbeitung einer Variable wirkt sich nicht auf die andere aus,
		// da der Wert zuvor kopiert wurde
		i++;

		System.out.println("DANACH primitiv--------------");
		System.out.println("i:" + i);
		System.out.println("j:" + j);
	}

	public static void objectTypes() {
		/*
		 * Objekt-Variablen werden implizit immer per 'Reference' übergeben.
		 * Dies bedeutet, bei einer Zuweisung oder einer Übergabe eines Objekts
		 * an eine Methode, wird keine Kopie des Objekts angelegt, sondern eine
		 * Referenz übergeben ('Zeiger').
		 * 
		 * Alle Variablen denen das Objekt zugewiesen wurde und alle Methoden,
		 * die die Variable übergeben bekommen haben, arbeiten auf der selben
		 * Objektinstanz.
		 */

		TestObject object1 = new TestObject();
		object1.setSomeValue(5);

		// 'Reference' wird an 'object2' übergeben.
		TestObject object2 = object1;

		System.out.println("ZUVOR Objekt--------------");
		System.out.println("1:" + object1.getSomeValue());
		System.out.println("2:" + object2.getSomeValue());

		/*
		 * Über die Variable 'object1' wird das referenzierte Objekt bearbeitet.
		 * Dies wirkt sich auf alle Objekte aus, die auf die Objektinstanz
		 * zeigen.
		 */
		object1.setSomeValue(10);

		System.out.println("DANACH Objekt--------------");
		System.out.println("1:" + object1.getSomeValue());
		System.out.println("2:" + object2.getSomeValue());

		/*
		 * Möchte man ein Objekt, analog zu primitiven Datentypen, als Kopie
		 * übergeben, gibt es hierfür eine 'clone' Methode, diese wird im
		 * Interface 'Cloneable' deklariert.
		 * 
		 * Das eigene Objekt muss hierfür eine clone()-Methode implementieren.
		 * Wird clone() aufgerufen, wird eine Kopie des Objekts erstellt. Es
		 * wird also ein neues Objekt auf dem Heap angelegt. Dieses neue Objekt
		 * hat zunächst alle Eigenschaften des alten Objekts. Die beiden
		 * Instanzen können zukünftig unabhängig voneinander bearbeitet werden.
		 */
		object2 = object1.clone();

		System.out.println("Nach Clone: Objekt--------------");
		System.out.println("1:" + object1.getSomeValue());
		System.out.println("2:" + object2.getSomeValue());

		/*
		 * Über die Variable 'object2' arbeiten wir nun auf einem geklonten
		 * Objekt. Wir arbeiten also auf einer eigenen Instanz. Der Wert der in
		 * 'object1' referenziert Instanz wird dadurch nicht beeinflusst.
		 */
		object2.setSomeValue(20);

		System.out.println("Nach Clone + Bearbeitung: Objekt--------------");
		System.out.println("1:" + object1.getSomeValue());
		System.out.println("2:" + object2.getSomeValue());
	}

	public static void cloneComplexWrong() {
		ComplexCloneObject_WrongImplementation object1 = new ComplexCloneObject_WrongImplementation();
		/*
		 * Hier wird ein sogenanntes 'AutoBoxing' eingesetzt, um aus primitiven
		 * Datentypen Objekttypen zu erzeugen. Siehe package 'wrapperClasses'.
		 */
		object1.getIntegerValues().add(5);
		object1.getIntegerValues().add(7);
		object1.getIntegerValues().add(10);

		ComplexCloneObject_WrongImplementation object2 = object1.clone();

		System.out.println("Complex Clone Wrong ------------------------");

		/*
		 * Hier nutzen wir die toString()-Methode unseres Objekts.
		 */
		System.out.println(object1);
		System.out.println(object2);

		/*
		 * Wir bearbeiten nun die Werte des geklonten Objekts.
		 */
		object2.getIntegerValues().add(20);
		object2.getIntegerValues().add(40);

		/*
		 * Oh Nein! In dieser Ausgabe stellen wir fest, dass die Werte '20' und
		 * '40' sowohl für die Instanz von 'object1' als auch für die Instanz
		 * von 'object2' verändert wurden! Das Klonen hat nicht korrekt
		 * funktioniert!
		 */
		System.out.println(object1);
		System.out.println(object2);
	}

	public static void cloneComplexCorrect() {
		ComplexCloneObject_CorrectImplementation object1 = new ComplexCloneObject_CorrectImplementation();
		/*
		 * Hier wird ein sogenanntes 'AutoBoxing' eingesetzt, um aus primitiven
		 * Datentypen Objekttypen zu erzeugen. Siehe package 'wrapperClasses'.
		 */
		object1.getIntegerValues().add(5);
		object1.getIntegerValues().add(7);
		object1.getIntegerValues().add(10);

		ComplexCloneObject_CorrectImplementation object2 = object1.clone();

		System.out.println("Complex Clone Correct ------------------------");

		/*
		 * Hier nutzen wir die toString()-Methode unseres Objekts.
		 */
		System.out.println(object1);
		System.out.println(object2);

		/*
		 * Wir bearbeiten nun die Werte des geklonten Objekts.
		 */
		object2.getIntegerValues().add(20);
		object2.getIntegerValues().add(40);

		/*
		 * Juhu! Diesmal wurde korrekt geklont.
		 */
		System.out.println(object1);
		System.out.println(object2);
	}
}
