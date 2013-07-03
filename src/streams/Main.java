package streams;

import static java.lang.System.out;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Main {

	static SecretKey key;
	
	static {
		KeyGenerator keyGen;
		try {
			/* Dieser Key ist so lange gültig, bis die Applikation beendet wird.
			 * Wir können nur innerhalb dieses Zeitraums mit der Verschlüsselung geschrieben
			 * Dokumente einlesen */
			keyGen = KeyGenerator.getInstance("AES");
			key = keyGen.generateKey();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		out.println("\n************ 1- DataStreams ***********\n");
		Main.writeWithDataStream();
		Main.readFromDataStream();
		
		out.println("\n************ 2- ObjectStreams ***********\n");
		Main.writeWithObjectStream();
		Main.readWithObjectStream();
		
		/* NICHT KLAUSUR RELEVANT!! Nur ein Beispiel für die Möglichkeit Streams ineinander zu wrappen */
		out.println("\n************ 3- EncryptedOutputStream ***********\n");
		Main.writeWithEncryptedObjectStream();
		Main.readWithEncryptedObjectStream();
	}
	
	public static void writeWithDataStream() {
		FileOutputStream fileStream;
		try {
			/*
			 * Java verwendet für seine Streams das so genannte Decorator-Pattern.
			 * Dies wird hier sehr gut beschrieben: http://stackoverflow.com/questions/6366385/decorator-pattern-for-io
			 */
			fileStream = new FileOutputStream("TestFile.txt");
			DataOutputStream dataStream = new DataOutputStream(fileStream);
			dataStream.writeUTF("My great String \n Multiple Lines");
			dataStream.writeInt(500009);
			dataStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readFromDataStream() {
		/* Die Inhalte der geschriebenen Datei müssen in der gleichen Reihenfolge wieder ausgelesen
		 * werden, in der sie geschrieben wurden.
		 */
		FileInputStream fileStream;
		try {
			fileStream = new FileInputStream("TestFile.txt");
			DataInputStream dataStream = new DataInputStream(fileStream);
			String text = dataStream.readUTF();
			int number = dataStream.readInt();
			dataStream.close();
			System.out.println(text+ "" + number);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/* Um aufzuräumen wird das File nach dem Lesen gelöscht.*/
			/* String fileName = "TestFile.txt";
			 File f = new File(fileName);
			 f.delete();*/
		}
	}
	
	
	public static void writeWithObjectStream() {
		FileOutputStream fileStream;
		
		HumanBeing benjamin = new HumanBeing("Benjamin",14);
		HumanBeing michael = new HumanBeing("Michael", 16);
		HumanBeing frank = new HumanBeing("Frank", 12);
		benjamin.addFriend(michael);
		benjamin.addFriend(frank);
		
		System.out.println(benjamin);
		
		try {
			fileStream = new FileOutputStream("Serialization.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileStream);
			objectOutputStream.writeInt(5100);
			objectOutputStream.writeObject("String Test");
			objectOutputStream.writeObject(benjamin);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readWithObjectStream() {
		FileInputStream fileStream;
		
		HumanBeing benjamin = null;
			
		try {
			fileStream = new FileInputStream("Serialization.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);
			objectInputStream.readInt();
			
			objectInputStream.readObject();
			benjamin = (HumanBeing) objectInputStream.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(benjamin);
	}
	
	
	
	public static void writeWithEncryptedObjectStream() {
		FileOutputStream fileStream;
		
		HumanBeing benjamin = new HumanBeing("Benjamin",14);
		HumanBeing michael = new HumanBeing("Michael", 16);
		HumanBeing frank = new HumanBeing("Frank", 12);
		benjamin.addFriend(michael);
		benjamin.addFriend(frank);
		
		System.out.println(benjamin);
		
		try {
			fileStream = new FileOutputStream("Serialization_Encrypted.txt"); 
			Cipher myCipher = Cipher.getInstance("AES");

			try {
				myCipher.init(Cipher.ENCRYPT_MODE, key);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
			
			CipherOutputStream cipher = new CipherOutputStream(fileStream, myCipher);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(cipher);
			objectOutputStream.writeInt(5100);
			objectOutputStream.writeObject("String Test");
			objectOutputStream.writeObject(benjamin);
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} 
	}
	
	public static void readWithEncryptedObjectStream() {
		FileInputStream fileStream;
		
		HumanBeing benjamin = null;
			
		try {
			fileStream = new FileInputStream("Serialization_Encrypted.txt");
			Cipher myCipher = null;
	
			try {
				myCipher = Cipher.getInstance("AES");
				myCipher.init(Cipher.DECRYPT_MODE, key);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			}
			
			CipherInputStream cipher = new CipherInputStream(fileStream, myCipher);
			ObjectInputStream objectInputStream = new ObjectInputStream(cipher);
			objectInputStream.readInt();
			
			objectInputStream.readObject();
			benjamin = (HumanBeing) objectInputStream.readObject();
			objectInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(benjamin);
	}
	
	public static void bufferedStream() {
	}

}
