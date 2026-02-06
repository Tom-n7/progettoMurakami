create or replace table utente
(
    email    varchar(256)                   not null
        primary key,
    password char(32)                       not null,
    ruolo    enum ('lettore', 'biblioteca') not null
);

