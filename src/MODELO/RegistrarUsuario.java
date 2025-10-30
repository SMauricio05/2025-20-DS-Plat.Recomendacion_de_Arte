/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class RegistrarUsuario extends javax.swing.JFrame {
      private JTextField txtNombre, txtEmail, txtContrasena, txtIntereses;
    private JButton btnGuardar;
    private CONEXION conexion;

    public RegistrarUsuario() {
        initComponents();
        conexion = new CONEXION();
        conexion.conectar(); // Abre la conexión a SQL Server
    }

    private void initComponents() {
        txtNombre = new JTextField(20);
        txtEmail = new JTextField(20);
        txtContrasena = new JTextField(20);
        txtIntereses = new JTextField(20);
        btnGuardar = new JButton("Guardar Usuario");

        // Evento del botón
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarUsuario();
            }
        });

        // Aquí puedes agregar los componentes al JFrame (layout, panel, etc.)
    }

    private void insertarUsuario() {
        try {
            Connection conn = conexion.conn; // usa la conexión existente
            String sql = "{CALL sp_InsertarUsuario(?, ?, ?, ?)}"; // llamada al SP
            CallableStatement cs = conn.prepareCall(sql);

            // Asignar parámetros
            cs.setString(1, txtNombre.getText());
            cs.setString(2, txtEmail.getText());
            cs.setString(3, txtContrasena.getText());
            cs.setString(4, txtIntereses.getText());

            cs.execute(); // ejecuta el procedimiento
            JOptionPane.showMessageDialog(this, "Usuario insertado correctamente.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al insertar el usuario: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new RegistrarUsuario().setVisible(true);
    }
    
}
