package projektaufgabe;

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
			List<String> grundaustattung, List<String> ausruestung, EinsatzfuehrungsdienstKategorien kategorieEDF) {
		super (modell, baujahr, kennzeichen, funkrufname, leistung, groesse, erlaubteFahrer, einsatzgebiet, 
				grundaustattung, ausruestung);
		setBeschreibung("Sind besetzt mit Fuehrungseinheiten mit entsprechender Entscheidungskompetenz.");
		this.kategorieEDF = kategorieEDF;
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
