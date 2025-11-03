package MODELO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuscarEnBD {

    public static class Obra {
        private int id;
        private String titulo;
        private String artista;
        private String descripcion;
        private String categoria;
        private String fechaCreacion;
        private String imagenUrl;

        // Constructor
        public Obra(int id, String titulo, String artista, String descripcion,
                    String categoria, String fechaCreacion, String imagenUrl) {
            this.id = id;
            this.titulo = titulo;
            this.artista = artista;
            this.descripcion = descripcion;
            this.categoria = categoria;
            this.fechaCreacion = fechaCreacion;
            this.imagenUrl = imagenUrl;
        }

        // Getters
        public int getId() { return id; }
        public String getTitulo() { return titulo; }
        public String getArtista() { return artista; }
        public String getDescripcion() { return descripcion; }
        public String getCategoria() { return categoria; }
        public String getFechaCreacion() { return fechaCreacion; }
        public String getImagenUrl() { return imagenUrl; }
    }

    /**
     * Busca coincidencias de obras o artistas en la tabla ObrasArte.
     * @param termino Texto que ingresa el usuario
     * @return Lista de objetos Obra que coinciden
     */
    public List<Obra> buscarObras(String termino) {
        List<Obra> resultados = new ArrayList<>();
        CONEXION conexion = new CONEXION();
        conexion.conectar();

        String sql = "SELECT id_obra, titulo, artista, descripcion, categoria, " +
                     "CONVERT(VARCHAR, fecha_creacion, 103) AS fecha_creacion, imagen_url " +
                     "FROM ObrasArte " +
                     "WHERE titulo LIKE ? OR artista LIKE ?";

        try (Connection conn = conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String likeTerm = "%" + termino + "%";
            stmt.setString(1, likeTerm);
            stmt.setString(2, likeTerm);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                resultados.add(new Obra(
                        rs.getInt("id_obra"),
                        rs.getString("titulo"),
                        rs.getString("artista"),
                        rs.getString("descripcion"),
                        rs.getString("categoria"),
                        rs.getString("fecha_creacion"),
                        rs.getString("imagen_url")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar en la base de datos: " + e.getMessage());
        }

        return resultados;
    }
}
