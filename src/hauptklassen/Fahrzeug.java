package hauptklassen;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.Einsatzgebiet;

public abstract class Fahrzeug implements Serializable 
{
	private static final long serialVersionUID = -1466146206607392728L;
	private String beschreibung;
	private String modell;
	private int baujahr;
	private String kennzeichen;
	private String funkrufname;
	private int leistung;
	private Map<String, Double> groesse;
	private ErlaubteFahrer erlaubteFahrer;
	private String erlaubteBesatzung;
	private Einsatzgebiet einsatzgebiet;
	private List<String> ausruestung;
	private List<String> ausstattung;

	public Fahrzeug(String modell, int baujahr, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groesse, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> ausruestung, List<String> ausstattung) 
	{
		super();
		this.modell = modell;
		this.baujahr = baujahr;
		this.kennzeichen = "S-RK " + kennzeichen;
		this.funkrufname = "Rotkreuz Stuttgart " + funkrufname;
		this.leistung = leistung;
		this.groesse = groesse;
		this.erlaubteFahrer = erlaubteFahrer;
		this.einsatzgebiet = einsatzgebiet;
		this.ausruestung = ausruestung;
		this.ausstattung = ausstattung;
	}

	@Override
	public String toString() {
		return " > Beschreibung - " + beschreibung + "\n"
				+ " > modell: " + modell + ", "
				+ "baujahr: " + baujahr + ", "
				+ "kennzeichen: " + kennzeichen + ", \n   "
				+ "funkrufname: " + funkrufname + ", \n   "
				+ "groesse: " + groesse + ", \n   "
				+ "leistung: " + leistung + ", "
				+ "erlaubteFahrer: " + erlaubteFahrer + ", \n   "
				+ "besatzung: " + erlaubteBesatzung + ", \n   "
				+ "einsatzgebiet: " + einsatzgebiet + "\n"
				+ " > ausruestung: " + ausruestung + "\n"
				+ " > austattung: " + ausstattung + "\n";
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
	
	public Map<String, Double> getGroesse() {
		return groesse;
	}
	public void setGroesse(Map<String, Double> groesse) {
		this.groesse = groesse;
	}

	public ErlaubteFahrer getErlaubteFahrer() {
		return erlaubteFahrer;
	}
	public void setErlaubteFahrer(ErlaubteFahrer erlaubteFahrer) {
		this.erlaubteFahrer = erlaubteFahrer;
	}
	
	public String getBesatzung() {
		return erlaubteBesatzung;
	}
	public void setBesatzung(String besatzung) {
		this.erlaubteBesatzung = besatzung;
	}
	
	public Einsatzgebiet getEinsatzgebiet() {
		return einsatzgebiet;
	}
	public void setEinsatzgebiet(Einsatzgebiet einsatzgebiet) {
		this.einsatzgebiet = einsatzgebiet;
	}

	public List<String> getAusruestung() {
		return ausruestung;
	}
	public void setAusruestung(List<String> ausruestung) {
		this.ausruestung = ausruestung;
	}

	public List<String> getAusstattung() {
		return ausstattung;
	}
	public void setAusstattung(List<String> ausstattung) {
		this.ausstattung = ausstattung;
	}
}
