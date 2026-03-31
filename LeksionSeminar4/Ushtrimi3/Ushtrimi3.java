import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.awt.event.*;

/**
 * Seminar 4 — Ushtrimi 3: JTextArea me Menu dhe Numërim Karakteresh
 *
 * Detyrë:
 * - Të krijohet një aplikacion që përmban një JTextArea për shkrim teksti dhe
 *   një JScrollPane. Të krijohet një menu me këto opsione:
 *   a. Menu "File": Clear (pastron tekstin), Exit
 *   b. Menu "Format": Uppercase, Lowercase
 *   c. Menu "Look & Feel": Metal, System
 *   Në një JLabel shfaq numrin e karaktereve të shkruara në JTextArea.
 *
 * Shpjegim:
 * - JMenuBar/JMenu/JMenuItem ndërtojnë menunë me nënmenytë e kërkuara.
 * - DocumentListener vëzhgon çdo ndryshim në JTextArea dhe përditëson
 *   numëruesin e karaktereve në kohë reale.
 * - UIManager.setLookAndFeel() + SwingUtilities.updateComponentTreeUI()
 *   ndryshojnë pamjen vizuale pa rihapje të dritares.
 */
public class Ushtrimi3 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("TextArea me Menu");

        JTextArea taText = new JTextArea();
        taText.setLineWrap(true);
        taText.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(taText);

        JLabel lblKaraktere = new JLabel("Karaktere: 0");

        // --- MenuBar ---
        JMenuBar menuBar = new JMenuBar();

        // Menu File
        JMenu menuFile = new JMenu("File");
        JMenuItem itemClear = new JMenuItem("Clear");
        JMenuItem itemExit  = new JMenuItem("Exit");
        menuFile.add(itemClear);
        menuFile.add(itemExit);

        // Menu Format
        JMenu menuFormat = new JMenu("Format");
        JMenuItem itemUpper = new JMenuItem("Uppercase");
        JMenuItem itemLower = new JMenuItem("Lowercase");
        menuFormat.add(itemUpper);
        menuFormat.add(itemLower);

        // Menu Look & Feel
        JMenu menuLF = new JMenu("Look & Feel");
        JMenuItem itemMetal  = new JMenuItem("Metal");
        JMenuItem itemSystem = new JMenuItem("System");
        menuLF.add(itemMetal);
        menuLF.add(itemSystem);

        menuBar.add(menuFile);
        menuBar.add(menuFormat);
        menuBar.add(menuLF);
        frame.setJMenuBar(menuBar);

        // Layout
        frame.setLayout(new BorderLayout(5, 5));
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(lblKaraktere, BorderLayout.SOUTH);

        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // DocumentListener: numëron karakteret në kohë reale
        taText.getDocument().addDocumentListener(new DocumentListener() {
            private void update() {
                lblKaraktere.setText("Karaktere: " + taText.getText().length());
            }
            @Override public void insertUpdate(DocumentEvent e)  { update(); }
            @Override public void removeUpdate(DocumentEvent e)  { update(); }
            @Override public void changedUpdate(DocumentEvent e) { update(); }
        });

        // File > Clear
        itemClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taText.setText("");
            }
        });

        // File > Exit
        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Format > Uppercase
        itemUpper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taText.setText(taText.getText().toUpperCase());
            }
        });

        // Format > Lowercase
        itemLower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taText.setText(taText.getText().toLowerCase());
            }
        });

        // Look & Feel > Metal
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

        // Look & Feel > System
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
    }
}
