CREATE TABLE Eventos (
    id_evento INT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    descripcion VARCHAR(MAX),
    ubicacion VARCHAR(200),
    fecha_inicio DATE,
    fecha_fin DATE,
    imagen_url VARCHAR(300),
    activo BIT DEFAULT 1

);
