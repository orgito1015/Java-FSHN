import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ushtrimi3 {

    private JLabel lbl;
    private JTextField tfCounter;
    private JButton btnRrit;
    private int counter = 0;

    Ushtrimi3() {
        JFrame f = new JFrame("Counter");

        lbl = new JLabel("Vlera:");
        lbl.setBounds(20, 50, 80, 20);

        tfCounter = new JTextField("0");
        tfCounter.setBounds(110, 50, 100, 20);
        tfCounter.setEditable(false);

        btnRrit = new JButton("Rrit");
        btnRrit.setBounds(20, 100, 100, 30);

        f.add(lbl);
        f.add(tfCounter);
        f.add(btnRrit);

        f.setSize(300, 200);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnRrit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                tfCounter.setText(String.valueOf(counter));
            }
        });
    }

    public static void main(String[] args) {
        new Ushtrimi3();
    }
}
