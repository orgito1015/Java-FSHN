# UshtrimeSeminar2 — Ushtrime Shtesë Seminar 2

## Përshkrimi

Ky dosje përmban ushtrime shtesë Swing të seminarit 2 të kursit Java — FSHN.

## Skedarët

| Skedar | Përshkrimi |
|--------|------------|
| `KalkulatorSimple.java` | Kalkulator i thjeshtë me +, -, *, / dhe trajtim gabimesh |
| `NgjyraPanel.java` | Ndërrues ngjyrash me panel dhe dy butona |

---

## Ushtrimi 1 — Kalkulator i Thjeshtë (`KalkulatorSimple.java`)

### Detyra
Krijo një kalkulator Swing me:
- Dy fusha `JTextField` për numrat e hyrjes
- Katër butona: `+`, `-`, `*`, `/`
- Një fushë `JTextField` jo-modifikueshme për rezultatin
- Trajtim të ndarjes me zero dhe input-it jo-numerik

### Shpjegimi i Kodit

```
[Numri 1 ]  [_____________]
[Numri 2 ]  [_____________]
[Rezultat]  [_____________]
  [+]  [-]  [*]  [/]
```

- `Double.parseDouble()` konverton tekst → numër
- `try/catch NumberFormatException` kap input jo-numerik
- `e.getActionCommand()` identifikon cilin buton u shtyp
- `b == 0` kontrollon ndarje me zero

### Si ta ekzekutosh

```bash
javac KalkulatorSimple.java
java KalkulatorSimple
```

---

## Ushtrimi 2 — Ndërrues Ngjyrash (`NgjyraPanel.java`)

### Detyra
Krijo një dritare me:
- Një panel qendror (`JPanel`) me sfond të bardhë
- Butoni **"E Kuqe"** → ngjyros sfondin e kuq
- Butoni **"E Kaltër"** → ngjyros sfondin kaltër

### Shpjegimi i Kodit

- `JPanel` — kontejner me sfond të ndryshueshëm
- `setBackground(Color.RED/BLUE)` — ndryshon ngjyrën
- `repaint()` — rivis panelin me ngjyrën e re
- `BorderLayout` — panel kryesor CENTER, butonat SOUTH

### Si ta ekzekutosh

```bash
javac NgjyraPanel.java
java NgjyraPanel
```

---

## Konceptet e Demonstruara

- Komponentë Swing: `JFrame`, `JPanel`, `JTextField`, `JButton`
- Layout: `BorderLayout` dhe `null` layout me `setBounds`
- Event handling: `ActionListener` i ndarë dhe i përbashkët
- Trajtim gabimesh: `try/catch`, `JOptionPane`
- Manipulimi i UI-t gjatë runtime: ngjyra, tekst
