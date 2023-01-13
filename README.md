# Projektaufgabe Fahrzeugverwaltung 
## Was wollen Sie konkret machen?

Rettungsfahrzeuge verwalten für das DRK.
## Welche Funktionen muss / soll das Programm haben?

  - Fahrzeug anlegen und löschen
  - Fahrzeuge sortieren nach verschieden kriterien
  - Fahrzeuge in einer Datei abspeichern
  - Kosten für 1x Tanken und Informationen über die Benzin art ausgeben.
  - Ausgaben:
      - Vorhandene angelegte Fahrzeuge ausgeben
      - Alle Infos über ein beliebiges Fahrzeug ausgeben lassen
## Wie sieht die grobe Architektur aus?

  - **Hauptklassen**
    - Anwendung
    - ErstellungNeuesFahrzeug
    - Fahrzeug (abstract)
      - Einsatzfuehrungsdienst
      - Infektionsrettungswagen 
      - Krankentransportwagen 
      - Notarzteinsatzfahrzeug 
      - Rettungswagen
    - Sortiermaschine
    - Verwaltung Benzin
    - AusgabeException
      
  - **Enums**
    - EFDKategorien
    - Einsatzgebiet
    - ErlaubteBesatzung
    - ErlaubteFahrer
    - GroesseTank
## Wie sieht Ihre grobe Zeitplanung aus?

  - ~~07.12.22 – 14.12.22: Aufgabenbeschreibung~~
  - ~~14.12.22 – 21.12.22: Programmierstart – Grundgerüst (Grundklassen, Methoden …)~~
  - ~~21.12.22 – 11.01.22: Verknüpfungen untereinander, Interaktions-Terminal (Main Class)~~
  - 11.01.22 – 15.01.22: Verfeinerung, Prüfen ob noch Exceptions fehlen
  - 16.01.22: Abgabe des Projekts

## Authors

- [@NiklasW31](https://www.github.com/NiklasW31)
- [@Monstershadow](https://www.github.com/Monstershadow)

