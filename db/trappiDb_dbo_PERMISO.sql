create table PERMISO
(
    IDPERM          int not null
        constraint PK_PERMISO
            primary key nonclustered,
    IDEMP           int
        constraint FK_PERMISO_RELATIONS_EMPLEADO
            references EMPLEADO,
    NUMDIASPERM     int,
    VALORPAGARPERM  money,
    COMENTPERM      varchar(1024),
    FECHAINICIOPERM datetime,
    FECHAFINPERM    datetime,
    ESTADOPERM      varchar(1024),
    TIPOPERM        varchar(1024)
)
go

