package projektaufgabe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;

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
	private String kennzeichen;
	private String funkrufname;
	private Map<String, Double> groesse;
	private List<String> ausruestung;
	private int leistung;
	private List<String> grundaustattung;
	private ErlaubteFahrer erlaubteFahrer;

	
	public Fahrzeug(String beschreibung, String modell, String kennzeichen, String funkrufname, Map<String, Double> groese, 
		List<String> ausruestung, int leistung, List<String> grundaustattung, ErlaubteFahrer erlaubteFahrer) 
	{
		super();
		this.beschreibung = beschreibung;
		this.modell = modell;
		this.kennzeichen = "S-RK "+kennzeichen;
		this.funkrufname = "Rotkreuz Stuttgart "+funkrufname;
		this.groesse = groese;
		this.ausruestung = ausruestung;
		this.leistung = leistung;
		this.grundaustattung = grundaustattung;
		this.setErlaubteFahrer(erlaubteFahrer);
	}

//	@Override
//	public String toString() {
//		return "Beschreibung: " + beschreibung + ".\n"
//				+ "{modell-" + modell + ", groese-" + groesse 
//				+ ", ausruestung-" + ausruestung + ", leistung-" + leistung 
//				+ ", grundaustattung-" + grundaustattung + ", fuehrerscheinklasse-" + erlaubteFahrer +"}";
//	}

	@Override
	public String toString() {
		return " Beschreibung: " + beschreibung + ".\n"
				+ " {modell=" + modell + ", kennzeichen=" + kennzeichen
				+ " funkrufname=" + funkrufname + ", groesse=" + groesse
				+ " leistung=" + leistung + ", erlaubteFahrer=" + erlaubteFahrer + ".\n"
				+ " ausruestung=" + ausruestung + ".\n"
				+ " grundaustattung=" + grundaustattung + "]"; 
	}
	
	/**---------- Setter und Getter ----------*/
	
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

	public List<String> getAusruestung() {
		return ausruestung;
	}
	public void setAusruestung(ArrayList<String> ausruestung) {
		this.ausruestung = ausruestung;
	}
	
	public int getLeistung() {
		return leistung;
	}
	public void setLeistung(int leistung) {
		this.leistung = leistung;
	}

	public List<String> getGrundaustattung() {
		return grundaustattung;
	}
	public void setGrundaustattung(ArrayList<String> grundaustattung) {
		this.grundaustattung = grundaustattung;
	}

	public Map<String, Double> getGroese() {
		return groesse;
	}
	public void setGroese(Map<String, Double> groese) {
		this.groesse = groese;
	}

	public ErlaubteFahrer getErlaubteFahrer() {
		return erlaubteFahrer;
	}

	public void setErlaubteFahrer(ErlaubteFahrer erlaubteFahrer) {
		this.erlaubteFahrer = erlaubteFahrer;
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
	
}
