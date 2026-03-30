# Ushtrimi 1 — Kontroll Pozitiv/Negativ

## Detyrë

Krijoni një aplikacion në JAVA që merr nga përdoruesi në një textField një numër. Në klik të një butoni tregoni nëse numri është **pozitiv** apo **negativ**.

## Skedarët

| Skedar | Përshkrim |
|--------|-----------|
| `Ushtrimi1.java` | Aplikacion Swing me JTextField, buton dhe JLabel rezultati |

## Çfarë demonstron kodi

- Lexim inputi numerik nga `JTextField`
- Konvertim `String` → `int` me `Integer.parseInt()`
- Trajtim gabimi me `try/catch` për `NumberFormatException`
- Kontroll me `if/else if/else` për pozitiv, negativ, zero
- Shfaqje rezultati në `JLabel`

## Si ekzekutohet

```bash
javac Ushtrimi1.java
java Ushtrimi1
```
