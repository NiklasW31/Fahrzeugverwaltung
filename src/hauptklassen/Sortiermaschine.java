package hauptklassen;

import java.util.Comparator;

public class Sortiermaschine 
{
//	try/catch einbauen??
	public static Comparator<Fahrzeug> KennzeichenComparator = new Comparator<Fahrzeug>() 
	{
		@Override
		public int compare (Fahrzeug o1, Fahrzeug o2) {
			return (int) (o1.getKennzeichen().compareTo(o2.getKennzeichen()));
		}
	};
	
	public static Comparator<Fahrzeug> GroesseComparator = new Comparator<Fahrzeug>() 
	{
		@Override
		public int compare(Fahrzeug o1, Fahrzeug o2) {
			return (int) (o1.getGroese().get("Laenge") - o2.getGroese().get("Laenge")); 
		}
		
	};
	
	public static Comparator<Fahrzeug> LeistungComparator = new Comparator<Fahrzeug>() 
	{
		@Override
		public int compare (Fahrzeug o1, Fahrzeug o2) {
			return (int) (o1.getLeistung() - o2.getLeistung());
		}
	};
	
	public static Comparator<Fahrzeug> EinsatzgebietComparator = new Comparator<Fahrzeug>() 
	{
		@Override
		public int compare (Fahrzeug o1, Fahrzeug o2) {
			return (int) (o1.getEinsatzgebiet().compareTo(o2.getEinsatzgebiet()));
		}
	};
	
	
}
