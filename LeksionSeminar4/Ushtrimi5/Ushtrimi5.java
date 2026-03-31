import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Seminar 4 — Ushtrimi 5: Loja "Gjej Numrin"
 *
 * Detyrë:
 * - Programi zgjedh rastësisht një numër nga 1 deri në 100. Përdoruesi
 *   përpiqet ta gjejë duke futur vlera në JTextField dhe duke klikuar "Provo".
 * - Pas çdo përpjekjeje shfaqet feedback (më i madh/më i vogël) në JLabel.
 * - Kur gjendet numri i saktë, shfaqet mesazh suksesi me JOptionPane.
 * - Butoni "Lojë e re" gjeneron numër të ri dhe rifillon lojën.
 * - Shfaqet numri i përpjekjeve.
 * - Nëse inputi nuk është numerik, shfaqet gabim me JOptionPane.
 *
 * Shpjegim:
 * - Random.nextInt(100) + 1 gjeneron numër të rastësishëm nga 1 deri 100.
 * - Integer.parseInt() konverton inputin; NumberFormatException kapet me
 *   try/catch dhe shfaqet gabim.
 * - Feedback-u (more/less/correct) shfaqet në JLabel poshtë fushës.
 */
public class Ushtrimi5 {

    private static int numriFshehtë;
    private static int përpjekje;

    public static void main(String[] args) {
        Random random = new Random();
        numriFshehtë = random.nextInt(100) + 1;
        përpjekje = 0;

        JFrame frame = new JFrame("Gjej Numrin");

        JLabel lblUdhëzim = new JLabel(
                "Kam zgjedhur një numër nga 1 deri në 100. Gjejeni!",
                SwingConstants.CENTER);

        JTextField tfNumri = new JTextField();
        JButton btnProvo = new JButton("Provo");

        JLabel lblFeedback = new JLabel("Jepni supozimin tuaj dhe klikoni Provo.",
                SwingConstants.CENTER);
        lblFeedback.setFont(new Font("Arial", Font.ITALIC, 13));

        JLabel lblPërpjekje = new JLabel("Përpjekje: 0", SwingConstants.CENTER);

        JButton btnLojeRe = new JButton("Lojë e re");

        lblUdhëzim.setBounds(10, 20, 380, 25);
        tfNumri.setBounds(70, 65, 180, 30);
        btnProvo.setBounds(260, 65, 90, 30);
        lblFeedback.setBounds(10, 110, 380, 25);
        lblPërpjekje.setBounds(10, 145, 380, 25);
        btnLojeRe.setBounds(135, 190, 130, 35);

        frame.add(lblUdhëzim);
        frame.add(tfNumri);
        frame.add(btnProvo);
        frame.add(lblFeedback);
        frame.add(lblPërpjekje);
        frame.add(btnLojeRe);

        frame.setSize(410, 275);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Aksion i përbashkët për butonin "Provo" dhe Enter në textField
        ActionListener actionProvo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = tfNumri.getText().trim();
                try {
                    int numri = Integer.parseInt(input);
                    përpjekje++;
                    lblPërpjekje.setText("Përpjekje: " + përpjekje);

                    if (numri < numriFshehtë) {
                        lblFeedback.setText("Numri " + numri + " është MË I VOGËL se numri i fshehtë. Provo sërish!");
                        lblFeedback.setForeground(new Color(180, 60, 0));
                    } else if (numri > numriFshehtë) {
                        lblFeedback.setText("Numri " + numri + " është MË I MADH se numri i fshehtë. Provo sërish!");
                        lblFeedback.setForeground(new Color(0, 80, 180));
                    } else {
                        lblFeedback.setText("Saktë! Numri ishte " + numriFshehtë + ".");
                        lblFeedback.setForeground(new Color(0, 140, 0));
                        JOptionPane.showMessageDialog(frame,
                                "Urime! Gjetët numrin " + numriFshehtë
                                + " në " + përpjekje + " përpjekje!",
                                "Fituat!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    tfNumri.setText("");
                    tfNumri.requestFocus();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Ju lutem vendosni një numër të plotë!",
                            "Gabim", JOptionPane.ERROR_MESSAGE);
                    tfNumri.setText("");
                    tfNumri.requestFocus();
                }
            }
        };

        btnProvo.addActionListener(actionProvo);
        tfNumri.addActionListener(actionProvo);  // Enter në textField

        // Butoni "Lojë e re"
        btnLojeRe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numriFshehtë = random.nextInt(100) + 1;
                përpjekje = 0;
                tfNumri.setText("");
                lblPërpjekje.setText("Përpjekje: 0");
                lblFeedback.setText("Loja filloi! Jepni supozimin tuaj.");
                lblFeedback.setForeground(Color.BLACK);
                tfNumri.requestFocus();
            }
        });
    }
}
