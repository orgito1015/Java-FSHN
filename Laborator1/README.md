# Laborator 1 — Laboratory Exercises

## Overview

This folder contains **Laboratory 1** exercises for the Java course at FSHN. The exercises focus on writing static methods and designing object-oriented classes in Java.

The full exercise descriptions are also available in `Ushtrime Laboratori 1.pdf`.

## Exercises

### Exercise 1 — Email Dot Check
- Write a static method `perfshinPiken(String email)` that takes an email address as a parameter and returns `true` if it contains a dot (`.`), otherwise `false`.
- Test the method in `main` with several examples.

### Exercise 2 — Weather Category
- Write a static method `kategoriaEMotit(char kodi)` that takes a character code and returns a weather description:
  - `'S'` → "Diell" (Sunny)
  - `'R'` → "Shi" (Rain)
  - `'C'` → "Vranësira" (Cloudy)
  - `'W'` → "Erë" (Wind)
  - `'N'` → "Borë" (Snow)
  - Any other character → "Kod i panjohur" (Unknown code)
- **Bonus:** The method should also work with lowercase letters.

### Exercise 3 — Count Digits Below Four
- Write a method `numeroShifratNenKater(int n)` that returns the count of digits in `n` that are less than 4 (i.e., 0, 1, 2, or 3).
- Example: `n = 15270` → result is `3` (digits 1, 2, and 0 are < 4).

### Exercise 4 — Project Management Class
- Implement a class `MenaxhimProjekti` with attributes: project name (`String`), total budget (`double`), and a list of team members (`ArrayList<String>`).
- Include:
  - Parameterized and no-argument constructors
  - Getter and setter methods for all fields
  - A method `isProjektIMadh()` that returns `true` if the budget exceeds 50,000 Euro
- Build a test class that creates an object and adds several team members.

### Exercise 5 — Gym Membership Class
- Implement a class `AnetaresiaPalestres` with attributes: client name (`String`), registration year (`int`), and a list of planned exercises (`ArrayList<String>`).
- Include:
  - Parameterized and no-argument constructors
  - Getter and setter methods
  - A method `isAnetarBesnik()` that returns `true` if the client has been registered for at least 3 years (reference year: 2026)
  - A method `shtoUshtrim(String ushtrim)` that adds a new exercise to the list
- Build a test class.

## Concepts Demonstrated

- Static methods
- String and character manipulation
- Control flow (`if`/`switch`)
- Object-oriented programming: classes, constructors, getters/setters
- `ArrayList` usage
