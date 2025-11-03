package MODELO;

public class Obra {
    private int id;
    private String titulo;
    private String artista;
    private String descripcion;
    private String categoria;
    private String fechaCreacion;
    private String imagenUrl;
    private boolean disponibilidad;

    // Constructor
    public Obra(int id, String titulo, String artista, String descripcion, String categoria,
                String fechaCreacion, String imagenUrl, boolean disponibilidad) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fechaCreacion = fechaCreacion;
        this.imagenUrl = imagenUrl;
        this.disponibilidad = disponibilidad;
    }

    // Getters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public String getDescripcion() { return descripcion; }
    public String getCategoria() { return categoria; }
    public String getFechaCreacion() { return fechaCreacion; }
    public String getImagenUrl() { return imagenUrl; }
    public boolean isDisponibilidad() { return disponibilidad; }
}
