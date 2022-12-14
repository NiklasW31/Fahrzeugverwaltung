Was wollen Sie konkret machen?
Rettungsfahrzeuge verwalten für das DRK.

Welche Funktionen muss / soll das Programm haben?
  - Fahrzeug allgemein: anlegen und löschen
  - Besatzung, Größe (höhe, breite, länge), Kennzeichen, Sirenen (Anzahl & Sound?), Leistung, Einsatzgebiet, Baujahr, Modell, Grundausstattung, Benzin, Funkruf Name
  - Rettungsfahrzeuge Kategorien:
      - Typ A: (A1, A2) Krankenwagen, geeignet für den Transport liegender Patienten
      - Typ B: Notfallkrankenwagen
      - Typ C: Rettungswagen
  - Modelle der Fahrzeuge
  - Ausrüstung der Fahrzeuge je nach Kategorie
  - berechtigte Personen und Führerschein
  - Kosten: Fahrzeug an sich; Reinigung; Ausrüstung; Benzin; Überholung
  - bei Einsatz: Fahrzeuge bewegen und wieder einsammeln; Standardauslauf festlegen

  - vergleich von Fahrzeugen oder Kategorien untereinander
  - //ob z.B. 2 Wagen der Kategorie B, 1 Wagen der Kategorie A ungefähr ausgleichen 
  - //können. Mit allem Drum und Dran -> NICE TO HAVE
  
  - Ausgaben
  - Vorhandene Modelle ausgeben
  - Vorhandene angelegte Fahrzeuge ausgeben
  - Allgemeine Infos über beliebiges Fahrzeug ausgeben lassen
  - Die Möglichkeit zum vergleichen // NICE TO HAVE
  - Die Möglichkeit Daten einzugeben und ein/mehrere passende Wagen 
  - berechnen und ausgeben //NICE TO HAVE


Wie sieht die grobe Architektur aus?

>Package: 
  - projektaufgabe
  
>Grundklassen:
  - Fahrzeug (abstract)
  - FahrzeugKategorieA (abstract)
  - FahrzeugKategorieB (abstract)
  - FahrzeugKategorieC (abstract)
  - Ausgaben

  - abstract Beschreibung; //Eigenschaften & Details zum Wagen
  - abstract Modelle
  - abstract Größe
  - abstract Ausrüstung; //vielleicht abstract variable List
  - abstract Leistung
  - abstract Grundausstattung

>Enums:
  - Unter Kategorien (Enum);
  - Einsatzgebiet (Enum);
  - Erlaubtes Personal/Besatzung (Enum);
  - Erlaubte Fahrer? (Enum);

>Interfaces:
  - (interface)Benzin;
  - (interface)Kosten;
  - (interface)Reinigung;
  
Wie sieht Ihre grobe Zeitplanung aus?
  - 07.12.22 – 14.12.22: Aufgabenbeschreibung.
  - 14.12.22 – 21.12.22: Programmierstart – Grundgerüst (Grundklassen, Methoden …)
  - 21.12.22 – 11.01.22: Verknüpfungen untereinander, Interaktions-Terminal (Main Class)
  - 11.01.22 – 16.01.22: Verfeinerung, Prüfen ob noch Exceptions fehlen, nice to have liste abarbeiten (falls noch Zeit ist.) 
