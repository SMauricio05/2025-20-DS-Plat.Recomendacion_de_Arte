package VISTA;

import javax.swing.*;
import MODELO.CONEXION;
import java.awt.*;

public class LoginUsuario extends JPanel {

    private MainArtify mainFrame; // referencia al frame principal
    private JTextField txtCorreo;
    private JPasswordField txtContrasena;
    private JButton btnLogin, btnCrearCuenta;

    public LoginUsuario(MainArtify frame) {
        this.mainFrame = frame;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblTitulo = new JLabel("Inicio de Sesión - Artify");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel lblCorreo = new JLabel("Correo:");
        JLabel lblContrasena = new JLabel("Contraseña:");

        txtCorreo = new JTextField(20);
        txtContrasena = new JPasswordField(20);

        btnLogin = new JButton("Iniciar Sesión");
        btnCrearCuenta = new JButton("Crear Cuenta");

        // Evento para iniciar sesión
        btnLogin.addActionListener(e -> iniciarSesion());

        // Evento para ir al panel de registro
        btnCrearCuenta.addActionListener(e -> mainFrame.mostrarPanel("Registro"));

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridwidth = 1; gbc.gridy++;
        add(lblCorreo, gbc);
        gbc.gridx = 1;
        add(txtCorreo, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblContrasena, gbc);
        gbc.gridx = 1;
        add(txtContrasena, gbc);

        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 2;
        add(btnLogin, gbc);

        gbc.gridy++;
        add(btnCrearCuenta, gbc);
    }

    private void iniciarSesion() {
        String correo = txtCorreo.getText();
        String contrasena = new String(txtContrasena.getPassword());

        CONEXION conexion = new CONEXION();
        conexion.conectar();
        try {
            var conn = conexion.getConnection();
            var ps = conn.prepareStatement(
                "SELECT * FROM Usuarios WHERE email = ? AND contrasena = ?"
            );
            ps.setString(1, correo);
            ps.setString(2, contrasena);
            var rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
                mainFrame.mostrarPanel("Inicio");
            } else {
                JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + ex.getMessage());
        }
    }
}
