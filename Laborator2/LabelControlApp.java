import javax.swing.*;
import java.awt.event.*;

/**
 * Ushtrimi 4 — Kontrolli i Label-it
 *
 * Detyrë:
 * - Butoni "Fshi"   → fshin tekstin e label-it
 * - Butoni "Rifillo" → rikthen tekstin origjinal të label-it
 *
 * Shpjegim:
 * - JLabel ruan tekstin e tij; setText("") e fshin.
 * - Teksti origjinal ruhet në konstantën TEKST_ORIGJINAL dhe
 *   butoni "Rifillo" e rikthen atë me setText().
 * - Dy ActionListener të ndryshëm i trajtojnë butonat individualë.
 */
public class LabelControlApp {

    private static final String TEKST_ORIGJINAL = "Mirë se vini në sistemin tonë!";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kontrolli i Label-it");

        JLabel lbl = new JLabel(TEKST_ORIGJINAL, SwingConstants.CENTER);
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
                lbl.setText(TEKST_ORIGJINAL);
            }
        });
    }
}
