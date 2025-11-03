package MODELO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MostrarObras {

    public List<Obra> obtenerObras() {
        List<Obra> lista = new ArrayList<>();
        try {
            CONEXION conexion = new CONEXION();
            conexion.conectar();
            Connection conn = conexion.getConnection();

            String sql = "SELECT * FROM ObrasArte WHERE disponibilidad = 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Obra obra = new Obra(
                    rs.getInt("id_obra"),
                    rs.getString("titulo"),
                    rs.getString("artista"),
                    rs.getString("descripcion"),
                    rs.getString("categoria"),
                    rs.getString("fecha_creacion"),
                    rs.getString("imagen_url"),
                    rs.getBoolean("disponibilidad")
                );
                lista.add(obra);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
