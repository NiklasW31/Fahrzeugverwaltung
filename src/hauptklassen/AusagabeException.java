package hauptklassen;

public class AusagabeException extends Exception
{
	public AusagabeException() {
		super("Fahrzeugliste konnte nicht ausgegeben werden!");
	}

	public AusagabeException(String nachricht) {
		super(nachricht);
	}
}