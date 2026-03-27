# LeksionSeminar 1 — Lecture/Seminar 1

## Overview

This folder contains **Seminar 1** exercises for the Java course at FSHN.
The exercises focus on writing **static methods** covering mathematical operations,
string/character processing, and basic control flow.

## Files

| File | Description |
|------|-------------|
| `UshtrimiS1_1.java` | Temperature conversion: Celsius → Fahrenheit |
| `UshtrimiS1_2.java` | Determine whether a number is even or odd |
| `UshtrimiS1_3.java` | Compute the factorial of a non-negative integer |

## Exercises

### Exercise 1 — Temperature Conversion (Celsius → Fahrenheit)
- Write a static method `celsiusNeFahrenheit(double celsius)` that converts a
  temperature from Celsius to Fahrenheit using the formula **F = C × 9/5 + 32**.
- Test with: 0°C, 100°C, −40°C, 37°C.

**Key concepts:** arithmetic with doubles, static methods, `printf` formatting.

---

### Exercise 2 — Even or Odd (Çift apo Tek)
- Write `isCift(int n)` that returns `true` if `n` is even.
- Write `pershkruaj(int n)` that returns `"çift"` or `"tek"`.
- Test with positive, negative, and zero values.

**Key concepts:** modulo operator (`%`), ternary operator, boolean return values.

---

### Exercise 3 — Factorial (Faktorial)
- Write `faktorial(int n)` that computes `n!` (with the convention `0! = 1`).
- Return `-1` for negative input as an error indicator.
- Test with: 0, 1, 5, 10, −1.

**Key concepts:** iterative computation with `for`, `long` type for large results,
edge-case handling.

## How to Run

```bash
# Compile
javac UshtrimiS1_1.java

# Run
java UshtrimiS1_1
```

## Concepts Demonstrated

- Static method design
- Arithmetic expressions and type casting
- Boolean logic and the ternary operator
- Loops (`for`)
- Edge-case handling and error signalling
