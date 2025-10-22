CREATE TABLE ObrasArte (
    id_obra INT IDENTITY(1,1) PRIMARY KEY,
    titulo NVARCHAR(200) NOT NULL,
    artista NVARCHAR(150),
    descripcion NVARCHAR(MAX),
    categoria NVARCHAR(100),
    fecha_creacion DATE,
    imagen_url NVARCHAR(300),
    disponible BIT DEFAULT 1
);