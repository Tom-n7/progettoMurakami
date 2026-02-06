create or replace
    definer = root@localhost procedure inserisci_libro(IN titolo varchar(128), IN pubblicazione date,
                                                       IN editore varchar(128), IN lingua varchar(64),
                                                       IN ISNB varchar(17), IN nome_serie varchar(256),
                                                       IN numero_serie int, IN descrizione varchar(1024))
BEGIN

        declare exit handler for sqlexception
    begin
        rollback;
        resignal;
    end;


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

