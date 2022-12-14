package projektaufgabe;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anwendung //Main-Terminal
{
	private static Scanner scanner = new Scanner(System.in);
	private static List<Fahrzeug> fahrzeuge = new ArrayList<>();
	
	public static void main(String[] args) 
	{	
		fahrzeugeLaden();
		boolean schleife = true;
		
		while(schleife) {
		//Auswahl der Aktion
		System.out.println("Was moechten Sie tun? :");
		System.out.println("1. Gebe eine Liste aller Fahrzeuge aus.");
		System.out.println("2. Gebe Informationen über ein Fahrzeug aus.");
		System.out.println("3. Erstelle ein Fahrzeug");
		System.out.println("4. Lösche ein Fahrzeug");
		System.out.println("5. Vergleiche Fahrzeuge");
		System.out.println("6. Beende das Programm");
		
		int eingabe = scanner.nextInt();	
		
					/*zum testen*/
		//fahrzeuge.remove(1);
		//System.out.println(fahrzeuge.toString());
		
		switch(eingabe) 
		{
			case 1:
				//Gebe eine Liste aller Fahrzeuge aus
				fahrzeugeAnzeigen();
				break;
			case 2:
				//Gebe Informationen über ein Fahrzeug aus
				break;
			case 3:
				//Erstelle ein Fahrzeug
				fahrzeugErstellen();
				break;
			case 4:
				//Lösche ein Fahrzeug
				fahrzeugLoeschen();
				break;
			case 5:
				//Vergleiche Fahrzeuge
				fahrzeugeVergleichen();
				break;
			case 6:
				//Programm beenden
				schleife = false;
				break;
				
			default:
				//Exeption oder simple nachricht
				System.out.println("Eingabe ungültig, bitte versuche es erneut.");
				break;
				}
		}
		
		System.out.println("Programm wurde Beendet");
		}

	public static void fahrzeugeLaden() 
	{
		// Objekte aus der Datei aufrufen
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FahrzeugListe.Liste"))) {
		while (true) {
		Object obj = ois.readObject();
		fahrzeuge.add((Fahrzeug) obj);
		}
		} catch (EOFException e) {
		// Ende der Datei erreicht
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Fehler beim laden der Fahrzeuge : "); 
			e.printStackTrace();
		}
	}
	
	public static void fahrzeugeAnzeigen() {
		int counter = 0;
		for(Fahrzeug fa : fahrzeuge) {
			System.out.println(counter + ": " + fa.toString());
			counter++;
		}
		
	}
	
	public static void fahrzeugErstellen() 
	{
		System.out.println("Gebe eine Beschreibung ein: ");
		String beschreibung = scanner.next();
		System.out.println("Gebe das Modell ein: ");
		String modell = scanner.next();
		System.out.println("Gebe die Fahrzeug Größe ein: ");
		int groesse = scanner.nextInt();
		System.out.println("Gebe die Ausrüstung des Fahrzeuges an: ");
		List<String> ausruestung = new ArrayList<>();
		while(true) {
			System.out.println("Gebe ein Gegegenstand ein: (zum beenden 'x' eingeben)");
			String ausruestungTemp = scanner.next();
			if(ausruestungTemp.equals("x")) {
				break;
			}else {
				ausruestung.add(ausruestungTemp);
			}
		}
		System.out.println("Gebe die Leistung des Fahrzeuges an: ");
		int leistung = scanner.nextInt();
		System.out.println("Gebe die Grundaustattung an: ");
		List<String> grundaustattung = new ArrayList<>();
		while(true) {
			System.out.println("Gebe ein Objekt ein: (zum beenden 'x' eingeben)");
			String grundaustattungTemp = scanner.next();
			if(grundaustattungTemp.equals("x")) {
				break;
			}else {
				grundaustattung.add(grundaustattungTemp);
			}
		}

		fahrzeuge.add(new FahrzeugKategorieA(beschreibung, modell, groesse, ausruestung, leistung, grundaustattung));
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FahrzeugListe.Liste"))) {
			for (Object obj : fahrzeuge) {
			oos.writeObject(obj);
			}
			} catch (IOException e) {
			e.printStackTrace();
			}
	}
	
	private static void fahrzeugLoeschen(){
		fahrzeugeAnzeigen();
		Path datei = Paths.get("FahrzeugListe.Liste");
		
		//löscht das Fahrzeug aus der Schleife
		try {
		System.out.println("Bitte gebe die Nummer des Fahrzeuges an welches du Löschen willst: ");
		int fahrzeugNummer = scanner.nextInt();
		fahrzeuge.remove(fahrzeugNummer);
		
		} catch (Exception e) {
				System.out.println("Fehler: ungültige Fahrzeug Nummer");
		}
		//löscht die alte "Text" Datei
		try {
			Files.delete(datei);
			System.out.println("Löschen war erfolgreich.");
		} catch (IOException e1) {
			System.out.println("Löschen fehlgeschlagen.");
			e1.printStackTrace();
		}
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FahrzeugListe.Liste"))) {
			for (Fahrzeug fa : fahrzeuge) {
			//Die übrig gebliebenen Fahrzeuge werden wieder eingefügt
			oos.writeObject(fa);
			}
			} catch (IOException ex) {
			ex.printStackTrace();
			}
		}
	
	private static void fahrzeugeVergleichen() {
		System.out.println("Fehlt noch :/");
	}

}
