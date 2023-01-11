package hauptklassen;

public class AusagabeException extends Exception
{
	private static final long serialVersionUID = 6004424171245354178L;

	public AusagabeException() {
		super("Fahrzeugliste konnte nicht ausgegeben werden!");
	}

	public AusagabeException(String nachricht) {
		super(nachricht);
	}
}