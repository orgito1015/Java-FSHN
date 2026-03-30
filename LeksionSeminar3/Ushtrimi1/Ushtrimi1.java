import javax.swing.*;
import java.awt.event.*;

/**
 * Seminar 3 — Ushtrimi 1: Kontroll Pozitiv/Negativ
 *
 * Detyrë:
 * - Krijoni një aplikacion në JAVA që merr nga përdoruesi në një textField
 *   një numër. Në klik të një butoni tregoni nëse numri është pozitiv apo negativ.
 *
 * Shpjegim:
 * - JTextField merr inputin nga përdoruesi si tekst.
 * - Integer.parseInt() konverton vargun në numër të plotë.
 * - try/catch kap NumberFormatException nëse inputi nuk është numër.
 * - Kontrolli n > 0 / n < 0 / n == 0 përcakton tipin e numrit.
 * - Rezultati shfaqet në JLabel poshtë butonit.
 */
public class Ushtrimi1 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kontrollo Numrin");

        JLabel lblFushe = new JLabel("Jepni nje numer:");
        JTextField tfNumri = new JTextField();
        JButton btnKontrollo = new JButton("Kontrollo");
        JLabel lblRezultati = new JLabel("", SwingConstants.CENTER);

        lblFushe.setBounds(20, 30, 130, 25);
        tfNumri.setBounds(160, 30, 120, 25);
        btnKontrollo.setBounds(110, 80, 120, 30);
        lblRezultati.setBounds(20, 130, 260, 25);

        frame.add(lblFushe);
        frame.add(tfNumri);
        frame.add(btnKontrollo);
        frame.add(lblRezultati);

        frame.setSize(320, 210);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnKontrollo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(tfNumri.getText().trim());
                    if (n > 0) {
                        lblRezultati.setText("Numri " + n + " eshte pozitiv.");
                    } else if (n < 0) {
                        lblRezultati.setText("Numri " + n + " eshte negativ.");
                    } else {
                        lblRezultati.setText("Numri eshte zero.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Ju lutem jepni nje numer te plote!",
                            "Gabim", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
