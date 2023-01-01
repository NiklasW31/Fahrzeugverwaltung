package hauptklassen;

import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.Einsatzgebiet;
import interfaces.Fahrzeugzusatz;

public class Rettungswagen extends Fahrzeug implements Fahrzeugzusatz
{
	private static final long serialVersionUID = 3121374339826972330L;
	
	public Rettungswagen (String modell, int baujahr, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groesse, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> ausstattung, List<String> standardausruestung) {
		super (modell, baujahr, kennzeichen, funkrufname, leistung, groesse, erlaubteFahrer, einsatzgebiet, 
				ausstattung, standardausruestung);
		setBeschreibung("Der RTW soll bei Notfallpatienten die Erstversorgung \n   "
				+ "sicherstellen, die Patienten transportfaehig machen und sie daraufhin \n   "
				+ "waerend des Transports ueberwachen.");
	}
	
//	Standardgrundaustattung:
//		Notfallkoffer
//		Beatmungsrucksack
//		Notfalltasche Kind
//		Notfalltasche Trauma
//		Absaugpumpe Accuvac
//		Schaufeltrage
//		Fahrtrage Styker
//		Corpuls C3
//		Weimann Medumat Standard 2
//		Spineboard

//	Standardausrüstung: Luftfederung, Rückfahrkamera, LED-Innenbeleuchtung, LED-Außenbeleuchtung
	
	@Override
	public String toString() {
		return "[Rettungswagen] \n" + super.toString();
	}
	
	@Override
	public void benutzeBenzin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void anzahlKosten() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double berechenAlleKosten() {
		// TODO Auto-generated method stub
		return 0;
	}
}
