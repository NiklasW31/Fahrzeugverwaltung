package projektaufgabe;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;

public class Einsatzfuehrungsdienst extends Fahrzeug {


	public Einsatzfuehrungsdienst(String beschreibung, String modell, String kennzeichen, String funkrufname,
			Map<String, Double> groese, List<String> ausruestung, int leistung, List<String> grundaustattung,
			ErlaubteFahrer erlaubteFahrer) {
		super(beschreibung, modell, kennzeichen, funkrufname, groese, ausruestung, leistung, grundaustattung, erlaubteFahrer);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -6672047570052812398L;

	@Override
	public String toString() {
		return "[Einsatzfuehrungsdienst] " + super.toString();
	}

}
