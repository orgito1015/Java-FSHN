import javax.swing.*;
import java.awt.*;

public class Exercise7 extends JFrame {

    private int niveli = 0;
    private final KochPanel panel;

    public Exercise7() {
        super("Ushtrimi 7 – Flok dëbore Koch");

        panel = new KochPanel();
        JButton nextButton = new JButton("Iteracioni pasardhës");
        JLabel levelLabel = new JLabel("Niveli: 0");

        nextButton.addActionListener(e -> {
            niveli++;
            levelLabel.setText("Niveli: " + niveli);
            panel.repaint();
        });

        JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER));
        controls.add(nextButton);
        controls.add(levelLabel);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(controls, BorderLayout.SOUTH);

        setSize(800, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class KochPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(1.2f));
            g2.setColor(new Color(30, 80, 180));

            int w = getWidth();
            int h = getHeight();
            int margin = 70;

            PointD p1 = new PointD(w / 2.0, margin);
            PointD p2 = new PointD(margin, h - margin);
            PointD p3 = new PointD(w - margin, h - margin);

            drawKoch(g2, p1, p2, niveli);
            drawKoch(g2, p2, p3, niveli);
            drawKoch(g2, p3, p1, niveli);
        }

        private void drawKoch(Graphics2D g2, PointD a, PointD b, int level) {
            if (level == 0) {
                g2.drawLine((int) Math.round(a.x), (int) Math.round(a.y),
                            (int) Math.round(b.x), (int) Math.round(b.y));
                return;
            }

            double dx = (b.x - a.x) / 3.0;
            double dy = (b.y - a.y) / 3.0;

            PointD pA = new PointD(a.x + dx, a.y + dy);
            PointD pB = new PointD(a.x + 2 * dx, a.y + 2 * dy);

            double angle = -Math.PI / 3.0;
            double rx = dx * Math.cos(angle) - dy * Math.sin(angle);
            double ry = dx * Math.sin(angle) + dy * Math.cos(angle);
            PointD pPeak = new PointD(pA.x + rx, pA.y + ry);

            drawKoch(g2, a, pA, level - 1);
            drawKoch(g2, pA, pPeak, level - 1);
            drawKoch(g2, pPeak, pB, level - 1);
            drawKoch(g2, pB, b, level - 1);
        }
    }

    private static class PointD {
        final double x;
        final double y;

        PointD(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Exercise7::new);
    }
}
