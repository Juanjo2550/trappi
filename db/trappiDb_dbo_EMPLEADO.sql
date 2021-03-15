create table EMPLEADO
(
    IDEMP             int           not null
        constraint PK_EMPLEADO
            primary key nonclustered,
    NOMBREEMP         varchar(1024),
    APELLIDOEMP       varchar(1024),
    CEDULAEMP         varchar(1024) not null,
    CARGOEMP          varchar(1024),
    DEPARTAMENTOEMP   varchar(1024),
    CUENTABANCARIAEMP varchar(1024),
    BANCOEMP          varchar(1024),
    ESTADOEMP         varchar(1024),
    TIPOEMP           varchar(1024),
    SUELDOEMP         varchar(50),
    SEXOEMP           varchar(10)
)
go

INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (1, N'Juan José', N'Jaramillo Cajamarca', N'1722951165', N'Jefe', N'RRHH', N'2204573281', N'Pichincha', N'Activo', N'Administrativo', N'2500', N'M');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (2, N'Alisson Dayana', N'Taco Almachi', N'1706496880', N'programador', N'RRHH', N'23573849390', N'Pichincha', N'Activo', N'conductor', N'1500', N'F');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (3, N'Diana Jessica', N'Dias Andrade', N'1762441094', N'Obrero de línea', N'RRHH', N'2204588291', N'Pacífico', N'Activo', N'conductor', N'1500', N'F');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (4, N'Andres German', N'Quijia Rodriguez', N'1782341165', N'Obrero de línea', N'RRHH', N'2109898293', N'Pacífico', N'Activo', N'conductor', N'1500', N'M');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (5, N'Alberto Bryan', N'Dias Andrade', N'1762841094', N'Obrero de línea', N'RRHH', N'2804588294', N'Pacífico', N'Activo', N'conductor', N'1500', N'M');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (6, N'Luis Fernando', N'Marquez Dominguez', N'1799461091', N'Obrero de línea', N'RRHH', N'2944538245', N'Pichincha', N'Ocupado', N'conductor', N'1500', N'M');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (7, N'Solange Fernanda', N'Toapanta Pamzmiño', N'1788041050', N'Obrero de línea', N'RRHH', N'2304557281', N'Pacífico', N'Activo', N'conductor', N'1500', N'F');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (8, N'Elizabeth Abigail', N'Dilez Andrade', N'1765041032', N'Obrero de línea', N'RRHH', N'2454588253', N'Pacífico', N'Activo', N'conductor', N'1500', N'F');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (9, N'Alex Camilo', N'Carrillo Morales', N'1755041589', N'Obrero de Línea', N'RRHH', N'23546512', N'Pichincha', N'Activo', N'conductor', N'1200', N'M');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (10, N'Henry Carlos', N'Barrera Sanchez', N'1725527356', N'Obrero de linea', N'RRHH', N'5145892', N'Amazonas', N'Activo', N'conductor', N'1200', N'M');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (13, N'Andres Juan', N'Mayorga', N'178965892', N'Obrero de linea', N'RRHH', N'1564564', N'Banco Pichincha', N'Activo', N'administrativo', N'1500', N'M');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (14, N'Henry', N'Erazo', N'175214895', N'mba', N'RRHH', N'2422572572', N'Pichincha', N'Activo', N'conductor', N'140', N'M');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (15, N'Luz', N'Barrera', N'1707967584', N'MBA', N'RRHH', N'578578578', N'Pacifico', N'Activo', N'administrativo', N'14000', N'F');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (11, N'Micaela Sandra', N'Escobar Escobar', N'17855897415', N'Obrero de linea', N'RRHH', N'115584562', N'Pacifico', N'Activo', N'conductor', N'2000', N'F');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (16, N'Javier', N'Barrera', N'181891456', N'mba', N'rrhh', N'124242', N'pichincha', N'Ocupado', N'conductor', N'1455', N'M');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (19, N'Pepe', N'Lagarto', N'17551545614', N'Obrero', N'Logistico', N'75275275', N'Pichicnha', N'Activo', N'conductor', N'396', N'M');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (12, N'Andres Juan', N'Mayorga', N'178965892', N'Obrero de linea', N'RRHH', N'75275275', N'Pichincha', N'Activo', N'conductor', N'1200', N'M');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (17, N'Diego', N'Carrera', N'17550412', N'mba', N'RRHH', N'12451241', N'Pichincha', N'Ocupado', N'conductor', N'500', N'M');
INSERT INTO trappiDb.dbo.EMPLEADO (IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) VALUES (18, N'Alexander', N'Quijia Andrade', N'1752416007', N'MBA', N'rrhh', N'12947023', N'pacifico', N'Activo', N'conductor', N'1000', N'M');