CREATE TABLE Usuarios (
    id_usuario INT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    intereses VARCHAR(500),
    fecha_registro DATETIME DEFAULT GETDATE(),
    activo BIT DEFAULT 1
);

