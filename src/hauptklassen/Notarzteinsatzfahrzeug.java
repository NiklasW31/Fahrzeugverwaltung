package hauptklassen;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.Einsatzgebiet;
import interfaces.Fahrzeugzusatz;

public class Notarzteinsatzfahrzeug extends Fahrzeug implements Fahrzeugzusatz
{	
	private static final long serialVersionUID = 1L;
	
	public Notarzteinsatzfahrzeug(String modell, String kennzeichen, String funkrufname,
			Einsatzgebiet einsatzgebiet, Map<String, Double> groese, List<String> ausruestung, int leistung,
			List<String> grundaustattung,ErlaubteFahrer erlaubteFahrer) {
		super(modell, kennzeichen, einsatzgebiet, funkrufname, groese, ausruestung, leistung, 
				grundaustattung, erlaubteFahrer);
		setBeschreibung("Fuer den Transport, die Erstversorgung und Ueberwachung von Patienten.");
	}
	
	@Override
	public String toString() {
		return "[Notartzeinsatzfahrzeug] :" + super.toString();
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
