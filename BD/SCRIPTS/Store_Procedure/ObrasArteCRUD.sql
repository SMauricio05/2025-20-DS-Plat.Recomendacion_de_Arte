CREATE PROCEDURE sp_InsertarObra
    @titulo NVARCHAR(200),
    @artista NVARCHAR(150),
    @descripcion NVARCHAR(MAX),
    @categoria NVARCHAR(100),
    @fecha_creacion DATE,
    @imagen_url NVARCHAR(300)
AS
BEGIN
    INSERT INTO ObrasArte (titulo, artista, descripcion, categoria, fecha_creacion, imagen_url)
    VALUES (@titulo, @artista, @descripcion, @categoria, @fecha_creacion, @imagen_url);
END;
GO

CREATE PROCEDURE sp_ListarObras
AS
BEGIN
    SELECT * FROM ObrasArte WHERE disponibilidad = 1;
END;
GO

--INSERTAMOS OBRA

EXEC sp_InsertarObra
    @titulo = 'Paisaje Cultural de Junín',
    @artista = 'Angelo Rojas',
    @descripcion = 'Obra que representa los paisajes naturales de la región Junín.',
    @categoria = 'Fotografía',
    @fecha_creacion = '2024-08-12',
    @imagen_url = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeZlnnmqrmSSwuPuCgeBSiokGSiBXk6blyzA&s';




	SELECT *FROM ObrasArte;
