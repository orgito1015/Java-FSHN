# Ushtrimi 2 — Kopjimi i Tekstit midis TextArea-ve

## Detyrë

Krijoni një aplikacion në JAVA që përmban **dy textArea** dhe **një buton**. Në klik të butonit të kopjohet teksti nga textArea e parë tek e dyta.

## Skedarët

| Skedar | Përshkrim |
|--------|-----------|
| `Ushtrimi2.java` | Aplikacion Swing me dy JTextArea dhe buton kopjimi |

## Çfarë demonstron kodi

- Krijim dhe konfigurim i `JTextArea`
- Mbështjellje me `JScrollPane` për lëvizje vertikale
- Bllokimi i editimit me `setEditable(false)` në textArea të dytë
- Kopjim teksti me `getText()` dhe `setText()`
- Trajtim eventi të butonit me `ActionListener`

## Si ekzekutohet

```bash
javac Ushtrimi2.java
java Ushtrimi2
```
