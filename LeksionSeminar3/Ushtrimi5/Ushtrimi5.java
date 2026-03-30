import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Seminar 3 — Ushtrimi 5: Makinë Llogaritëse
 *
 * Detyrë:
 * - Ndërtoni një aplikacion në JAVA që krijon një makinë llogaritëse.
 *
 * Shpjegim:
 * - Ekrani shfaq inputin dhe rezultatin në JTextField.
 * - Butonat numerikë (0-9) dhe pika dhjetore shtojnë karaktere në ekran.
 * - Butonat e operacioneve (+, -, *, /) ruajnë operandin e parë dhe
 *   operacionin, pastaj pastrojnë ekranin për inputin e dytë.
 * - Butoni "=" llogarit rezultatin dhe e shfaq në ekran.
 * - Butoni "C" pastron ekranin dhe resetizon gjendjen.
 * - try/catch trajton gabimin e ndarjes me zero.
 */
public class Ushtrimi5 {

    private static double numri1 = 0;
    private static String operacioni = "";
    private static boolean inputiRi = true;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Makinë Llogaritëse");

        JTextField tfEkran = new JTextField("0");
        tfEkran.setEditable(false);
        tfEkran.setHorizontalAlignment(JTextField.RIGHT);
        tfEkran.setFont(new Font("Arial", Font.BOLD, 20));

        String[][] etiketat = {
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"0", ".", "=", "+"}
        };

        JPanel panelButona = new JPanel(new GridLayout(4, 4, 5, 5));

        for (String[] rresht : etiketat) {
            for (String etiketa : rresht) {
                JButton btn = new JButton(etiketa);
                btn.setFont(new Font("Arial", Font.PLAIN, 16));
                panelButona.add(btn);

                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String klikuar = e.getActionCommand();

                        if (klikuar.matches("[0-9]") || klikuar.equals(".")) {
                            if (inputiRi) {
                                tfEkran.setText(klikuar);
                                inputiRi = false;
                            } else {
                                if (klikuar.equals(".") && tfEkran.getText().contains(".")) {
                                    return;
                                }
                                tfEkran.setText(tfEkran.getText() + klikuar);
                            }
                        } else if (klikuar.equals("=")) {
                            double numri2 = Double.parseDouble(tfEkran.getText());
                            double rezultati = llogarit(numri1, numri2, operacioni);
                            if (Double.isInfinite(rezultati)) {
                                JOptionPane.showMessageDialog(frame,
                                        "Nuk mund te ndash me zero!",
                                        "Gabim", JOptionPane.ERROR_MESSAGE);
                                tfEkran.setText("0");
                            } else {
                                if (rezultati == Math.floor(rezultati)) {
                                    tfEkran.setText(String.valueOf((long) rezultati));
                                } else {
                                    tfEkran.setText(String.valueOf(rezultati));
                                }
                            }
                            operacioni = "";
                            inputiRi = true;
                        } else {
                            numri1 = Double.parseDouble(tfEkran.getText());
                            operacioni = klikuar;
                            inputiRi = true;
                        }
                    }
                });
            }
        }

        JButton btnC = new JButton("C");
        btnC.setFont(new Font("Arial", Font.BOLD, 16));
        btnC.setBackground(new Color(220, 80, 80));
        btnC.setForeground(Color.WHITE);
        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfEkran.setText("0");
                numri1 = 0;
                operacioni = "";
                inputiRi = true;
            }
        });

        JPanel panelEkran = new JPanel(new BorderLayout(5, 0));
        panelEkran.add(tfEkran, BorderLayout.CENTER);
        panelEkran.add(btnC, BorderLayout.EAST);

        frame.setLayout(new BorderLayout(5, 5));
        frame.add(panelEkran, BorderLayout.NORTH);
        frame.add(panelButona, BorderLayout.CENTER);

        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setSize(260, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static double llogarit(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b == 0 ? Double.POSITIVE_INFINITY : a / b;
            default:  return b;
        }
    }
}
