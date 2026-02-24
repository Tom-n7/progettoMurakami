create
    definer = root@localhost procedure crea_nuovo_libro(IN arg_titolo varchar(128), IN arg_pubblicazione date,
                                                        IN arg_editore varchar(128), IN arg_lingua varchar(64),
                                                        IN arg_ISNB varchar(17), IN arg_nome_serie varchar(256),
                                                        IN arg_numero_serie int, IN arg_descrizione varchar(1024),
                                                        IN arg_nome_scaffale varchar(64), OUT v_id_libro int)
BEGIN

        declare exit handler for sqlexception
    begin
        rollback;
        resignal;
    end;


        START TRANSACTION;
            INSERT INTO libro(titolo, pubblicazione, editore, lingua, ISNB, nome_serie, numero_serie, descrizione)
                VALUES (arg_titolo, arg_pubblicazione, arg_editore, arg_lingua, arg_ISNB,
                        arg_nome_serie, arg_numero_serie, arg_descrizione);


            select ID 
                from 
                    libro 
                where
                    titolo = arg_titolo and pubblicazione = arg_pubblicazione and editore = arg_editore and lingua = arg_lingua
                     and ISNB = arg_ISNB and nome_serie = arg_nome_serie and  numero_serie = arg_numero_serie and descrizione = arg_descrizione
                into v_id_libro;

        commit;

end;

