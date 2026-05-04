import javax.swing.*;
import java.awt.*;

/**
 * Ushtrimi 3 – Prona dhe Klientet (GUI)
 *
 * JFrame qe lejon:
 *   - Krijimin e nje prone (emri kerkohet ne fillim).
 *   - Shtimin e klienteve te interesuar (emri + oferta).
 *   - Shfaqjen e numrit total te klienteve.
 *   - Gjetjen e ofertes maksimale.
 *   - Shfaqjen e listes se te gjithe klienteve.
 */
public class Exercise3GUI extends JFrame {

    private final Prona     prona;
    private final JTextArea taOutput;
    private final JLabel    lblTitulli;

    public Exercise3GUI() {
        super("Ushtrimi 3 – Prona dhe Klientet");

        // Kerko emrin e prona-s ne fillim
        String emriPrones = JOptionPane.showInputDialog(null,
            "Shkruaj emrin e prona-s:", "Krijo Prona", JOptionPane.QUESTION_MESSAGE);
        if (emriPrones == null || emriPrones.isBlank()) emriPrones = "Prona Pa Emer";
        prona = new Prona(emriPrones.trim());

        lblTitulli = new JLabel("Prona: " + prona.getEmri() + "   |   Klientet: 0", SwingConstants.CENTER);
        lblTitulli.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        lblTitulli.setBorder(BorderFactory.createEmptyBorder(8, 5, 8, 5));

        taOutput = new JTextArea();
        taOutput.setEditable(false);
        taOutput.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(taOutput);

        JButton btnShtoKlient  = new JButton("Shto Klient");
        JButton btnNumKlientet = new JButton("Numro Klientet");
        JButton btnOfertaMaks  = new JButton("Oferta Maksimale");
        JButton btnShfaqTe     = new JButton("Shfaq te Gjithe");

        JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        south.add(btnShtoKlient);
        south.add(btnNumKlientet);
        south.add(btnOfertaMaks);
        south.add(btnShfaqTe);

        add(lblTitulli, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);

        btnShtoKlient.addActionListener(e -> shtoKlient());
        btnNumKlientet.addActionListener(e -> JOptionPane.showMessageDialog(this,
            "Numri i klienteve te interesuar: " + prona.numëroKlientë(),
            "Numro Klientet", JOptionPane.INFORMATION_MESSAGE));
        btnOfertaMaks.addActionListener(e -> {
            Klient maks = prona.ofertaMaks();
            String msg = (maks != null)
                ? "Oferta maksimale:\n" + maks
                : "Nuk ka klienta te regjistruar.";
            JOptionPane.showMessageDialog(this, msg, "Oferta Maksimale", JOptionPane.INFORMATION_MESSAGE);
        });
        btnShfaqTe.addActionListener(e -> shfaqTeGjithe());

        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void shtoKlient() {
        JTextField tfEmri   = new JTextField();
        JTextField tfOferta = new JTextField();
        Object[] fields = {"Emri i klientit:", tfEmri, "Oferta (EUR):", tfOferta};

        int res = JOptionPane.showConfirmDialog(this, fields, "Shto Klient", JOptionPane.OK_CANCEL_OPTION);
        if (res != JOptionPane.OK_OPTION) return;

        try {
            String emri   = tfEmri.getText().trim();
            double oferta = Double.parseDouble(tfOferta.getText().trim());
            Klient klient = new Klient(emri, oferta);
            prona.shtoKlient(klient);
            lblTitulli.setText("Prona: " + prona.getEmri() + "   |   Klientet: " + prona.numëroKlientë());
            taOutput.append("U shtua: " + klient + "\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Oferta duhet te jete nje numer!",
                "Gabim", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void shfaqTeGjithe() {
        StringBuilder sb = new StringBuilder(
            "=== Klientet e Prona-s \"" + prona.getEmri() + "\" ===\n");
        if (prona.getKlientet().isEmpty()) {
            sb.append("Nuk ka klienta te regjistruar.");
        } else {
            for (int i = 0; i < prona.getKlientet().size(); i++) {
                sb.append(i + 1).append(". ").append(prona.getKlientet().get(i)).append("\n");
            }
        }
        taOutput.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Exercise3GUI::new);
    }
}
