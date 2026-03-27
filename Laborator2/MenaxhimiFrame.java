import javax.swing.*;

/**
 * Ushtrimi 1 — Dritare Grafike (JFrame)
 *
 * Detyrë:
 * - Krijo një dritare me titull "Laboratori 2 - Java"
 * - Shto një label me tekst "Miresevini ne Sistemin e Menaxhimit"
 * - Dritarja të vendoset në qendër të ekranit
 * - Madhësia fikse (nuk lejohet resize)
 *
 * Shpjegim:
 * - JFrame është klasa kryesore Swing për krijimin e dritareve grafike.
 * - JLabel shton tekst brenda dritares; SwingConstants.CENTER e qendron.
 * - setLocationRelativeTo(null) e vendos dritaren në qendër të ekranit.
 * - setResizable(false) parandalon ndryshimin e madhësisë.
 * - setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) mbyll aplikacionin
 *   kur mbyllet dritarja.
 */
public class MenaxhimiFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Laboratori 2 - Java");

        JLabel lbl = new JLabel("Miresevini ne Sistemin e Menaxhimit",
                                SwingConstants.CENTER);
        frame.add(lbl);

        frame.setSize(450, 200);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // qendrohet në ekran
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
