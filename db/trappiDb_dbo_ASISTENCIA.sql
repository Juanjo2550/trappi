create table ASISTENCIA
(
    IDREGASIS    int not null
        constraint PK_ASISTENCIA
            primary key nonclustered,
    IDEMP        int
        constraint FK_ASISTENC_RELATIONS_EMPLEADO
            references EMPLEADO,
    FECHAREGASIS datetime,
    OBSASIS      varchar(1024),
    HORASALIDA   time,
    HORAINGRESO  time
)
go

INSERT INTO trappiDb.dbo.ASISTENCIA (IDREGASIS, IDEMP, FECHAREGASIS, OBSASIS, HORASALIDA, HORAINGRESO) VALUES (1, 5, N'2021-03-15 00:00:00.000', N'N/A', null, N'12:01:37');
INSERT INTO trappiDb.dbo.ASISTENCIA (IDREGASIS, IDEMP, FECHAREGASIS, OBSASIS, HORASALIDA, HORAINGRESO) VALUES (2, 2, N'2021-03-15 00:00:00.000', N'N/A', null, N'12:01:54');