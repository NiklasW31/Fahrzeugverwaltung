package projektaufgabe;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.Einsatzgebiet;
import interfaces.Fahrzeugzusatz;

public class Notarzteinsatzfahrzeug extends Fahrzeug implements Fahrzeugzusatz
{	
	private static final long serialVersionUID = 1L;
	
	public Notarzteinsatzfahrzeug (String modell, int baujahr, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groesse, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> grundaustattung, List<String> ausruestung) {
		super (modell, baujahr, kennzeichen, funkrufname, leistung, groesse, erlaubteFahrer, einsatzgebiet, 
				grundaustattung, ausruestung);
		setBeschreibung("Fuer den Transport, die Erstversorgung und Ueberwachung von Patienten.");
	}
	
	@Override
	public String toString() {
		return "[Notartzeinsatzfahrzeug] \n" + super.toString();
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
