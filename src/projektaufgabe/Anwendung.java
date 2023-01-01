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
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import enums.EinsatzfuehrungsdienstKategorien;
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
		while(schleife) 
		{
			//Auswahl der Aktion
			System.out.println("Was moechten Sie tun? :");
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
					//Gebe Informationen ueber ein Fahrzeug aus
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
					//sortiere Fahrzeuge
					fahrzeugeSortieren();
					System.out.println();
					break;
				
				case "6":
					//Vergleiche Fahrzeuge
					//fahrzeugeVergleichen();
					System.out.println("NOCH NICHT VORHANDEN");
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
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FahrzeugListe.Liste")))
		{
			while (true) {
				Object obj = ois.readObject();
				fahrzeuge.add((Fahrzeug) obj);
			}
		} catch (EOFException e) {
			// Ende der Datei erreicht
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Fehler beim laden der Fahrzeuge : " + e);
//			FEHLER GEFUNDEN! 
//			-> wollte 'projektaugabe' in 'hauptklasse' umbennenen, dann hat es aber gemeint, 
//			dass es projektaugabe.rettungswagen nicht mehr findet 
			
//			Man muesste die FahzeugListe resetten. In der Datei "FahrzeugListe.Liste ist auch der Pfad hinterlegt da das Objekt ansich dort gespeichert wird
		}
	}
	
	public static void fahrzeugeAnzeigen() 
	{
		System.out.println("---------- Liste aller Fahrzeuge ----------");
		int counter = 1;
		for(Fahrzeug fa : fahrzeuge) 
		{
			if (fa instanceof Rettungswagen) {
				System.out.println(counter + ": Rettungswagen, " + fa.getModell());
			} else if (fa instanceof Notarzteinsatzfahrzeug) {
				System.out.println(counter + ": Notarzteinsatzfahrzeug, " + fa.getModell());
			} else if (fa instanceof Krankentransportwagen) {
				System.out.println(counter + ": Krankentransportwagen, " + fa.getModell());
			} else if (fa instanceof Infektionsrettungswagen) {
				System.out.println(counter + ": Krankentransportwagen, " + fa.getModell());
			} else if (fa instanceof Einsatzfuehrungsdienst) {
				System.out.println(counter + ": Einsatzfuehrungsdienst, " + fa.getModell());
			}
			counter++;
		}
		System.out.println("-------------------------------------------");
//		schoeneren output mit 01,02,10,usw.? -> printf?
	}
	
	public static void fahrzeugInfo() 
	{
		try 
		{
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
	
	//neue Fahrzeuge Erstellen
	public static void fahrzeugErstellen() 
	{	
		System.out.println("Bitte geben Sie die Fahrzeugkategorie fuer das Fahrzeug ein: \n"
				+ "... 1 - Rettungswagen\n"
				+ "... 2 - Notarzteinsatzfahrzeug\n"
				+ "... 3 - Krankentransportwagen\n"
				+ "... 4 - Infektionsrettungswagen\n"
				+ "... 5 - Einsatzfuehrungsdienst");
		
		boolean gueltigeKat = true;
		int kategorie = 0;
		
		while(gueltigeKat) {
			kategorie = scanner.nextInt();
			
			switch(kategorie) {
				case 1,2,3,4,5:
					gueltigeKat = false;
					break;
					
				default:
					System.out.println("Ungueltige Eingabe! \nBitte geben Sie eine gueltige Kategorie ein. (1 - 5)"); 
					break;
			}
		}
		
		//Modell
		System.out.println("Bitte geben Sie das Modell ein: (Bsp.: Sprinter_316_CDI)");
		String modell = scanner.next();
		// mindest laenge oder andere Kriterien fuer modell?
//		Was meinst du mit andere Kriterien?
		
		//Baujahr
		int baujahr;
		while(true) {
			System.out.println("Bitte geben Sie das Baujahr ein: (Bsp.: 2017)");
			try {
				baujahr = scanner.nextInt();
				break;
			} catch(InputMismatchException e){
				System.err.println(e);
				scanner.next();
			}
		}
				
		//Kennzeichen einfügen
		System.out.println("Bitte geben Sie das Kennzeichen ein: (Bsp.: S-RK 0101)");
		System.out.print("S-RK ");
		String kennzeichen = scanner.next();
		
		//Funkrufnamen einfügen
		System.out.println("Bitte geben Sie den Funkrufnamen ein: (Bsp.: Rotkreuz Stuttgart 01/0101)");
		System.out.print("Rotkreuz Stuttgart ");
		String funkrufname = scanner.next();
		
		//Leistung einfügen
		int leistung;
		while(true) {
			System.out.println("Bitte geben Sie die Leistung des Fahrzeuges an: (Bsp.: 120)");
			try {
				leistung = scanner.nextInt();
				break;
			} catch(InputMismatchException e) {
				System.err.println("Ungueltige eingabe: " + e);
				scanner.next();
			}
		}

//		//Groesse einfügen
//		System.out.println("Bitte geben Sie die Fahrzeug Groesse ein: ");
//		HashMap<String, Double> groesse = new HashMap<>();
//		System.out.println("Geben Sie die Fahrzeug Laenge ein: (Bsp.: 6,2)");
//		double laenge = scanner.nextDouble();
//		groesse.put("Laenge", laenge);
//		System.out.println("Geben Sie die Fahrzeug Breite ein: (Bsp.: 2,7)");
//		double breite = scanner.nextDouble();
//		groesse.put("Breite", breite);
//		System.out.println("Geben Sie die Fahrzeug Hoehe ein: (Bsp.: 3,0)");
//		double hoehe = scanner.nextDouble();
//		groesse.put("Hoehe", hoehe);
		
		//Groesse
		System.out.println("Bitte geben Sie die Fahrzeug Groesse ein: ");
		HashMap<String, Double> groesse = new HashMap<>();
		while(true) {
			try {
				System.out.println("Geben Sie die Fahrzeug Laenge ein: (Bsp.: 6,2)");
				double laenge = scanner.nextDouble();
				groesse.put("Laenge", laenge);
				System.out.println("Geben Sie die Fahrzeug Breite ein: (Bsp.: 2,7)");
				double breite = scanner.nextDouble();
				groesse.put("Breite", breite);
				System.out.println("Geben Sie die Fahrzeug Hoehe ein: (Bsp.: 3,0)");
				double hoehe = scanner.nextDouble();
				groesse.put("Hoehe", hoehe);
				
				break;
			} catch(InputMismatchException e) {
				System.err.println("Ungueltige eingabe: " + e);
				groesse.clear();
				scanner.next();
			}
		}

		//Einsatzgebiet einfügen
		System.out.println("Bitte geben Sie das Einsatzgebiet ein: (1,2,4; Bsp.: rettungswache1)");
		boolean gueltigW = true;
		String wache = "";
		while(gueltigW) {
			wache = scanner.next();
			switch(wache) {
				case "rettungswache1", "rettungswache2", "rettungswache4":
					gueltigW = false;
					break;
					
				default:
					System.out.println("Ungueltige Eingabe! \nBitte geben Sie ein gueltige Einsatzgebiet ein. (1,2,4; Bsp.: rettungswache1)");  
					break;
			}
		}
		Einsatzgebiet einsatzgebiet = Einsatzgebiet.valueOf(wache.toUpperCase());

		//Ausstattung einfügen??
		System.out.println("Bitte geben Sie die Ausatattung an: ");
		List<String> ausstattung = new ArrayList<>();
		while(true) {
			System.out.println("Geben Sie ein min. 1 Objekt ein: (zum beenden 'x' eingeben)"
					+ "\nAusstattung = " + ausstattung);
			String ausstattungTemp = scanner.next();
			if (ausstattungTemp.equals("x")|| ausstattungTemp.equals("X")) {
				break;
			} else {
				ausstattung.add(ausstattungTemp);
			}
		}
		
		//Ausruestung einfügen??
		System.out.println("Bitte geben Sie die Standardausruestung des Fahrzeuges an: ");
		List<String> standardausruestung = new ArrayList<>();
		while(true) {
			System.out.println("Geben Sie ein min. 1 Gegenstand ein: (zum beenden 'x' eingeben)"
						+ "\nStandardausruestung = " + standardausruestung);
			String standardausruestungTemp = scanner.next();
			if (standardausruestungTemp.equals("x") || standardausruestungTemp.equals("X")) {
				break;
			} else {
				standardausruestung.add(standardausruestungTemp);
			}
		}
		
		//Erstellung des neuen Objects
		switch(kategorie) 
		{
			case 1:
				fahrzeuge.add(new Rettungswagen(modell, baujahr, kennzeichen, funkrufname, leistung, groesse, ErlaubteFahrer.C, einsatzgebiet, ausstattung, standardausruestung));
				break;
				
			case 2:
				fahrzeuge.add(new Notarzteinsatzfahrzeug(modell, baujahr, kennzeichen, funkrufname, leistung, groesse, ErlaubteFahrer.B1, einsatzgebiet, ausstattung, standardausruestung));
				break;
				
			case 3:
				fahrzeuge.add(new Krankentransportwagen(modell, baujahr, kennzeichen, funkrufname, leistung, groesse, ErlaubteFahrer.C1, einsatzgebiet, ausstattung, standardausruestung));
				break;
				
			case 4:
				fahrzeuge.add(new Infektionsrettungswagen(modell, baujahr, kennzeichen, funkrufname, leistung, groesse, ErlaubteFahrer.C, einsatzgebiet, ausstattung, standardausruestung));
				break;
				
			case 5:				
				//Kategorie des Einsatzfuehrungsdienst einfügen
				//ErlaubteFahrer einfügen
				System.out.println("Bitte geben Sie die Kategorie des Einsatzfuehrungsdienstes ein: \n"
						+ "... 1 - KOMMANDOWAGEN\n"
						+ "... 2 - EINSATZLEITWAGEN\n"
						+ "... 3 - PERSONENWAGEN");
				
				boolean gueltigKEDF = true;
				int typ = 0;
				String wagentyp = "";
				String klasse = "";
				while(gueltigKEDF) 
				{
					typ = scanner.nextInt();
					switch(typ) 
					{
						case 1:
							wagentyp = "Kommandowagen";
							klasse = "B1";
							gueltigKEDF = false;
							break;
							
						case 2:
							wagentyp = "Einsatzleitwagen";
							klasse = "C1";
							gueltigKEDF = false;
							break;
							
						case 3:
							wagentyp = "Personenwagen";
							klasse = "B";
							gueltigKEDF = false;
							break;
									
						default:
							System.out.println("Ungueltige Eingabe! \nBitte geben Sie eine gueltige Kategorie ein. (1,2,3)"); 
							break;
					}
				}
				EinsatzfuehrungsdienstKategorien kategorieEDF = EinsatzfuehrungsdienstKategorien.valueOf(wagentyp.toUpperCase());
				ErlaubteFahrer erlaubteFahrer = ErlaubteFahrer.valueOf(klasse);
				
				fahrzeuge.add(new Einsatzfuehrungsdienst(modell, baujahr, kennzeichen, funkrufname, leistung, groesse, erlaubteFahrer, einsatzgebiet, ausstattung, standardausruestung, kategorieEDF));
				break;
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
	
	private static void fahrzeugeSortieren() 
	{
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
			System.out.println("Fehler: ungueltige Eingabe!");
		}
	}

//	private static void fahrzeugeVergleichen() {
//		fahrzeugeAnzeigen();
//		System.out.println("Welche Fahrzeuge wollen sie vergleichen ?");
//		System.out.println("Fahrzeug 1:");
//		int fahrzeugEins = scanner.nextInt();
//		System.out.println("Fahrzeug 2:");
//		int FahrzeugZwei = scanner.nextInt();
//		
//		System.out.println("Welche Attribute moechten Sie verlgeichen ?");
//		//??
//	}

}
