package hauptklassen;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.Einsatzgebiet;
import interfaces.Fahrzeugzusatz;

public class Krankentransportwagen extends Fahrzeug implements Fahrzeugzusatz
{
	private static final long serialVersionUID = 1L;
	
	public Krankentransportwagen (String modell, String kennzeichen, String funkrufname,
			Einsatzgebiet einsatzgebiet, Map<String, Double> groese, List<String> ausruestung, int leistung, 
			List<String> grundaustattung, ErlaubteFahrer erlaubteFahrer) {
		super (modell, kennzeichen, einsatzgebiet, funkrufname, groese, ausruestung, leistung, 
				grundaustattung, ErlaubteFahrer.C1);
		setBeschreibung("Fuer den Transport, die erweiterte Versorgung, Behandlung und Überwachung von Patienten.");
	}

	@Override
	public String toString() {
		return "[Krankentransportwagen]: " + super.toString();
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