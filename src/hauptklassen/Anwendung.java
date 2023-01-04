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

public class Anwendung //Main-Terminal
{
	private static Scanner scanner = new Scanner(System.in);
	private static List<Fahrzeug> fahrzeuge = new ArrayList<>();
	
	public static void main(String[] args)
	{	
		
		fahrzeugeLaden();
		
		boolean schleife = true;
		while(schleife) 
		{
			//Auswahl der Aktion
			System.out.println("BackUp: Was moechten Sie tun? :");
			System.out.println("1. Gebe eine Liste aller Fahrzeuge aus.");
			System.out.println("2. Gebe Informationen ueber ein Fahrzeug aus.");
			System.out.println("3. Erstelle ein Fahrzeug");
			System.out.println("4. Loesche ein Fahrzeug");
			System.out.println("5. Fahrzeugliste sortieren");
			System.out.println("6. Vergleiche Fahrzeuge (Nice to have)");
			System.out.println("7. Beende das Programm");
			
			switch(scanner.next()) 
			{
				case "1":
					//Gebe eine Liste aller Fahrzeuge aus
					fahrzeugeAnzeigen();
					System.out.println();
					break;
				
				case "2":
					//Gebe alle Informationen ueber ein Fahrzeug aus
					fahrzeugInfo();
					System.out.println();
					break;
				
				case "3":
					//Erstelle ein Fahrzeug
					fahrzeugErstellen();
					System.out.println();
					break;
				
				case "4":
					//Loesche ein Fahrzeug
					fahrzeugLoeschen();
					System.out.println();
					break;
				
				case "5":
					//Sortiere die Fahrzeuge
					fahrzeugeSortieren();
					System.out.println();
					break;
				
				case "6":
					//Vergleiche zwei Fahrzeuge
					fahrzeugeVergleichen();
					break;
				
				case "7":
					//Programm beenden
					schleife = false;
					System.out.println("\nProgramm wurde Beendet");
					break;
						
				default:
					System.out.println("Ungueltige Eingabe! \nBitte geben sie eine gueltige Nummer ein.\n");
			}
		}
	}

	public static void fahrzeugeLaden() 
	{
		// Objekte aus der Datei aufrufen
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FahrzeugListe.Liste"))){
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
	
	public static void fahrzeugeAnzeigen() 
	{
		System.out.println("---------- Liste aller Fahrzeuge ----------");
		int counter = 1;
		for(Fahrzeug fa : fahrzeuge) 
		{
			if (fa instanceof Rettungswagen) {
				System.out.printf("%2d: Rettungswagen, %s \n", counter, fa.getEinsatzgebiet());
			} else if (fa instanceof Notarzteinsatzfahrzeug) {
				System.out.printf("%2d: Notarzteinsatzfahrzeug, %s \n", counter, fa.getEinsatzgebiet());
			} else if (fa instanceof Krankentransportwagen) {
				System.out.printf("%2d: Krankentransportwagen, %s \n", counter, fa.getEinsatzgebiet());
			} else if (fa instanceof Infektionsrettungswagen) {
				System.out.printf("%2d: Infektionsrettungswagen, %s \n", counter, fa.getEinsatzgebiet());
			} else if (fa instanceof Einsatzfuehrungsdienst) {
				System.out.printf("%2d: Einsatzfuehrungsdienst, %s \n", counter, fa.getEinsatzgebiet());
			}
			counter++;
		}
		System.out.println("-------------------------------------------");
	}
	
	public static void fahrzeugInfo() 
	{
		try {
			fahrzeugeAnzeigen();
			
			System.out.println("Ueber welches Auto wollen Sie weitere Informationen einsehen ? (1-" + fahrzeuge.size() + ")");
			int auswahl = scanner.nextInt();
			System.out.println("---------- Informationen ueber das Fahrzeug ----------");
			System.out.print(fahrzeuge.get(auswahl-1));
			System.out.println("------------------------------------------------------");
		} catch(Exception e) {
			System.out.println("Ungueltige Eingabe :" + e); 
		}
	}
	
	public static void fahrzeugErstellen() 
	{	
		System.out.println("Bitte geben Sie die Fahrzeugkategorie fuer das Fahrzeug an: \n"
				+ "... 1 - Rettungswagen\n"
				+ "... 2 - Notarzteinsatzfahrzeug\n"
				+ "... 3 - Krankentransportwagen\n"
				+ "... 4 - Infektionsrettungswagen\n"
				+ "... 5 - Einsatzfuehrungsdienst");
		
		boolean gueltigeKat = true;
		String kategorie = "";
		Fahrzeug neuesFahrzeug;
		
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
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FahrzeugListe.Liste"))) {
			for (Fahrzeug f : fahrzeuge) {
				oos.writeObject(f);
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void fahrzeugLoeschen()
	{
		fahrzeugeAnzeigen();
		Path datei = Paths.get("FahrzeugListe.Liste");
		
		//loescht das Fahrzeug aus der Schleife
		try {
			System.out.println("Bitte geben Sie die Nummer des Fahrzeuges an, welches sie loeschen moechten: ");
			int fahrzeugNummer = scanner.nextInt();
			fahrzeuge.remove(fahrzeugNummer-1);
		} catch (Exception e) {
				System.out.println("Fehler: ungueltige Fahrzeug Nummer!"); 
		}
		
		//loescht die alte "Text" Datei
		try {
			Files.delete(datei);
		} catch (IOException e) {
			System.out.println("Loeschen der Textdatei fehlgeschlagen.");
			e.printStackTrace();
		}
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FahrzeugListe.Liste"))) {
			for (Fahrzeug fa : fahrzeuge) {
			//Die uebrig gebliebenen Fahrzeuge werden wieder eingefuegt
			oos.writeObject(fa);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void fahrzeugeSortieren() 
	{
		try {
			System.out.println("Nach welchem Kriterium moechten sie sortieren: ");
			System.out.println("1. Kennzeichen");
			System.out.println("2. Groesse");
			System.out.println("3. Leistung");
			System.out.println("4. Einsatzgebiet");
			
			int sortieren = scanner.nextInt();
			
			switch (sortieren) 
			{
				case 1:
					Collections.sort(fahrzeuge, Sortiermaschine.KennzeichenComparator);
					System.out.println("Die Liste wurde nach Kennzeichen sortiert.");
					break;
					
				case 2:
					Collections.sort(fahrzeuge, Sortiermaschine.GroesseComparator);
					System.out.println("Die Liste wurde nach Groesse sortiert.");
					break;
					
				case 3:
					Collections.sort(fahrzeuge, Sortiermaschine.LeistungComparator);
					System.out.println("Die Liste wurde nach Leistung sortiert.");
					break;
					
				case 4:
					Collections.sort(fahrzeuge, Sortiermaschine.EinsatzgebietComparator);
					System.out.println("Die Liste wurde nach Einsatzgebieten sortiert.");
					break;
			}
		} catch (Exception e) {
			System.out.println("Fehler: ungueltige Eingabe!");
		}
	}

	private static void fahrzeugeVergleichen() {
		System.out.println("NOCH NICHT VORHANDEN");
//		fahrzeugeAnzeigen();
//		System.out.println("Welche Fahrzeuge wollen sie vergleichen ?");
//		System.out.println("Fahrzeug 1:");
//		int fahrzeugEins = scanner.nextInt();
//		System.out.println("Fahrzeug 2:");
//		int FahrzeugZwei = scanner.nextInt();
//		
//		System.out.println("Welche Attribute moechten Sie verlgeichen ?");
//		//??
	}

}
