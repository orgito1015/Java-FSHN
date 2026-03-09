//SWING
import javax.swing.*;

public class Shembull1_Swing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Frame i pare");
        JLabel lbl = new JLabel("Pershendetje te gjitheve", JLabel.CENTER);

        frame.add(lbl);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
