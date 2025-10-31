--1-INSERTAR EVENTO
CREATE PROCEDURE sp_InsertarEvento
    @nombre VARCHAR(200),
    @descripcion VARCHAR(MAX),
    @ubicacion VARCHAR(200),
    @fecha_inicio DATE,
    @fecha_fin DATE,
    @imagen_url VARCHAR(300)
AS
BEGIN
    INSERT INTO Eventos (nombre, descripcion, ubicacion, fecha_inicio, fecha_fin, imagen_url)
    VALUES (@nombre, @descripcion, @ubicacion, @fecha_inicio, @fecha_fin, @imagen_url);
END;
GO

--INSERTAMOS DATOS
EXEC sp_InsertarEvento
    @nombre = 'Festival de Música',
    @descripcion = 'Conciertos y actividades al aire libre',
    @ubicacion = 'Parque Central',
    @fecha_inicio = '2025-12-10',
    @fecha_fin = '2025-12-12',
    @imagen_url = 'https://example.com/festival.jpg';


--2-ACTUALIZAR EVENTOS
CREATE PROCEDURE sp_ActualizarEvento
    @id_evento INT,
    @nombre VARCHAR(200),
    @descripcion VARCHAR(MAX),
    @ubicacion VARCHAR(200),
    @fecha_inicio DATE,
    @fecha_fin DATE,
    @imagen_url VARCHAR(300),
    @activo BIT
AS
BEGIN
    UPDATE Eventos
    SET nombre = @nombre,
        descripcion = @descripcion,
        ubicacion = @ubicacion,
        fecha_inicio = @fecha_inicio,
        fecha_fin = @fecha_fin,
        imagen_url = @imagen_url,
        activo = @activo
    WHERE id_evento = @id_evento;
END;
GO
----ACTUALIZAR EVENTO datos
EXEC sp_ActualizarEvento
    @id_evento = 1,
    @nombre = 'Festival de Jazz',
    @descripcion = 'Actualizado: nueva programación',
    @ubicacion = 'Parque Central',
    @fecha_inicio = '2025-12-10',
    @fecha_fin = '2025-12-12',
    @imagen_url = 'https://example.com/jazz.jpg',
    @activo = 1;
	--actualizar evento
	EXEC sp_InsertarEvento
    @nombre = 'Festival de Música',
    @descripcion = 'Conciertos y actividades al aire libre',
    @ubicacion = 'Parque Central',
    @fecha_inicio = '2025-12-10',
    @fecha_fin = '2025-12-12',
    @imagen_url = 'https://example.com/festival.jpg';


--3-ELIMINAR EVENTOS
CREATE PROCEDURE sp_EliminarEvento
    @id_evento INT
AS
BEGIN
    UPDATE Eventos
    SET activo = 0
    WHERE id_evento = @id_evento;
END;
GO
--Comprobación
EXEC sp_EliminarEvento @id_evento = 1;


--4-CONSULTAR TODO LOS EVENTOS ACTIVOS
CREATE PROCEDURE sp_ObtenerEventos
AS
BEGIN
    SELECT id_evento, nombre, descripcion, ubicacion, fecha_inicio, fecha_fin, imagen_url
    FROM Eventos
    WHERE activo = 1
    ORDER BY fecha_inicio;
END;
GO
--consulta 
EXEC sp_ObtenerEventos;


--5-CONSULTAR EVENTO POR ID
CREATE PROCEDURE sp_ObtenerEventoPorId
    @id_evento INT
AS
BEGIN
    SELECT id_evento, nombre, descripcion, ubicacion, fecha_inicio, fecha_fin, imagen_url, activo
    FROM Eventos
    WHERE id_evento = @id_evento;
END;
GO
--comprobacion
EXEC sp_ObtenerEventoPorId @id_evento = 1;
EXEC sp_ObtenerEventoPorId @id_evento = 2;







