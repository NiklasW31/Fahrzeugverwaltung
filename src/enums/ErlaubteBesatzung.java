package enums;

public enum ErlaubteBesatzung 
{	
	RETTUNGSWAGEN("ein/e Rettungsassistent:in und ein/e Sanitaeter:in"), 
	NOTARZTEINSATZFAHRZEUG("Ein/e Notarzt:in"), 
	KRANKENTRANSPORTWAGEN("Min. ein/e Rettungssanitaeter:in & ein/e Rettungshelfer:in"),
	INFEKTIONSRETTUNGSWAGEN("Drei Einsatzkraefte & ein/e Notarzt:in"), 
	EDF_KOMMANDOWAGEN("ein/e Zugfuehrer:in, ein/e Zugtruppfuehrer:in & ein/e Fahrer:in"), 
	EDF_EINSATZLEITWAGEN("Die Fuehrungskraefte(diverse) und/oder der Zugtrupp"), 
	EDF_PERSONENWAGEN("Ein/e Fahrer:in und/oder Begleitungpersonen");

	private String besatzung;
	
	ErlaubteBesatzung(String besatzung) {
		this.besatzung = besatzung;
	}
	public String getBesatzung() {
		return besatzung;
	}
}
