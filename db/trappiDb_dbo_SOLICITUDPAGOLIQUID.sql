create table SOLICITUDPAGOLIQUID
(
    IDSOLPAGO2  int not null
        constraint PK_SOLICITUDPAGOLIQUID
            primary key nonclustered,
    IDLIQUID    int
        constraint FK_SOLICITU_RELATIONS_LIQUIDAC
            references LIQUIDACION,
    IDEMP       int
        constraint FK_SOLICITUD_RELATIONS_EMPLEADO
            references EMPLEADO,
    FECHASOLIC  varchar(1024),
    ESTADOSOLIC varchar(1024)
)
go

