import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Exercise 5 – ComboBox me Ngjyra + Checkbox + 20 Katrore Random
 *
 * - ComboBox me 3 ngjyra: E kuqe, Blu, E verdhë
 * - Checkbox "I ngjyrosur" – nëse checked, katrorët mbushen me ngjyrë
 * - 20 katrore me koordinata random vizatohen sa herë ndryshon zgjedhja
 */
public class Exercise5 extends Frame implements ItemListener {

    private final Choice colorChoice;
    private final Checkbox filledCheck;
    private final DrawPanel drawPanel;

    public Exercise5() {
        super("Ushtrimi 5 – Katrore me Ngjyra");
        setLayout(new BorderLayout());

        // --- Panel i kontrollit ---
        Panel controlPanel = new Panel(new FlowLayout());

        colorChoice = new Choice();
        colorChoice.add("E kuqe");
        colorChoice.add("Blu");
        colorChoice.add("E verdhë");
        colorChoice.addItemListener(this);

        filledCheck = new Checkbox("I ngjyrosur", true);
        filledCheck.addItemListener(this);

        controlPanel.add(new Label("Ngjyra:"));
        controlPanel.add(colorChoice);
        controlPanel.add(filledCheck);
        add(controlPanel, BorderLayout.NORTH);

        // --- Panel i vizatimit ---
        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override public void windowClosing(WindowEvent e) { dispose(); }
        });

        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        drawPanel.repaint();
    }

    private Color getSelectedColor() {
        switch (colorChoice.getSelectedIndex()) {
            case 0:  return Color.RED;
            case 1:  return Color.BLUE;
            default: return Color.YELLOW;
        }
    }

    // --- Panel i brendshëm ---
    class DrawPanel extends Panel {
        private static final int SQUARES  = 20;
        private static final int SQ_SIZE  = 40;
        private static final long SEED_MULTIPLIER = 1000L;
        private final Random rnd = new Random();

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            int w = getWidth()  - SQ_SIZE;
            int h = getHeight() - SQ_SIZE;
            if (w <= 0 || h <= 0) return;

            Color c    = getSelectedColor();
            boolean fill = filledCheck.getState();

            rnd.setSeed(colorChoice.getSelectedIndex() * SEED_MULTIPLIER + (fill ? 1 : 0));

            for (int i = 0; i < SQUARES; i++) {
                int x = rnd.nextInt(w);
                int y = rnd.nextInt(h);
                g.setColor(c);
                if (fill) {
                    g.fillRect(x, y, SQ_SIZE, SQ_SIZE);
                } else {
                    g.drawRect(x, y, SQ_SIZE, SQ_SIZE);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Exercise5();
    }
}
