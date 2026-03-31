import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.awt.event.*;

/**
 * Seminar 4 — Ushtrimi 2: JLabel, JButton dhe Menu Look & Feel
 *
 * Detyrë:
 * - Të krijohet një aplikacion i thjeshtë me një JLabel, një JButton dhe një
 *   menu "Ndrysho Pamjen" për ndryshimin e pamjes. Paraprakisht label ka një
 *   tekst default. Në klikim të butonit të ndryshojë teksti në label.
 *   Menu-ja ka 3 nënmenu: Metal, System, FlatLaf.
 *
 * Shpjegim:
 * - JMenuBar/JMenu/JMenuItem ndërtojnë menunë e aplikacionit.
 * - UIManager.setLookAndFeel() ndryshon pamjen vizuale të aplikacionit.
 * - SwingUtilities.updateComponentTreeUI() aplikon pamjen e re në të gjithë
 *   komponentet ekzistues pa pasur nevojë të rihapet dritarja.
 * - FlatLaf kërkon bibliotekën e jashtme; nëse mungon, shfaqet mesazh gabimi.
 */
public class Ushtrimi2 {

    private static int klikime = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("JLabel dhe JButton");

        JLabel lblTekst = new JLabel("Tekst fillestar", SwingConstants.CENTER);
        lblTekst.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton btnNdrysho = new JButton("Ndrysho Tekstin");

        lblTekst.setBounds(50, 60, 280, 40);
        btnNdrysho.setBounds(130, 130, 160, 35);

        frame.add(lblTekst);
        frame.add(btnNdrysho);

        // --- Menu ---
        JMenuBar menuBar = new JMenuBar();
        JMenu menuPamja = new JMenu("Ndrysho Pamjen");

        JMenuItem itemMetal = new JMenuItem("Metal");
        JMenuItem itemSystem = new JMenuItem("System");
        JMenuItem itemFlatLaf = new JMenuItem("FlatLaf");

        menuPamja.add(itemMetal);
        menuPamja.add(itemSystem);
        menuPamja.add(itemFlatLaf);
        menuBar.add(menuPamja);
        frame.setJMenuBar(menuBar);

        frame.setSize(400, 230);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Buton: ndryshon tekstin e label
        btnNdrysho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                klikime++;
                lblTekst.setText("Teksti u ndryshua " + klikime + " here");
            }
        });

        // Menu: Metal
        itemMetal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel(new MetalLookAndFeel());
                    SwingUtilities.updateComponentTreeUI(frame);
                } catch (UnsupportedLookAndFeelException ex) {
                    JOptionPane.showMessageDialog(frame, "Metal L&F nuk mbështetet.",
                            "Gabim", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Menu: System
        itemSystem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    SwingUtilities.updateComponentTreeUI(frame);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "System L&F nuk mbështetet.",
                            "Gabim", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Menu: FlatLaf (kërkon bibliotekën com.formdev:flatlaf)
        itemFlatLaf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
                    SwingUtilities.updateComponentTreeUI(frame);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame,
                            "FlatLaf nuk është i instaluar.\n"
                            + "Shto bibliotekën flatlaf.jar në classpath.",
                            "Gabim", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
