# Exercise 3 — `Comparable` me klasën `Student`

## Detyrë

- Krijoni klasën `Student` që implementon `Comparable<Student>`.
- Krahasimi të bëhet sipas emrit.
- Merrni 5 emra nga përdoruesi, krijoni 5 objekte `Student`.
- Me `compareTo`, gjeni studentin e parë dhe të fundit alfabetikisht.

## Zgjidhja

- `Student.compareTo` përdor krahasim alfabetik (`compareToIgnoreCase`).
- Programi lexon 5 emra dhe llogarit minimumin/maksimumin sipas rendit natyral.
