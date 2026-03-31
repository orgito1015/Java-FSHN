# Ushtrimi 5 — Loja "Gjej Numrin"

## Detyrë

Të krijohet një aplikacion GUI për lojën **"Gjej Numrin"**:

- Programi zgjedh rastësisht një numër nga **1 deri në 100**.
- Përdoruesi fut supozime në `JTextField` dhe klikon **"Provo"**.
- Pas çdo përpjekjeje `JLabel` tregon nëse numri është **më i madh** apo **më i vogël**.
- Kur numri gjendet, shfaqet mesazh suksesi me `JOptionPane`.
- Butoni **"Lojë e re"** gjeneron numër të ri dhe rifillon lojën.
- Shfaqet numri i **përpjekjeve** të bëra.
- Nëse inputi nuk është numerik, shfaqet gabim me `JOptionPane`.

## Skedarët

| Skedar | Përshkrim |
|--------|-----------|
| `Ushtrimi5.java` | Aplikacion Swing për lojën "Gjej Numrin" me feedback dhe numërim |

## Çfarë demonstron kodi

- `Random.nextInt(100) + 1` për gjenerim numri të rastësishëm
- `Integer.parseInt()` me `try/catch` për validim inputi numerik
- Ndryshim dinamik i tekstit dhe ngjyrës së `JLabel` për feedback
- `JOptionPane.showMessageDialog()` për mesazhe suksesi/gabimi
- `ActionListener` i njëjti i lidhur me `JTextField` (Enter) dhe `JButton`

## Si ekzekutohet

```bash
javac Ushtrimi5.java
java Ushtrimi5
```
