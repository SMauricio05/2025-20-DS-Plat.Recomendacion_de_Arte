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


-- Insertamos 7 obras de arte de ejemplo

EXEC sp_InsertarObra
    @titulo = 'Paisaje Cultural de Junín',
    @artista = 'Angelo Rojas',
    @descripcion = 'Obra que representa los paisajes naturales de la región Junín.',
    @categoria = 'Fotografía',
    @fecha_creacion = '2024-08-12',
    @imagen_url = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeZlnnmqrmSSwuPuCgeBSiokGSiBXk6blyzA&s';

EXEC sp_InsertarObra
    @titulo = 'El Nevado Huaytapallana',
    @artista = 'Carla Huamán',
    @descripcion = 'Pintura que retrata el majestuoso paisaje.',
    @categoria = 'Pintura',
    @fecha_creacion = '2023-11-20',
    @imagen_url = 'https://f.rpp-noticias.io/2012/05/05/fotos_actualidad_pintorvictor_pintor1.jpg?width=860&quality=80';

EXEC sp_InsertarObra
    @titulo = 'Mercado de Huancayo',
    @artista = 'Luis Gamarra',
    @descripcion = 'Fotografía que muestra la vitalidad y colores del mercado tradicional de Huancayo.',
    @categoria = 'Fotografía',
    @fecha_creacion = '2024-05-02',
    @imagen_url = 'https://diariocorreo.pe/resizer/v2/2KK7U6BRTFH4NOUCUJIXOTUSXA.jpeg?auth=6c134798bbbf1e0e7d988d33a37c231468026a52276671dfa2fef9c47d6ff14c&width=1600&height=900&quality=75&smart=true';

EXEC sp_InsertarObra
    @titulo = 'Tejidos de la Sierra',
    @artista = 'María Ayala',
    @descripcion = 'Obra textil inspirada en los patrones y colores tradicionales de la sierra central.',
    @categoria = 'Arte Textil',
    @fecha_creacion = '2022-10-15',
    @imagen_url = 'https://www.boletomachupicchu.com/gutblt/wp-content/uploads/2025/03/representacion-disenos-geometricos-full.jpg';

EXEC sp_InsertarObra
    @titulo = 'Danza de los Shapis',
    @artista = 'Ricardo Torres',
    @descripcion = 'Escultura que representa la danza tradicional de los Shapis del valle del Mantaro.',
    @categoria = 'Escultura',
    @fecha_creacion = '2023-09-10',
    @imagen_url = 'https://portal.andina.pe/EDPfotografia/Thumbnail/2014/03/28/000238837W.jpg';

EXEC sp_InsertarObra
    @titulo = 'Catedral de Huancayo al Atardecer',
    @artista = 'Elena Ramos',
    @descripcion = 'Lienzo que muestra la Catedral de Huancayo iluminada por la luz del atardecer.',
    @categoria = 'Pintura',
    @fecha_creacion = '2024-03-18',
    @imagen_url = 'https://www.dehuancayo.com/index.php?view=image&format=raw&type=orig&id=30&Itemid=117&option=com_joomgallery';

EXEC sp_InsertarObra
    @titulo = 'El Valle del Mantaro',
    @artista = 'Fernando Salazar',
    @descripcion = 'Fotografía aérea del fértil Valle del Mantaro, reflejando su belleza natural y agrícola.',
    @categoria = 'Fotografía',
    @fecha_creacion = '2024-06-22',
    @imagen_url = 'https://as1.ftcdn.net/v2/jpg/02/81/34/54/1000_F_281345423_5UCTbFqphmhflg2fq6x8gK63Iuzpn2ti.jpg';
GO

-- Verificar las obras insertadas
EXEC sp_ListarObras;
GO


