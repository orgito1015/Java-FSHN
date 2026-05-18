import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Exercise2 extends JFrame {

    private final int[] values;
    private final BarPanel barPanel;
    private final JButton sortButton;
    private int i = 0;
    private int j = 0;
    private boolean swapped = false;

    public Exercise2() {
        super("Vizualizimi i Bubble Sort");
        this.values = gjeneroVlera(30);
        this.barPanel = new BarPanel(values);
        this.sortButton = new JButton("Rendit");

        setLayout(new BorderLayout());
        add(barPanel, BorderLayout.CENTER);
        add(sortButton, BorderLayout.SOUTH);

        sortButton.addActionListener(e -> filloRenditjen());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private int[] gjeneroVlera(int n) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int k = 0; k < n; k++) {
            arr[k] = random.nextInt(200) + 20;
        }
        return arr;
    }

    private void filloRenditjen() {
        sortButton.setEnabled(false);
        i = 0;
        j = 0;
        swapped = false;

        Timer timer = new Timer(80, e -> {
            if (i >= values.length - 1) {
                ((Timer) e.getSource()).stop();
                sortButton.setEnabled(true);
                return;
            }

            if (j < values.length - 1 - i) {
                if (values[j] > values[j + 1]) {
                    int temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                    swapped = true;
                }
                j++;
                barPanel.repaint();
            } else {
                if (!swapped) {
                    ((Timer) e.getSource()).stop();
                    sortButton.setEnabled(true);
                    return;
                }
                i++;
                j = 0;
                swapped = false;
            }
        });

        timer.start();
    }

    static class BarPanel extends JPanel {
        private final int[] values;

        BarPanel(int[] values) {
            this.values = values;
            setPreferredSize(new Dimension(800, 450));
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (values.length == 0) return;

            int width = getWidth();
            int height = getHeight();
            int max = 1;
            for (int v : values) {
                if (v > max) max = v;
            }

            int barWidth = Math.max(1, width / values.length);
            for (int k = 0; k < values.length; k++) {
                int barHeight = (int) ((values[k] / (double) max) * (height - 20));
                int x = k * barWidth;
                int y = height - barHeight;

                g.setColor(new Color(70, 130, 180));
                g.fillRect(x, y, barWidth - 2, barHeight);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Exercise2::new);
    }
}
