package hauptklassen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import enums.GroesseTank;

/**
 * Die Klasse uebernimmt vollstaendig das Verwalten des Benzins.
 */
public class VerwaltungBenzin 
{
	private static Scanner scanner = new Scanner(System.in);
	private static String benzinArt = "";
	private static float superPreis = 0;
	private static float dieselPreis = 0;

	//Auswahl der Aktion mit Benzin
	public static void benzinVerwaltung() 
	{
		FileReader fr = null;
		BufferedReader br = null;
		
		//speichere Benzinpreise in Textdatei
		try {
			fr = new FileReader("Benzin.Preise");
			br = new BufferedReader(fr);

			superPreis = Float.valueOf(br.readLine());
			dieselPreis = Float.valueOf(br.readLine());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		boolean schleife = true;
		while (schleife) 
		{	
			System.out.println("Welche Aktionen moechten sie mit dem Benzin ausfuehren: \n"
					+ "1. Die Benzin-Informationen anzeigen. \n"
					+ "2. Den Standardpreis aendern. \n"
					+ "3. Vorgang beenden.");

			switch (scanner.next()) 
			{
				case "1":
					System.out.println("Von welcher Fahrzeugart moechten Sie die Informationen ansehen: \n"
							+ "... 1 - Rettungswagen \n"
							+ "... 2 - Notarzteinsatzfahrzeug \n" 
							+ "... 3 - Krankentransportwagen \n"
							+ "... 4 - Infektionsrettungswagen \n" 
							+ "....... Einsatzfuehrungsdienst(EFD) \n"
							+ "\t 5 - Kommandowagen \n" 
							+ "\t 6 - Einsatzleitwagen \n" 
							+ "\t 7 - Personenwagen");
					
					try {
						benzinInfos(scanner.next());
					} catch (InputMismatchException e) {
						System.err.println("Ungueltige eingabe: " + e);
						scanner.next();
					}
					break;

				case "2":
					try {
						FileWriter fw = new FileWriter("Benzin.Preise");
						BufferedWriter bw = new BufferedWriter(fw);

						System.out.println("Welchen Preis moechten sie aendern: \n"
								+ "... 1 - Super \n"
								+ "... 2 - Diesel");

						switch (scanner.next()) {
							case "1":
								try {
									System.out.print("Bitte gebe einen neuen Durchschnittspreis fuer Super ein: ");
									float superPreisFloat = scanner.nextFloat();
									String superPreisNeu = Float.toString(superPreisFloat);
									String dieselPreisAlt = Float.toString(dieselPreis);

									br.readLine();
									bw.write(superPreisNeu);
									bw.newLine();
									bw.write(dieselPreisAlt);

									// reader/writer werden geschlossen
									bw.close();
									fw.close();
									br.close();
									fr.close();
								} catch (Exception e) {
									System.err.println(e);
								}
								break;
							
							case "2":
								try {
									System.out.print("Bitte gebe einen neuen Durchschnittspreis fuer Diesel ein: ");
									float dieselPreisFloat = scanner.nextFloat();
									String dieselPreisNeu = Float.toString(dieselPreisFloat);
									String superPreisAlt = Float.toString(superPreis);

									br.readLine();
									bw.write(superPreisAlt);
									bw.newLine();
									bw.write(dieselPreisNeu);

									// reader/writer werden geschlossen
									bw.close();
									fw.close();
									br.close();
									fr.close();
								} catch (Exception e) {
									System.err.println(e);
								}
								break;

							default:
								System.out.println("Ungueltige eingabe.");
						}

					} catch (IOException e) {
						System.err.println(e);
					}
					break;

				case "3":
					schleife = false;
					break;

				default:
					System.out.println("Ungueltige Eingabe! \nBitte geben sie eine gueltige Nummer ein.\n");
					break;
			}
		}
	}

	// Zuweisung und Ausgabe der Benzin-Informationen
	private static void benzinInfos(String str) 
	{
		String f = "";
		float preis = 0;
		
		switch (str) 
		{
			case "1":
				f = "Rettungswagen";
				benzinArt = "Diesel";
				preis = dieselPreis;
				break;

			case "2":
				f = "Notarzteinsatzfahrzeuge";
				benzinArt = "Diesel";
				preis = dieselPreis;
				break;

			case "3":
				f = "Krankentransportwagen";
				benzinArt = "Diesel";
				preis = dieselPreis;
				break;

			case "4":
				f = "Infektionsrettungswagen";
				benzinArt = "Diesel";
				preis = dieselPreis;
				break;

			case "5":
				f = "EFD-Kommandowagen";
				benzinArt = "Super";
				preis = superPreis;
				break;

			case "6":
				f = "EFD-Einsatzleitwagen";
				benzinArt = "Diesel";
				preis = dieselPreis;
				break;

			case "7":
				f = "EFD-Personenwagen";
				benzinArt = "Super";
				preis = superPreis;
				break;
		}

		System.out.println("~~~~~~~~~~~~~ Benzin Informatioenen ~~~~~~~~~~~~~~ \n"
				+ "> Fahrzeugtyp: Alle " + f + ". \n"
				+ "> Das zu benutzende Benzin ist " + benzinArt + ". \n"
				+ "> Der Tank hat eine Kapazitaet von " + einfuegenTank(str) + " Liter. \n"
				+ "> Der Standardpreis fuer " + benzinArt + " liegt bei " + preis + " Euro. \n"
				+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
	}

	//Zuweisung der Tankgroesse
	private static int einfuegenTank(String str) {
		int t = 0;

		try {
			if (str.equals("1")) {
				t = GroesseTank.SPRINTER.getWert();
			} else if (str.equals("2")) {
				t = GroesseTank.VITO.getWert();
			} else if (str.equals("3")) {
				t = GroesseTank.SPRINTER.getWert();
			} else if (str.equals("4")) {
				t = GroesseTank.SPRINTER.getWert();
			} else if (str.equals("5")) {
				t = GroesseTank.PKW.getWert();
			} else if (str.equals("6")) {
				t = GroesseTank.SPRINTER.getWert();
			} else if (str.equals("7")) {
				t = GroesseTank.PKW.getWert();
			}
		} catch (Exception e) {
			System.out.println("Tankgroesse konnte nicht ermittelt werden!");
		}
		return t;
	}
}
