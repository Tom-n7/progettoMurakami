create or replace table annunci
(
    biblioteca varchar(256)  not null,
    testo      varchar(2048) not null,
    immagine   mediumblob    null,
    id         int auto_increment
        primary key,
    constraint annunci_biblioteca_email_fk
        foreign key (biblioteca) references biblioteca (email)
            on update cascade on delete cascade
);

