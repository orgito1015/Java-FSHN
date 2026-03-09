//AWT
import java.awt.*;
import java.awt.event.*;

public class Shembull1 {
    public static void main(String[] args) {
        Frame frame = new Frame("Frame i pare");
        Label lbl = new Label("Pershendetje te gjitheve", Label.CENTER);
        frame.add(lbl);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}
