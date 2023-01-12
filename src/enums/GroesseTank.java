package enums;

public enum GroesseTank {
	ZWANZIG(20), ZEHN(10), FUENFZEHN(15), FUENF(5), DREI(3);
	
	int wert;
	private GroesseTank(int wert) {
		this.wert = wert;
	}
	public int getWert() {
		return wert;
	}
}
