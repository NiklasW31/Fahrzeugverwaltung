package hauptklassen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.ErlaubteBesatzung;
import interfaces.Benzin;
import enums.Einsatzgebiet;

public class Rettungswagen extends Fahrzeug implements Benzin
{
	private static final long serialVersionUID = 3121374339826972330L;
	
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
	public void benutzeBenzin() {
		// TODO Auto-generated method stub
		
	}
}
