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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import enums.Einsatzgebiet;
import enums.ErlaubteFahrer;

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
		System.out.println("2. Gebe Informationen ueber ein Fahrzeug aus.");
		System.out.println("3. Erstelle ein Fahrzeug");
		System.out.println("4. Loesche ein Fahrzeug");
		System.out.println("5. Fahrzeugliste sortieren");
		System.out.println("6. Vergleiche Fahrzeuge (Nice to have)");
		System.out.println("7. Beende das Programm");
		
		int eingabe = scanner.nextInt();	
		
					/*zum testen*/
		//fahrzeuge.remove(1);
		//System.out.println(fahrzeuge.toString());
		
		switch(eingabe) 
		{
			case 1:
				//Gebe eine Liste aller Fahrzeuge aus
				fahrzeugeAnzeigen();
				System.out.println();
				break;
				
			case 2:
				//Gebe Informationen ueber ein Fahrzeug aus
				fahrzeugInfo();
				break;
				
			case 3:
				//Erstelle ein Fahrzeug
				fahrzeugErstellen();
				System.out.println();
				break;
				
			case 4:
				//Loesche ein Fahrzeug
				fahrzeugLoeschen();
				System.out.println();
				break;
				
			case 5:
				//sortiere Fahrzeuge
				fahrzeugeSortieren();
				System.out.println();
				break;
				
			case 6:
				//Vergleiche Fahrzeuge
				fahrzeugeVergleichen();
				System.out.println();
				break;
				
			case 7:
				//Programm beenden
				schleife = false;
				System.out.println();
				break;
				
			default:
				//Exeption oder simple nachricht
				System.out.println("Eingabe ungueltig, bitte versuchen Sie es erneut.");
				System.out.println();
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
		int counter = 1;
		for(Fahrzeug fa : fahrzeuge) {
			if (fa instanceof Rettungswagen) {
				System.out.println(counter + ": Rettungswagen, " + fa.getModell());
			}else if (fa instanceof Notarzteinsatzfahrzeug) {
				System.out.println(counter + ": Notarzteinsatzfahrzeug, " + fa.getModell());
			} else if (fa instanceof Krankentransportwagen) {
				System.out.println(counter + ": Krankentransportwagen, " + fa.getModell());
			}else if (fa instanceof Infektionsrettungswagen) {
				System.out.println(counter + ": Krankentransportwagen, " + fa.getModell());
			} else if (fa instanceof Einsatzfuehrungsdienst) {
				System.out.println(counter + ": Einsatzfuehrungsdienst, " + fa.getModell());
			}
			counter++;
		}
		//schoeneren output mit 01,02,10,usw.?
	}
	
	public static void fahrzeugInfo(){
		try {
		fahrzeugeAnzeigen();
		
		System.out.println("Ueber welches Auto wollen Sie weitere Informationen einsehen ? (1-" + fahrzeuge.size()+")");
		int auswahl = scanner.nextInt();
		System.out.println(fahrzeuge.get(auswahl-1));
		}catch(Exception e) {
			System.out.println("Ungueltige eingabe :" + e);
		}
	}
	
	public static void fahrzeugErstellen() 
	{
		/**
		 * Wir brauchen für den ganzen Vorgang eine Exeption. 
		 * Wenn mal testest alle Fahrzeuge anzeigen, siehst du ein 4 Objekt.
		 * Allerdings fehlt da eine beschreibung, weil ich beim ersten versuch eins 
		 * anzulegen einen Fehler bei Modell hatte. Als ich es erneut versucht habe 
		 * wurde die Beschreibung einfach übersprungen.
		 * -> Müssen es so machen, dass das neue Objekt gelöscht/fallen gelassen wird.
		 **/
		String beschreibung;
		while(true) {
			System.out.println("Bitte geben Sie eine Beschreibung ein: "); 
			beschreibung = scanner.next();
			if(beschreibung.isEmpty() == false) {
				break;
			}
		}
		
		System.out.println("Bitte geben Sie die Fahrzeugkategorie fuer das Fahrzeug ein: \n"
				+ "... 1 - Rettungswagen\n"
				+ "... 2 - Notarzteinsatzfahrzeug\n"
				+ "... 3 - Krankentransportwagen\n"
				+ "... 4 - Infektionsrettungswagen\n"
				+ "... 5 - Einsatzfuehrungsdienst\n");
		
		boolean gueltigeKat = true;
		int kategorie = 0;
		while(gueltigeKat) {
			kategorie = scanner.nextInt();
			switch(kategorie) {
				case 1, 2, 3, 4, 5:
					gueltigeKat = false;
					break;
				default:
					System.out.println("ungueltige eingabe. Bitte geben Sie eine gueltige Kategorie ein. (1 - 5)");
					break;
			}
		}
		
		System.out.println("Bitte geben Sie das Modell ein: ");
		String modell = scanner.next();
		
		System.out.println("Bitte geben Sie das Kennzeichen ein: ");
		System.out.print("S-RK ");
		String kennzeichen = scanner.next();
		
		System.out.println("Bitte geben Sie den Funkrufnamen ein: ");
		System.out.print("Rotkreuz Stuttgart ");
		String funkrufname = scanner.next();
		
		System.out.println("Bitte geben Sie das Einsatzgebiet ein: (Rettungswache 1,2,4)");
		boolean gueltigW = true;
		String wache = "";
		while(gueltigW) {
			wache = scanner.next().toLowerCase();
			switch(wache) {
				case "rettungswache 1", "rettungswache 2", "rettungswache 4":
					gueltigW = false;
					break;
				default:
					System.out.println("ungueltige eingabe. Bitte geben Sie ein gueltige Einsatzgebiet ein. (Rettungswache 1,2,4)");
					break;
			}
		}
		Einsatzgebiet einsatzgebiet = Einsatzgebiet.valueOf(wache.toUpperCase()); //warum uppercase?
		
		System.out.println("Bitte geben Sie die Fahrzeug Groesse ein: ");
		HashMap<String, Double> groesse = new HashMap<>();
		System.out.println("Geben Sie die Fahrzeug Laenge ein: ");
		double laenge = scanner.nextInt();
		groesse.put("Laenge", laenge);
		System.out.println("Geben Sie die Fahrzeug Breite ein: ");
		double breite = scanner.nextInt();
		groesse.put("Breite", breite);
		System.out.println("Geben Sie die Fahrzeug Hoehe ein: ");
		double hoehe = scanner.nextInt();
		groesse.put("Hoehe", hoehe);

		
		System.out.println("Bitte geben Sie die Ausruestung des Fahrzeuges an: ");
		List<String> ausruestung = new ArrayList<>();
		
		while(true) {
			System.out.println("Geben Sie ein min. 1 Gegenstand ein: (zum beenden 'x' eingeben)");
			String ausruestungTemp = scanner.next();
			if(ausruestungTemp.equals("x") || ausruestungTemp.equals("X")) {
				break;
			}else {
				ausruestung.add(ausruestungTemp);
			}
		}
		
		System.out.println("Bitte geben Sie die Leistung des Fahrzeuges an: ");
		int leistung = scanner.nextInt();
		
		System.out.println("Bitte geben Sie die Grundaustattung an: ");
		List<String> grundaustattung = new ArrayList<>();
		
		while(true) {
			System.out.println("Geben Sie ein min. 1 Objekt ein: (zum beenden 'x' eingeben)");
			String grundaustattungTemp = scanner.next();
			if(grundaustattungTemp.equals("x")|| grundaustattungTemp.equals("X")) {
				break;
			}else {
				grundaustattung.add(grundaustattungTemp);
			}
		}
		
		System.out.println("Bitte geben Sie die benoetigte Fuehrerscheinklasse für das Fahrzeug ein: (B, C1, C)");
		boolean gueltigF = true;
		String klasse = "";
		while(gueltigF) {
			klasse = scanner.next();
			switch(klasse) {
				case "C", "C1", "B":
					gueltigF = false;
					break;
				default:
					System.out.println("ungueltige eingabe. Bitte geben Sie eine gueltige Klasse ein. (B, C1, C)");
					break;
			}
		}
		ErlaubteFahrer erlaubteFahrer = ErlaubteFahrer.valueOf(klasse);
		
		switch(kategorie) {
			case 1:
				fahrzeuge.add(new Rettungswagen(modell, kennzeichen, funkrufname, einsatzgebiet, groesse, ausruestung, leistung, grundaustattung, erlaubteFahrer));
				break;
			case 2:
				fahrzeuge.add(new Notarzteinsatzfahrzeug(modell, kennzeichen, funkrufname, einsatzgebiet, groesse, ausruestung, leistung, grundaustattung, erlaubteFahrer));
				break;
			case 3:
				fahrzeuge.add(new Krankentransportwagen(modell, kennzeichen, funkrufname, einsatzgebiet, groesse, ausruestung, leistung, grundaustattung, erlaubteFahrer));
				break;
			case 4:
				fahrzeuge.add(new Infektionsrettungswagen(modell, kennzeichen, funkrufname, einsatzgebiet, groesse, ausruestung, leistung, grundaustattung, erlaubteFahrer));
				break;
			case 5:
				fahrzeuge.add(new Einsatzfuehrungsdienst(modell, kennzeichen, funkrufname, einsatzgebiet, groesse, ausruestung, leistung, grundaustattung, erlaubteFahrer));
				break;
		}
		
		//fahrzeuge.add(new FahrzeugKategorieA(beschreibung, modell, groesse, ausruestung, leistung, grundaustattung, erlaubteFahrer));
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FahrzeugListe.Liste"))) {
			for (Fahrzeug fahrzeug : fahrzeuge) {
			oos.writeObject(fahrzeug);
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
				System.out.println("Fehler: ungueltige Fahrzeug Nummer");
		}
		//loescht die alte "Text" Datei
		try {
			Files.delete(datei);
			//System.out.println("Loeschen war erfolgreich."); //Die Loeschung war erfolgreich!
		} catch (IOException e) {
			System.out.println("Loeschen fehlgeschlagen."); //Die Loeschung ist fehlgeschlagen!
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
	
	private static void fahrzeugeSortieren() {
		try {
			System.out.println("Wonach moechten sie sortieren: ");
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
			System.out.println("Fehler: ungueltige eingabe");
		}
	}

	private static void fahrzeugeVergleichen() {
		fahrzeugeAnzeigen();
		System.out.println("Welche Fahrzeuge wollen sie vergleichen ?");
		System.out.println("Fahrzeug 1:");
		int fahrzeugEins = scanner.nextInt();
		System.out.println("Fahrzeug 2:");
		int FahrzeugZwei = scanner.nextInt();
		
		System.out.println("Welche Attribute moechten Sie verlgeichen ?");
		//??
	}

}
