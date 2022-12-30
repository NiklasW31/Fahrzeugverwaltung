package projektaufgabe;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.Einsatzgebiet;
import interfaces.Fahrzeugzusatz;

public class Krankentransportwagen extends Fahrzeug implements Fahrzeugzusatz
{
	private static final long serialVersionUID = 1L;
	
	public Krankentransportwagen (String modell, int baujahr, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groesse, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> ausstattung, List<String> standardausruestung) {
		super (modell, baujahr, kennzeichen, funkrufname, leistung, groesse, erlaubteFahrer, einsatzgebiet, 
				ausstattung, standardausruestung);
		setBeschreibung("Fuer den Transport, die erweiterte Versorgung, Behandlung und \n  "
				+ "Überwachung von Patienten.");
	}

//	Standardgrundaustattung: 
//		Stryker Fahrtrage
//		Tragestuhl
//		Vakuummatratze
//		Absaugpumpe Weimann Accuvac
//		halbautomatischer AED
//		Ulmer Notfallkoffer
//		Sauerstoffflasche
//		Schutzhelme
//		Klimaanlage
//  -> Unterschiede: Pulsoxymeter, Taschenlampe

//	Standardausrüstung: Nichts angegeben
	
	@Override
	public String toString() {
		return "[Krankentransportwagen] \n" + super.toString();
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
