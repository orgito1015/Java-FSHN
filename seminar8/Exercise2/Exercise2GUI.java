import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Ushtrimi 2 – FigurëGjeometrike (GUI)
 *
 * JFrame qe lejon:
 *   - Shtimin e figurave gjeometrike nje nga nje.
 *   - Gjetjen e figures me perimetrin me te madh.
 *   - Fshirjen e te gjitha figurave per fillim te ri.
 *
 * Ekstra: per trekendesh kontrollon vlerat para se ta shtoje.
 */
public class Exercise2GUI extends JFrame {

    private final List<FiguraGjeometrike> figurat = new ArrayList<>();
    private final JTextArea               taOutput;
    private final JLabel                  lblNumFigura;

    public Exercise2GUI() {
        super("Ushtrimi 2 – Figurat Gjeometrike");

        taOutput = new JTextArea();
        taOutput.setEditable(false);
        taOutput.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(taOutput);

        lblNumFigura = new JLabel("Figurat e shtuara: 0", SwingConstants.LEFT);

        JButton btnShtoFigure = new JButton("Shto Figure");
        JButton btnGjejMaks   = new JButton("Gjej Perimetrin Maks");
        JButton btnFshij      = new JButton("Fshij te Gjitha");

        JPanel south = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        south.add(lblNumFigura);
        south.add(btnShtoFigure);
        south.add(btnGjejMaks);
        south.add(btnFshij);

        add(scroll, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);

        btnShtoFigure.addActionListener(e -> shtoFigure());
        btnGjejMaks.addActionListener(e   -> gjejPerimetrinMaks());
        btnFshij.addActionListener(e -> {
            figurat.clear();
            taOutput.setText("");
            lblNumFigura.setText("Figurat e shtuara: 0");
        });

        setSize(620, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void shtoFigure() {
        String[] llojet = {"Rreth", "Drejtkendesh", "Trekendesh"};
        String lloj = (String) JOptionPane.showInputDialog(this,
            "Zgjidhni llojen e figures:",
            "Lloji i Figures", JOptionPane.QUESTION_MESSAGE,
            null, llojet, llojet[0]);
        if (lloj == null) return;

        int lloji = java.util.Arrays.asList(llojet).indexOf(lloj) + 1;
        double a = 0, b = 0, c = 0;

        try {
            switch (lloji) {
                case 1: {
                    String val = JOptionPane.showInputDialog(this,
                        "Rrezja (r):", "Rreth", JOptionPane.QUESTION_MESSAGE);
                    if (val == null) return;
                    a = Double.parseDouble(val.trim());
                    break;
                }
                case 2: {
                    String va = JOptionPane.showInputDialog(this,
                        "Gjatesia (a):", "Drejtkendesh", JOptionPane.QUESTION_MESSAGE);
                    if (va == null) return;
                    String vb = JOptionPane.showInputDialog(this,
                        "Gjeresia (b):", "Drejtkendesh", JOptionPane.QUESTION_MESSAGE);
                    if (vb == null) return;
                    a = Double.parseDouble(va.trim());
                    b = Double.parseDouble(vb.trim());
                    break;
                }
                case 3: {
                    String va = JOptionPane.showInputDialog(this, "Brinja a:", "Trekendesh", JOptionPane.QUESTION_MESSAGE);
                    if (va == null) return;
                    String vb = JOptionPane.showInputDialog(this, "Brinja b:", "Trekendesh", JOptionPane.QUESTION_MESSAGE);
                    if (vb == null) return;
                    String vc = JOptionPane.showInputDialog(this, "Brinja c:", "Trekendesh", JOptionPane.QUESTION_MESSAGE);
                    if (vc == null) return;

                    a = Double.parseDouble(va.trim());
                    b = Double.parseDouble(vb.trim());
                    c = Double.parseDouble(vc.trim());

                    // Ekstra: kontroll validiteti
                    FiguraGjeometrike test = new FiguraGjeometrike(a, b, c, 3);
                    if (!test.eshteTriangulIVlefshëm()) {
                        JOptionPane.showMessageDialog(this,
                            "Vlerat " + a + ", " + b + ", " + c
                                + " NUK formojne nje trekendesh te vlefshëm!",
                            "Vlera jo te vlefshme", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    break;
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vlera numerike jo e vlefshme!",
                "Gabim", JOptionPane.ERROR_MESSAGE);
            return;
        }

        FiguraGjeometrike fg = new FiguraGjeometrike(a, b, c, lloji);
        figurat.add(fg);
        taOutput.append("Figura " + figurat.size() + ": " + fg + "\n");
        lblNumFigura.setText("Figurat e shtuara: " + figurat.size());
    }

    private void gjejPerimetrinMaks() {
        if (figurat.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Nuk ka figura te shtuara!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        FiguraGjeometrike maks = figurat.get(0);
        for (FiguraGjeometrike fg : figurat) {
            if (fg.llogaritPerimetrin() > maks.llogaritPerimetrin()) {
                maks = fg;
            }
        }
        taOutput.append("\n>>> Figura me perimetrin me te madh: " + maks + "\n");
        JOptionPane.showMessageDialog(this,
            "Figura me perimetrin me te madh:\n" + maks,
            "Rezultati", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Exercise2GUI::new);
    }
}
