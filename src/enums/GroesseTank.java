package enums;

public enum GroesseTank {
	SPRINTER(100), VITO(57), PKW(50);
	
	int wert;
	private GroesseTank(int wert) {
		this.wert = wert;
	}
	public int getWert() {
		return wert;
	}
}
