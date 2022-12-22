package hauptklassen;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Verwaltung //Textdatei einlesen & änderungen & ausgeben
{
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ausgeben();
	}
	
	public static void erstellen(Fahrzeug fahrzeug) throws IOException, ClassNotFoundException {
		FileOutputStream fileOutputStream = new FileOutputStream("FahrzeugListe.Liste");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(fahrzeug);
	}
	
	public static void loeschen(Fahrzeug fahrzeug) throws IOException, ClassNotFoundException {
	}
	
	public static void ausgeben() throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream("FahrzeugListe.Liste");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Fahrzeug myObjectFromFile = (Fahrzeug) objectInputStream.readObject();
		
		System.out.println("Beschreibung: " + myObjectFromFile.getBeschreibung());
		System.out.println("Modell: " + myObjectFromFile.getModell());
		System.out.println("Größe: " + myObjectFromFile.getGroese());
		System.out.println("Ausruestung: " + myObjectFromFile.getAusruestung());
		System.out.println("Leisung: " + myObjectFromFile.getLeistung());
		System.out.println("Grundaustattung: " + myObjectFromFile.getGrundaustattung());
	}
	
	
}
