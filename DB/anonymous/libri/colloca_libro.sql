create
    definer = root@localhost procedure colloca_libro(IN arg_id_libro int, IN arg_nome_scaffale varchar(64))
BEGIN

    declare exit handler for sqlexception
        begin
            rollback;
            resignal;
        end;

    START TRANSACTION;

        INSERT INTO collocazione(libro, scaffale)
            values (arg_id_libro,arg_nome_scaffale);

    end;

