import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Seminar 3 — Ushtrimi 4: Butona me FlowLayout
 *
 * Detyrë:
 * - Duke përdorur FlowLayout krijoni disa butona.
 * - Në klik të secilit buton afishoni mesazhin: "Ju klikuat _____".
 *
 * Shpjegim:
 * - FlowLayout është layout-i default i JPanel.
 * - Cikli for krijon butona dinamikisht bazuar në listën e emrave.
 * - Një ActionListener i vetëm trajton të gjithë butonat;
 *   e.getActionCommand() kthen tekstin e butonit të klikuar.
 * - JLabel në fund të dritares shfaq mesazhin.
 */
public class Ushtrimi4 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Butona FlowLayout");

        String[] emrat = {"Buton 1", "Buton 2", "Buton 3", "Buton 4", "Buton 5"};

        JPanel panelButona = new JPanel(new FlowLayout());
        JLabel lblMesazhi = new JLabel("Klikoni nje buton...", SwingConstants.CENTER);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblMesazhi.setText("Ju klikuat " + e.getActionCommand());
            }
        };

        for (String emri : emrat) {
            JButton btn = new JButton(emri);
            btn.addActionListener(al);
            panelButona.add(btn);
        }

        frame.add(panelButona, BorderLayout.CENTER);
        frame.add(lblMesazhi, BorderLayout.SOUTH);

        frame.setSize(400, 160);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
