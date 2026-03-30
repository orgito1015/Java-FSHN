import javax.swing.*;
import java.awt.event.*;

/**
 * Ushtrimi 4 — Kontrolli i Label-it
 *
 * Detyrë:
 * - Label me tekstin fillestar "Teksti fillestar"
 * - Butoni "Fshi"    → fshin tekstin e label-it (bëhet bosh)
 * - Butoni "Rifillo" → shfaq tekstin "Teksti u rikthye"
 *
 * Shpjegim:
 * - JLabel ruan tekstin e tij; setText("") e fshin.
 * - Butoni "Rifillo" vendos tekstin "Teksti u rikthye" me setText().
 * - Dy ActionListener të ndryshëm i trajtojnë butonat individualë.
 */
public class LabelControlApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kontrolli i Label-it");

        JLabel lbl = new JLabel("Teksti fillestar", SwingConstants.CENTER);
        lbl.setBounds(20, 40, 360, 30);

        JButton btnFshi    = new JButton("Fshi");
        JButton btnRifillo = new JButton("Rifillo");
        btnFshi.setBounds(60, 110, 100, 30);
        btnRifillo.setBounds(240, 110, 100, 30);

        frame.add(lbl);
        frame.add(btnFshi);
        frame.add(btnRifillo);

        frame.setSize(420, 210);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnFshi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl.setText("");
            }
        });

        btnRifillo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl.setText("Teksti u rikthye");
            }
        });
    }
}
