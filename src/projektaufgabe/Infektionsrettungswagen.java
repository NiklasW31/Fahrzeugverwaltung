package projektaufgabe;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.Einsatzgebiet;
import interfaces.Fahrzeugzusatz;

public class Infektionsrettungswagen extends Fahrzeug implements Fahrzeugzusatz
{
	private static final long serialVersionUID = 6159612121016380185L;
	
	public Infektionsrettungswagen (String modell, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groese, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> grundaustattung, List<String> ausruestung) {
		super (modell, kennzeichen, funkrufname, leistung, groese, erlaubteFahrer, einsatzgebiet, 
				grundaustattung, ausruestung);
		setBeschreibung("Der Infektions-Rettungswagen ist speziell fuer den Transport von \n  "
				+ "Patienten mit hoch ansteckenden, lebensbedrohlichen Erkrankungen ausgelegt.");
	}

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
