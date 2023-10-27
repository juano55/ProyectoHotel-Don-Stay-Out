import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


public class LoginApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    public URL fondo = this.getClass().getResource("/imagen/1.jpg");
    public Image imagenfondo = new ImageIcon (fondo).getImage();

    
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Inicio de Sesión");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        
        JPanel panel_n = new JPanel();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel_n.setBackground(Color.cyan);
        panel.add(panel_n, constraints);
        
        JLabel userLabel = new JLabel("Usuario:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(userLabel, constraints);

        JTextField userField = new JTextField(20);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(userField, constraints);

        JLabel passwordLabel = new JLabel("Contraseña:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(passwordLabel, constraints);

        JPasswordField passwordField = new JPasswordField(20);
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(passwordField, constraints);

        JButton loginButton = new JButton("Iniciar Sesión");
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(loginButton, constraints);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                char[] password = passwordField.getPassword();
                // Aquí puedes verificar el nombre de usuario y contraseña
                // por ejemplo, comparándolos con los valores correctos.

                if (username.equals("usuario") && String.valueOf(password).equals("contraseña")) {
                    JOptionPane.showMessageDialog(frame, "Inicio de sesión exitoso");
                } else {
                    JOptionPane.showMessageDialog(frame, "Inicio de sesión fallido");
                }
                // Limpia los campos después del intento de inicio de sesión.
                userField.setText("");
                passwordField.setText("");
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    
}
