package projektaufgabe;

import java.util.Comparator;

public class Sortiermaschine 
{
	public static Comparator<Fahrzeug> KennzeichenComparator = new Comparator<Fahrzeug>() 
	{
		@Override
		public int compare (Fahrzeug o1, Fahrzeug o2) {
			return (int) (o1.getKennzeichen().compareTo(o2.getKennzeichen()));
		}
	};
	
//	public static Comparator<Fahrzeug> GroesseComparator = new Comparator<Fahrzeug>() 
//	{
//		@Override
//		public int compare(Fahrzeug o1, Fahrzeug o2) {
//			return 0; 
//		}
//		
//	};
	
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
