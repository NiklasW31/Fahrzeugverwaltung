package projektaufgabe;

import java.util.Comparator;

public class Sortiermaschine 
{
	public static Comparator<Fahrzeug> LeistungComparator = new Comparator<Fahrzeug>() 
	{
		@Override
		public int compare (Fahrzeug o1, Fahrzeug o2) {
			return (int) (o1.getLeistung() - o2.getLeistung());
		}
	};
	
	//wird zu HashMap
	public static Comparator<Fahrzeug> GroesseComparator = new Comparator<Fahrzeug>() 
	{
		@Override
		public int compare (Fahrzeug o1, Fahrzeug o2) {
			return (int) (o1.getGroese() - o2.getGroese());
		}
	};
	
//	public static Comparator<Fahrzeug> FuehrerscheinComparator = new Comparator<Fahrzeug>() 
//	{
//		@Override
//		public int compare (Fahrzeug o1, Fahrzeug o2) {
//			return (int) (o1.getErlaubteFahrer().compareTo(o2.getErlaubteFahrer()));
//		}
//	};
	
}
