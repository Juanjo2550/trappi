create table LIQUIDACION
(
    IDLIQUID        int not null
        constraint PK_LIQUIDACION
            primary key nonclustered,
    IDEMP           int
        constraint FK_LIQUIDAC_RELATIONS_EMPLEADO
            references EMPLEADO,
    FECHALIQUID     datetime,
    VALORLIQUID     money,
    ANOSLIQUID      int,
    ULTSUELDOLIQUID money
)
go

