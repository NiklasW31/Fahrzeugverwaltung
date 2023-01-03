package hauptklassen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.Einsatzgebiet;
import interfaces.Fahrzeugzusatz;

public class Krankentransportwagen extends Fahrzeug implements Fahrzeugzusatz
{
	
	private static final long serialVersionUID = 4971368672198566795L;

	public Krankentransportwagen (String modell, int baujahr, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groesse, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> ausstattung, List<String> standardausruestung) {
		super (modell, baujahr, kennzeichen, funkrufname, leistung, groesse, erlaubteFahrer, einsatzgebiet, 
				ausstattung, standardausruestung);
		setBeschreibung("Fuer den Transport, die erweiterte Versorgung, Behandlung und \n  "
				+ "Überwachung von Patienten.");
		
		ArrayList<String> ausruestung = new ArrayList<>();
		ausruestung.addAll(Arrays.asList("Stryker Fahrtrage", "Tragestuhl", "Vakuummatratze", "Absaugpumpe Weimann Accuvac",
				"halbautomatischer AED", "Ulmer Notfallkoffer", "Sauerstoffflasche", "Schutzhelme"));
		setStandardausruestung(ausruestung);
	}

//	Standardgrundaustattung: 
//		Klimaanlage
//  -> Unterschiede: Pulsoxymeter, Taschenlampe

//	Standardausruestung:
	
//	Stryker Fahrtrage
//	Tragestuhl
//	Vakuummatratze
//	Absaugpumpe Weimann Accuvac
//	halbautomatischer AED
//	Ulmer Notfallkoffer
//	Sauerstoffflasche
//	Schutzhelme
	
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
