import javax.swing.*;
import java.awt.event.*;

/**
 * Seminar 3 — Ushtrimi 2: Kopjimi i Tekstit midis TextArea-ve
 *
 * Detyrë:
 * - Krijoni një aplikacion në JAVA që përmban dy textArea dhe një buton.
 *   Në klik të butonit të kopjohet teksti nga textArea e parë tek e dyta.
 *
 * Shpjegim:
 * - JTextArea është komponent multi-rresht për input/output teksti.
 * - JScrollPane e mbështjell JTextArea për mundësi lëvizjeje vertikale.
 * - getText() merr përmbajtjen e textArea së parë.
 * - setText() vendos atë përmbajtje në textArea e dytë.
 */
public class Ushtrimi2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kopjim TextArea");

        JLabel lbl1 = new JLabel("TextArea 1 (burimi):");
        JLabel lbl2 = new JLabel("TextArea 2 (destinacioni):");

        JTextArea ta1 = new JTextArea();
        JTextArea ta2 = new JTextArea();
        ta2.setEditable(false);

        JScrollPane sp1 = new JScrollPane(ta1);
        JScrollPane sp2 = new JScrollPane(ta2);

        JButton btnKopjo = new JButton("Kopjo");

        lbl1.setBounds(20, 10, 180, 20);
        sp1.setBounds(20, 35, 340, 100);
        lbl2.setBounds(20, 145, 200, 20);
        sp2.setBounds(20, 170, 340, 100);
        btnKopjo.setBounds(150, 285, 80, 30);

        frame.add(lbl1);
        frame.add(sp1);
        frame.add(lbl2);
        frame.add(sp2);
        frame.add(btnKopjo);

        frame.setSize(400, 360);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnKopjo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta2.setText(ta1.getText());
            }
        });
    }
}
