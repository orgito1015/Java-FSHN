import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Ushtrimi 1 – Menaxhimi i Librave (GUI)
 *
 * JFrame me panel butonash:
 *   1. Shfaq Librat  – shfaq te gjithe librat ne zonen qendrore
 *   2. Kerko Librin  – kerkton nje liber sipas titullit
 *   3. Shto Librin   – shton nje liber te ri nepermjet nje dialogu
 *   4. Hiq Librin    – heq nje liber sipas titullit
 *   0. Dil           – mbyll aplikacionin
 */
public class LibriGUI extends JFrame {

    private final List<Libri> lista     = new ArrayList<>();
    private final JTextArea   taOutput;

    public LibriGUI() {
        super("Ushtrimi 1 – Menaxhimi i Librave");

        // Disa libra fillestar
        lista.add(new Libri("J.K. Rowling",            "Harry Potter",   "978-0439708180", 309, "Fantazi",  15.99));
        lista.add(new Libri("George Orwell",            "1984",           "978-0451524935", 328, "Distopi",  12.99));
        lista.add(new Libri("Antoine de Saint-Exupery", "Princi i Vogel", "978-0156012195",  96, "Fabel",    9.99));

        taOutput = new JTextArea();
        taOutput.setEditable(false);
        taOutput.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(taOutput);

        JButton btnShfaq = new JButton("1. Shfaq Librat");
        JButton btnKerko = new JButton("2. Kerko Librin");
        JButton btnShto  = new JButton("3. Shto Librin");
        JButton btnHiq   = new JButton("4. Hiq Librin");
        JButton btnDil   = new JButton("0. Dil");

        JPanel panelBtns = new JPanel(new GridLayout(5, 1, 5, 5));
        panelBtns.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelBtns.add(btnShfaq);
        panelBtns.add(btnKerko);
        panelBtns.add(btnShto);
        panelBtns.add(btnHiq);
        panelBtns.add(btnDil);

        add(scroll, BorderLayout.CENTER);
        add(panelBtns, BorderLayout.EAST);

        btnShfaq.addActionListener(e -> shfaqLibrat());
        btnKerko.addActionListener(e -> kerkoLibrin());
        btnShto.addActionListener(e  -> shtoLibrin());
        btnHiq.addActionListener(e   -> hiqLibrin());
        btnDil.addActionListener(e   -> System.exit(0));

        setSize(950, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        shfaqLibrat(); // shfaq listen fillestare
    }

    private void shfaqLibrat() {
        StringBuilder sb = new StringBuilder("--- Lista e Librave (" + lista.size() + " libra) ---\n");
        if (lista.isEmpty()) {
            sb.append("Lista eshte bosh.\n");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                sb.append(i + 1).append(". ").append(lista.get(i)).append("\n");
            }
        }
        taOutput.setText(sb.toString());
    }

    private void kerkoLibrin() {
        String titulli = JOptionPane.showInputDialog(this,
            "Shkruaj titullin e librit:", "Kerko Librin", JOptionPane.QUESTION_MESSAGE);
        if (titulli == null || titulli.isBlank()) return;

        StringBuilder sb = new StringBuilder("Rezultatet per \"" + titulli.trim() + "\":\n");
        boolean gjetur = false;
        for (Libri l : lista) {
            if (l.getTitulli().equalsIgnoreCase(titulli.trim())) {
                sb.append(l).append("\n");
                gjetur = true;
            }
        }
        if (!gjetur) sb.append("Libri nuk u gjet.");
        taOutput.setText(sb.toString());
    }

    private void shtoLibrin() {
        JTextField tfAutori  = new JTextField();
        JTextField tfTitulli = new JTextField();
        JTextField tfIsbn    = new JTextField();
        JTextField tfFaqe    = new JTextField();
        JTextField tfLloji   = new JTextField();
        JTextField tfCmimi   = new JTextField();

        Object[] fields = {
            "Autori:",      tfAutori,
            "Titulli:",     tfTitulli,
            "ISBN:",        tfIsbn,
            "Num. Faqeve:", tfFaqe,
            "Lloji:",       tfLloji,
            "Cmimi (EUR):", tfCmimi
        };

        int result = JOptionPane.showConfirmDialog(this, fields, "Shto Librin", JOptionPane.OK_CANCEL_OPTION);
        if (result != JOptionPane.OK_OPTION) return;

        try {
            String autori  = tfAutori.getText().trim();
            String titulli = tfTitulli.getText().trim();
            String isbn    = tfIsbn.getText().trim();
            int    faqe    = Integer.parseInt(tfFaqe.getText().trim());
            String lloji   = tfLloji.getText().trim();
            double cmimi   = Double.parseDouble(tfCmimi.getText().trim());

            lista.add(new Libri(autori, titulli, isbn, faqe, lloji, cmimi));
            shfaqLibrat();
            JOptionPane.showMessageDialog(this, "Libri u shtua me sukses!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vlera numerike jo e vlefshme!",
                "Gabim", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void hiqLibrin() {
        String titulli = JOptionPane.showInputDialog(this,
            "Shkruaj titullin e librit per ta hequr:", "Hiq Librin", JOptionPane.QUESTION_MESSAGE);
        if (titulli == null || titulli.isBlank()) return;

        boolean hequr = lista.removeIf(l -> l.getTitulli().equalsIgnoreCase(titulli.trim()));
        if (hequr) {
            shfaqLibrat();
            JOptionPane.showMessageDialog(this, "Libri u hoq me sukses!");
        } else {
            JOptionPane.showMessageDialog(this,
                "Libri me titull '" + titulli.trim() + "' nuk u gjet.",
                "Nuk u gjet", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LibriGUI::new);
    }
}
