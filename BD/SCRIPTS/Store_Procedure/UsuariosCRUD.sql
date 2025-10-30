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