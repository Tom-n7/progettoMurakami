create or replace
    definer = root@localhost procedure carica_libreria_personale()
BEGIN

        declare exit handler for sqlexception
    begin
        rollback;
        resignal;
    end;


    set transaction isolation level read committed;

        START TRANSACTION;

            select l.titolo, s.Nome, pubblicazione, editore, lingua, ISNB,
                   nome_serie, numero_serie, descrizione
            from
                libro as l left join scrittore as s on l.ID = s.libro

            order by l.titolo;

            select titolo, nome_immagne, file_immagine
            from
                libro left join libri.copertina c on libro.ID = c.libro;

        commit;



end;

