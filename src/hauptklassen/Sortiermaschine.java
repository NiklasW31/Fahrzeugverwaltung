package hauptklassen;

import java.util.Comparator;

public class Sortiermaschine 
{
	//Comparator nach Fahrzeugklasse!!
	
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
			return (int) (o1.getGroesse().get("Laenge") - o2.getGroesse().get("Laenge")); 
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
