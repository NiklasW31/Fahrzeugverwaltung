package enums;

public enum Einsatzgebiet 
{
	/**
	 * Das Gebiet der Landeshauptstadt Stuttgart ist für den Bereich der Notfallrettung in drei 
	 * Versorgungsbereiche (Mitte, Nord und Süd) unterteilt und wird von vier Rettungswachen des 
	 * Deutschen Roten Kreuzes und von drei Rettungswachen anderer Organisationen versorgt.
	 * https://www.drk-stuttgart.de/angebote-kurse/bevoelkerungsschutz-und-rettung/rettungsdienst/rettungswachen.html
	 * 
	 * Rettungswache 1: Hauptrettungswache, zuständig für Mitte 
	 * 		http://www.rettungsdienst-stuttgart.de/rettungsdienst_stuttgart/rettungswachen_rw1.htm
	 * 
	 * Rettungswache 2: zuständig für Nord/Mitte 
	 *   
	 * Rettungswache 4: zuständig für Süd
	 */
	
	RETTUNGSWACHE1("Mitte"), RETTUNGSWACHE2("Nord_Mitte"), RETTUNGSWACHE4("Sued");

	String bereich;
	private Einsatzgebiet(String bereich) {
		this.bereich = bereich;
	}
	public String getBereich() {
		return bereich;
	}
}
