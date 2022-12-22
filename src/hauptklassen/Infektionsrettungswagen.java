package hauptklassen;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.Einsatzgebiet;
import interfaces.Fahrzeugzusatz;

public class Infektionsrettungswagen extends Fahrzeug implements Fahrzeugzusatz
{
	private static final long serialVersionUID = 6159612121016380185L;
	
	public Infektionsrettungswagen (String modell, String kennzeichen, String funkrufname,
			Einsatzgebiet einsatzgebiet, Map<String, Double> groese, List<String> ausruestung, int leistung, 
			List<String> grundaustattung, ErlaubteFahrer erlaubteFahrer) {
		super (modell, kennzeichen, einsatzgebiet, funkrufname, groese, ausruestung, leistung, 
				grundaustattung, ErlaubteFahrer.C);
		setBeschreibung("Der Infektions-Rettungswagen ist speziell f�r den Transport von Patienten mit hoch ansteckenden, "
				+ "lebensbedrohlichen Erkrankungen ausgelegt.");
	}

	@Override
	public String toString() {
		return "[Infektionsrettungswagen] " + super.toString();
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
