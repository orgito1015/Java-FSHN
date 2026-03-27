import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Ushtrimi 3 — Input Emër dhe Mbiemër
 *
 * Detyrë:
 * - Merr input nga përdoruesi për emrin dhe mbiemrin
 * - Validon nëse ndonjë fushë është bosh
 * - Shfaq mesazhin: "Miredita, [Emri] [Mbiemri]! Pune te mbare."
 *
 * Shpjegim:
 * - JTextField përdoret për input teksti nga përdoruesi.
 * - String.trim() heq hapësirat boshe nga fillimi dhe fundi.
 * - String.isEmpty() kontrollon nëse vargu është bosh pas trim.
 * - Kur klikohet butoni, lexohen vlerat, kontrollohen, dhe
 *   JOptionPane shfaq mesazhin ose gabimin.
 */
public class EmriMbiemri {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Emri dhe Mbiemri");

        JLabel lblEmri    = new JLabel("Emri:");
        JLabel lblMbiemri = new JLabel("Mbiemri:");
        JTextField tfEmri    = new JTextField();
        JTextField tfMbiemri = new JTextField();
        JButton btnShfaq = new JButton("Shfaq");

        lblEmri.setBounds(20, 30, 80, 25);
        tfEmri.setBounds(110, 30, 150, 25);
        lblMbiemri.setBounds(20, 75, 80, 25);
        tfMbiemri.setBounds(110, 75, 150, 25);
        btnShfaq.setBounds(110, 120, 100, 30);

        frame.add(lblEmri);
        frame.add(tfEmri);
        frame.add(lblMbiemri);
        frame.add(tfMbiemri);
        frame.add(btnShfaq);

        frame.setSize(320, 220);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnShfaq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emri    = tfEmri.getText().trim();
                String mbiemri = tfMbiemri.getText().trim();

                if (emri.isEmpty() || mbiemri.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Ju lutem plotesoni te dy fushat!",
                            "Gabim",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                JOptionPane.showMessageDialog(frame,
                        "Miredita, " + emri + " " + mbiemri + "! Pune te mbare.",
                        "Pershendetje",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
