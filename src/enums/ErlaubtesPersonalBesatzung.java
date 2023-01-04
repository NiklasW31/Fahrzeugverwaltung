package enums;

public enum ErlaubtesPersonalBesatzung 
{	
	RETTUNGSWAGEN("Rettungsassistent/in und ein/e Rettungssanitaeter/in"), NOTARZTEINSATZFAHRZEUG("Einen Notarzt"), KRANKENTRANSPORTWAGEN("Mindestens einem/r Rettungssanitaeter:in und einem/r Rettungshelfer:in"),
	INFEKTIONSRETTUNGSWAGEN("INFEKTIONSRETTUNGSWAGEN"), EDF_KOMMANDOWAGEN("EDF_KOMMANDOWAGEN"), EDF_EINSATZLEITWAGEN("EDF_EINSATZLEITWAGEN"), EDF_PERSONENWAGEN("EDF_PERSONENWAGEN");

	private String besatzung;
	
	ErlaubtesPersonalBesatzung(String besatzung) {
		this.besatzung = besatzung;
		// TODO Auto-generated constructor stub
	}
	
	public String getBesatzung() {
		return besatzung;
	}
}
