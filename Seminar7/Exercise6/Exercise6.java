import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;

/**
 * Exercise 6 – Mini-Lojë: Kap Objektet
 *
 * - Nga pjesa e sipërme bien rrathe (objekte) automatikisht me Timer.
 * - Një "kosh" në fund kontrollohet nga përdoruesi me tastet shigjetë.
 * - Kapja e një objekti → +1 pikë.
 * - Nëse objekti bie jashtë (nuk kapet) → -1 jetë (max 5 jetë).
 * - Tasti N  → ndalon lojën (pause)
 * - Tasti R  → vazhdon lojën (resume)
 * - Tasti S  → mbyll aplikacionin
 */
public class Exercise6 extends Frame {

    // --- Parametra të lojës ---
    private static final int WIDTH        = 500;
    private static final int HEIGHT       = 550;
    private static final int BALL_RADIUS  = 15;
    private static final int BASKET_W     = 80;
    private static final int BASKET_H     = 20;
    private static final int BASKET_Y     = HEIGHT - 60;
    private static final int BASKET_SPEED = 20;
    private static final int FALL_SPEED   = 5;
    private static final int SPAWN_TICKS  = 30;   // objekt i ri çdo 30 tick
    private static final int MAX_LIVES    = 5;
    private static final int TIMER_DELAY  = 20;   // ms

    private int basketX;
    private int score;
    private int lives;
    private boolean running;
    private int tickCount;

    private final List<int[]> balls = new ArrayList<>(); // {x, y}
    private final Random rnd = new Random();

    private Timer timer;
    private final GamePanel gamePanel;

    public Exercise6() {
        super("Ushtrimi 6 – Mini-Lojë");

        basketX = WIDTH / 2 - BASKET_W / 2;
        score   = 0;
        lives   = MAX_LIVES;
        running = true;
        tickCount = 0;

        gamePanel = new GamePanel();
        add(gamePanel, BorderLayout.CENTER);

        // --- Timer i lojës ---
        timer = new Timer(TIMER_DELAY, e -> tick());
        timer.start();

        // --- Tastiera ---
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        if (running) basketX = Math.max(0, basketX - BASKET_SPEED);
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (running) basketX = Math.min(WIDTH - BASKET_W, basketX + BASKET_SPEED);
                        break;
                    case KeyEvent.VK_N:
                        running = false;
                        break;
                    case KeyEvent.VK_R:
                        running = true;
                        break;
                    case KeyEvent.VK_S:
                        dispose();
                        break;
                }
                gamePanel.repaint();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override public void windowClosing(WindowEvent e) { dispose(); }
        });

        setResizable(false);
        setSize(WIDTH, HEIGHT + 40);
        setLocationRelativeTo(null);
        setFocusable(true);
        setVisible(true);
        requestFocus();
    }

    private void tick() {
        if (!running) return;

        tickCount++;

        // Shto objekt të ri
        if (tickCount % SPAWN_TICKS == 0) {
            int x = BALL_RADIUS + rnd.nextInt(WIDTH - 2 * BALL_RADIUS);
            balls.add(new int[]{x, 0});
        }

        // Lëviz objektet poshtë
        Iterator<int[]> it = balls.iterator();
        while (it.hasNext()) {
            int[] ball = it.next();
            ball[1] += FALL_SPEED;

            // Kap → zhduk
            if (ball[1] + BALL_RADIUS >= BASKET_Y &&
                ball[0] >= basketX - BALL_RADIUS &&
                ball[0] <= basketX + BASKET_W + BALL_RADIUS) {
                score++;
                it.remove();
            }
            // Bie jashtë → humb jetë
            else if (ball[1] - BALL_RADIUS > HEIGHT) {
                lives--;
                it.remove();
                if (lives <= 0) {
                    running = false;
                }
            }
        }

        gamePanel.repaint();
    }

    // --- Panel i vizatimit ---
    class GamePanel extends Panel {
        @Override
        public void paint(Graphics g) {
            // Sfond
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);

            // Objektet (rrathe)
            g.setColor(Color.CYAN);
            for (int[] ball : balls) {
                g.fillOval(ball[0] - BALL_RADIUS, ball[1] - BALL_RADIUS,
                           2 * BALL_RADIUS, 2 * BALL_RADIUS);
            }

            // Koshi
            g.setColor(Color.GREEN);
            g.fillRect(basketX, BASKET_Y, BASKET_W, BASKET_H);

            // HUD – pikët dhe jetët
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 14));
            g.drawString("Pikë: " + score, 10, 20);
            g.drawString("Jetë: " + lives, WIDTH - 80, 20);

            // Mesazh pause / game over
            if (!running) {
                g.setFont(new Font("Arial", Font.BOLD, 20));
                if (lives <= 0) {
                    g.setColor(Color.RED);
                    g.drawString("GAME OVER! Pikë: " + score, WIDTH / 2 - 100, HEIGHT / 2);
                    g.setFont(new Font("Arial", Font.PLAIN, 14));
                    g.drawString("Shtyp S për të dalë", WIDTH / 2 - 60, HEIGHT / 2 + 30);
                } else {
                    g.setColor(Color.YELLOW);
                    g.drawString("NDAL  –  R për të vazhduar", WIDTH / 2 - 130, HEIGHT / 2);
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(WIDTH, HEIGHT);
        }
    }

    public static void main(String[] args) {
        new Exercise6();
    }
}
