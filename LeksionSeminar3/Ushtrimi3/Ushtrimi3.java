import javax.swing.*;
import java.awt.event.*;

/**
 * Seminar 3 — Ushtrimi 3: Numërim i Karakterit në Tekst
 *
 * Detyrë:
 * - Shkruani një aplikacion në JAVA që merr një rresht me tekst dhe një
 *   karakter nëpërmjet dy fushave tekst dhe në klikim të një butoni gjen
 *   sa herë ndodhet ky karakter në tekst.
 *
 * Shpjegim:
 * - Dy JTextField: njëra për tekstin, tjetra për karakterin.
 * - Validohet që fusha e karakterit të ketë saktësisht 1 shkronjë.
 * - Cikli for kalon nëpër çdo karakter të tekstit dhe numëron sa herë
 *   gjendet karakteri i dhënë.
 * - Rezultati shfaqet me JOptionPane.showMessageDialog().
 */
public class Ushtrimi3 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Numërim Karakteri");

        JLabel lblTekst = new JLabel("Teksti:");
        JTextField tfTekst = new JTextField();
        JLabel lblKarakter = new JLabel("Karakteri:");
        JTextField tfKarakter = new JTextField();
        JButton btnNumero = new JButton("Numero");
        JLabel lblRezultati = new JLabel("", SwingConstants.CENTER);

        lblTekst.setBounds(20, 30, 80, 25);
        tfTekst.setBounds(110, 30, 180, 25);
        lblKarakter.setBounds(20, 75, 80, 25);
        tfKarakter.setBounds(110, 75, 60, 25);
        btnNumero.setBounds(110, 120, 120, 30);
        lblRezultati.setBounds(20, 165, 280, 25);

        frame.add(lblTekst);
        frame.add(tfTekst);
        frame.add(lblKarakter);
        frame.add(tfKarakter);
        frame.add(btnNumero);
        frame.add(lblRezultati);

        frame.setSize(330, 230);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnNumero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tekst = tfTekst.getText();
                String karakterStr = tfKarakter.getText();

                if (karakterStr.length() != 1) {
                    JOptionPane.showMessageDialog(frame,
                            "Ju lutem jepni saktesisht nje karakter!",
                            "Gabim", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                char karakter = karakterStr.charAt(0);
                int count = 0;
                for (int i = 0; i < tekst.length(); i++) {
                    if (tekst.charAt(i) == karakter) {
                        count++;
                    }
                }

                lblRezultati.setText("Karakteri '" + karakter
                        + "' u gjet " + count + " here ne tekst.");
            }
        });
    }
}
