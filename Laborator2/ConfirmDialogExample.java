import javax.swing.*;

/**
 * Ushtrimi 2 — Confirm Dialog (Dialogu i Konfirmimit)
 *
 * Detyrë:
 * - Shfaq një dialog me pyetjen: "Deshironi te fshini te dhenat?"
 * - Nëse përdoruesi zgjedh "Po" (Yes) → shfaq mesazh paralajmërues
 * - Nëse përdoruesi zgjedh "Jo" (No)  → shfaq mesazh informues
 *
 * Shpjegim:
 * - JOptionPane.showConfirmDialog() shfaq dialog me butonat YES/NO dhe
 *   kthen JOptionPane.YES_OPTION ose JOptionPane.NO_OPTION.
 * - JOptionPane.showMessageDialog() me tipin WARNING_MESSAGE shfaq ikonën
 *   e paralajmërimit, ndërsa INFORMATION_MESSAGE shfaq ikonën e informacionit.
 * - Aplikacioni mbyllet pas zgjedhjes me System.exit(0).
 */
public class ConfirmDialogExample {

    public static void main(String[] args) {
        int zgjedhja = JOptionPane.showConfirmDialog(
                null,
                "Deshironi te fshini te dhenat?",
                "Konfirmim",
                JOptionPane.YES_NO_OPTION
        );

        if (zgjedhja == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                    null,
                    "Te dhenat u fshin!",
                    "Paralajmerim",
                    JOptionPane.WARNING_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Veprimi u anulua. Te dhenat nuk u fshin.",
                    "Informacion",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

        System.exit(0);
    }
}
