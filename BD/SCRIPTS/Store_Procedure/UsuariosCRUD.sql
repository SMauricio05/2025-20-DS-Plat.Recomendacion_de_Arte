-- Insertar usuario
CREATE PROCEDURE sp_InsertarUsuario
    @nombre NVARCHAR(100),
    @email NVARCHAR(150),
    @contrasena NVARCHAR(255),
    @intereses NVARCHAR(500)
AS
BEGIN
    INSERT INTO Usuarios (nombre, email, contrasena, intereses)
    VALUES (@nombre, @email, @contrasena, @intereses);
END;
GO

-- Seleccionar usuarios
CREATE PROCEDURE sp_ListarUsuarios
AS
BEGIN
    SELECT * FROM Usuarios WHERE activo = 1;
END;
GO

-- Actualizar usuario
CREATE PROCEDURE sp_ActualizarUsuario
    @id_usuario INT,
    @nombre NVARCHAR(100),
    @intereses NVARCHAR(500)
AS
BEGIN
    UPDATE Usuarios
    SET nombre = @nombre,
        intereses = @intereses
    WHERE id_usuario = @id_usuario;
END;
GO

EXEC sp_ListarUsuarios;


-- Eliminar usuario (marcar como inactivo)
CREATE PROCEDURE sp_EliminarUsuario
    @id_usuario INT
AS
BEGIN
    UPDATE Usuarios
    SET activo = 0
    WHERE id_usuario = @id_usuario;
END;
GO




-- Inserción de 7 usuarios de ejemplo

EXEC sp_InsertarUsuario 
    @nombre = 'Juan Pérez', 
    @email = 'juan.perez@gmail.com', 
    @contrasena = 'juan123', 
    @intereses = 'Arte, música, cine';

EXEC sp_InsertarUsuario 
    @nombre = 'María López', 
    @email = 'maria.lopez@gmail.com', 
    @contrasena = 'maria456', 
    @intereses = 'Pintura, lectura, danza';

EXEC sp_InsertarUsuario 
    @nombre = 'Carlos Gómez', 
    @email = 'carlos.gomez@gmail.com', 
    @contrasena = 'carlos789', 
    @intereses = 'Escultura, teatro, fotografía';

EXEC sp_InsertarUsuario 
    @nombre = 'Lucía Torres', 
    @email = 'lucia.torres@gmail.com', 
    @contrasena = 'lucia101', 
    @intereses = 'Diseño, arte digital, viajes';

EXEC sp_InsertarUsuario 
    @nombre = 'Pedro Ramírez', 
    @email = 'pedro.ramirez@gmail.com', 
    @contrasena = 'pedro202', 
    @intereses = 'Cine, pintura, literatura';

EXEC sp_InsertarUsuario 
    @nombre = 'Ana Castillo', 
    @email = 'ana.castillo@gmail.com', 
    @contrasena = 'ana303', 
    @intereses = 'Música, fotografía, moda';

EXEC sp_InsertarUsuario 
    @nombre = 'Diego Fernández', 
    @email = 'diego.fernandez@gmail.com', 
    @contrasena = 'diego404', 
    @intereses = 'Arquitectura, diseño gráfico, escultura';
GO
---PARA VERIFICAR LOS USUARIOS REGISTRADOS

EXEC sp_ListarUsuarios;
GO
