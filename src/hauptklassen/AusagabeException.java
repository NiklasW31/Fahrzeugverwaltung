package hauptklassen;

/** 
 * Dies ist eine eigenerstellte Exception fuer den Fall, dass die 
 * Fahrezeugliste, also die Textdatei, nicht gelesen/Ausgegeben werden kann.
 */
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