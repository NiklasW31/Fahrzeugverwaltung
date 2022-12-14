package projektaufgabe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Fahrzeug implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private String beschreibung;
	private String modell;
	private int groese;
	private List<String> ausruestung;
	private int leistung;
	private List<String> grundaustattung;
	
	public Fahrzeug(String beschreibung, String modell, int groese, 
		List<String> ausruestung, int leistung, List<String> grundaustattung) 
	{
		super();
		this.beschreibung = beschreibung;
		this.modell = modell;
		this.groese = groese;
		this.ausruestung = ausruestung;
		this.leistung = leistung;
		this.grundaustattung = grundaustattung;
	}

	@Override
	public String toString() {
		return "Fahrzeug [beschreibung=" + beschreibung + ", modell=" + modell + ", groese=" + groese + ", ausruestung="
				+ ausruestung + ", leistung=" + leistung + ", grundaustattung=" + grundaustattung + "]";
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

	public int getGroese() {
		return groese;
	}
	public void setGroese(int groese) {
		this.groese = groese;
	}
	
}
