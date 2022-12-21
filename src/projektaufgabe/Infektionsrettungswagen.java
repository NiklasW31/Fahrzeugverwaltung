package projektaufgabe;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.Einsatzgebiet;
import interfaces.Fahrzeugzusatz;

public class Infektionsrettungswagen extends Fahrzeug implements Fahrzeugzusatz
{
	private static final long serialVersionUID = 6159612121016380185L;
	
	public Infektionsrettungswagen (String beschreibung, String modell, String kennzeichen, String funkrufname,
			Einsatzgebiet einsatzgebiet, Map<String, Double> groese, List<String> ausruestung, int leistung, 
			List<String> grundaustattung, ErlaubteFahrer erlaubteFahrer) {
		super (beschreibung, modell, kennzeichen, einsatzgebiet, funkrufname, groese, ausruestung, leistung, 
				grundaustattung, ErlaubteFahrer.C);
	}
	/** 
	 * für beschreibung einsetzen:
	 * 		Infektionsrettungswagen = ?
	 */

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
