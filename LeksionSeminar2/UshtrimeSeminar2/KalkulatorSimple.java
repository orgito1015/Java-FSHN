import javax.swing.*;
import java.awt.event.*;

/**
 * UshtrimeSeminar2 — Ushtrimi 1: Kalkulator i Thjeshtë
 *
 * Detyrë:
 * - Krijo një kalkulator të thjeshtë me dy fusha input (JTextField)
 *   dhe katër butona: +, -, *, /.
 * - Shfaq rezultatin në një fushë të tretë jo të modifikueshme.
 * - Trajto ndarjen me zero me mesazh gabimi.
 *
 * Shpjegim:
 * - Double.parseDouble() konverton vargun e tekstit në numër.
 * - try/catch kap NumberFormatException kur inputi nuk është numër.
 * - Ndarje me zero kontrollohet eksplicitisht (b == 0) dhe shfaq gabim me
 *   JOptionPane.showMessageDialog().
 * - Një ActionListener i vetëm trajton të katër butonat duke lexuar
 *   e.getActionCommand() për të identifikuar cilin buton u klikua.
 */
public class KalkulatorSimple {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulator i Thjeshte");

        JLabel lbl1   = new JLabel("Numri 1:");
        JLabel lbl2   = new JLabel("Numri 2:");
        JLabel lblRez = new JLabel("Rezultati:");
        JTextField tf1   = new JTextField();
        JTextField tf2   = new JTextField();
        JTextField tfRez = new JTextField();
        JButton btnMbledh = new JButton("+");
        JButton btnZbrit  = new JButton("-");
        JButton btnShumez = new JButton("*");
        JButton btnPjeto  = new JButton("/");

        lbl1.setBounds(20, 20, 80, 25);
        tf1.setBounds(110, 20, 120, 25);
        lbl2.setBounds(20, 60, 80, 25);
        tf2.setBounds(110, 60, 120, 25);
        lblRez.setBounds(20, 100, 80, 25);
        tfRez.setBounds(110, 100, 120, 25);
        tfRez.setEditable(false);

        btnMbledh.setBounds(20,  150, 50, 30);
        btnZbrit.setBounds(85,   150, 50, 30);
        btnShumez.setBounds(150, 150, 50, 30);
        btnPjeto.setBounds(215,  150, 50, 30);

        frame.add(lbl1);   frame.add(tf1);
        frame.add(lbl2);   frame.add(tf2);
        frame.add(lblRez); frame.add(tfRez);
        frame.add(btnMbledh); frame.add(btnZbrit);
        frame.add(btnShumez); frame.add(btnPjeto);

        frame.setSize(300, 240);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        ActionListener calc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(tf1.getText().trim());
                    double b = Double.parseDouble(tf2.getText().trim());
                    double rez;
                    String op = e.getActionCommand();
                    switch (op) {
                        case "+": rez = a + b; break;
                        case "-": rez = a - b; break;
                        case "*": rez = a * b; break;
                        case "/":
                            if (b == 0) {
                                JOptionPane.showMessageDialog(frame,
                                        "Nuk mund te ndash me zero!",
                                        "Gabim", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            rez = a / b;
                            break;
                        default: return;
                    }
                    tfRez.setText(String.valueOf(rez));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Ju lutem jepni vlera numerike!",
                            "Gabim", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        btnMbledh.addActionListener(calc);
        btnZbrit.addActionListener(calc);
        btnShumez.addActionListener(calc);
        btnPjeto.addActionListener(calc);
    }
}
