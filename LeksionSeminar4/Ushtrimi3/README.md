# Ushtrimi 3 — JTextArea me Menu dhe Numërim Karakteresh

## Detyrë

Të krijohet një aplikacion që përmban një **JTextArea** për shkrim teksti dhe një **JScrollPane**. Të krijohet një menu me këto opsione:

- **File**: Clear (pastron tekstin), Exit
- **Format**: Uppercase, Lowercase
- **Look & Feel**: Metal, System

Në një **JLabel** shfaq numrin e karaktereve të shkruara në JTextArea.

## Skedarët

| Skedar | Përshkrim |
|--------|-----------|
| `Ushtrimi3.java` | Aplikacion Swing me JTextArea, JMenuBar dhe numërim karakteresh |

## Çfarë demonstron kodi

- `DocumentListener` për numërim karakteresh në kohë reale
- Ndërtim i menuve me `JMenuBar` / `JMenu` / `JMenuItem`
- `UIManager.setLookAndFeel()` dhe `SwingUtilities.updateComponentTreeUI()`
- `BorderLayout` me `JScrollPane` dhe `JLabel` në `SOUTH`

## Si ekzekutohet

```bash
javac Ushtrimi3.java
java Ushtrimi3
```
