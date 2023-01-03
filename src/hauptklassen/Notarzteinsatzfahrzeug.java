package hauptklassen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import enums.ErlaubteFahrer;
import enums.Einsatzgebiet;
import interfaces.Fahrzeugzusatz;

public class Notarzteinsatzfahrzeug extends Fahrzeug implements Fahrzeugzusatz
{	
	private static final long serialVersionUID = 1L;
	
	public Notarzteinsatzfahrzeug (String modell, int baujahr, String kennzeichen, String funkrufname, int leistung,
			Map<String, Double> groesse, ErlaubteFahrer erlaubteFahrer, Einsatzgebiet einsatzgebiet,
			List<String> ausstattung, List<String> standardausruestung) {
		super (modell, baujahr, kennzeichen, funkrufname, leistung, groesse, erlaubteFahrer, einsatzgebiet, 
				ausstattung, standardausruestung);
		setBeschreibung("Fuer den Transport, die Erstversorgung und Ueberwachung von Patienten.");
		
		ArrayList<String> ausruestung = new ArrayList<>();
		ausruestung.addAll(Arrays.asList("Beatmungsgeraet Weinmann Medumat Transport", "Notfallrucksack Atmung", "Notfallrucksack Kreislauf", "Notfallrucksack Baby",
				"Notfallrucksack Trauma", "EKG/Defi Corpuls C3", "Corpuls CPR Reanimationshilfe", "2x Spritzenpumpe Braun Perfusor Space", "Zusatztaschen NEF", "MANV Sets",
				"Absaugpumpe Weinmann Avccuvac", "Einsatz-Management-System: Convexis Connex"));
		setStandardausruestung(ausruestung);
		
	}
	
//	Standardgrundaustattung: 
//		Beatmungsgerät Weinmann Medumat Transport
//		Notfallrucksack Atmung
//		Notfallrucksack Kreislauf
//		Notfallrucksack Baby
//		Notfallrucksack Trauma
//		EKG/Defi Corpuls C3
//		Corpuls CPR Reanimationshilfe
//		2x Spritzenpumpe Braun Perfusor Space
//		Zusatztaschen NEF (Intox, Verbrennung, etc.)
//		MANV Sets
//		Absaugpumpe Weinmann Avccuvac
//		Einsatz-Management-System: Convexis Connex
//	-> Unterschiede: KET System

//Standardausrüstung: Automatikgetriebe, Allradantrieb, Schiebetüren beidseits, Rückfahrkamera

	
	@Override
	public String toString() {
		return "[Notartzeinsatzfahrzeug] \n" + super.toString();
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
