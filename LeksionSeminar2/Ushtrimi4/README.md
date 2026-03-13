# Ushtrimi 4 — Running Sum Calculator

## Overview

This folder contains a **running sum calculator** built with Java Swing. The user enters a number and presses Enter; the program adds it to a running total and displays the updated sum. Invalid (non-numeric) input shows an error dialog.

## Files

| File | Description |
|------|-------------|
| `Ushtrimi4.java` | Swing-based sum calculator with input validation |

## What the Code Demonstrates

- Reading numeric input from a `JTextField` using `Double.parseDouble()`
- Accumulating a running sum across multiple inputs
- Handling invalid input with a `try/catch` block for `NumberFormatException`
- Displaying an error message using `JOptionPane.showMessageDialog()`
- Using an `ActionListener` on a `JTextField` (triggered by pressing Enter)

## How to Run

```bash
javac Ushtrimi4.java
java Ushtrimi4
```
