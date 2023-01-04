package hauptklassen;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.ErlaubtesBesatzung;
import enums.Einsatzgebiet;
import interfaces.Benzin;

public class Infektionsrettungswagen extends Fahrzeug implements Benzin
{
	private static final long serialVersionUID = 6159612121016380185L;
	
	public Infektionsrettungswagen (String modell, int baujahr, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groesse, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> ausruestung, List<String> ausstattung) {
		super (modell, baujahr, kennzeichen, funkrufname, leistung, groesse, erlaubteFahrer, einsatzgebiet, 
				ausruestung, ausstattung);
		setBeschreibung("Der Infektions-Rettungswagen ist speziell fuer den Transport von \n  "
				+ "Patienten mit hoch ansteckenden, lebensbedrohlichen Erkrankungen ausgelegt.");
		setPersonalBesatzung(ErlaubtesBesatzung.INFEKTIONSRETTUNGSWAGEN.getBesatzung());
	}
	
	@Override
	public String toString() {
		return "[Infektionsrettungswagen] \n" + super.toString();
	}

	@Override
	public void benutzeBenzin() {
		// TODO Auto-generated method stub
		
	}
	
}
