import java.awt.*;
import java.awt.event.*;

/**
 * Exercise 2 – Mouse Coordinates
 *
 * Frame me 2 Label dhe 2 TextField.
 * Në klikim të mouse shfaqen koordinatat X dhe Y.
 */
public class Exercise2 extends Frame implements MouseListener {

    private final TextField tfX;
    private final TextField tfY;

    public Exercise2() {
        super("Ushtrimi 2 – Koordinatat e Mouse");

        setLayout(new GridLayout(2, 2, 10, 10));

        add(new Label("X:"));
        tfX = new TextField("0");
        tfX.setEditable(false);
        add(tfX);

        add(new Label("Y:"));
        tfY = new TextField("0");
        tfY.setEditable(false);
        add(tfY);

        addMouseListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setSize(300, 120);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        tfX.setText(String.valueOf(e.getX()));
        tfY.setText(String.valueOf(e.getY()));
    }

    @Override public void mousePressed(MouseEvent e)  {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e)  {}
    @Override public void mouseExited(MouseEvent e)   {}

    public static void main(String[] args) {
        new Exercise2();
    }
}
