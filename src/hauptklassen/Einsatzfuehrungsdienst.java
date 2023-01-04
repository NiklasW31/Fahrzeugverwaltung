package hauptklassen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.ErlaubteBesatzung;
import enums.Einsatzgebiet;
import enums.EinsatzfuehrungsdienstKategorien;
import interfaces.Benzin;

public class Einsatzfuehrungsdienst extends Fahrzeug implements Benzin
{
	private static final long serialVersionUID = -6672047570052812398L;
	private EinsatzfuehrungsdienstKategorien kategorieEDF;
	
	public Einsatzfuehrungsdienst (String modell, int baujahr, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groesse, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> ausruestung, List<String> ausstattung, EinsatzfuehrungsdienstKategorien kategorieEDF) {
		super (modell, baujahr, kennzeichen, funkrufname, leistung, groesse, erlaubteFahrer, einsatzgebiet, 
				ausruestung, ausstattung);
		
		setBeschreibung("Sind besetzt mit Fuehrungseinheiten mit entsprechender Entscheidungskompetenz.");
		this.kategorieEDF = kategorieEDF;
		
		if(kategorieEDF.equals(EinsatzfuehrungsdienstKategorien.KOMMANDOWAGEN)) {
			setErlaubteBesatzung(ErlaubteBesatzung.EDF_KOMMANDOWAGEN.getBesatzung());
		} else if(kategorieEDF.equals(EinsatzfuehrungsdienstKategorien.EINSATZLEITWAGEN)) {
			setErlaubteBesatzung(ErlaubteBesatzung.EDF_EINSATZLEITWAGEN.getBesatzung());
		} else if(kategorieEDF.equals(EinsatzfuehrungsdienstKategorien.PERSONENWAGEN)) {
			setErlaubteBesatzung(ErlaubteBesatzung.EDF_PERSONENWAGEN.getBesatzung());
		}
	}
	
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
	
	public static List<String> fuelleKWStandardausruestung(){
		List<String> s = new ArrayList<>();
		s.addAll(Arrays.asList("Einsatzunterlagen", "Kennzeichnungswesten", "2m und 4m Handfunkgeräte",
							   "\n\t\t Notfallrucksack", "AED", "Verletztenversorgungssets (MANV)", 
							   "\n\t\t Einsatz-Management-System Convexis Connex"));
		return s;
	}
	
	public static List<String> fuelleKWStandardausstattung(){
		List<String> s = new ArrayList<>();
		s.addAll(Arrays.asList("Automatikgetriebe", "Allradantrieb", "Rueckfahrkamera", 
							   "\n\t\tRadstand 3430 mm"));
		return s;
	}

	@Override
	public String toString() {
		return "[Einsatzfuehrungsdienst] \n" 
				+ " > Kategorie - " + kategorieEDF + "\n"
				+ super.toString();
	}

	@Override
	public void benutzeBenzin() {
		// TODO Auto-generated method stub
		
	}

	/**---------- Getter und Setter ----------*/
	
	public EinsatzfuehrungsdienstKategorien getKategorie() {
		return kategorieEDF;
	}
	public void setKategorie(EinsatzfuehrungsdienstKategorien kategorieEDF) {
		this.kategorieEDF = kategorieEDF;
	}

}
