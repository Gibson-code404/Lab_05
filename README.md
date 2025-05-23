# Lab 07 – Reverse Polish Notation Rechner (HTW Berlin)

## Aufgabe
In diesem Lab wurde ein vollständiger Taschenrechner auf Basis der umgekehrten polnischen Notation (Postfix) umgesetzt. Das Ziel war es, von der Implementierung grundlegender Datenstrukturen (Stack) bis zur Auswertung komplexer mathematischer Ausdrücke alles eigenständig in Java zu programmieren.

## Aufbau & Inhalt

### `stack/`
- Stack.java – eigene Stack-Implementierung mit generischen Typen auf Basis einer verketteten Liste.
- SimpleStack.java – Interface für Stack-Methoden (push, pop, top, isEmpty).
- Underflow.java – eigene Exception für Stack-Unterläufe.

### `scanner/`
- Zerlegt einen Infix-Ausdruck (z. B. 3 + 4 * (2 - 1)) in eine Liste von Tokens.

### `infix/`
- Infix.java – Wandelt einen Infix-Ausdruck in einen Postfix-Ausdruck um (Shunting-Yard-Algorithmus).

### `postfix/`
- Postfix.java – Berechnet das Ergebnis eines Postfix-Ausdrucks (z. B. 3 4 +) inklusive Gleitkommazahlen und Exponenten.

### `ui/`
- ConsoleApp.java – Benutzeroberfläche über die Konsole. Nimmt Infix-Ausdrücke entgegen, zeigt Postfix-Ausgabe und berechnetes Ergebnis an.

### `test/`
- Umfangreiche Tests mit JUnit 5 für Stack, Scanner, Infix-Umwandlung und Postfix-Auswertung.
- TestCases.java – Zentrale Sammlung von Testfällen mit Infix, Postfix und Ergebnissen.

## Ausführen

1. Projekt öffnen in IntelliJ
2. ConsoleApp.java ausführen
3. Beispiel:
   
   3 + 4 * (2 - 1)
   Postfix: 3 4 2 1 - * +
   Ergebnis: 7.00
   

## Testen

Alle Tests lassen sich in IntelliJ über Rechtsklick auf den Test-Ordner → Run Tests ausführen.

## Besonderheiten
- Keine Verwendung von Java Collections (LinkedList, Stack) – alles selbst implementiert.
- Unterstützung für Gleitkommazahlen und ^ (Exponent).
- Vollständig getestet (Unit-Tests, Edge Cases, Axiome für Stack).

## Autor
Niclas Affeld  
HTW Berlin – Internationale Medieninformatik  
Sommersemester 2025
