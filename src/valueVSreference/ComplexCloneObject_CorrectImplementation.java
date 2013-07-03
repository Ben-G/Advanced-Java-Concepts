package valueVSreference;

import java.util.ArrayList;

public class ComplexCloneObject_CorrectImplementation extends
		ComplexCloneObject_WrongImplementation {

	public ComplexCloneObject_CorrectImplementation clone() {
		ComplexCloneObject_CorrectImplementation clonedObj = (ComplexCloneObject_CorrectImplementation) super
				.clone();
		/*
		 * Die Referenz auf unsere Liste muss manuell geklont werden. Dafür
		 * erzeugen wir eine neue Liste, die mit der alten initialisiert wird.
		 */
		clonedObj.setIntegerValues(new ArrayList<Integer>(this
				.getIntegerValues()));

		return clonedObj;
	}

}
