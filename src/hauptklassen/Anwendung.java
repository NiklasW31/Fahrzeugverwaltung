package hauptklassen;

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
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Dies ist unser Haupt-Terminal, welches unser Grundgeruest bildet, und uns 
 * je nach Aktion an die passende Stelle weiterleitet.
 */
public class Anwendung
{
	private static Scanner scanner = new Scanner(System.in);
	private static List<Fahrzeug> fahrzeuge = new ArrayList<>();
	
	//Auswahl der Hauptaktionen 
	public static void main(String[] args) throws AusagabeException 
	{	
		fahrzeugeLaden();
		
		boolean schleife = true;
		while(schleife) 
		{
			System.out.println("|--------- Willkommen im Hautpterminal ---------\n"
					+ "| Was moechten Sie tun? : \n"
					+ "| 1. Gebe eine Liste aller Fahrzeuge aus. \n"
					+ "| 2. Gebe Informationen ueber ein Fahrzeug aus. \n"
					+ "| 3. Erstelle ein Fahrzeug. \n"
					+ "| 4. Loesche ein Fahrzeug. \n"
					+ "| 5. Sortiere die Fahrzeugliste. \n"
					+ "| 6. Verwalte das Benzin. \n"
					+ "| 7. Beende das Programm");
			
			switch(scanner.next()) 
			{
				case "1":
					fahrzeugeAnzeigen();
					System.out.println();
					break;
				
				case "2":
					fahrzeugInfo();
					System.out.println();
					break;
				
				case "3":
					fahrzeugErstellen();
					System.out.println();
					break;
				
				case "4":
					fahrzeugLoeschen();
					System.out.println();
					break;
				
				case "5":
					fahrzeugeSortieren();
					System.out.println();
					break;
				
				case "6":
					VerwaltungBenzin.benzinVerwaltung();;
					break;
				
				case "7":
					schleife = false;
					System.out.println("\nProgramm wurde Beendet");
					break;
						
				default:
					System.out.println("Ungueltige Eingabe! \nBitte geben sie eine gueltige Nummer ein.\n");
			}
		}
	}
	
	// Vorhandene Objekte aus der Datei aufrufen
	public static void fahrzeugeLaden() 
	{
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Fahrzeug.Liste"))){
			while (true) {
				Object obj = ois.readObject();
				fahrzeuge.add((Fahrzeug) obj);
			}
		} catch (EOFException e) {
				// Ende der Datei erreicht
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Fehler beim laden der Fahrzeuge : " + e);
		}
	}
	
	//Gebe eine kurze Liste aller Fahrzeuge aus
	public static void fahrzeugeAnzeigen() throws AusagabeException 
	{
		if(fahrzeuge.size() >= 0) 
		{
			int counter = 1;
			System.out.println("~~~~~~~~~~ Liste aller Fahrzeuge ~~~~~~~~~~");
			
			for(Fahrzeug fa : fahrzeuge) {
				if (fa instanceof Rettungswagen) {
					System.out.printf("%2d: Rettungswagen, %s \n", counter, fa.getKennzeichen());
				} else if (fa instanceof Notarzteinsatzfahrzeug) {
					System.out.printf("%2d: Notarzteinsatzfahrzeug, %s \n", counter, fa.getKennzeichen());
				} else if (fa instanceof Krankentransportwagen) {
					System.out.printf("%2d: Krankentransportwagen, %s \n", counter, fa.getKennzeichen());
				} else if (fa instanceof Infektionsrettungswagen) {
					System.out.printf("%2d: Infektionsrettungswagen, %s \n", counter, fa.getKennzeichen());
				} else if (fa instanceof Einsatzfuehrungsdienst) {
					System.out.printf("%2d: Einsatzfuehrungsdienst, %s \n", counter, fa.getKennzeichen());
				}
				counter++;
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		else {
			throw new AusagabeException();
		}
	}
	
	//Gebe alle Informationen ueber ein Fahrzeug aus
	public static void fahrzeugInfo() 
	{
		try {
			fahrzeugeAnzeigen();	
		} catch(AusagabeException e) {
			e.printStackTrace();
		}
		
		try {	
			System.out.println("Ueber welches Auto wollen Sie weitere Informationen einsehen ? (1-" + fahrzeuge.size() + ")");
			int auswahl = scanner.nextInt();
			
			System.out.println("~~~~~~~~~~ Informationen ueber das Fahrzeug ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.print(fahrzeuge.get(auswahl-1));
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		} catch(Exception e) {
			System.out.println("Ungueltige Eingabe :" + e); 
		}
	}
	
	//Erstelle ein neues Fahrzeug
	public static void fahrzeugErstellen() 
	{	
		System.out.println("Bitte geben Sie die Fahrzeugkategorie fuer das Fahrzeug an: \n"
				+ "... 1 - Rettungswagen \n"
				+ "... 2 - Notarzteinsatzfahrzeug \n"
				+ "... 3 - Krankentransportwagen \n"
				+ "... 4 - Infektionsrettungswagen \n"
				+ "... 5 - Einsatzfuehrungsdienst");
		
		boolean gueltigeKat = true;
		String kategorie = "";
		Fahrzeug neuesFahrzeug;
		
		// Leite Erstellung & Zahl des Fahrzeugtyps weiter
		while(gueltigeKat) 
		{
			kategorie = scanner.next();
			
			switch(kategorie) 
			{
				case "1", "2", "3", "4", "5":
					neuesFahrzeug = ErstellungNeuesFahrzeug.erstelleFahrzeug(kategorie);
					fahrzeuge.add(neuesFahrzeug);
					gueltigeKat = false;
					break;
					
				default:
					System.out.println("Ungueltige Eingabe! \nBitte geben Sie eine gueltige Kategorie ein. (1 - 5)"); 
					break;
			}
		}
		
		// Speichert das erstellte Fahrezug in die Textdatei
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Fahrzeug.Liste"))) {
			for (Fahrzeug f : fahrzeuge) {
				oos.writeObject(f);
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Loesche ein Fahrzeug aus der Liste
	private static void fahrzeugLoeschen()
	{
		try {
			fahrzeugeAnzeigen();
		} catch (AusagabeException e) {
		}
		
		Path datei = Paths.get("Fahrzeug.Liste");
		
		try {
			System.out.println("Bitte geben Sie die Nummer des Fahrzeuges an, welches sie loeschen moechten: ");
			int fahrzeugNummer = scanner.nextInt();
			fahrzeuge.remove(fahrzeugNummer-1);
		} catch (Exception e) {
				System.out.println("Fehler: ungueltige Fahrzeug Nummer!"); 
		}
		
		//Loescht die alte Textdatei
		try {
			Files.delete(datei);
		} catch (IOException e) {
			System.out.println("Loeschen der Textdatei fehlgeschlagen.");
			e.printStackTrace();
		}
		
		//Speichere uebrige Fahrzeuge in eine "neue" Textdatei
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Fahrzeug.Liste"))) {
			for (Fahrzeug fa : fahrzeuge) {
			oos.writeObject(fa);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Sortiere alle Fahrzeuge
	private static void fahrzeugeSortieren() 
	{
		System.out.println("Nach welchem Kriterium moechten sie sortieren: \n"
				+ "... 1 - Kennzeichen \n"
				+ "... 2 - Groesse \n"
				+ "... 3 - Leistung \n"
				+ "... 4 - Einsatzgebiet");
		
		switch (scanner.next()) 
		{
			case "1":
				Collections.sort(fahrzeuge, Sortiermaschine.KennzeichenComparator);
				System.out.println("Die Liste wurde nach Kennzeichen sortiert.");
				break;
				
			case "2":
				Collections.sort(fahrzeuge, Sortiermaschine.GroesseComparator);
				System.out.println("Die Liste wurde nach Groesse sortiert.");
				break;
				
			case "3":
				Collections.sort(fahrzeuge, Sortiermaschine.LeistungComparator);
				System.out.println("Die Liste wurde nach Leistung sortiert.");
				break;
				
			case "4":
				Collections.sort(fahrzeuge, Sortiermaschine.EinsatzgebietComparator);
				System.out.println("Die Liste wurde nach Einsatzgebieten sortiert.");
				break;
					
			default:
				System.out.println("Ungueltige Eingabe! \nBitte geben Sie ein gueltiges Kriterium ein.\n"); 
				break;
		}
	}

}
