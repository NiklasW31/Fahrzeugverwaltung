package hauptklassen;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.Einsatzgebiet;
import interfaces.Fahrzeugzusatz;

public class Einsatzfuehrungsdienst extends Fahrzeug implements Fahrzeugzusatz
{
	private static final long serialVersionUID = -6672047570052812398L;
	
	public Einsatzfuehrungsdienst (String modell, String kennzeichen, String funkrufname, 
			Einsatzgebiet einsatzgebiet, Map<String, Double> groese, List<String> ausruestung, int leistung, 
			List<String> grundaustattung, ErlaubteFahrer erlaubteFahrer) {
		super (modell, kennzeichen, einsatzgebiet, funkrufname, groese, ausruestung, leistung, 
				grundaustattung, erlaubteFahrer/** B oder B1 oder C1 */);
		setBeschreibung("Sind besetzt mit Fuehrungseinheiten mit entsprechender Entscheidungskompetenz.");
	}

	@Override
	public String toString() {
		return "[Einsatzfuehrungsdienst] " + super.toString();
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
