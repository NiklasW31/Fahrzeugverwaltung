package projektaufgabe;

import java.util.List;
import enums.ErlaubteFahrer;
import interfaces.Fahrzeugzusatz;


public class Krankentransportwagen extends Fahrzeug implements Fahrzeugzusatz
{
	private static final long serialVersionUID = 1L;

	public Krankentransportwagen (String beschreibung, String modell, int groese, 
			List<String> ausruestung, int leistung, List<String> grundaustattung, ErlaubteFahrer erlaubteFahrer) {
		super(beschreibung, modell, groese, ausruestung, leistung, grundaustattung, erlaubteFahrer);
	}
	/** 
	 * für beschreibung einsetzen:
	 * 		Rettungswagen = Für den Transport, die erweiterte Versorgung, Behandlung und Überwachung von Patienten. 
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
		return "[KategorieC]: " + super.toString();
	}
	
	
	
}
