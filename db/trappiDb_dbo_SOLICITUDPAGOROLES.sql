create table SOLICITUDPAGOROLES
(
    IDSOLPAGO   int not null
        constraint PK_SOLICITUDPAGOROLES
            primary key nonclustered,
    ID_ROL      int
        constraint FK_SOLICITU_RELATIONS_ROLPAGOS
            references ROLPAGOS,
    IDEMP       int
        constraint FK_SOLICITU_RELATIONS_EMPLEADO
            references EMPLEADO,
    FECHASOLIC  varchar(1024),
    ESTADOSOLIC varchar(1024)
)
go

