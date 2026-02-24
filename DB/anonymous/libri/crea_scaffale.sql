create
    definer = root@localhost procedure crea_scaffale(IN arg_nome_scaffale varchar(64))
BEGIN

    declare exit handler for sqlexception
        begin
            rollback;
            resignal;
        end;

    START TRANSACTION;

        INSERT INTO scaffale(nome)
            values (arg_nome_scaffale);

    end;

