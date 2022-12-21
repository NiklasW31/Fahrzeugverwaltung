package projektaufgabe;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import interfaces.Fahrzeugzusatz;


public class Krankentransportwagen extends Fahrzeug implements Fahrzeugzusatz
{
	public Krankentransportwagen(String beschreibung, String modell, String kennzeichen, String funkrufname,
			Map<String, Double> groese, List<String> ausruestung, int leistung, List<String> grundaustattung,
			ErlaubteFahrer erlaubteFahrer) {
		super(beschreibung, modell, kennzeichen, funkrufname, groese, ausruestung, leistung, grundaustattung, erlaubteFahrer);
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;


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
		return "[Krankentransportwagen]: " + super.toString();
	}
	
	
	
}
