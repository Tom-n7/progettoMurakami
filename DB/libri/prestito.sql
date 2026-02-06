create or replace table prestito
(
    libro int                           not null,
    id    int auto_increment
        primary key,
    amico varchar(64)                   not null,
    email varchar(256)                  null,
    stato enum ('prestato', 'ricevuto') not null,
    constraint prestito_libro_ID_fk
        foreign key (libro) references libro (ID)
            on update cascade on delete cascade
);

