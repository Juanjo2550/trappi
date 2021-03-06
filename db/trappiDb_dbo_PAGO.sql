create table PAGO
(
    IDPAGO        int   not null
        constraint PK_PAGO
            primary key nonclustered,
    IDLIBRODIARIO int
        constraint FK_PAGO_RELATIONS_LIBRODIA
            references LIBRODIARIO,
    NROCUENTA     text  not null,
    MONTO         money not null,
    DIAPAGO       int   not null,
    MESPAGO       int   not null,
    ANIOPAGO      int   not null
)
go

INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (1, 1, N'1597368420', 40.0000, 7, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (2, 1, N'1597368420', 80.0000, 7, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (3, 1, N'1597368420', 80.0000, 7, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (4, 1, N'1597368420', 4.0000, 7, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (5, 1, N'1547935481', 20.1700, 7, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (7, 1, N'2204573281', 2150.0000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (12, 1, N'2944538245', 100.0000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (13, 1, N'2454588253', 105.0000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (23, 1, N'2204573281', 130.0000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (24, 1, N'2204588291', 4100.0000, 12, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (28, 1, N'5145892', 199.0000, 12, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (34, 1, N'1597368420', 1775.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (35, 1, N'1597368420', 1775.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (37, 1, N'1597368420', 3.7500, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (38, 1, N'1597368420', 3.7500, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (39, 1, N'2452793885', 1684.5000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (40, 1, N'2452793885', 270.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (42, 1, N'2452793885', 270.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (45, 1, N'12947023', 199.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (47, 1, N'1547935481', 0.5000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (48, 1, N'2452793885', 840.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (49, 1, N'2452793885', 5380.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (51, 1, N'2804588294', 1500.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (52, 1, N'2204573281', 2475.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (54, 1, N'1547935497', 0.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (55, 1, N'1547935497', 0.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (56, 1, N'2452793885', 1679.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (57, 1, N'2452793885', 15786.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (58, 1, N'1547935481', 846.8500, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (59, 1, N'1547935481', 846.8500, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (60, 1, N'1547935481', 846.8500, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (61, 1, N'1547935497', 0.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (62, 1, N'2109898293', 1515.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (63, 1, N'1547935497', 0.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (69, 1, N'1547935497', 0.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (71, 1, N'1547935497', 15.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (72, 1, N'1547935497', 250.0000, 15, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (74, 1, N'1547935497', 45.0000, 15, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (100, 1, N'1547935481', 900.0000, 28, 2, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (36, 1, N'1597368420', 15.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (41, 1, N'1597368420', 795.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (50, 1, N'2109898293', 1515.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (53, 1, N'1547935497', 0.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (64, 1, N'1547935497', 15.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (65, 1, N'1547935497', 15.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (66, 1, N'1547935497', 15.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (67, 1, N'1547935497', 15.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (68, 1, N'1547935497', 15.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (70, 1, N'1547935497', 15.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (8, 1, N'1597368420', 720.0000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (22, 1, N'1547935481', 299.0000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (25, 1, N'2204588291', 4100.0000, 12, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (32, 1, N'1547935481', 193.2000, 13, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (33, 1, N'1547935481', 11.2000, 13, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (9, 1, N'1597368420', 80.0000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (10, 1, N'1547935481', 889.0000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (11, 1, N'1547935481', 295.0000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (14, 1, N'1547935481', 31.0000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (15, 1, N'1547935481', 31.0000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (16, 1, N'1547935481', 280.0000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (17, 1, N'1547935481', 775.0000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (18, 1, N'1547935481', 1120.0000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (19, 1, N'1597368420', 120.0000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (20, 1, N'1597368420', 120.0000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (21, 1, N'1547935481', 62.0000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (29, 1, N'2944538245', 100.0000, 12, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (30, 1, N'2454588253', 105.0000, 12, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (26, 1, N'2944538245', 100.0000, 12, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (27, 1, N'5145892', 199.0000, 12, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (31, 1, N'23573849390', 2200.0000, 12, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (43, 1, N'1547935481', 4.2500, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (44, 1, N'1547935481', 4.2500, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (46, 1, N'2452793885', 270.0000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.PAGO (IDPAGO, IDLIBRODIARIO, NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO) VALUES (73, 1, N'2452793885', 1679.0000, 15, 3, 2021);