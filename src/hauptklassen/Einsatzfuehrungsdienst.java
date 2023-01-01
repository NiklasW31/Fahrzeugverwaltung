package hauptklassen;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.Einsatzgebiet;
import enums.EinsatzfuehrungsdienstKategorien;
import interfaces.Fahrzeugzusatz;

public class Einsatzfuehrungsdienst extends Fahrzeug implements Fahrzeugzusatz
{
	private static final long serialVersionUID = -6672047570052812398L;
	private EinsatzfuehrungsdienstKategorien kategorieEDF;

	public Einsatzfuehrungsdienst (String modell, int baujahr, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groesse, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> ausstattung, List<String> standardausruestung, EinsatzfuehrungsdienstKategorien kategorieEDF) {
		super (modell, baujahr, kennzeichen, funkrufname, leistung, groesse, erlaubteFahrer, einsatzgebiet, 
				ausstattung, standardausruestung);
		setBeschreibung("Sind besetzt mit Fuehrungseinheiten mit entsprechender Entscheidungskompetenz.");
		this.kategorieEDF = kategorieEDF;
	}
	
//  KOMMNDOWAGEN, K.A
//	PERSONENWAGEN, hat nichts
	
//	EINSATZLEITFAHRZEUG Groß
//	Standardgrundaustattung:    
//		Stromerzeuger
//		2 vollwertige Arbeitsplätze mit Funk, Telefon, EDV-Technik
//		4x 4 m-Band Funkgeräte AEG Telecar 10, fest verbaut
//		2 Laptops mit Drucker
//		Scanner
//		Kleinstbeamer
//		Einsatzunterlagen
//		Stadtpläne, Whiteboards, Flatscreens
//		Besprechungsraum mit Tisch und seitlichen Sitzbänken
//		Notfallrucksack
	
//	Standardausrüstung: steht nichts
	
//	EINSATZLEITFAHRZEUG klein
//	Standardgrundaustattung: 
//		Einsatzunterlagen
//		Kennzeichnungswesten
//		2m und 4m Handfunkgeräte
//		Notfallrucksack
//		AED
//		Verletztenversorgungssets (MANV)
//		Einsatz-Management-System Convexis Connex
	
//	Standardausrüstung: Automatikgetriebe, Allradantrieb, Radstand 3430 mm, Rückfahrkamera


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

	@Override
	public void anzahlKosten() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double berechenAlleKosten() {
		// TODO Auto-generated method stub
		return 0;
	}

	public EinsatzfuehrungsdienstKategorien getKategorie() {
		return kategorieEDF;
	}
	public void setKategorie(EinsatzfuehrungsdienstKategorien kategorieEDF) {
		this.kategorieEDF = kategorieEDF;
	}

}
