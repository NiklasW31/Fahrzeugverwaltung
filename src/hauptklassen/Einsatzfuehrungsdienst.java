package hauptklassen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.ErlaubteBesatzung;
import enums.Einsatzgebiet;
import enums.EFDKategorien;

/**
 * Eine Klasse mit einer von 5 Hauptfahrzeugtypen.
 */
public class Einsatzfuehrungsdienst extends Fahrzeug
{
	private static final long serialVersionUID = -6672047570052812398L;
	private EFDKategorien kategorieEDF;
	
	public Einsatzfuehrungsdienst (String modell, int baujahr, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groesse, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> ausruestung, List<String> ausstattung, EFDKategorien kategorieEDF) {
		super (modell, baujahr, kennzeichen, funkrufname, leistung, groesse, erlaubteFahrer, einsatzgebiet, 
				ausruestung, ausstattung);
		
		//Festsetzung eineheitlicher Information des Einsatzfuehrungsdienstes
		setBeschreibung("Sind besetzt mit Fuehrungseinheiten mit entsprechender Entscheidungskompetenz.");
		this.kategorieEDF = kategorieEDF;
		
		//Zuweissung der moeglichen Besatzung, je nach Kategorie des EFD-Fahrzeugtyps
		if(kategorieEDF.equals(EFDKategorien.KOMMANDOWAGEN)) {
			setErlaubteBesatzung(ErlaubteBesatzung.EDF_KOMMANDOWAGEN.getBesatzung());
		} else if(kategorieEDF.equals(EFDKategorien.EINSATZLEITWAGEN)) {
			setErlaubteBesatzung(ErlaubteBesatzung.EDF_EINSATZLEITWAGEN.getBesatzung());
		} else if(kategorieEDF.equals(EFDKategorien.PERSONENWAGEN)) {
			setErlaubteBesatzung(ErlaubteBesatzung.EDF_PERSONENWAGEN.getBesatzung());
		}
	}
	
	//fuer EFDKategorie Einsatzleitwagen
	public static List<String> fuelleELWStandardausruestung(){
		List<String> s = new ArrayList<>();
		s.addAll(Arrays.asList("Stromerzeuger", "4x 4 m-Band Funkgeraete AEG Telecar 10", 
							   "\n\t\t 2 vollwertige Arbeitsplaetze mit Funk + Telefon + EDV-Technik", 
							   "\n\t\t 2 Laptops mit Drucker", "Scanner", "Kleinstbeamer",
							   "\n\t\t Einsatzunterlagen", "Stadtplaene", "Whiteboards", "Flatscreens", 
							   "\n\t\t Besprechungsraum mit Tisch und seitlichen Sitzbaenken", 
							   "\n\t\t Notfallrucksack"));
		return s;
	}
	
	//fuer EFDKategorie Einsatzleitwagen
	public static List<String> fuelleELWStandardausstattung(){
		List<String> s = new ArrayList<>();
		s.addAll(Arrays.asList("Rueckfahrkamera", "LED-Innenbeleuchtung", "LED-Aussenbeleuchtung",
							   "\n\t\t"));
		return s;
	}
	
	//fuer EFDKategorie Kommandowagen
	public static List<String> fuelleKWStandardausruestung(){
		List<String> s = new ArrayList<>();
		s.addAll(Arrays.asList("Einsatzunterlagen", "Kennzeichnungswesten", "2m und 4m Handfunkgeräte",
							   "\n\t\t Notfallrucksack", "AED", "Verletztenversorgungssets (MANV)", 
							   "\n\t\t Einsatz-Management-System Convexis Connex"));
		return s;
	}
	
	//fuer EFDKategorie Kommandowagen
	public static List<String> fuelleKWStandardausstattung(){
		List<String> s = new ArrayList<>();
		s.addAll(Arrays.asList("Automatikgetriebe", "Allradantrieb", "Rueckfahrkamera", 
							   "\n\t\t"));
		return s;
	}
	
	//fuer EFDKategorie Personenwagen
	public static List<String> fuellePWStandardausstattung(){
		List<String> s = new ArrayList<>();
		s.addAll(Arrays.asList("Rueckfahrkamera", "Allradantrieb"));
		return s;
	}

	@Override
	public String toString() {
		return "[Einsatzfuehrungsdienst] \n" 
				+ " > Kategorie - " + kategorieEDF + "\n"
				+ super.toString();
	}

	
	/**---------- Getter und Setter ----------*/
	
	public EFDKategorien getKategorie() {
		return kategorieEDF;
	}
	public void setKategorie(EFDKategorien kategorieEDF) {
		this.kategorieEDF = kategorieEDF;
	}

}
