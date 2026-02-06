create or replace table amicizie
(
    let   varchar(64) not null,
    amico varchar(64) not null,
    primary key (amico, let),
    constraint amicizie_lettore_username_fk
        foreign key (let) references lettore (username)
            on update cascade on delete cascade,
    constraint amicizie_lettore_username_fk_2
        foreign key (amico) references lettore (username)
            on update cascade on delete cascade
);

