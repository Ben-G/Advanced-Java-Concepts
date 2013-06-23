package overriding;

//import java.io.FileNotFoundException;

public class ExtendedClass extends BaseClass {

/*
 * *************** exceptionMethod() ****************	
 */

	/*
	 * Gültige Art die Methode zu überschreiben!
	 * 
	 * Zu Beachten:
	 * 
	 * 1) Die Sichtbarkeit darf beim Überschreiben der Methode erweitert werden, aus protected wurde public
	 * 2) Es darf eine Unterklasse des Rückgabewerts zurück gegeben werden. In der Superklasse geben wir 'Object'
	 *	  als Rückgabetyp an, hier wird eine Subclass von 'Object', 'Extended Class' zurückgegeben. 
	 * 3) Die Exception darf weggelasssen werden. Die überschriebene Methode hat die Möglichkeit die Exception
	 *    selbst zu behandeln und muss somit nicht gezwungen werden sie zu deklarieren.
	 */
	public ExtendedClass exceptionMethod() {
		return null;
	}
	
	/*
	 * Keine gültige Art die Methode zu überschreiben!
	 *  
	 * Problem: Die Sichtbarkeit darf in einer überschriebenen Methode nicht verringert werden.
	 * Ansonsten würde die Möglichkeit bestehen, dass eine Unterklasse weniger Methoden definiert als 
	 * ihre Superklasse. Da wir aber immer erwarten, dass jede Unterklasse mindestens die Methoden der 
	 * Superklasse anbietet, ist dies nicht gestattet.
	 * 
	 * Der Compiler / die IDE gibt folgende Fehlermeldung aus:
	 * 'Cannot reduce the visibility of the inherited method from 
	 * BaseClass'
	 */
	
	/*
	private Object exceptionMethod() {
		return null;
	}
	*/
	
	/*
	 * Keine gültige Art die Methode zu überschreiben!
	 * 
	 * Es dürfen keine 'throw'-Statements für zusätzliche Exceptions in der überschriebenen Methode 
	 * deklariert werden. Es dürfen lediglich Exceptions weggelassen werden, oder Unterklassen von Exceptions
	 * deklariert werden.
	 */
	/*protected ExtendedClass exceptionMethod() throws ClassNotFoundException {
		
	}*/
	
	/*
	 * Gültige Art die Methode zu überschreiben!
	 * 
	 * Eine Unterklasse der ursprünglich deklarierten Exception darf zurückgegeben werden.
	 * In 'BaseClass' wird angegeben, dass eine 'IOException' geworfen werden kann.
	 * Da die 'FileNotFoundException' eine Unterklasse der 'IOException' ist, darf auch diese 
	 * deklariert werden.
	 */
	/*public ExtendedClass exceptionMethod() throws FileNotFoundException {
		return null;
	}*/
	
/*
 * *************** invisibleMethod() ****************	
 */
	/*
	 * Vorsicht:
	 * 
	 * Dies ist kein Überschreiben der Methode der Superklasse.
	 * Die Methode der Superklasse ist 'private' und damit für Unterklassen nicht sichtbar!
	 * Hier wird lediglich eine neue Methode deklariert, die nicht in 'BaseClass' verfügbar ist.
	 */
	public Object invisibleMethod() {
		return null;
	}
	
/*
 * *************** finalMethod() ****************	
 */
	/*
	 *  finalMethod() kann nicht überschrieben werden, das sie in der Superklasse als 'final' markiert wurde.
	 * Fehlermeldung IDE/Compiler: 'Cannot override the final method from 
	 * BaseClass'
	 */
	
	/*public Object finalMethod() {
		
	}*/
}
