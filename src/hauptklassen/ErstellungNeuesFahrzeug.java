package hauptklassen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import enums.EFDKategorien;
import enums.Einsatzgebiet;
import enums.ErlaubteFahrer;

/**
 * Die Klasse uebernimmt vollstaendig die Erstellung eines neuen Fahrzeuges, welches 
 * nach beliebigen Angaben(im gewissen Rahmen) erstellt werden kann.
 * Uebergibt anschließend das fertige Fahrzeug ans Haupt-Terminal zurueck.
 */
public class ErstellungNeuesFahrzeug 
{
	private static Scanner scanner = new Scanner(System.in);

	public static Fahrzeug erstelleFahrzeug(String k) 
	{	
		//Roh-Objekt, wird am Ende gefuellt und ans Haupt-Terminal zurueckgegeben
		Fahrzeug f = null;
	
		// universelle Variablen, die alle besitzen
		String modell = eingabeModell();
		int baujahr = eingabeBaujahr();
		String kennzeichen = eingabeKennzeichen();
		String funkrufname = eingabeFunkrufnahme();
		int leistung = eingabeLeistung();
		HashMap<String, Double> groesse = eingabeGroeße();
		Einsatzgebiet einsatzgebiet = eingabeEinsatzgebiet();
		List<String> ausruestung = new ArrayList<>();
		List<String> t1 = new ArrayList<>();
		List<String> ausstattung = new ArrayList<>();
		List<String> t2 = new ArrayList<>();

		//Rettungswagen erstellen
		if (k.equals("1")) {
			//individuelle fuellung der Ausruestung/Ausstattung je nach Fahrzeugtyp
			ausruestung.addAll(Rettungswagen.fuelleStandardausruestung());
			t1.addAll(eingabeAusruestung(ausruestung));
			ausruestung = t1;
			
			ausstattung.addAll(Rettungswagen.fuelleStandardausstattung());
			t2.addAll(eingabeAusstattung(ausstattung));
			ausstattung = t2;
			
			Fahrzeug tmp = new Rettungswagen(modell, baujahr, kennzeichen, funkrufname, leistung, groesse, 
					ErlaubteFahrer.C, einsatzgebiet, ausruestung, ausstattung);
			f = tmp;
			
		} 
		//Notarzteinsatzfahrzeug erstellen
		else if (k.equals("2")) {
			ausruestung.addAll(Notarzteinsatzfahrzeug.fuelleStandardausruestung());
			t1.addAll(eingabeAusruestung(ausruestung));
			ausruestung = t1;
			
			ausstattung.addAll(Notarzteinsatzfahrzeug.fuelleStandardausstattung());
			t2.addAll(eingabeAusstattung(ausstattung));
			ausstattung = t2;
			
			Fahrzeug tmp = new Notarzteinsatzfahrzeug(modell, baujahr, kennzeichen, funkrufname, leistung, 
					groesse, ErlaubteFahrer.B1, einsatzgebiet, ausruestung, ausstattung);
			f = tmp;
			
		} 
		//Krankentransportwagen erstellen
		else if (k.equals("3")) {
			ausruestung.addAll(Krankentransportwagen.fuelleStandardausruestung());
			t1.addAll(eingabeAusruestung(ausruestung));
			ausruestung = t1;
			
			ausstattung.addAll(Krankentransportwagen.fuelleStandardausstattung());
			t2.addAll(eingabeAusstattung(ausstattung));
			ausstattung = t2;
			
			Fahrzeug tmp = new Krankentransportwagen(modell, baujahr, kennzeichen, funkrufname, leistung, 
					groesse, ErlaubteFahrer.C1, einsatzgebiet, ausruestung, ausstattung);
			f = tmp;
			
		} 
		//Infektionsrettungswagen erstellen
		else if (k.equals("4")) {
			ausruestung.addAll(Infektionsrettungswagen.fuelleStandardausruestung()); 
			t1.addAll(eingabeAusruestung(ausruestung));
			ausruestung = t1;
			
			ausstattung.addAll(Infektionsrettungswagen.fuelleStandardausstattung());
			t2.addAll(eingabeAusstattung(ausstattung));
			ausstattung = t2;
			
			Fahrzeug tmp = new Infektionsrettungswagen(modell, baujahr, kennzeichen, funkrufname, leistung, 
					groesse, ErlaubteFahrer.C, einsatzgebiet, ausruestung, ausstattung);
			f = tmp;
			
		} 
		//Einsatzfuehrungsdienst(EFD) erstellen
		else if (k.equals("5")){
			
			//explizite Variablen des EFD's
			EFDKategorien kategorieEDF = einfuegenKategorieEFD();
			ErlaubteFahrer erlaubteFahrer = einfuegenFahrerEFD(kategorieEDF);
		
			//fuelle Ausrustung/Ausstattung je nach gewuenschte Kategorie des EFD's
			if (kategorieEDF.equals(EFDKategorien.EINSATZLEITWAGEN)) {
				ausruestung.addAll(Einsatzfuehrungsdienst.fuelleELWStandardausruestung());
				t1.addAll(eingabeAusruestung(ausruestung));
				ausruestung = t1;
		
				ausstattung.addAll(Einsatzfuehrungsdienst.fuelleELWStandardausstattung());
				t2.addAll(eingabeAusstattung(ausstattung));
				ausstattung = t2;
				
			} else if(kategorieEDF.equals(EFDKategorien.KOMMANDOWAGEN)) {
				ausruestung.addAll(Einsatzfuehrungsdienst.fuelleKWStandardausruestung());
				t1.addAll(eingabeAusruestung(ausruestung));
				ausruestung = t1;
			
				ausstattung.addAll(Einsatzfuehrungsdienst.fuelleKWStandardausstattung());
				t2.addAll(eingabeAusstattung(ausstattung));
				ausstattung = t2;
				
			} else if(kategorieEDF.equals(EFDKategorien.PERSONENWAGEN)) {
				t1.addAll(eingabeAusruestung(ausruestung));
				ausruestung = t1;
				
				ausstattung.addAll(Einsatzfuehrungsdienst.fuellePWStandardausstattung());
				t2.addAll(eingabeAusstattung(ausstattung));
				ausstattung = t2;
			}
			
			Fahrzeug tmp = new Einsatzfuehrungsdienst(modell, baujahr, kennzeichen, funkrufname, leistung, 
					groesse, erlaubteFahrer, einsatzgebiet, ausruestung, ausstattung, kategorieEDF);
			f = tmp;
		}

		return f;
	}

	/** 
	 * Die folgenden Methoden sind alle zum Abfragen/Einfuegen der Variablen,
	 * welche das neue Fahrzeug benoetigt.
	 * @return modell, baujahr, kennzeichen, funkrufnahme, leistung, groesse, einsaztgebiet,
	 * 		   optionale ausruestung, optionale ausstattung, kategorieEFD, erlaubteFahrerEFD 
	 */
	
	private static String eingabeModell() {
		System.out.println("Bitte geben Sie das Modell ein: (Bsp.: Sprinter_316_CDI)");
		String s = scanner.next();
		return s;
	}

	private static int eingabeBaujahr() {
		int i;
		while (true) {
			System.out.println("Bitte geben Sie das Baujahr ein: (Bsp.: 2017)");
			try {
				i = scanner.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.err.println("Ungueltige eingabe: " + e);
				scanner.next();
			}
		}
		return i;
	}

	private static String eingabeKennzeichen() {
		System.out.println("Bitte geben Sie das Kennzeichen ein: (Bsp.: S-RK 0101)");
		System.out.print("S-RK ");
		String s = scanner.next();
		return s;
	}

	private static String eingabeFunkrufnahme() {
		System.out.println("Bitte geben Sie den Funkrufnamen ein: (Bsp.: Rotkreuz Stuttgart 01/0101)");
		System.out.print("Rotkreuz Stuttgart ");
		String s = scanner.next();
		return s;
	}

	private static int eingabeLeistung() {
		int i;
		while (true) {
			System.out.println("Bitte geben Sie die Leistung des Fahrzeuges an: (Bsp.: 120 kW)");
			try {
				i = scanner.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.err.println("Ungueltige eingabe: " + e);
				scanner.next();
			}
		}
		return i;
	}

	private static HashMap<String, Double> eingabeGroeße() {
		System.out.println("Bitte geben Sie die Fahrzeug Groesse ein: ");
		HashMap<String, Double> m = new HashMap<>();
		while (true) {
			try {
				System.out.println("Geben Sie die Fahrzeug Laenge ein: (Bsp.: 6,2)");
				double laenge = scanner.nextDouble();
				m.put("Laenge", laenge);
				System.out.println("Geben Sie die Fahrzeug Breite ein: (Bsp.: 2,7)");
				double breite = scanner.nextDouble();
				m.put("Breite", breite);
				System.out.println("Geben Sie die Fahrzeug Hoehe ein: (Bsp.: 3,0)");
				double hoehe = scanner.nextDouble();
				m.put("Hoehe", hoehe);

				break;
			} catch (InputMismatchException e) {
				System.err.println("Ungueltige eingabe: " + e);
				m.clear();
				scanner.next();
			}
		}
		return m;
	}

	private static Einsatzgebiet eingabeEinsatzgebiet() {
		System.out.println("Bitte geben Sie das Einsatzgebiet ein: \n" 
				+ "... 1 - Rettungswache 1\n"
				+ "... 2 - Rettungswache 2\n" 
				+ "... 4 - Rettungswache 4");

		boolean gueltigW = true;
		String gebiet = "";
		String wache = "";
		while (gueltigW) {
			gebiet = scanner.next();
			switch (gebiet) {
			case "1":
				wache = "rettungswache_1";
				gueltigW = false;
				break;

			case "2":
				wache = "rettungswache_2";
				gueltigW = false;
				break;

			case "4":
				wache = "rettungswache_4";
				gueltigW = false;
				break;

			default:
				System.out.println("Ungueltige Eingabe! \nBitte geben Sie ein gueltige Einsatzgebiet ein. (1,2,4)");
				break;
			}
		}
		Einsatzgebiet e = Einsatzgebiet.valueOf(wache.toUpperCase());
		return e;
	}

	private static List<String> eingabeAusruestung(List<String> l) {
		System.out.println("Bitte geben Sie die optionale Ausruestung des Fahrzeuges an: ");
		while (true) {
			System.out.println("Geben Sie ein 1 Gegenstand ein: (zum beenden 'x' eingeben)" 
					+ "\nGesamtausruestung = " + l);
			String optAusrTemp = scanner.next();
			if (optAusrTemp.equals("x") || optAusrTemp.equals("X")) {
				break;
			} else {
				l.add(optAusrTemp);
			}
		}
		return l;
	}
	
	private static List<String> eingabeAusstattung(List<String> l) {
		System.out.println("Bitte geben Sie eine optionale Ausstattung an: ");
		while (true) {
			System.out.println("Geben Sie ein 1 Objekt ein: (zum beenden 'x' eingeben)" 
					+ "\nGesamtausstattung = " + l);
			String optAussTemp = scanner.next();
			if (optAussTemp.equals("x") || optAussTemp.equals("X")) {
				break;
			} else {
				l.add(optAussTemp);
			}
		}
		return l;
	}

	private static EFDKategorien einfuegenKategorieEFD() {
		System.out.println("Bitte geben Sie die Kategorie des Einsatzfuehrungsdienstes ein: \n"
				+ "... 1 - Kommandowagen\n" 
				+ "... 2 - Einsatzleitwagen\n"
				+ "... 3 - Personenwagen");

		boolean gueltigKEDF = true;
		String typ = "";
		String wagentyp = "";
		
		while (gueltigKEDF) 
		{
			typ = scanner.next();
			switch (typ) {
			case "1":
				wagentyp = "Kommandowagen";
				gueltigKEDF = false;
				break;

			case "2":
				wagentyp = "Einsatzleitwagen";
				gueltigKEDF = false;
				break;

			case "3":
				wagentyp = "Personenwagen";
				gueltigKEDF = false;
				break;

			default:
				System.out.println("Ungueltige Eingabe! \nBitte geben Sie eine gueltige Kategorie ein. (1,2,3)");
				break;
			}
		}
		EFDKategorien e = EFDKategorien.valueOf(wagentyp.toUpperCase());
		return e;
	}
	
	private static ErlaubteFahrer einfuegenFahrerEFD(EFDKategorien kedf) {
		boolean gueltigEF= true;
		String klasse = "";
		
		while (gueltigEF) 
		{
			switch (kedf) {
			case KOMMANDOWAGEN:
				klasse = "B1";
				gueltigEF = false;
				break;

			case EINSATZLEITWAGEN:
				klasse = "C1";
				gueltigEF = false;
				break;

			case PERSONENWAGEN:
				klasse = "B";
				gueltigEF = false;
				break;

			default:
				System.out.println("Fehler bei einfuegen ErlaubteFahrer aufgetreten!");
				break;
			}
		}
		ErlaubteFahrer e = ErlaubteFahrer.valueOf(klasse);
		return e;
	}

}
