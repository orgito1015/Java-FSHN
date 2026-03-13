# Ushtrimi 2 — Form Input Exercise (AWT and Swing)

## Overview

This folder contains two programs that build a simple form with a text field, a label, and a button. One version uses **AWT** and the other uses **Swing**. When the user clicks the button, the name entered in the text field is displayed in a label.

## Files

| File | Description |
|------|-------------|
| `Ushtrimi1_AWT.java` | Form input exercise implemented with AWT |
| `Ushtrimi1_Swing.java` | Same form input exercise implemented with Swing |

## What the Code Demonstrates

- Creating a form with a text field, label, and button
- Implementing `ActionListener` to handle button click events
- Reading text from a `TextField` / `JTextField`
- Displaying the input in a `Label` / `JLabel`
- Layout management using absolute positioning (`setLayout(null)` and `setBounds(...)`)

## How to Run

```bash
# AWT version
javac Ushtrimi1_AWT.java
java Ushtrimi1_AWT

# Swing version
javac Ushtrimi1_Swing.java
java Ushtrimi1_Swing
```
