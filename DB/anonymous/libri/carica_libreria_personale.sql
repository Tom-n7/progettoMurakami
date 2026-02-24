create
    definer = root@localhost procedure carica_libreria_personale()
BEGIN

        declare exit handler for sqlexception
    begin
        rollback;
        resignal;
    end;


    set transaction isolation level read committed;

        START TRANSACTION;


            select nome from scaffale order by nome;

            select l.titolo, s.Nome, pubblicazione, editore, lingua, ISNB,
                   nome_serie, numero_serie, descrizione, scaffale, l.id
            from
                (libro as l left join scrittore as s on l.ID = s.libro)
                    join collocazione on collocazione.libro = l.ID

            order by scaffale, l.titolo;

        commit;



end;

