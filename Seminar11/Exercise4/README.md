# Exercise 4 — Kërkimi në një listë kontaktesh

## Detyrë

- Ruani në një array 1000 emra + numra telefoni të gjeneruar rastësisht.
- Lejoni kërkimin:
  1. sipas emrit (pas renditjes alfabetike sipas emrit, duke ruajtur lidhjen emër–numër),
  2. sipas numrit të telefonit (numrat nuk janë të renditur numerikisht, por sipas renditjes së emrave).

## Zgjidhja

- Krijohen 1000 objekte `Contact` (`emri`, `numriTelefonit`).
- Array renditet me Selection Sort sipas emrit.
- Kërkimi sipas emrit bëhet me Binary Search.
- Kërkimi sipas numrit bëhet me kërkim linear, sepse numrat nuk janë të renditur numerikisht.
