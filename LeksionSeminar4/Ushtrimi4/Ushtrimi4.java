import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Seminar 4 — Ushtrimi 4: Aplikacion GUI për Porositjen e Picës
 *
 * Detyrë:
 * - Të krijohet një aplikacion GUI për porositjen e picës me:
 *   - JTextField për emrin e klientit
 *   - JComboBox për madhësinë (E vogël, Mesatare, E madhe)
 *   - 3 JCheckBox për përbërës shtesë (Djathë ekstra, Kërpudha, Oliva)
 *   - 2 JRadioButton për mënyrën e marrjes (Në lokal, Me vete)
 *   - JButton "Përfundo porosinë"
 *   - JTextArea për përmbledhjen e porosisë
 * - Në klikim të butonit: kontrollohet emri, shfaqet përmbledhja, dhe nëse
 *   emri mungon shfaqet mesazh gabimi me JOptionPane.
 *
 * Shpjegim:
 * - ButtonGroup grupëzon JRadioButton-et që vetëm njëri të jetë i zgjedhur.
 * - JCheckBox.isSelected() teston nëse çboks është i zgjedhur.
 * - JComboBox.getSelectedItem() kthen opsionin e zgjedhur.
 * - StringBuilder ndërton me efikasitet vargun e përmbledhjes.
 */
public class Ushtrimi4 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Porositja e Picës");

        // --- Emri i klientit ---
        JLabel lblEmri = new JLabel("Emri i klientit:");
        JTextField tfEmri = new JTextField();

        // --- Madhësia e picës ---
        JLabel lblMadhesia = new JLabel("Madhësia:");
        String[] madhesitë = {"E vogël", "Mesatare", "E madhe"};
        JComboBox<String> cbMadhesia = new JComboBox<>(madhesitë);

        // --- Përbërës shtesë ---
        JLabel lblPerberes = new JLabel("Përbërës shtesë:");
        JCheckBox cbDjathe   = new JCheckBox("Djathë ekstra");
        JCheckBox cbKerpudha = new JCheckBox("Kërpudha");
        JCheckBox cbOliva    = new JCheckBox("Oliva");

        // --- Mënyra e marrjes ---
        JLabel lblMenyra = new JLabel("Mënyra e marrjes:");
        JRadioButton rbLokal  = new JRadioButton("Në lokal", true);
        JRadioButton rbMeVete = new JRadioButton("Me vete");
        ButtonGroup grupMenyra = new ButtonGroup();
        grupMenyra.add(rbLokal);
        grupMenyra.add(rbMeVete);

        // --- Butoni dhe përmbledhja ---
        JButton btnPerfundo = new JButton("Përfundo porosinë");

        JTextArea taPërmbledhja = new JTextArea();
        taPërmbledhja.setEditable(false);
        taPërmbledhja.setLineWrap(true);
        taPërmbledhja.setWrapStyleWord(true);
        JScrollPane spPërmbledhja = new JScrollPane(taPërmbledhja);
        JLabel lblPërmbledhja = new JLabel("Përmbledhja e porosisë:");

        // --- Pozicionimi (null layout) ---
        lblEmri.setBounds(20, 20, 130, 25);
        tfEmri.setBounds(160, 20, 200, 25);

        lblMadhesia.setBounds(20, 60, 130, 25);
        cbMadhesia.setBounds(160, 60, 200, 25);

        lblPerberes.setBounds(20, 100, 130, 25);
        cbDjathe.setBounds(160, 100, 140, 25);
        cbKerpudha.setBounds(160, 130, 140, 25);
        cbOliva.setBounds(160, 160, 140, 25);

        lblMenyra.setBounds(20, 200, 130, 25);
        rbLokal.setBounds(160, 200, 110, 25);
        rbMeVete.setBounds(160, 230, 110, 25);

        btnPerfundo.setBounds(130, 275, 180, 35);

        lblPërmbledhja.setBounds(20, 325, 200, 25);
        spPërmbledhja.setBounds(20, 355, 340, 110);

        frame.add(lblEmri);
        frame.add(tfEmri);
        frame.add(lblMadhesia);
        frame.add(cbMadhesia);
        frame.add(lblPerberes);
        frame.add(cbDjathe);
        frame.add(cbKerpudha);
        frame.add(cbOliva);
        frame.add(lblMenyra);
        frame.add(rbLokal);
        frame.add(rbMeVete);
        frame.add(btnPerfundo);
        frame.add(lblPërmbledhja);
        frame.add(spPërmbledhja);

        frame.setSize(400, 510);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // --- Logika e butonit ---
        btnPerfundo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emri = tfEmri.getText().trim();

                if (emri.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Ju lutem vendosni emrin e klientit!",
                            "Gabim", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                StringBuilder sb = new StringBuilder();
                sb.append("=== Përmbledhja e Porosisë ===\n");
                sb.append("Klienti  : ").append(emri).append("\n");
                sb.append("Madhësia : ").append(cbMadhesia.getSelectedItem()).append("\n");

                // Përbërës shtesë
                StringBuilder perberes = new StringBuilder();
                if (cbDjathe.isSelected())   perberes.append("Djathë ekstra, ");
                if (cbKerpudha.isSelected()) perberes.append("Kërpudha, ");
                if (cbOliva.isSelected())    perberes.append("Oliva, ");
                String perberesStr = perberes.length() > 0
                        ? perberes.substring(0, perberes.length() - 2)
                        : "Asnjë";
                sb.append("Shtesa   : ").append(perberesStr).append("\n");

                // Mënyra e marrjes
                String menyra = rbLokal.isSelected() ? "Në lokal" : "Me vete";
                sb.append("Marrja   : ").append(menyra).append("\n");

                taPërmbledhja.setText(sb.toString());
            }
        });
    }
}
