CREATE TABLE Recomendaciones (
    id_recomendacion INT IDENTITY(1,1) PRIMARY KEY,
    id_usuario INT FOREIGN KEY REFERENCES Usuarios(id_usuario),
    id_obra INT NULL FOREIGN KEY REFERENCES ObrasArte(id_obra),
    id_evento INT NULL FOREIGN KEY REFERENCES Eventos(id_evento),
    tipo NVARCHAR(20) CHECK (tipo IN ('OBRA', 'EVENTO')),
    fecha_recomendacion DATETIME DEFAULT GETDATE()
);