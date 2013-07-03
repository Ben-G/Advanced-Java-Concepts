package streams;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* Diese Klasse muss 'Serializable' implementieren um über einen ObjectStream geschrieben werden zu können.*/
public class HumanBeing implements Serializable {

	/*
	 * Java verlang für alle Klassen die 'Serializable' sind eine
	 * 'serialVersionUID'. Diese dient zur Versionierung des Datenmodells. Somit
	 * kann festgestellt werden, wenn inkompatible Versionen des Datenmodells
	 * aufeinandertreffen.
	 * 
	 * Auszug aus der Dokumentation:
	 * 
	 * The serialization runtime associates with each serializable class a
	 * version number, called a serialVersionUID, which is used during
	 * deserialization to verify that the sender and receiver of a serialized
	 * object have loaded classes for that object that are compatible with
	 * respect to serialization. If the receiver has loaded a class for the
	 * object that has a different serialVersionUID than that of the
	 * corresponding sender's class, then deserialization will result in an
	 * InvalidClassException. A serializable class can declare its own
	 * serialVersionUID explicitly by declaring a field named "serialVersionUID"
	 * that must be static, final, and of type long:
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private List<HumanBeing> friends;
	/* Über das Schlüsselwort transient können wir einzelne Member-Variablen von der Serialisierung ausschließen. */
	private transient int age;

	{
		this.friends = new ArrayList<HumanBeing>();
	}

	public HumanBeing(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public boolean addFriend(HumanBeing e) {
		return friends.add(e);
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<HumanBeing> getFriends() {
		return friends;
	}

	public void setFriends(List<HumanBeing> friends) {
		this.friends = friends;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * Easteregg: gegenseitige Freundschaften sind mit dieser Implementierung
	 * nicht möglich. Findest du raus weshalb? ;)
	 */
	public String toString() {
		StringBuilder stringB = new StringBuilder("My Name is " + this.name + " I am "+ this.age +" years old");

		if (this.friends.size() > 0) {
			stringB.append(" and these are my friends: \n");
			for (HumanBeing friend : this.friends) {
				stringB.append("\t");
				stringB.append(friend);
				stringB.append("\n");
			}
		}

		return stringB.toString();
	}
}
