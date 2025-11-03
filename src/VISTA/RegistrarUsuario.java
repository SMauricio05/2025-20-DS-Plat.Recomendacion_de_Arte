package VISTA;

import javax.swing.*;
import MODELO.CONEXION;
import java.awt.*;
import java.awt.event.*;

public class RegistrarUsuario extends JPanel {

    private MainArtify mainFrame;
    private JTextField txtNombre, txtCorreo, txtContrasena;
    private JButton btnRegistrar, btnVolver;

    public RegistrarUsuario(MainArtify frame) {
        this.mainFrame = frame;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblTitulo = new JLabel("Crear Cuenta - Artify");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblCorreo = new JLabel("Correo:");
        JLabel lblContrasena = new JLabel("Contraseña:");

        txtNombre = new JTextField(20);
        txtCorreo = new JTextField(20);
        txtContrasena = new JTextField(20);

        btnRegistrar = new JButton("Registrar");
        btnVolver = new JButton("Volver");

        // Acción registrar usuario
        btnRegistrar.addActionListener(e -> registrarUsuario());

        // Acción volver al login
        btnVolver.addActionListener(e -> mainFrame.mostrarPanel("Login"));

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridwidth = 1; gbc.gridy++;
        add(lblNombre, gbc);
        gbc.gridx = 1;
        add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblCorreo, gbc);
        gbc.gridx = 1;
        add(txtCorreo, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblContrasena, gbc);
        gbc.gridx = 1;
        add(txtContrasena, gbc);

        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 2;
        add(btnRegistrar, gbc);

        gbc.gridy++;
        add(btnVolver, gbc);
    }

    private void registrarUsuario() {
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String contrasena = txtContrasena.getText();

        CONEXION conexion = new CONEXION();
        conexion.conectar();
        try {
            var conn = conexion.getConnection();
            var ps = conn.prepareStatement("EXEC sp_InsertarUsuario ?, ?, ?, NULL");
            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setString(3, contrasena);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Usuario registrado con éxito");
            mainFrame.mostrarPanel("Login");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar usuario: " + ex.getMessage());
        }
    }
}
