create or replace table scrittore
(
    ID    int auto_increment
        primary key,
    Nome  varchar(128) null,
    libro int          not null,
    constraint scrittore_libro_ID_fk
        foreign key (libro) references libro (ID)
);

