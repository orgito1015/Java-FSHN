import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Ushtrimi 5 — Login System (Sistemi i Hyrjes)
 *
 * Detyrë:
 * - Dy fusha teksti: Username dhe Password
 * - Buton "Login"
 * - Nëse username = "admin" dhe password = "1234":
 *     label poshtë butonit bëhet e gjelbër dhe thotë "Akses i lejuar"
 * - Nëse gabim:
 *     label bëhet e kuqe dhe thotë "Username ose Password gabim"
 *
 * Shpjegim:
 * - JPasswordField fsheh karakteret e fjalëkalimit.
 * - new String(pfPassword.getPassword()) konverton char[] në String.
 * - setForeground(Color.GREEN/RED) ndryshon ngjyrën e label-it.
 * - Pas hyrjes me sukses label-i bëhet i gjelbër; gabimi e bën të kuq.
 */
public class LoginApp {

    private static final String SAKT_USERNAME = "admin";
    private static final String SAKT_PASSWORD = "1234";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");

        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        JTextField tfUsername = new JTextField();
        JPasswordField pfPassword = new JPasswordField();
        JButton btnLogin = new JButton("Login");
        JLabel lblStatus = new JLabel("", SwingConstants.CENTER);

        lblUsername.setBounds(20, 30, 80, 25);
        tfUsername.setBounds(110, 30, 150, 25);
        lblPassword.setBounds(20, 70, 80, 25);
        pfPassword.setBounds(110, 70, 150, 25);
        btnLogin.setBounds(110, 115, 100, 30);
        lblStatus.setBounds(20, 160, 260, 25);

        frame.add(lblUsername);
        frame.add(tfUsername);
        frame.add(lblPassword);
        frame.add(pfPassword);
        frame.add(btnLogin);
        frame.add(lblStatus);

        frame.setSize(320, 230);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUsername.getText().trim();
                String password = new String(pfPassword.getPassword());

                if (SAKT_USERNAME.equals(username) && SAKT_PASSWORD.equals(password)) {
                    lblStatus.setForeground(Color.GREEN.darker());
                    lblStatus.setText("Akses i lejuar");
                } else {
                    lblStatus.setForeground(Color.RED);
                    lblStatus.setText("Username ose Password gabim");
                    tfUsername.setText("");
                    pfPassword.setText("");
                    tfUsername.requestFocus();
                }
            }
        });
    }
}
