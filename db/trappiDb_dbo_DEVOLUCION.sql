create table DEVOLUCION
(
    idDevolucion    int   not null
        constraint PK_DEVOLUCION
            primary key nonclustered,
    nroFactura      int   not null,
    valorDevolucion money not null,
    diaDevolucion   int   not null,
    mesDevolucion   int   not null,
    anioDevolucion  int   not null
)
go

INSERT INTO trappiDb.dbo.DEVOLUCION (idDevolucion, nroFactura, valorDevolucion, diaDevolucion, mesDevolucion, anioDevolucion) VALUES (1, 3, 1.0752, 13, 3, 2021);
INSERT INTO trappiDb.dbo.DEVOLUCION (idDevolucion, nroFactura, valorDevolucion, diaDevolucion, mesDevolucion, anioDevolucion) VALUES (2, 11, 0.7526, 13, 3, 2021);
INSERT INTO trappiDb.dbo.DEVOLUCION (idDevolucion, nroFactura, valorDevolucion, diaDevolucion, mesDevolucion, anioDevolucion) VALUES (3, 12, 4.0186, 13, 3, 2021);
INSERT INTO trappiDb.dbo.DEVOLUCION (idDevolucion, nroFactura, valorDevolucion, diaDevolucion, mesDevolucion, anioDevolucion) VALUES (4, 13, 5.0400, 13, 3, 2021);
INSERT INTO trappiDb.dbo.DEVOLUCION (idDevolucion, nroFactura, valorDevolucion, diaDevolucion, mesDevolucion, anioDevolucion) VALUES (5, 14, 7.4400, 13, 3, 2021);
INSERT INTO trappiDb.dbo.DEVOLUCION (idDevolucion, nroFactura, valorDevolucion, diaDevolucion, mesDevolucion, anioDevolucion) VALUES (8, 18, 2.1660, 14, 3, 2021);
INSERT INTO trappiDb.dbo.DEVOLUCION (idDevolucion, nroFactura, valorDevolucion, diaDevolucion, mesDevolucion, anioDevolucion) VALUES (9, 9, 0.3840, 14, 3, 2021);
INSERT INTO trappiDb.dbo.DEVOLUCION (idDevolucion, nroFactura, valorDevolucion, diaDevolucion, mesDevolucion, anioDevolucion) VALUES (10, 25, 0.3840, 14, 3, 2021);
INSERT INTO trappiDb.dbo.DEVOLUCION (idDevolucion, nroFactura, valorDevolucion, diaDevolucion, mesDevolucion, anioDevolucion) VALUES (11, 4, 0.6720, 28, 2, 2021);
INSERT INTO trappiDb.dbo.DEVOLUCION (idDevolucion, nroFactura, valorDevolucion, diaDevolucion, mesDevolucion, anioDevolucion) VALUES (12, 28, 1.2480, 15, 3, 2021);
INSERT INTO trappiDb.dbo.DEVOLUCION (idDevolucion, nroFactura, valorDevolucion, diaDevolucion, mesDevolucion, anioDevolucion) VALUES (13, 29, 210.4800, 15, 3, 2021);
INSERT INTO trappiDb.dbo.DEVOLUCION (idDevolucion, nroFactura, valorDevolucion, diaDevolucion, mesDevolucion, anioDevolucion) VALUES (6, 10, 1.4880, 14, 3, 2021);
INSERT INTO trappiDb.dbo.DEVOLUCION (idDevolucion, nroFactura, valorDevolucion, diaDevolucion, mesDevolucion, anioDevolucion) VALUES (7, 17, 3.5880, 14, 3, 2021);