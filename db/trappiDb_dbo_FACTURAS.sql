create table FACTURAS
(
    IDFACTURA        int not null
        constraint PK_FACTURAS
            primary key nonclustered,
    IDCLIENTE        int not null
        constraint FK_FACTURAS_RELATIONS_CLIENTES
            references CLIENTES
            on delete cascade,
    NUMEROFACTURA    int,
    SUBTOTAL         money,
    IMPUESTOS        money,
    TOTAL            money,
    DIRECCION        varchar(1024),
    ESTADODEVOLUCION varchar(255)
)
go

INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (1, 5, 1, 18.2700, 2.1924, 20.4624, N'Av Mariscal Sucre y Equinoccial', N'SIN DEVOLUCION');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (2, 5, 2, 11.7000, 1.4040, 13.1040, N'Av Mariscal Sucre y Equinoccial', N'SIN DEVOLUCION');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (4, 4, 4, 5.6000, 0.6720, 6.2720, N'Av El Inca y Mariana de Jesus', N'DEVOLUCION REALIZADA');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (16, 1, 16, 270.0000, 32.4000, 302.4000, N'Av. Mariscal Sucre y Matilde Alvarez', N'SIN DEVOLUCION');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (9, 2, 9, 3.2000, 0.3840, 3.5840, N'Av. Teniente Hugo Ortiz y 5 de Junio', N'DEVOLUCION REALIZADA');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (10, 2, 10, 12.4000, 1.4880, 13.8880, N'Av. Teniente Hugo Ortiz y 5 de Junio', N'DEVOLUCION REALIZADA');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (11, 1, 11, 5.6000, 0.6720, 6.2720, N'Av. Mariscal Sucre y Matilde Alvarez', N'DEVOLUCION REALIZADA');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (12, 1, 12, 29.9000, 3.5880, 33.4880, N'Av. Mariscal Sucre y Matilde Alvarez', N'DEVOLUCION REALIZADA');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (13, 1, 13, 42.0000, 5.0400, 47.0400, N'Av. Mariscal Sucre y Matilde Alvarez', N'DEVOLUCION REALIZADA');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (14, 1, 14, 62.0000, 7.4400, 69.4400, N'Av. Mariscal Sucre y Matilde Alvarez', N'DEVOLUCION REALIZADA');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (18, 1, 18, 18.0500, 2.1660, 20.2160, N'Av. Mariscal Sucre y Matilde Alvarez', N'DEVOLUCION REALIZADA');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (20, 2, 20, 270.0000, 32.4000, 302.4000, N'Av. Teniente Hugo Ortiz y 5 de Junio', N'SIN DEVOLUCION');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (21, 1, 21, 16.0000, 1.9200, 17.9200, N'Av. Mariscal Sucre y Matilde Alvarez', N'SIN DEVOLUCION');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (25, 5, 25, 3.2000, 0.3840, 3.5840, N'Av Mariscal Sucre y Equinoccial', N'DEVOLUCION REALIZADA');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (26, 5, 26, 0.8000, 0.0960, 0.8960, N'Av Mariscal Sucre y Equinoccial', N'SIN DEVOLUCION');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (27, 5, 27, 3.1000, 0.3720, 3.4720, N'Av Mariscal Sucre y Equinoccial', N'SIN DEVOLUCION');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (28, 6, 28, 10.4000, 1.2480, 11.6480, N'06 de diciembre y el nodal', N'DEVOLUCION REALIZADA');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (29, 5, 29, 1754.0000, 210.4800, 1964.4800, N'Av Mariscal Sucre y Equinoccial', N'DEVOLUCION REALIZADA');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (15, 2, 15, 8.8000, 1.0560, 9.8560, N'Av. Teniente Hugo Ortiz y 5 de Junio', N'SIN DEVOLUCION');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (17, 3, 17, 29.9000, 3.5880, 33.4880, N'Av Gral Rumiñahui y Nela Martinez ', N'DEVOLUCION REALIZADA');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (19, 1, 19, 350.7000, 42.0840, 392.7840, N'Av. Mariscal Sucre y Matilde Alvarez', N'SIN DEVOLUCION');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (22, 1, 22, 4.0000, 0.4800, 4.4800, N'Av. Mariscal Sucre y Matilde Alvarez', N'SIN DEVOLUCION');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (23, 5, 23, 26.8000, 3.2160, 30.0160, N'Av Mariscal Sucre y Equinoccial', N'SIN DEVOLUCION');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (24, 5, 24, 2690.0000, 322.8000, 3012.8000, N'Av Mariscal Sucre y Equinoccial', N'SIN DEVOLUCION');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (30, 5, 30, 3.1000, 0.3720, 3.4720, N'Av Mariscal Sucre y Equinoccial', N'SIN DEVOLUCION');
INSERT INTO trappiDb.dbo.FACTURAS (IDFACTURA, IDCLIENTE, NUMEROFACTURA, SUBTOTAL, IMPUESTOS, TOTAL, DIRECCION, ESTADODEVOLUCION) VALUES (3, 1, 3, 8.0000, 0.9600, 8.9600, N'Av. Mariscal Sucre y Matilde Alvarez', N'DEVOLUCION REALIZADA');