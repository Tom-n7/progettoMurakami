create or replace table libro
(
    titolo        varchar(128)  not null,
    pubblicazione date          null,
    ID            int auto_increment
        primary key,
    editore       varchar(128)  null,
    lingua        varchar(64)   null,
    ISNB          varchar(17)   null comment 'il codice isnb è composto da 13 cifre divise in 5 settori da trattini  "-", prima del 2010 le cifre enrano 10',
    nome_serie    varchar(256)  null,
    numero_serie  int           null comment 'dovrebbe essere null se nome_serie null',
    descrizione   varchar(1024) null
);

