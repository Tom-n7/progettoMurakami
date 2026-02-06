create or replace table collocazione
(
    libro    int         not null,
    scaffale varchar(64) not null,
    primary key (libro, scaffale),
    constraint collocazione_libro_ID_fk
        foreign key (libro) references libro (ID)
            on update cascade on delete cascade,
    constraint collocazione_scaffale_nome_fk
        foreign key (scaffale) references scaffale (nome)
            on update cascade on delete cascade
);

