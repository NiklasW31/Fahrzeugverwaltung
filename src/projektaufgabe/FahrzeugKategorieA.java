package projektaufgabe;

import java.util.List;
import enums.ErlaubteFahrer;
import interfaces.Fahrzeugzusatz;


public class FahrzeugKategorieA extends Fahrzeug implements Fahrzeugzusatz
{
	private static final long serialVersionUID = 1L;

	public FahrzeugKategorieA (String beschreibung, String modell,int groese, 
			List<String> ausruestung,int leistung,List<String> grundaustattung, ErlaubteFahrer erlaubteFahrer) {
		super(beschreibung, modell, groese, ausruestung, leistung, grundaustattung, erlaubteFahrer);
	}
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

}
