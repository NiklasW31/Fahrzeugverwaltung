package projektaufgabe;

import java.util.List;
import enums.ErlaubteFahrer;


public class FahrzeugKategorieA extends Fahrzeug 
{
	private static final long serialVersionUID = 1L;

	public FahrzeugKategorieA (String beschreibung, String modell,int groese, 
			List<String> ausruestung,int leistung,List<String> grundaustattung, ErlaubteFahrer erlaubteFahrer) {
		super(beschreibung, modell, groese, ausruestung, leistung, grundaustattung, erlaubteFahrer);
	}

}
