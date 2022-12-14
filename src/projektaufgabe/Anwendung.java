package projektaufgabe;

import java.util.Scanner;

public class Anwendung //Main-Terminal
{
	public static void main(String[] args) 
	{	
		//Auswahl der Aktion
		System.out.println("Was moechten Sie tun? :");
		System.out.println("1. Gebe eine Liste aller Fahrzeuge aus.");
		System.out.println("2. Gebe Informationen über ein Fahrzeug aus.");
		System.out.println("3. Erstelle ein Fahrzeug");
		System.out.println("4. Lösche ein Fahrzeug");
		System.out.println("5. Vergleiche Fahrzeuge");
		
		Scanner scanner = new Scanner(System.in);
		int eingabe = scanner.nextInt();	
		
		switch(eingabe) 
		{
			case 1:
				//Gebe eine Liste aller Fahrzeuge aus
				break;
			case 2:
				//Gebe Informationen über ein Fahrzeug aus
				break;
			case 3:
				//Erstelle ein Fahrzeug
				break;
			case 4:
				//Lösche ein Fahrzeug
				break;
			case 5:
				//Vergleiche Fahrzeuge
				break;
				
			default:
				//Exeption oder simple nachricht
				break;
		}
		
	}

}
