# Ushtrimi 4 — GUI për Porositjen e Picës

## Detyrë

Të krijohet një aplikacion GUI për porositjen e picës me:

- `JTextField` për emrin e klientit
- `JComboBox` për zgjedhjen e madhësisë (`E vogël`, `Mesatare`, `E madhe`)
- Tre `JCheckBox` për përbërës shtesë (`Djathë ekstra`, `Kërpudha`, `Oliva`)
- Dy `JRadioButton` për mënyrën e marrjes (`Në lokal`, `Me vete`)
- `JButton` "Përfundo porosinë"
- `JTextArea` për përmbledhjen e porosisë

Në klikim të butonit: kontrollohet emri, shfaqet përmbledhja, dhe nëse emri mungon shfaqet mesazh gabimi me `JOptionPane`.

## Skedarët

| Skedar | Përshkrim |
|--------|-----------|
| `Ushtrimi4.java` | Aplikacion Swing me formë porosie dhe JTextArea për përmbledhje |

## Çfarë demonstron kodi

- `JComboBox` për listë opsionesh
- `JCheckBox.isSelected()` për kontrollin e opsioneve shtesë
- `ButtonGroup` + `JRadioButton` për zgjedhje ekskluzive
- Validim inputi dhe mesazh gabimi me `JOptionPane`
- `StringBuilder` për ndërtim dinamik të tekstit

## Si ekzekutohet

```bash
javac Ushtrimi4.java
java Ushtrimi4
```
