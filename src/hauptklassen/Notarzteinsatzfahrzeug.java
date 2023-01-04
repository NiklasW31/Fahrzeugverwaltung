package hauptklassen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.ErlaubtesPersonalBesatzung;
import interfaces.Benzin;
import enums.Einsatzgebiet;

public class Notarzteinsatzfahrzeug extends Fahrzeug implements Benzin
{	
	private static final long serialVersionUID = 1L;
	
	public Notarzteinsatzfahrzeug (String modell, int baujahr, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groesse, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> ausruestung, List<String> ausstattung) {
		super (modell, baujahr, kennzeichen, funkrufname, leistung, groesse, erlaubteFahrer, einsatzgebiet, 
				ausruestung, ausstattung);
		setBeschreibung("Fuer den Transport, die Erstversorgung und Ueberwachung von Patienten.");
		setPersonalBesatzung(ErlaubtesPersonalBesatzung.NOTARZTEINSATZFAHRZEUG.getBesatzung());
	}

	public static List<String> fuelleStandardausruestung(){
		List<String> s = new ArrayList<>();
		s.addAll(Arrays.asList("Beatmungsgeraet Weinmann Medumat Transport", 
							   "\n\t\tNotfallrucksack Atmung", "Notfallrucksack Kreislauf", 
							   "\n\t\tNotfallrucksack Baby", "Notfallrucksack Trauma",
							   "\n\t\tEKG/Defi Corpuls C3", "Corpuls CPR Reanimationshilfe", 
							   "\n\t\t2x Spritzenpumpe Braun Perfusor Space", "Zusatztaschen NEF", 
							   "\n\t\tMANV Sets", "Absaugpumpe Weimann Accuvac",
							   "\n\t\tEinsatz-Management-System: Convexis Connex"));
		// -> Unterschiede: KET System
		return s;
	}

	public static List<String> fuelleStandardausstattung(){
		List<String> s = new ArrayList<>();
		s.addAll(Arrays.asList("Automatikgetriebe", "Allradantrieb", "Rueckfahrkamera", 
							   "\n\t\t Schiebetueren beidseits"));
		return s;
	}

	@Override
	public String toString() {
		return "[Notartzeinsatzfahrzeug] \n" + super.toString();
	}
	
	@Override
	public void benutzeBenzin() {
		// TODO Auto-generated method stub
		
	}
}
