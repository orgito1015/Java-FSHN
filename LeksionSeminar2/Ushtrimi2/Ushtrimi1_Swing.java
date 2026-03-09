import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ushtrimi1_Swing {

    private JLabel lblEmri, lblAfisho;
    private JTextField tfEmri;
    private JButton btnKliko;

    Ushtrimi1_Swing() {
        JFrame f = new JFrame();

        lblEmri = new JLabel("Jepni emrin:");
        lblEmri.setBounds(20, 50, 100, 20);

        tfEmri = new JTextField("Emer Mbiemer");
        tfEmri.setBounds(120, 50, 100, 20);

        btnKliko = new JButton("Kliko");
        btnKliko.setBounds(20, 100, 100, 30);

        lblAfisho = new JLabel();
        lblAfisho.setBounds(20, 150, 100, 20);

        f.add(tfEmri);
        f.add(lblEmri);
        f.add(btnKliko);
        f.add(lblAfisho);

        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnKliko.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String emri = tfEmri.getText();
                lblAfisho.setText(emri);
                tfEmri.setText("");
            }
        });
    }

    public static void main(String[] args) {
        Ushtrimi1_Swing s = new Ushtrimi1_Swing();
    }
}
