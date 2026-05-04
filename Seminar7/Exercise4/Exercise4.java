import java.awt.*;
import java.awt.event.*;

/**
 * Exercise 4 – Popup Menu
 *
 * Panel me tekst. Me klik të djathtë shfaqet popup menu me:
 *   "Bold", "Italic", "Bold Italic"
 * Zgjedhja ndryshon stilin e fontit të tekstit.
 */
public class Exercise4 extends Frame {

    private final Label textLabel;
    private final PopupMenu popupMenu;

    public Exercise4() {
        super("Ushtrimi 4 – Popup Menu");
        setLayout(new BorderLayout());

        textLabel = new Label("Ky tekst do të ndryshojë stilin!", Label.CENTER);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(textLabel, BorderLayout.CENTER);

        // --- Popup Menu ---
        popupMenu = new PopupMenu();

        MenuItem boldItem      = new MenuItem("Bold");
        MenuItem italicItem    = new MenuItem("Italic");
        MenuItem boldItalicItem = new MenuItem("Bold Italic");

        boldItem.addActionListener(e      -> setStyle(Font.BOLD));
        italicItem.addActionListener(e    -> setStyle(Font.ITALIC));
        boldItalicItem.addActionListener(e -> setStyle(Font.BOLD | Font.ITALIC));

        popupMenu.add(boldItem);
        popupMenu.add(italicItem);
        popupMenu.add(boldItalicItem);
        add(popupMenu);

        // Trego popup-in me klik të djathtë
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(Exercise4.this, e.getX(), e.getY());
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(Exercise4.this, e.getX(), e.getY());
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setStyle(int style) {
        Font current = textLabel.getFont();
        textLabel.setFont(new Font(current.getName(), style, current.getSize()));
    }

    public static void main(String[] args) {
        new Exercise4();
    }
}
