create table DETALLEFACTURA
(
    IDDETALLEFACTURA int   not null
        constraint PK_DETALLEFACTURA
            primary key nonclustered,
    IDFACTURA        int   not null
        constraint FK_DETALLEF_RELATIONS_FACTURAS
            references FACTURAS
            on delete cascade,
    NOMBRECL         varchar(100),
    IDARTICULO       int   not null
        constraint FK_BIEN_RELATIONS_DETALLEF
            references BIEN,
    PRECIOUNITARIO   money not null,
    CANTIDAD         int   not null
)
go

INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (5, 3, N'Bryan Flores', 5, 0.8000, 0);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (17, 15, N'Elvis Montaluisa', 6, 2.8000, 2);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (18, 15, N'Elvis Montaluisa', 5, 0.8000, 0);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (20, 17, N'Andres Gomez', 7, 2.9900, 2);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (29, 21, N'Bryan Flores', 5, 0.8000, 0);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (30, 21, N'Bryan Flores', 13, 1.6000, 1);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (32, 23, N'Alex Carrillo', 5, 0.8000, 0);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (33, 23, N'Alex Carrillo', 12, 2.6000, 2);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (34, 24, N'Alex Carrillo', 20, 2690.0000, 2690);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (36, 26, N'Alex Carrillo', 5, 0.8000, 0);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (39, 29, N'Alex Carrillo', 17, 1754.0000, 1754);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (40, 30, N'Alex Carrillo', 4, 3.1000, 3);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (1, 1, N'Alex Carrillo', 4, 3.1000, 3);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (2, 1, N'Alex Carrillo', 7, 2.9900, 2);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (3, 2, N'Alex Carrillo', 5, 0.8000, 0);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (4, 2, N'Alex Carrillo', 4, 3.1000, 3);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (6, 4, N'Juan Romero', 6, 2.8000, 2);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (15, 13, N'Bryan Flores', 6, 2.8000, 2);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (16, 14, N'Bryan Flores', 4, 3.1000, 3);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (19, 16, N'Bryan Flores', 16, 270.0000, 270);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (21, 18, N'Bryan Flores', 15, 3.7500, 3);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (11, 9, N'Elvis Montaluisa', 5, 0.8000, 0);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (12, 10, N'Elvis Montaluisa', 4, 3.1000, 3);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (13, 11, N'Bryan Flores', 6, 2.8000, 2);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (14, 12, N'Bryan Flores', 7, 2.9900, 2);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (22, 18, N'Bryan Flores', 12, 2.6000, 2);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (23, 18, N'Bryan Flores', 13, 1.6000, 1);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (28, 20, N'Elvis Montaluisa', 16, 270.0000, 270);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (35, 25, N'Alex Carrillo', 13, 1.6000, 1);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (37, 27, N'Alex Carrillo', 4, 3.1000, 3);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (38, 28, N'jese', 12, 2.6000, 2);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (24, 19, N'Bryan Flores', 12, 2.6000, 2);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (25, 19, N'Bryan Flores', 15, 3.7500, 3);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (26, 19, N'Bryan Flores', 6, 2.8000, 2);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (27, 19, N'Bryan Flores', 7, 2.9900, 2);
INSERT INTO trappiDb.dbo.DETALLEFACTURA (IDDETALLEFACTURA, IDFACTURA, NOMBRECL, IDARTICULO, PRECIOUNITARIO, CANTIDAD) VALUES (31, 22, N'Bryan Flores', 5, 0.8000, 0);