import java.awt.*;
import java.awt.event.*;

/**
 * Exercise 3 – MenuBar me 3 Menu
 *
 * Frame me MenuBar që përmban Menu1, Menu2, Menu3.
 * Menu3 ka një item "Dil" që mbyll aplikacionin.
 */
public class Exercise3 extends Frame {

    public Exercise3() {
        super("Ushtrimi 3 – MenuBar");

        // --- MenuBar ---
        MenuBar menuBar = new MenuBar();

        Menu menu1 = new Menu("Menu1");
        menu1.add(new MenuItem("Item 1.1"));
        menu1.add(new MenuItem("Item 1.2"));

        Menu menu2 = new Menu("Menu2");
        menu2.add(new MenuItem("Item 2.1"));
        menu2.add(new MenuItem("Item 2.2"));

        Menu menu3 = new Menu("Menu3");
        MenuItem exitItem = new MenuItem("Dil");
        exitItem.addActionListener(e -> dispose());
        menu3.add(exitItem);

        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        setMenuBar(menuBar);

        // --- Përmbajtja e frame ---
        Label info = new Label("Zgjidh Menu3 → Dil për të mbyllur aplikacionin.", Label.CENTER);
        add(info, BorderLayout.CENTER);

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

    public static void main(String[] args) {
        new Exercise3();
    }
}
