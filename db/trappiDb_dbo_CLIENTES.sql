create table CLIENTES
(
    IDCLIENTE         int           not null
        constraint PK_CLIENTES
            primary key nonclustered,
    NOMBRECLIE        varchar(1024) not null,
    FECHADENACIMIENTO datetime      not null,
    CELULAR           varchar(1024) not null,
    DIRECCION         varchar(1024) not null,
    CEDULA2           varchar(1024) not null,
    CONTRASENA        varchar(1024) not null,
    CORREO            varchar(1024) not null
)
go

INSERT INTO trappiDb.dbo.CLIENTES (IDCLIENTE, NOMBRECLIE, FECHADENACIMIENTO, CELULAR, DIRECCION, CEDULA2, CONTRASENA, CORREO) VALUES (6, N'jese', N'1989-10-12 00:00:00.000', N'092343234', N'06 de diciembre y el nodal', N'0706859601', N'12345', N'jese@gmail.com');
INSERT INTO trappiDb.dbo.CLIENTES (IDCLIENTE, NOMBRECLIE, FECHADENACIMIENTO, CELULAR, DIRECCION, CEDULA2, CONTRASENA, CORREO) VALUES (1, N'Bryan Flores', N'1998-07-03 00:00:00.000', N'0992772076', N'Av. Mariscal Sucre y Matilde Alvarez', N'1721791661', N'12345', N'bf97930@gmail.com');
INSERT INTO trappiDb.dbo.CLIENTES (IDCLIENTE, NOMBRECLIE, FECHADENACIMIENTO, CELULAR, DIRECCION, CEDULA2, CONTRASENA, CORREO) VALUES (2, N'Elvis Montaluisa', N'1998-01-05 00:00:00.000', N'0979259076', N'Av. Teniente Hugo Ortiz y 5 de Junio', N'0503408080', N'12345', N'elvisM@gmail.com');
INSERT INTO trappiDb.dbo.CLIENTES (IDCLIENTE, NOMBRECLIE, FECHADENACIMIENTO, CELULAR, DIRECCION, CEDULA2, CONTRASENA, CORREO) VALUES (3, N'Andres Gomez', N'1999-07-10 00:00:00.000', N'0987329687', N'Av Gral Rumiñahui y Nela Martinez ', N'1727624593', N'12345', N'andresGM@gmail.com');
INSERT INTO trappiDb.dbo.CLIENTES (IDCLIENTE, NOMBRECLIE, FECHADENACIMIENTO, CELULAR, DIRECCION, CEDULA2, CONTRASENA, CORREO) VALUES (4, N'Juan Romero', N'1998-09-03 00:00:00.000', N'0960210136', N'Av El Inca y Mariana de Jesus', N'0706859600', N'12345', N'juanR@gmail.com');
INSERT INTO trappiDb.dbo.CLIENTES (IDCLIENTE, NOMBRECLIE, FECHADENACIMIENTO, CELULAR, DIRECCION, CEDULA2, CONTRASENA, CORREO) VALUES (5, N'Alex Carrillo', N'1985-10-03 00:00:00.000', N'0912345678', N'Av Mariscal Sucre y Equinoccial', N'1755041589', N'12345', N'alexC@gmail.com');