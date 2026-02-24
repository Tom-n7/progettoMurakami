create
    definer = root@localhost procedure get_libri_scaffale(IN nome_scaffale varchar(64))
BEGIN

    declare exit handler for sqlexception
        begin
            rollback;
            resignal;
        end;

    START TRANSACTION;
        select libro
            from
                collocazione
            where
                nome_scaffale = scaffale;
    end;

