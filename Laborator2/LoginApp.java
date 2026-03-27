import javax.swing.*;
import java.awt.event.*;

/**
 * Ushtrimi 5 — Login System (Sistemi i Hyrjes)
 *
 * Detyrë:
 * - Përdorues: admin
 * - Fjalëkalim: 1234
 * - Nëse kredencialet janë të sakta  → "Akses i lejuar"
 * - Nëse kredencialet janë të gabuara → "Username ose Password gabim"
 *
 * Shpjegim:
 * - JPasswordField fsheh karakteret e fjalëkalimit.
 * - new String(pfPassword.getPassword()) konverton char[] në String.
 * - String.equals() krahason username dhe password me vlerat e sakta.
 * - Pas hyrjes me sukses dritarja mbyllet; pas gabimit fushat pastrohen.
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
        JButton btnLogin = new JButton("Hyr");

        lblUsername.setBounds(20, 30, 80, 25);
        tfUsername.setBounds(110, 30, 150, 25);
        lblPassword.setBounds(20, 75, 80, 25);
        pfPassword.setBounds(110, 75, 150, 25);
        btnLogin.setBounds(110, 120, 100, 30);

        frame.add(lblUsername);
        frame.add(tfUsername);
        frame.add(lblPassword);
        frame.add(pfPassword);
        frame.add(btnLogin);

        frame.setSize(320, 220);
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
                    JOptionPane.showMessageDialog(frame,
                            "Akses i lejuar! Miresevini, " + username + ".",
                            "Sukses",
                            JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Username ose Password gabim!",
                            "Gabim hyrjeje",
                            JOptionPane.ERROR_MESSAGE);
                    tfUsername.setText("");
                    pfPassword.setText("");
                    tfUsername.requestFocus();
                }
            }
        });
    }
}
