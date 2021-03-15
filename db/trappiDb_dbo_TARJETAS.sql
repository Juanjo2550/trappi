create table TARJETAS
(
    IDTARJETA        int         not null
        constraint PK_TARJETAS
            primary key nonclustered,
    IDCUENTABANCARIA int         not null
        constraint FK_TARJETAS_RELATIONS_CUENTABA
            references CUENTABANCARIA
            on delete cascade,
    NUMEROTARJETA    bigint      not null,
    CVV              int         not null,
    FECHADECADUCIDAD varchar(20) not null,
    TIPO             varchar(50)
)
go

INSERT INTO trappiDb.dbo.TARJETAS (IDTARJETA, IDCUENTABANCARIA, NUMEROTARJETA, CVV, FECHADECADUCIDAD, TIPO) VALUES (1, 1, 83482923, 348, N'10/2022', N'Credito');
INSERT INTO trappiDb.dbo.TARJETAS (IDTARJETA, IDCUENTABANCARIA, NUMEROTARJETA, CVV, FECHADECADUCIDAD, TIPO) VALUES (2, 2, 27482353, 485, N'09/2022', N'Credito');
INSERT INTO trappiDb.dbo.TARJETAS (IDTARJETA, IDCUENTABANCARIA, NUMEROTARJETA, CVV, FECHADECADUCIDAD, TIPO) VALUES (3, 5, 34758374, 243, N'10/2023', N'Credito');
INSERT INTO trappiDb.dbo.TARJETAS (IDTARJETA, IDCUENTABANCARIA, NUMEROTARJETA, CVV, FECHADECADUCIDAD, TIPO) VALUES (7, 2, 25748473, 938, N'04/2023', N'Debito');
INSERT INTO trappiDb.dbo.TARJETAS (IDTARJETA, IDCUENTABANCARIA, NUMEROTARJETA, CVV, FECHADECADUCIDAD, TIPO) VALUES (8, 3, 43810864, 352, N'09/2022', N'Debito');
INSERT INTO trappiDb.dbo.TARJETAS (IDTARJETA, IDCUENTABANCARIA, NUMEROTARJETA, CVV, FECHADECADUCIDAD, TIPO) VALUES (9, 6, 10238439, 243, N'10/2024', N'Debito');
INSERT INTO trappiDb.dbo.TARJETAS (IDTARJETA, IDCUENTABANCARIA, NUMEROTARJETA, CVV, FECHADECADUCIDAD, TIPO) VALUES (4, 4, 23853564, 453, N'12/2022', N'Credito');