package projektaufgabe;

import java.util.ArrayList;

public abstract class Fahrzeug {
	
	private String beschreibung;
	private String modell;
	private int groese;
	private ArrayList<String> ausruestung;
	private int leistung;
	private ArrayList<String> grundaustattung;
	
	
	public Fahrzeug(String beschreibung, String modell, int groese, ArrayList<String> ausruestung, int leistung,
			ArrayList<String> grundaustattung) {
		super();
		this.beschreibung = beschreibung;
		this.modell = modell;
		this.groese = groese;
		this.ausruestung = ausruestung;
		this.leistung = leistung;
		this.grundaustattung = grundaustattung;
	}


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


	public ArrayList<String> getAusruestung() {
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


	public ArrayList<String> getGrundaustattung() {
		return grundaustattung;
	}


	public void setGrundaustattung(ArrayList<String> grundaustattung) {
		this.grundaustattung = grundaustattung;
	}


	public int getGroese() {
		return groese;
	}


	public void setGroese(int groese) {
		this.groese = groese;
	}


	@Override
	public String toString() {
		return "Fahrzeug [beschreibung=" + beschreibung + ", modell=" + modell + ", groese=" + groese + ", ausruestung="
				+ ausruestung + ", leistung=" + leistung + ", grundaustattung=" + grundaustattung + "]";
	}
	
	
}
