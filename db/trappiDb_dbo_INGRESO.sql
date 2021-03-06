create table INGRESO
(
    IDINGRESO2    int   not null
        constraint PK_INGRESO
            primary key nonclustered,
    IDLIBRODIARIO int
        constraint FK_INGRESO_RELATIONS_LIBRODIA
            references LIBRODIARIO,
    NROFACTURA2   text  not null,
    TOTAL3        money not null,
    DIAINGRESO2   int   not null,
    MESINGRESO2   int   not null,
    ANIOINGRESO2  int   not null
)
go

INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (1, 1, N'77', 31.3600, 7, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (2, 1, N'86', 23.5200, 7, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (5, 1, N'90', 3.5840, 7, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (6, 1, N'91', 19.6000, 7, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (10, 1, N'95', 77.9520, 7, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (100, 1, N'78', 1500.0000, 28, 2, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (13, 1, N'97', 8.9600, 7, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (14, 1, N'98', 13.8880, 8, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (101, 1, N'102', 100000.0000, 28, 2, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (19, 1, N'102', 40.3200, 8, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (27, 1, N'110', 10.4160, 12, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (28, 1, N'111', 12.5440, 12, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (31, 1, N'114', 15.6800, 12, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (35, 1, N'3', 8.9600, 13, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (38, 1, N'6', 10.4160, 13, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (39, 1, N'7', 10.4160, 13, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (40, 1, N'8', 3.4720, 13, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (47, 1, N'15', 9.8560, 14, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (49, 1, N'17', 33.4880, 14, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (53, 1, N'21', 17.9200, 14, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (55, 1, N'23', 30.0160, 14, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (56, 1, N'24', 3012.8000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (58, 1, N'26', 0.8960, 15, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (61, 1, N'29', 1964.4800, 15, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (62, 1, N'30', 3.4720, 15, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (9, 1, N'94', 59.5840, 7, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (15, 1, N'99', 3326.4000, 8, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (16, 1, N'100', 4.4800, 8, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (18, 1, N'101', 34.7200, 8, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (29, 1, N'112', 3.1360, 12, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (33, 1, N'1', 20.4624, 12, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (34, 1, N'2', 13.1040, 12, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (36, 1, N'4', 6.2720, 13, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (37, 1, N'5', 13.8880, 13, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (41, 1, N'9', 3.5840, 13, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (42, 1, N'10', 13.8880, 13, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (43, 1, N'11', 6.2720, 13, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (44, 1, N'12', 33.4880, 13, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (45, 1, N'13', 47.0400, 13, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (46, 1, N'14', 69.4400, 13, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (48, 1, N'16', 302.4000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (50, 1, N'18', 20.2160, 14, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (57, 1, N'25', 3.5840, 14, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (3, 1, N'87', 11.7600, 7, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (59, 1, N'27', 3.4720, 15, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (60, 1, N'28', 11.6480, 15, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (4, 1, N'89', 8.9600, 7, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (52, 1, N'20', 302.4000, 14, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (7, 1, N'92', 90.9440, 7, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (8, 1, N'93', 13.4400, 7, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (11, 1, N'96', 89.6000, 7, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (20, 1, N'103', 11.7488, 11, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (21, 1, N'104', 31.3600, 11, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (22, 1, N'105', 20.5856, 11, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (23, 1, N'106', 12.5440, 11, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (24, 1, N'107', 15.6800, 11, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (25, 1, N'108', 10.4160, 11, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (26, 1, N'109', 7.1680, 11, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (30, 1, N'113', 3.4720, 12, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (32, 1, N'115', 6.6976, 12, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (51, 1, N'19', 392.7840, 14, 3, 2021);
INSERT INTO trappiDb.dbo.INGRESO (IDINGRESO2, IDLIBRODIARIO, NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2) VALUES (54, 1, N'22', 4.4800, 14, 3, 2021);