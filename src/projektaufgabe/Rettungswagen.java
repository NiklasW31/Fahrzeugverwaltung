package projektaufgabe;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.Einsatzgebiet;
import interfaces.Fahrzeugzusatz;

public class Rettungswagen extends Fahrzeug implements Fahrzeugzusatz
{
	private static final long serialVersionUID = 3121374339826972330L;
	
	public Rettungswagen (String modell, String kennzeichen, String funkrufname,
			Einsatzgebiet einsatzgebiet, Map<String, Double> groese, List<String> ausruestung, int leistung,
			List<String> grundaustattung, ErlaubteFahrer erlaubteFahrer) {
		super (modell, kennzeichen, einsatzgebiet, funkrufname, groese, ausruestung, leistung, 
				grundaustattung, ErlaubteFahrer.C1);
		setBeschreibung("Der RTW soll bei Notfallpatienten die erstversorgung sicherstellen "
				+ ",die Patienten Transportfaehig machen und sie daraufhin waerend des Transports zu ueberwachen.");
	}
	/** 
	 * für beschreibung einsetzen:
	 * 		Rettungswagen = ?
	 */

	@Override
	public String toString() {
		return "[Rettungswagen] " + super.toString();
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
