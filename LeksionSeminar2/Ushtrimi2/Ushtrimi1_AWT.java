import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ushtrimi1_AWT extends Frame implements ActionListener {

    private Label lblEmri, lblAfisho;
    private TextField tfEmri;
    private Button btnKliko;

    Ushtrimi1_AWT() {
        lblEmri = new Label("Jepni emrin");
        lblEmri.setBounds(20, 50, 80, 20);

        tfEmri = new TextField("Emer Mbiemer");
        tfEmri.setBounds(120, 50, 100, 20);

        btnKliko = new Button("Kliko");
        btnKliko.setBounds(20, 100, 100, 30);
        btnKliko.addActionListener(this);

        lblAfisho = new Label();
        lblAfisho.setBounds(20, 150, 100, 20);

        add(tfEmri);
        add(lblEmri);
        add(btnKliko);
        add(lblAfisho);

        setSize(300, 300);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Ushtrimi1_AWT awt = new Ushtrimi1_AWT();
        awt.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent evt) {
        String emri = tfEmri.getText();
        lblAfisho.setText(emri);
        tfEmri.setText("");
    }
}
