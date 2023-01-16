package hauptklassen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.ErlaubteBesatzung;
import enums.Einsatzgebiet;

/**
 * Eine Klasse mit einer von 5 Hauptfahrzeugtypen.
 */
public class Krankentransportwagen extends Fahrzeug
{
	private static final long serialVersionUID = 1L;
	
	public Krankentransportwagen (String modell, int baujahr, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groesse, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> ausruestung, List<String> ausstattung) {
		super (modell, baujahr, kennzeichen, funkrufname, leistung, groesse, erlaubteFahrer, einsatzgebiet, 
				ausruestung, ausstattung);
		
		//Festsetzung eineheitlicher Information der Krankentransportwagen 
		setBeschreibung("Fuer den Transport, die erweiterte Versorgung, Behandlung \n   "
				+ "und Ueberwachung von Patienten.");
		setErlaubteBesatzung(ErlaubteBesatzung.KRANKENTRANSPORTWAGEN.getBesatzung());
	}
	
	public static List<String> fuelleStandardausruestung(){
		List<String> s = new ArrayList<>();
		s.addAll(Arrays.asList("Stryker Fahrtrage", "Tragestuhl", "Vakuummatratze", 
							   "\n\t\t Absaugpumpe Weimann Accuvac", "halbautomatischer AED", 
							   "\n\t\t Ulmer Notfallkoffer", "Sauerstoffflasche", 
							   "\n\t\t Schutzhelme"));
		//  -> Bsp. Unterschiede: Pulsoxymeter, Taschenlampe
		return s;
	}

	public static List<String> fuelleStandardausstattung(){
		List<String> s = new ArrayList<>();
		s.add("Klimaanlage");
		return s;
	}
	
	@Override
	public String toString() {
		return "[Krankentransportwagen] \n" + super.toString();
	}
	
	
}
