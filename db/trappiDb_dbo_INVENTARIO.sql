create table INVENTARIO
(
    IDENTIFICADOR      int identity
        constraint PK_INVENTARIO
            primary key nonclustered,
    IDENTIFICADORBIEN2 int
        constraint FK_INVENTAR_RELATIONS_BIEN
            references BIEN,
    CANTIDADINVENTARIO int not null
)
go

INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (1, 5, 78);
INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (2, 6, 62);
INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (3, 4, 75);
INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (4, 7, 50);
INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (5, 9, 1);
INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (7, 11, 1);
INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (8, 12, 34);
INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (10, 14, 2);
INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (11, 15, 80);
INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (6, 10, 13);
INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (12, 16, 2);
INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (13, 17, 8);
INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (9, 13, 92);
INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (14, 18, 2);
INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (15, 19, 1);
INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (16, 20, 1);
INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (17, 21, 4);
INSERT INTO trappiDb.dbo.INVENTARIO (IDENTIFICADOR, IDENTIFICADORBIEN2, CANTIDADINVENTARIO) VALUES (18, 8, 8);