import java.awt.*;
import java.awt.event.*;

/**
 * Exercise 1 – Mouse Events Demo
 *
 * Shpjegim i klasës MouseEvent dhe ndërfaqeve listener:
 *
 * MouseEvent është një klasë event që gjenerohет kur përdoruesi ndërvepron me
 * miun (shtypje, lëshim, klikim, lëvizje, hyrje/dalje). Objekti MouseEvent mban
 * koordinatat (X, Y) të cursorit si dhe butonin e shtypur.
 *
 * Dy ndërfaqet listener:
 *   1. MouseListener      – trajton ngjarjet: mouseClicked, mousePressed,
 *                           mouseReleased, mouseEntered, mouseExited
 *   2. MouseMotionListener – trajton ngjarjet: mouseMoved, mouseDragged
 *
 * Disa metoda të rëndësishme:
 *   getX() / getY()     – koordinatat e cursorit në momentin e ngjarjes
 *   getButton()         – butoni i miut (BUTTON1/2/3)
 *   getClickCount()     – numri i klikimeve radhazi
 *   isShiftDown() …     – gjendje e tasteve modifikuese
 */
public class Exercise1 extends Frame implements MouseListener, MouseMotionListener {

    private final TextArea log;

    public Exercise1() {
        super("Ushtrimi 1 – Mouse Events Demo");
        setLayout(new BorderLayout());

        log = new TextArea("Ngjarjet e mouse do të shfaqen këtu:\n", 20, 60, TextArea.SCROLLBARS_VERTICAL_ONLY);
        log.setEditable(false);
        add(log, BorderLayout.CENTER);

        addMouseListener(this);
        addMouseMotionListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void appendLog(String msg) {
        log.append(msg + "\n");
    }

    // --- MouseListener ---
    @Override public void mouseClicked(MouseEvent e)  { appendLog("mouseClicked  @ (" + e.getX() + ", " + e.getY() + ") buton=" + e.getButton()); }
    @Override public void mousePressed(MouseEvent e)  { appendLog("mousePressed  @ (" + e.getX() + ", " + e.getY() + ")"); }
    @Override public void mouseReleased(MouseEvent e) { appendLog("mouseReleased @ (" + e.getX() + ", " + e.getY() + ")"); }
    @Override public void mouseEntered(MouseEvent e)  { appendLog("mouseEntered  (cursor hyri në frame)"); }
    @Override public void mouseExited(MouseEvent e)   { appendLog("mouseExited   (cursor doli nga frame)"); }

    // --- MouseMotionListener ---
    @Override public void mouseMoved(MouseEvent e)    { /* mos logi lëvizjen – do mbushte log-un shpejt */ }
    @Override public void mouseDragged(MouseEvent e)  { appendLog("mouseDragged  @ (" + e.getX() + ", " + e.getY() + ")"); }

    public static void main(String[] args) {
        new Exercise1();
    }
}
