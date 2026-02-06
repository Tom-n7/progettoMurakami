create or replace table lettore
(
    email    varchar(256) not null
        primary key,
    username varchar(64)  not null,
    constraint lettore_pk
        unique (username),
    constraint lettore_utente_email_fk
        foreign key (email) references utente (email)
            on update cascade on delete cascade
);

