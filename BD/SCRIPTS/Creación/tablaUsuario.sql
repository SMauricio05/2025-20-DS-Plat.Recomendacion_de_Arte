CREATE TABLE Usuarios (
    id_usuario INT IDENTITY(1,1) PRIMARY KEY,
    nombre NVARCHAR(100) NOT NULL,
    email NVARCHAR(150) UNIQUE NOT NULL,
    contrasena NVARCHAR(255) NOT NULL,
    intereses NVARCHAR(500),
    fecha_registro DATETIME DEFAULT GETDATE(),
    activo BIT DEFAULT 1
);
