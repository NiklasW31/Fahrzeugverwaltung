package projektaufgabe;

import java.util.List;

public class FahrzeugKategorieA extends Fahrzeug 
{
	private static final long serialVersionUID = 1L;

	public FahrzeugKategorieA (String beschreibung, String modell,int groese, 
			List<String> ausruestung,int leistung,List<String> grundaustattung) {
		super(beschreibung, modell, groese, ausruestung, leistung, grundaustattung);
	}

}
