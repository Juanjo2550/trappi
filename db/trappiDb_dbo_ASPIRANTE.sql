create table ASPIRANTE
(
    ID_ASP      int not null
        constraint PK_ASPIRANTE
            primary key nonclustered,
    NOMBREASP   varchar(1024),
    APELLIDOASP varchar(1024),
    CEDULAASP   varchar(1024),
    TELEFONOASP varchar(1024),
    CARGOASP    varchar(1024)
)
go

INSERT INTO trappiDb.dbo.ASPIRANTE (ID_ASP, NOMBREASP, APELLIDOASP, CEDULAASP, TELEFONOASP, CARGOASP) VALUES (2, N'Diego', N'Marquez', N'1755041597', N'514865', N'mba');
INSERT INTO trappiDb.dbo.ASPIRANTE (ID_ASP, NOMBREASP, APELLIDOASP, CEDULAASP, TELEFONOASP, CARGOASP) VALUES (3, N'Diego', N'Carrera', N'17550411587', N'514865', N'mba');
INSERT INTO trappiDb.dbo.ASPIRANTE (ID_ASP, NOMBREASP, APELLIDOASP, CEDULAASP, TELEFONOASP, CARGOASP) VALUES (4, N'Diego', N'Carrera', N'1755049858', N'514865', N'mba');
INSERT INTO trappiDb.dbo.ASPIRANTE (ID_ASP, NOMBREASP, APELLIDOASP, CEDULAASP, TELEFONOASP, CARGOASP) VALUES (1, N'Diego', N'Marquez', N'1755041596', N'514865', N'mba');
INSERT INTO trappiDb.dbo.ASPIRANTE (ID_ASP, NOMBREASP, APELLIDOASP, CEDULAASP, TELEFONOASP, CARGOASP) VALUES (5, N'Diego', N'Carrera', N'17550412', N'514865', N'mba');
INSERT INTO trappiDb.dbo.ASPIRANTE (ID_ASP, NOMBREASP, APELLIDOASP, CEDULAASP, TELEFONOASP, CARGOASP) VALUES (6, N'Alex Camilo', N'Carrillo Morales', N'1755041589', N'5143128', N'Obrero de Línea');
INSERT INTO trappiDb.dbo.ASPIRANTE (ID_ASP, NOMBREASP, APELLIDOASP, CEDULAASP, TELEFONOASP, CARGOASP) VALUES (7, N'Henry Carlos', N'Barrera Sanchez', N'1725527356', N'565612', N'Obrero de linea');
INSERT INTO trappiDb.dbo.ASPIRANTE (ID_ASP, NOMBREASP, APELLIDOASP, CEDULAASP, TELEFONOASP, CARGOASP) VALUES (9, N'Andres Juan', N'Mayorga', N'178965892', N'5752', N'Obrero de linea');
INSERT INTO trappiDb.dbo.ASPIRANTE (ID_ASP, NOMBREASP, APELLIDOASP, CEDULAASP, TELEFONOASP, CARGOASP) VALUES (10, N'Daniela', N'Márquez', N'1724975386', N'2342342', N'mba');
INSERT INTO trappiDb.dbo.ASPIRANTE (ID_ASP, NOMBREASP, APELLIDOASP, CEDULAASP, TELEFONOASP, CARGOASP) VALUES (11, N'Henry', N'Erazo', N'175214895', N'265465', N'mba');
INSERT INTO trappiDb.dbo.ASPIRANTE (ID_ASP, NOMBREASP, APELLIDOASP, CEDULAASP, TELEFONOASP, CARGOASP) VALUES (12, N'Luz', N'Barrera', N'1707967584', N'5221654', N'MBA');
INSERT INTO trappiDb.dbo.ASPIRANTE (ID_ASP, NOMBREASP, APELLIDOASP, CEDULAASP, TELEFONOASP, CARGOASP) VALUES (13, N'Javier', N'Barrera', N'181891456', N'654184', N'mba');
INSERT INTO trappiDb.dbo.ASPIRANTE (ID_ASP, NOMBREASP, APELLIDOASP, CEDULAASP, TELEFONOASP, CARGOASP) VALUES (8, N'Micaela Sandra', N'Escobar Escobar', N'17855897415', N'216546541', N'Obrero de linea');
INSERT INTO trappiDb.dbo.ASPIRANTE (ID_ASP, NOMBREASP, APELLIDOASP, CEDULAASP, TELEFONOASP, CARGOASP) VALUES (15, N'Pepe', N'Lagarto', N'17551545614', N'516514986', N'Obrero');
INSERT INTO trappiDb.dbo.ASPIRANTE (ID_ASP, NOMBREASP, APELLIDOASP, CEDULAASP, TELEFONOASP, CARGOASP) VALUES (14, N'Alexander', N'Quijia Andrade', N'1752416007', N'514633', N'MBA');