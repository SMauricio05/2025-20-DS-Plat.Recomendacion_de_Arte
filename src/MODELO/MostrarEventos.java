package MODELO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MostrarEventos {
    private CONEXION conexion;

    public MostrarEventos() {
        conexion = new CONEXION();
        conexion.conectar();
    }

    public List<Evento> obtenerEventos() {
        List<Evento> lista = new ArrayList<>();

        try (Connection conn = conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT nombre, descripcion, ubicacion, fecha_inicio, fecha_fin, imagen_url FROM Eventos WHERE activo = 1")) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Evento e = new Evento(
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("ubicacion"),
                        rs.getDate("fecha_inicio"),
                        rs.getDate("fecha_fin"),
                        rs.getString("imagen_url")
                );
                lista.add(e);
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener los eventos: " + ex.getMessage());
        }

        return lista;
    }
}
