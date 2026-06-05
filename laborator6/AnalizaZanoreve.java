import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnalizaZanoreve extends JFrame {

    private final JTextField inputField;
    private final JLabel rezultatiLabel;

    public AnalizaZanoreve() {
        setTitle("Analiza e Zanoreve");
        setSize(400, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        add(new JLabel("Shkruani nje fjale:"));

        inputField = new JTextField(20);
        add(inputField);

        JButton butonAnalizo = new JButton("Analizo");
        add(butonAnalizo);

        rezultatiLabel = new JLabel("Rezultati do te shfaqet ketu...");
        add(rezultatiLabel);

        butonAnalizo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teksti = inputField.getText().toUpperCase();
                int count = 0;

                for (char c : teksti.toCharArray()) {
                    if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                        count++;
                    }
                }

                rezultatiLabel.setText("Numri i zanoreve: " + count);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AnalizaZanoreve().setVisible(true));
    }
}
