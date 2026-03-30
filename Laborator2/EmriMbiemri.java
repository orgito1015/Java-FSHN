import javax.swing.*;

/**
 * Ushtrimi 3 — Input Emër dhe Mbiemër (përmes dy dritareve)
 *
 * Detyrë:
 * - Kërko emrin e përdoruesit nëpërmjet JOptionPane.showInputDialog()
 * - Kërko mbiemrin e përdoruesit nëpërmjet JOptionPane.showInputDialog()
 * - Nëse emri lihet bosh, shfaq: "Ju lutem shkruani nje emer te vlefshem"
 * - Bashkoje emrin dhe mbiemrin dhe shfaq: "Miredita, [Emri] [Mbiemri]! Pune te mbare."
 *
 * Shpjegim:
 * - JOptionPane.showInputDialog() shfaq dritare input një pas një.
 * - String.trim() heq hapësirat boshe; isEmpty() kontrollon nëse është bosh.
 * - Mesazhi final shfaqet me showMessageDialog().
 */
public class EmriMbiemri {

    public static void main(String[] args) {
        String emri = JOptionPane.showInputDialog(null,
                "Shkruani emrin tuaj:", "Hap 1 - Emri",
                JOptionPane.QUESTION_MESSAGE);

        if (emri == null) {
            System.exit(0);
        }

        emri = emri.trim();

        if (emri.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Ju lutem shkruani nje emer te vlefshem",
                    "Gabim", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        String mbiemri = JOptionPane.showInputDialog(null,
                "Shkruani mbiemrin tuaj:", "Hap 2 - Mbiemri",
                JOptionPane.QUESTION_MESSAGE);

        if (mbiemri == null) {
            System.exit(0);
        }

        mbiemri = mbiemri.trim();

        JOptionPane.showMessageDialog(null,
                "Miredita, " + emri + " " + mbiemri + "! Pune te mbare.",
                "Pershendetje", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
