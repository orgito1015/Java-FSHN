import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Seminar 4 — Ushtrimi 1: Konvertim Teksti (Lower/Upper Case)
 *
 * Detyrë:
 * - Ndërtoni një aplikacion i cili do të përmbajë një frame, me një textArea
 *   ku do te afishohet një tekst. Të shtohen 2 butona: "To Lower Case" dhe
 *   "To Upper Case" që do te kthejnë tekstin në shkronja të vogla ose të
 *   mëdha në varësi të butonit të zgjedhur.
 *
 * Shpjegim:
 * - JTextArea mban dhe afishon tekstin e ndryshësueshëm nga përdoruesi.
 * - JScrollPane lejon lëvizjen vertikale kur teksti tejkalon sipërfaqen.
 * - getText() merr tekstin aktual; toLowerCase()/toUpperCase() e konvertojnë.
 * - setText() vendos tekstin e konvertuar përsëri në textArea.
 */
public class Ushtrimi1 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Konvertim Teksti");

        JTextArea taText = new JTextArea("Shkruani tekstin tuaj ketu...");
        taText.setLineWrap(true);
        taText.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(taText);

        JButton btnLower = new JButton("To Lower Case");
        JButton btnUpper = new JButton("To Upper Case");

        scrollPane.setBounds(20, 20, 340, 180);
        btnLower.setBounds(20, 215, 160, 35);
        btnUpper.setBounds(200, 215, 160, 35);

        frame.add(scrollPane);
        frame.add(btnLower);
        frame.add(btnUpper);

        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnLower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taText.setText(taText.getText().toLowerCase());
            }
        });

        btnUpper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taText.setText(taText.getText().toUpperCase());
            }
        });
    }
}
