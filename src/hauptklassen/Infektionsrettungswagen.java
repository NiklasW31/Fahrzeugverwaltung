package hauptklassen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.ErlaubteBesatzung;
import enums.Einsatzgebiet;

public class Infektionsrettungswagen extends Fahrzeug
{
	private static final long serialVersionUID = 6159612121016380185L;
	
	public Infektionsrettungswagen (String modell, int baujahr, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groesse, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> ausruestung, List<String> ausstattung) {
		super (modell, baujahr, kennzeichen, funkrufname, leistung, groesse, erlaubteFahrer, einsatzgebiet, 
				ausruestung, ausstattung);
		
		setBeschreibung("Der Infektions-Rettungswagen ist speziell fuer den Transport von \n  "
				+ "Patienten mit hoch ansteckenden, lebensbedrohlichen Erkrankungen ausgelegt.");
		setErlaubteBesatzung(ErlaubteBesatzung.INFEKTIONSRETTUNGSWAGEN.getBesatzung());
	}
	
	public static List<String> fuelleStandardausruestung(){
		List<String> s = new ArrayList<>();
		s.addAll(Arrays.asList("Wechselkoffer", "Sauerstoffflaschenschrank", "Spritzenpumpe",
							   "\n\t\t Life-Base_3", "Lifepak_15", "ACCU-VAC", "Desinfektionsanlage",
							   "\n\t\t Deckencenter", "elektrischer_Tragetisch", "Weimann Medumat Standard 2", 
							   "\n\t\t Spineboard"));
		return s;
	}

	public static List<String> fuelleStandardausstattung(){
		List<String> s = new ArrayList<>();
		s.addAll(Arrays.asList("Automatikgetriebe", "Rueckfahrkamera", "Nebelscheinwerfer", "UKW-Radio",
							   "\n\t\tLED-Aussenbeleuchtung", "LED-Aussenbeleuchtung"));
		return s;
	}
	
	@Override
	public String toString() {
		return "[Infektionsrettungswagen] \n" + super.toString();
	}

	
}
