import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ushtrimi4 {

    private JLabel lblVlera, lblShuma;
    private JTextField tfVlera, tfShuma;
    private double shuma = 0;

    Ushtrimi4() {
        JFrame f = new JFrame("Shuma");

        lblVlera = new JLabel("Jepni vleren:");
        lblVlera.setBounds(20, 50, 100, 20);

        tfVlera = new JTextField();
        tfVlera.setBounds(130, 50, 100, 20);

        lblShuma = new JLabel("Shuma:");
        lblShuma.setBounds(20, 100, 100, 20);

        tfShuma = new JTextField("0");
        tfShuma.setBounds(130, 100, 100, 20);
        tfShuma.setEditable(false);

        f.add(lblVlera);
        f.add(tfVlera);
        f.add(lblShuma);
        f.add(tfShuma);

        f.setSize(300, 200);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tfVlera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double vlera = Double.parseDouble(tfVlera.getText());
                    shuma += vlera;
                    tfShuma.setText(String.valueOf(shuma));
                    tfVlera.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ju lutem jepni nje vlere numerike!");
                    tfVlera.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        new Ushtrimi4();
    }
}
