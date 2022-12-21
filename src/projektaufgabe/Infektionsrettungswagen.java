package projektaufgabe;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;

public class Infektionsrettungswagen extends Fahrzeug{

	private static final long serialVersionUID = 6159612121016380185L;

	public Infektionsrettungswagen(String beschreibung, String modell, Map<String, Double> groese, List<String> ausruestung,
			int leistung, List<String> grundaustattung, ErlaubteFahrer erlaubteFahrer) {
		super(beschreibung, modell, groese, ausruestung, leistung, grundaustattung, erlaubteFahrer);
		// TODO Auto-generated constructor stub
	}

}
