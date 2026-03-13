# Ushtrimi 1 — Basic GUI Window Examples

## Overview

This folder contains two example programs that demonstrate how to create a simple graphical window in Java, one using **AWT** and one using **Swing**.

## Files

| File | Description |
|------|-------------|
| `Shembull1.java` | Creates a basic AWT window with a centered greeting label |
| `Shembull1_Swing.java` | Creates the same window using Swing components |

## What the Code Demonstrates

- **`Shembull1.java` (AWT):**
  - Uses `Frame` and `Label` from the `java.awt` package
  - Sets the window size and makes it visible
  - Adds a `WindowListener` to close the application when the window is closed

- **`Shembull1_Swing.java` (Swing):**
  - Uses `JFrame` and `JLabel` from the `javax.swing` package
  - Achieves the same result with less code
  - Uses `setDefaultCloseOperation` instead of a manual `WindowListener`

## How to Run

```bash
# AWT version
javac Shembull1.java
java Shembull1

# Swing version
javac Shembull1_Swing.java
java Shembull1_Swing
```
