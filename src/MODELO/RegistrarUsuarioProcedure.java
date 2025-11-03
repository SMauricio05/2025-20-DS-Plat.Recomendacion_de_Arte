package MODELO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class RegistrarUsuarioProcedure {

    private String nombre;
    private String email;
    private String contrasena;
    private Connection conn;

    public RegistrarUsuarioProcedure(Connection conn) {
        this.conn = conn;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Método que inserta el usuario
    public void InsertarUsuario() {
        try {
            String sql = "{CALL sp_InsertarUsuario(?, ?, ?, ?)}";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, nombre);
            cs.setString(2, email);
            cs.setString(3, contrasena);
            cs.setNull(4, java.sql.Types.NVARCHAR); // intereses siempre NULL
            cs.execute();
            JOptionPane.showMessageDialog(null, "✅ Usuario registrado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al registrar usuario: " + e.getMessage());
        }
    }
}
