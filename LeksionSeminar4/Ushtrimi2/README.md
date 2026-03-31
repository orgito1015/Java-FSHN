# Ushtrimi 2 — JLabel, JButton dhe Menu Look & Feel

## Detyrë

Të krijohet një aplikacion i thjeshtë me një **JLabel**, një **JButton** dhe një menu **"Ndrysho Pamjen"** për ndryshimin e pamjes. Paraprakisht label ka një tekst default. Në klikim të butonit të ndryshojë teksti në label. Menu-ja ka 3 nënmenu: **Metal**, **System**, **FlatLaf**.

## Skedarët

| Skedar | Përshkrim |
|--------|-----------|
| `Ushtrimi2.java` | Aplikacion Swing me JLabel, JButton dhe JMenuBar për Look & Feel |

## Çfarë demonstron kodi

- Ndërtimi i `JMenuBar` / `JMenu` / `JMenuItem`
- `UIManager.setLookAndFeel()` për ndryshimin e pamjes vizuale
- `SwingUtilities.updateComponentTreeUI()` për aplikim të pamjes pa rihapje
- Trajtim `Exception` kur FlatLaf nuk është i disponueshëm

> **Shënim:** FlatLaf kërkon bibliotekën e jashtme `flatlaf.jar` (com.formdev:flatlaf). Nëse mungon, shfaqet mesazh gabimi me `JOptionPane`.

## Si ekzekutohet

```bash
javac Ushtrimi2.java
java Ushtrimi2
```
