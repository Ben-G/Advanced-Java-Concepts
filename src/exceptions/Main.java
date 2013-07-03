package exceptions;

import exceptions.customexceptions.MyOwnRuntimeException;
import static java.lang.System.*;

public class Main {

	public static void main(String[] args) {
		/* Diese Methode kann ohne Sonderbehandlung aufgerufen werden, da 'RuntimeExceptions' nicht abgefangen werden müssen. */
		// unchecked.throwsAnUncheckedException();
		out.println("\n************ 1- Catching Exceptions ***********\n");
		Main.catchingExceptions();
		
		out.println("\n************ 2- Finally Magic ***********\n");
		Main.finallyBlockMagic();
		out.println("Returned to main");
		
		out.println("\n************ 3- Working with declared Exceptions ***********\n");

	}
	
	public static void catchingExceptions() {
		UncheckedExceptions unchecked = new UncheckedExceptions();

		/* 
		 * Gute Behandlung von Exceptions: Spezifischere Exception zuerst abfangen.
		 * Der Finally Block wird immer aufgerufen und ist dazu geeignet allgemeine Aufräumarbeiten unterzubringen. (z.B. schließen von Streams, etc.).
		 */
		try {
			unchecked.throwsMyOwnRuntimeException();
		} catch(MyOwnRuntimeException e) {
			out.println("Caught my own runtime exception:" + e);
		} catch (RuntimeException e) {
			out.println("Caught general runtime exception:" + e);
		} finally {
			out.println("Tidy my stuff up in finally!");
		}
		
		try {
			// do nothing
		} finally {
			out.println("Finally is also called, when no exceptions occurs.");
		}
	}
	
	public static void finallyBlockMagic() {
		UncheckedExceptions unchecked = new UncheckedExceptions();

		try {
			unchecked.throwsAnUncheckedException();
		} catch(RuntimeException e) {
			out.println("Caught general runtime exception" + e);
			return;
		} finally {
			out.println("Finally is always called, even when return has been called previously!");
		}
	}
	
	public static void throwsDeclaredException() {
		
	}

}
