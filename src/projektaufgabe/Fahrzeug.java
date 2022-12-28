package projektaufgabe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import enums.ErlaubteFahrer;
import enums.Einsatzgebiet;

public abstract class Fahrzeug implements Serializable 
{
	private static final long serialVersionUID = -1466146206607392728L; //Vergleichsnummer (hat sich etwas geändert seitdem das Objekt erstellt wurde) ?
	private String beschreibung; 
	
	/**
	 * sollte abstract sein. -> abstract geht grad aber nicht
	 * Geplannt war, das jede Kategorie eine Beschreibung hat wofür genau sie benutzt 
	 * werden und nicht individuel eigegeben.
	 */
	
	private String modell;
	private int baujahr;
	private String kennzeichen;
	private String funkrufname;
	private int leistung;
	private Map<String, Double> groesse;
	private ErlaubteFahrer erlaubteFahrer;
	private Einsatzgebiet einsatzgebiet;
	private List<String> grundaustattung;
	private List<String> ausruestung;
	
	public Fahrzeug(String modell, int baujahr, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groesse, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> grundaustattung, List<String> ausruestung) 
	{
		super();
		this.modell = modell;
		this.baujahr = baujahr;
		this.kennzeichen = "S-RK "+ kennzeichen;
		this.funkrufname = "Rotkreuz Stuttgart " + funkrufname;
		this.leistung = leistung;
		this.groesse = groesse;
		this.setErlaubteFahrer(erlaubteFahrer);
		this.einsatzgebiet = einsatzgebiet;
		this.grundaustattung = grundaustattung;
		this.ausruestung = ausruestung;
	}

	@Override
	public String toString() {
		return " > Beschreibung - " + beschreibung + "\n"
				+ " > modell: " + modell + ", "
				+ "baujahr: " + baujahr + ", "
				+ "kennzeichen: " + kennzeichen + ", \n   "
				+ "funkrufname: " + funkrufname + ", "
				+ "groesse: " + groesse + ", \n   "
				+ "leistung: " + leistung + ", "
				+ "erlaubteFahrer: " + erlaubteFahrer + "\n"
				+ " > grundaustattung: " + grundaustattung + "\n"
				+ " > ausruestung: " + ausruestung + "\n"; 
	}
	
/**---------- Getter und Setter ----------*/
	
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getModell() {
		return modell;
	}
	public void setModell(String modell) {
		this.modell = modell;
	}

	public int getBaujahr() {
		return baujahr;
	}
	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
	}

	public String getKennzeichen() {
		return kennzeichen;
	}
	public void setKennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
	}
	
	public String getFunkrufname() {
		return funkrufname;
	}
	public void setFunkrufname(String funkrufname) {
		this.funkrufname = funkrufname;
	}
	
	public int getLeistung() {
		return leistung;
	}
	public void setLeistung(int leistung) {
		this.leistung = leistung;
	}
	
	public Map<String, Double> getGroese() {
		return groesse;
	}
	public void setGroese(Map<String, Double> groesse) {
		this.groesse = groesse;
	}

	public ErlaubteFahrer getErlaubteFahrer() {
		return erlaubteFahrer;
	}
	public void setErlaubteFahrer(ErlaubteFahrer erlaubteFahrer) {
		this.erlaubteFahrer = erlaubteFahrer;
	}
	
	public Einsatzgebiet getEinsatzgebiet() {
		return einsatzgebiet;
	}
	public void setEinsatzgebiet(Einsatzgebiet einsatzgebiet) {
		this.einsatzgebiet = einsatzgebiet;
	}
	
	public List<String> getGrundaustattung() {
		return grundaustattung;
	}
	public void setGrundaustattung(ArrayList<String> grundaustattung) {
		this.grundaustattung = grundaustattung;
	}
	
	public List<String> getAusruestung() {
		return ausruestung;
	}
	public void setAusruestung(ArrayList<String> ausruestung) {
		this.ausruestung = ausruestung;
	}
}
