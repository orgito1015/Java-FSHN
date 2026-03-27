import javax.swing.*;
import java.awt.event.*;

/**
 * UshtrimeSeminar2 — Ushtrimi 2: Ndërrues Ngjyrash (Color Switcher)
 *
 * Detyrë:
 * - Krijo një panel me dy butona: "E Kuqe" dhe "E Kaltër".
 * - Klikimi i butonit ndryshon ngjyrën e sfondit të panelit.
 *
 * Shpjegim:
 * - JPanel është kontejner Swing me background të modifikueshëm.
 * - setBackground(Color.RED) / setBackground(Color.BLUE) ndryshon ngjyrën.
 * - repaint() rikërkon vizatimin e panelit pas ndryshimit të ngjyrës.
 * - Shtimi i butonat në SOUTH dhe panelit kryesor në CENTER me BorderLayout.
 */
public class NgjyraPanel {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ndërrues Ngjyrash");

        JPanel panel = new JPanel();
        panel.setBackground(java.awt.Color.WHITE);

        JButton btnKuq   = new JButton("E Kuqe");
        JButton btnKalter = new JButton("E Kaltër");

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnKuq);
        btnPanel.add(btnKalter);

        frame.add(panel, java.awt.BorderLayout.CENTER);
        frame.add(btnPanel, java.awt.BorderLayout.SOUTH);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnKuq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(java.awt.Color.RED);
                panel.repaint();
            }
        });

        btnKalter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(java.awt.Color.BLUE);
                panel.repaint();
            }
        });
    }
}
