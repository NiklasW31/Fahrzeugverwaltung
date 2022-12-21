package projektaufgabe;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;

public class Infektionsrettungswagen extends Fahrzeug{

	public Infektionsrettungswagen(String beschreibung, String modell, String kennzeichen, String funkrufname,
			Map<String, Double> groese, List<String> ausruestung, int leistung, List<String> grundaustattung,
			ErlaubteFahrer erlaubteFahrer) {
		super(beschreibung, modell, kennzeichen, funkrufname, groese, ausruestung, leistung, grundaustattung, erlaubteFahrer);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 6159612121016380185L;

	@Override
	public String toString() {
		return "[Infektionsrettungswagen] " + super.toString();
	}
	
}
