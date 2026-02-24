create
    definer = root@localhost procedure get_scaffali_libreria_personale()
BEGIN

    declare exit handler for sqlexception
        begin
            rollback;
            resignal;
        end;

    START TRANSACTION;
        select * from scaffale order by nome;
    end;

