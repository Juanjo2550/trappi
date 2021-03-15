create table MANTENIMIENTO
(
    IDMANTENIMIENTO      int       not null
        constraint PK_MANTENIMIENTO
            primary key nonclustered,
    MATRICULA            char(10)
        constraint FK_MANTENIM_VEHICULO__VEHICULO
            references VEHICULO,
    DETALLEMANTENIMIENTO char(200) not null,
    VALORGASTO           decimal   not null
)
go

INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (1, N'PCU-4997  ', N'Chequeo de discos de freno                                                                                                                                                                              ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (2, N'DAQ-953   ', N'Cambio de aceite hidraulico                                                                                                                                                                             ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (1234, N'PBP-2432  ', N'Mantenimiento1                                                                                                                                                                                          ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (1235, N'PBP-2432  ', N'Mantenimiento1                                                                                                                                                                                          ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (1236, N'PBP-2432  ', N'Mantenimiento3                                                                                                                                                                                          ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (123, N'PBP-2432  ', N'asdasdsa                                                                                                                                                                                                ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (4, N'PBP-2432  ', N'Cambio de aceite                                                                                                                                                                                        ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (5, N'DAQ-953   ', N'Cambio de aceite                                                                                                                                                                                        ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (6, N'PBP-2432  ', N'No hay acotaciones                                                                                                                                                                                      ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (200, N'PBP-2432  ', N'                                                                                                                                                                                                        ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (501, N'PBP-2432  ', N'                                                                                                                                                                                                        ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (503, N'PBP-2432  ', N'mmmmm                                                                                                                                                                                                   ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (234, N'GSK-4500  ', N'Se necesita reparación urgente                                                                                                                                                                          ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (245, N'PBP-2432  ', N'Reparación urgente.                                                                                                                                                                                     ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (345, N'PBP-2432  ', N'Reparación urgente                                                                                                                                                                                      ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (1742, N'PBP-2432  ', N'Se va a repintar al vehiculo.                                                                                                                                                                           ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (129, N'PBP-2432  ', N'Cambio de pastillas                                                                                                                                                                                     ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (125, N'PBP-2432  ', N'                                                                                                                                                                                                        ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (178, N'PBP-2432  ', N'                                                                                                                                                                                                        ', 0);
INSERT INTO trappiDb.dbo.MANTENIMIENTO (IDMANTENIMIENTO, MATRICULA, DETALLEMANTENIMIENTO, VALORGASTO) VALUES (246, N'GSK-4500  ', N'                                                                                                                                                                                                        ', 0);