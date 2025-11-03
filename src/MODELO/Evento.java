package MODELO;

import java.util.Date;

public class Evento {
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private Date fechaInicio;
    private Date fechaFin;
    private String imagenUrl;

    public Evento(String nombre, String descripcion, String ubicacion, Date fechaInicio, Date fechaFin, String imagenUrl) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.imagenUrl = imagenUrl;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getUbicacion() { return ubicacion; }
    public Date getFechaInicio() { return fechaInicio; }
    public Date getFechaFin() { return fechaFin; }
    public String getImagenUrl() { return imagenUrl; }
}
