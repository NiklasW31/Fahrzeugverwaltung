package projektaufgabe;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import interfaces.Fahrzeugzusatz;


public class Rettungswagen extends Fahrzeug implements Fahrzeugzusatz
{
	public Rettungswagen(String beschreibung, String modell, String kennzeichen, String funkrufname,
			Map<String, Double> groese, List<String> ausruestung, int leistung, List<String> grundaustattung,
			ErlaubteFahrer erlaubteFahrer) {
		super(beschreibung, modell, kennzeichen, funkrufname, groese, ausruestung, leistung, grundaustattung, erlaubteFahrer);
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = 3121374339826972330L;
/** 
 * für beschreibung einsetzen:
 * 		Krankenwagen = Für den Transport eines oder mehrerer Patienten mit Krankentrage und/oder Tragestuhl.  
 */

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
	@Override
	public String toString() {
		return "[Rettungswagen] " + super.toString();
	}
	
	

}
