CREATE TABLE ObrasArte (
    id_obra INT IDENTITY(1,1) PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    artista VARCHAR(150),
    descripcion VARCHAR(MAX),
    categoria VARCHAR(100),
    fecha_creacion DATE,
    imagen_url VARCHAR(300),
    disponible BIT DEFAULT 1

);
