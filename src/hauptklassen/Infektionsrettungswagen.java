package hauptklassen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.Einsatzgebiet;
import interfaces.Fahrzeugzusatz;

public class Infektionsrettungswagen extends Fahrzeug implements Fahrzeugzusatz
{
	private static final long serialVersionUID = 6159612121016380185L;
	
	ArrayList<String> ausruestung = new ArrayList<>();
	
	public Infektionsrettungswagen (String modell, int baujahr, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groesse, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> ausstattung, List<String> standardausruestung) {
		super (modell, baujahr, kennzeichen, funkrufname, leistung, groesse, erlaubteFahrer, einsatzgebiet, 
				ausstattung, standardausruestung);
		setBeschreibung("Der Infektions-Rettungswagen ist speziell fuer den Transport von \n  "
				+ "Patienten mit hoch ansteckenden, lebensbedrohlichen Erkrankungen ausgelegt.");
		
		//ArrayList<String> ausruestung = new ArrayList<>();
		ausruestung.addAll(Arrays.asList(""));
		setStandardausruestung(ausruestung);
	}
	
//	Standardgrundaustattung: K.A
//	Standardausrüstung: K.A
	
	@Override
	public String toString() {
		return "[Infektionsrettungswagen] \n" + super.toString();
	}

	@Override
	public void benutzeBenzin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void anzahlKosten() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double berechenAlleKosten() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
