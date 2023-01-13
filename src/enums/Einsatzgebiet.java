package enums;

public enum Einsatzgebiet {	
	RETTUNGSWACHE_1("Stuttgart Mitte"), 
	RETTUNGSWACHE_2("Stuttgart Nord & Mitte"), 
	RETTUNGSWACHE_4("Stuttgart Sued");
	
	private String bereich;
	
	Einsatzgebiet(String bereich) {
		this.bereich = bereich;
	}
	
	public String getBereich() {
		return bereich;
	}
}
