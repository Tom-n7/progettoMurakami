create table copertina
(
    ID            int auto_increment
        primary key,
    nome_immagne  varchar(1024) null,
    file_immagine mediumblob    null,
    libro         int           not null,
    constraint copertina_libro_ID_fk
        foreign key (libro) references libro (ID)
            on update cascade on delete cascade
)
    comment 'contiene i file immagine delle copertine come BLOB';

