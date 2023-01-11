package hauptklassen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import enums.ErlaubteFahrer;
import enums.ErlaubteBesatzung;
import interfaces.Benzin;
import enums.Einsatzgebiet;

public class Rettungswagen extends Fahrzeug implements Benzin
{
	private static final long serialVersionUID = 3121374339826972330L;
	private static Scanner scanner = new Scanner(System.in);
	
	public Rettungswagen (String modell, int baujahr, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groesse, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> ausruestung, List<String> ausstattung) {
		super (modell, baujahr, kennzeichen, funkrufname, leistung, groesse, erlaubteFahrer, einsatzgebiet, 
				ausruestung, ausstattung);
		
		setBeschreibung("Der RTW soll bei Notfallpatienten die Erstversorgung \n   "
				+ "sicherstellen, die Patienten transportfaehig machen und sie daraufhin \n   "
				+ "waerend des Transports ueberwachen.");
		setErlaubteBesatzung(ErlaubteBesatzung.RETTUNGSWAGEN.getBesatzung());
	}
	
	public static List<String> fuelleStandardausruestung(){
		List<String> s = new ArrayList<>();
		s.addAll(Arrays.asList("Notfallkoffer", "Beatmungsrucksack", "Notfalltasche Kind",
							   "\n\t\t Notfalltasche Trauma", "Absaugpumpe Accuvac", "Schaufeltrage",
							   "\n\t\t Fahrtrage Styker", "Corpuls C3", "Weimann Medumat Standard 2", 
							   "\n\t\t Spineboard"));
		return s;
	}

	public static List<String> fuelleStandardausstattung(){
		List<String> s = new ArrayList<>();
		s.addAll(Arrays.asList("Luftfederung", "Rueckfahrkamera", "LED-Innenbeleuchtung", 
							   "\n\t\tLED-Aussenbeleuchtung"));
		return s;
	}
	
	@Override
	public String toString() {
		return "[Rettungswagen] \n" + super.toString();
	}
	
	@Override
	public void benutzeBenzin() 
	{
		String benzin = "Super";
		String tmpB = "";
		int tank = 20;
		float standardpreis = 1.80f;
		String tmpP = "";
		
		System.out.println("Was moechten Sie ueber das Benzin aller Rettungswagens wissen? :");
		System.out.println("1. Die aktuell gespeicherten Informationen.");
		System.out.println("2. Das Benzin wechseln.");
		System.out.println("3. Den Standardpreis aendern.");	
		
		String eingabe = scanner.next();
		
		switch(eingabe) 
		{	
			case "1":
				System.out.println("Benzin Infos zu Retteungswagen: \n");
				System.out.println("> Aktuell getanktes Benzin - " + benzin + "\n");
				System.out.println("> Kapazitaet des Tanks - " + tank + " Liter.\n");
				System.out.println("> Kosten fuer 1x auffuellen - " + standardpreis + " Euro.\n");
				break;
				
			case "2":
				System.out.println("Zu welchem Benzin moechten Sie wechseln:"
						+ "1 - Diesel"
						+ "2 - Super"
						+ "3 - Super +");
				
				try {
					if(scanner.next().equals("1")) {
						tmpB = "Diesel";
					} else if(scanner.next().equals("2")) {
						tmpB = "Super";
					} else if(scanner.next().equals("3")) {
						tmpB = "Super +";
					}
				} catch(InputMismatchException e) {
					System.err.println("Ungueltige eingabe: " + e);
					scanner.next();
				}
				break;

			case "3":
				System.out.println("Bitte geben Sie einen neuen Standardpreis ein: (Bsp: 2,0)");
				try {
					tmpP = scanner.next(); 
				} catch(InputMismatchException e) {
					System.err.println("Ungueltige eingabe: " + e);
					scanner.next();
				}
				break;
				
			default:
				System.out.println("Ungueltige Eingabe! \nBitte geben sie eine gueltige Nummer ein.\n");
				break;
		}
		benzin = tmpB;
		standardpreis = Float.valueOf(tmpP);
	}
}
