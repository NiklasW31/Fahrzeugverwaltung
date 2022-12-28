package projektaufgabe;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.Einsatzgebiet;
import interfaces.Fahrzeugzusatz;

public class Rettungswagen extends Fahrzeug implements Fahrzeugzusatz
{
	private static final long serialVersionUID = 3121374339826972330L;
	
	public Rettungswagen (String modell, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groese, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> grundaustattung, List<String> ausruestung) {
		super (modell, kennzeichen, funkrufname, leistung, groese, erlaubteFahrer, einsatzgebiet, 
				grundaustattung, ausruestung);
		setBeschreibung("Der RTW soll bei Notfallpatienten die Erstversorgung sicherstellen, \n  "
				+ "die Patienten transportfaehig machen und sie daraufhin waerend des \n  "
				+ "Transports ueberwachen.");
	}

	@Override
	public String toString() {
		return "[Rettungswagen] \n" + super.toString();
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
