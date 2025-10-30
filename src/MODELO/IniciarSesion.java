/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IniciarSesion extends javax.swing.JFrame {
    
       private JTextField txtEmail, txtContrasena;
    private JButton btnLogin;
    private CONEXION conexion;

    public IniciarSesion() {
        initComponents();
        conexion = new CONEXION();
        conexion.conectar();
    }

    private void initComponents() {
        txtEmail = new JTextField(20);
        txtContrasena = new JTextField(20);
        btnLogin = new JButton("Iniciar sesión");

        // Acción del botón
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });

        // Aquí puedes agregar tus componentes al JFrame (panel, layout, etc.)
    }

    private void iniciarSesion() {
        try {
            Connection conn = conexion.conn;
            String sql = "{CALL sp_IniciarSesion(?, ?)}";
            CallableStatement cs = conn.prepareCall(sql);

            cs.setString(1, txtEmail.getText());
            cs.setString(2, txtContrasena.getText());

            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                JOptionPane.showMessageDialog(this, "Bienvenido, " + nombre + "!");
                // Aquí puedes abrir otra ventana o menú principal
            } else {
                JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al iniciar sesión: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new IniciarSesion().setVisible(true);
    }
    
}
