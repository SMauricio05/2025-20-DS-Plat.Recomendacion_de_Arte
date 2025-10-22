CREATE TABLE Eventos (
    id_evento INT IDENTITY(1,1) PRIMARY KEY,
    nombre NVARCHAR(200) NOT NULL,
    descripcion NVARCHAR(MAX),
    ubicacion NVARCHAR(200),
    fecha_inicio DATE,
    fecha_fin DATE,
    imagen_url NVARCHAR(300),
    activo BIT DEFAULT 1
);