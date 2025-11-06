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
    @imagen_url = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2kSxuEEFjg7EPsEYOqHA4WiJy0yCEsYZOYQ&s';


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
    @imagen_url = 'https://upload.wikimedia.org/wikipedia/commons/e/e3/Nice_Jazz_Festival_2002.jpg',
    @activo = 1;
	--actualizar evento
	EXEC sp_InsertarEvento
    @nombre = 'Festival de Música',
    @descripcion = 'Conciertos y actividades al aire libre',
    @ubicacion = 'Parque Central',
    @fecha_inicio = '2025-12-10',
    @fecha_fin = '2025-12-12',
    @imagen_url = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSBWICvvQlr3bW_k4XLDQFfkjjKSy2ROiwNQ&s';


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



-- Inserción de 7 eventos de ejemplo
EXEC sp_InsertarEvento
    @nombre = 'Festival de Música Andina',
    @descripcion = 'Celebración anual de música tradicional con artistas de todo Junín.',
    @ubicacion = 'Plaza Constitución, Huancayo',
    @fecha_inicio = '2025-01-15',
    @fecha_fin = '2025-01-17',
    @imagen_url = 'https://cdn.pixabay.com/photo/2016/11/29/04/47/music-1867485_1280.jpg';

EXEC sp_InsertarEvento
    @nombre = 'Exposición de Arte Contemporáneo',
    @descripcion = 'Muestra de artistas emergentes de la región central del Perú.',
    @ubicacion = 'Centro Cultural Huancayo',
    @fecha_inicio = '2025-02-10',
    @fecha_fin = '2025-02-28',
    @imagen_url = 'https://diariocorreo.pe/resizer/v2/FLK3TQOOF5DTNICK4T7X3EBR5Y.png?auth=bd16860ead4ed25caa1301e1a9122c20500b616558e3ccb75ddfc40b64640f38&width=1200&height=675&quality=75&smart=true';

EXEC sp_InsertarEvento
    @nombre = 'Feria del Libro del Valle del Mantaro',
    @descripcion = 'Encuentro literario con presentaciones de autores y editoriales locales.',
    @ubicacion = 'Auditorio Municipal de Huancayo',
    @fecha_inicio = '2025-03-05',
    @fecha_fin = '2025-03-10',
    @imagen_url = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQUz1jMG7KtdT8hJGAOYsAKVrCp97z2KRoVrQ&s';

EXEC sp_InsertarEvento
    @nombre = 'Festival Gastronómico Sabores de la Sierra',
    @descripcion = 'Evento que promueve la gastronomía tradicional de Junín.',
    @ubicacion = 'Campo Ferial de Huancayo',
    @fecha_inicio = '2025-04-20',
    @fecha_fin = '2025-04-22',
    @imagen_url = 'https://portal.andina.pe/EDPFotografia3/thumbnail/2018/10/17/000539000M.jpg';

EXEC sp_InsertarEvento
    @nombre = 'Concurso de Danzas Típicas',
    @descripcion = 'Competencia entre agrupaciones folclóricas del centro del país.',
    @ubicacion = 'Coliseo Wanka, Huancayo',
    @fecha_inicio = '2025-05-01',
    @fecha_fin = '2025-05-03',
    @imagen_url = 'https://portal.andina.pe/EDPfotografia3/Thumbnail/2018/04/29/000499939W.webp';

EXEC sp_InsertarEvento
    @nombre = 'Exposición de Escultura en Piedra de Huamanga',
    @descripcion = 'Obras talladas por artistas ayacuchanos, promoviendo el arte ancestral.',
    @ubicacion = 'Museo Regional de Junín',
    @fecha_inicio = '2025-06-12',
    @fecha_fin = '2025-06-25',
    @imagen_url = 'https://portal.andina.pe/EDPfotografia3/Thumbnail/2019/04/26/000581657W.webp';

EXEC sp_InsertarEvento
    @nombre = 'Festival del Cuy y Productos Andinos',
    @descripcion = 'Evento culinario y cultural con exhibiciones gastronómicas y música.',
    @ubicacion = 'Plaza Huamanmarca, Huancayo',
    @fecha_inicio = '2025-07-10',
    @fecha_fin = '2025-07-12',
    @imagen_url = 'https://www.antamina.com/wp-content/uploads/2015/08/festival-cuy.jpg';
GO

-- Verificar los eventos insertados
EXEC sp_ObtenerEventos;
GO






