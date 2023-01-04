package hauptklassen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.ErlaubtesPersonalBesatzung;
import interfaces.Benzin;
import enums.Einsatzgebiet;

public class Krankentransportwagen extends Fahrzeug implements Benzin
{
	private static final long serialVersionUID = 1L;
	
	public Krankentransportwagen (String modell, int baujahr, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groesse, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> ausruestung, List<String> ausstattung) {
		super (modell, baujahr, kennzeichen, funkrufname, leistung, groesse, erlaubteFahrer, einsatzgebiet, 
				ausruestung, ausstattung);
		setBeschreibung("Fuer den Transport, die erweiterte Versorgung, Behandlung \n"
				+ "und Ueberwachung von Patienten.");
		setPersonalBesatzung(ErlaubtesPersonalBesatzung.KRANKENTRANSPORTWAGEN.getBesatzung());
	}
	
	public static List<String> fuelleStandardausruestung(){
		List<String> s = new ArrayList<>();
		s.addAll(Arrays.asList("Stryker Fahrtrage", "Tragestuhl", "Vakuummatratze", 
							   "\n\t\tAbsaugpumpe Weimann Accuvac", "halbautomatischer AED", 
							   "\n\t\tUlmer Notfallkoffer", "Sauerstoffflasche", 
							   "\n\t\tSchutzhelme"));
	//  -> Unterschiede: Pulsoxymeter, Taschenlampe
		return s;
	}

	public static List<String> fuelleStandardausstattung(){
		List<String> s = new ArrayList<>();
		s.add("Klimaanlage");
		//-> Unterschiede: Pulsoxymeter, Taschenlampe
		return s;
	}
	
	@Override
	public String toString() {
		return "[Krankentransportwagen] \n" + super.toString();
	}
	
	@Override
	public void benutzeBenzin() {
		// TODO Auto-generated method stub
		
	}
}
