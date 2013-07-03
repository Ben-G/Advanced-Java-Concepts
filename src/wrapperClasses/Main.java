package wrapperClasses;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main.basics();
		Main.wrappersWithoutAutoboxing();
		Main.wrappersWithAutoboxing();
	}

	public static void basics() {
		Integer i1 = new Integer(13);
		Integer i2 = new Integer("13");
		Boolean b = new Boolean("false");

		System.out.println(i1 + " " + i2 + " " + b);

		Integer i3 = Integer.valueOf("11000", 2);
		System.out.println(i3);

		Float f1 = new Float(3.14f);
		short s = f1.shortValue();
		System.out.println(s);

		long l1 = Long.parseLong("101010", 2);
		System.out.println(l1);
	}

	/*
	 * Bis Java Version 1.4 mussten Wrapper-Typen und primitive Typen immer
	 * explizit umgewandelt werden. Daraus ergibt sich folgender Code um einen
	 * int-Wert zu erhöhen:
	 */
	public static void wrappersWithoutAutoboxing() {
		Integer y = new Integer(567);
		int x = y.intValue();
		x++;
		y = new Integer(x);
		System.out.println("y = " + y);
	}

	/*
	 * Seit Java 1.5 greift in solchen Fällen das sogenannte 'Autoboxing'.
	 * Dieses wandelt implizit, je nach Bedarf primitive Typen in Wrapper-Typen,
	 * und umgekehrt, um.
	 */
	public static void wrappersWithAutoboxing() {
		Integer y = new Integer(567);
		y++;
		System.out.println("y = " + y);
		Main.autoboxParameter(y);
	}
	
	public static void autoboxParameter(Integer y) {
		System.out.println("y-Float = "+y.floatValue());
	}

}
