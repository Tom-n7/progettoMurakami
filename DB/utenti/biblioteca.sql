create or replace table biblioteca
(
    email varchar(256)  not null
        primary key,
    nome  varchar(64)   not null,
    via   varchar(1024) not null,
    citta varchar(32)   not null,
    CAP   int(5)        not null,
    constraint biblioteca_utente_email_fk
        foreign key (email) references utente (email)
            on update cascade on delete cascade
);

