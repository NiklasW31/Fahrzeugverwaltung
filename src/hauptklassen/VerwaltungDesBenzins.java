package hauptklassen;

import java.util.InputMismatchException;
import java.util.Scanner;

import enums.GroesseTank;

public class VerwaltungDesBenzins
{
	private static Scanner scanner = new Scanner(System.in);
	private static final String benzin = "Diesel"; 
	private static String preis = "1.80";
	
	public static void benzinVerwaltung() 
	{	
		boolean schleife = true;
		while(schleife) {
			System.out.println("Welche Aktionen moechten sie mit Benzin ausfuehren:");
			System.out.println("1. Die Benzin-Informationen anzeigen.");
			System.out.println("2. Den Standardpreis aendern.");
			System.out.println("3. Vorgang beenden.");
		
			String eingabe = scanner.next();
		
			switch(eingabe) 
			{	
				case "1":
					System.out.println("Von welcher Fahrzeugart moechten Sie die Informationen ansehen: \n"
							+ "... 1 - Rettungswagen\n"
							+ "... 2 - Notarzteinsatzfahrzeug\n"
							+ "... 3 - Krankentransportwagen\n"
							+ "... 4 - Infektionsrettungswagen\n"
							+ "....... Einsatzfuehrungsdienst(EFD)\n"
							+ "\t 5 - Kommandowagen\n"
							+ "\t 6 - Einsatzleitwagen\n"
							+ "\t 7 - Personenwagen");
					try {
						benzinInfos(scanner.next());
					} catch (InputMismatchException e) {
						System.err.println("Ungueltige eingabe: " + e);
						scanner.next();
					}
					break;

				case "2":
					System.out.println("Bitte geben Sie einen neuen Standardpreis ein: (Bsp: 2,0)");
					try {
						preis = scanner.next(); 
					} catch(InputMismatchException e) {
						System.err.println("Ungueltige eingabe: " + e);
						scanner.next();
					}
					break;
					
					case "3":
						schleife = false;
						break;
				
				default:
					System.out.println("Ungueltige Eingabe! \nBitte geben sie eine gueltige Nummer ein.\n");
					break;
			}
		}
	}
	
	private static void benzinInfos(String str) {
		String f = "";
		switch(str) {
			case "1":
				f = "Rettungswagen";
				break;
				
			case "2":
				f = "Notarzteinsatzfahrzeuge";
				break;
				
			case "3":
				f = "Krankentransportwagen";
				break;
				
			case "4":
				f = "Infektionsrettungswagen";
				break;
				
			case "5":
				f = "EFD-Kommandowagen";
				break;
				
			case "6":
				f = "EFD-Einsatzleitwagen";
				break;
				
			case "7":
				f = "EFD-Personenwagen";
				break;
		}
		
		System.out.println("~~~ Benzin Informatioenen aller " + f + " ~~~");
		System.out.println("Das zu benutzende Benzin ist " + benzin + ".");
		System.out.println("Der Tank hat eine Kapazitaet von " + einfuegenTank(str) + " Liter.");
		System.out.println("Der Standardpreis fuer Benzin liegt bei " + preis + " Euro.\n");
	}
	
	private static int einfuegenTank(String str) {
		int t = 0;
		
		try {
			if (str.equals("1")) {
				t = GroesseTank.FUENFZEHN.getWert();
			} else if (str.equals("2")) {
				t = GroesseTank.ZEHN.getWert();
			} else if (str.equals("3")) {
				t = GroesseTank.FUENFZEHN.getWert();
			} else if (str.equals("4")) {
				t = GroesseTank.ZWANZIG.getWert();
			} else if (str.equals("5")) {
				t = GroesseTank.ZEHN.getWert();
			} else if (str.equals("6")) {
				t = GroesseTank.FUENFZEHN.getWert();
			} else if (str.equals("7")) {
				t = GroesseTank.DREI.getWert();
			}
		} catch(Exception e) {
			System.out.println("Tankgroesse konnte nicht ermittelt werden!");
		}
		return t;
	}
}
