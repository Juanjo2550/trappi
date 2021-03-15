create table LIBRODIARIO
(
    IDLIBRODIARIO int not null
        constraint PK_LIBRODIARIO
            primary key nonclustered
)
go

INSERT INTO trappiDb.dbo.LIBRODIARIO (IDLIBRODIARIO) VALUES (1);