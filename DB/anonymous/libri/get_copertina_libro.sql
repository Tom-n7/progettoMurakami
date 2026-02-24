create
    definer = root@localhost procedure get_copertina_libro(IN libro_cercato int)
BEGIN

    declare exit handler for sqlexception
        begin
            rollback;
            resignal;
        end;

    start transaction;

        select libro.ID, c.nome_immagne, c.file_immagine
            from
                libro left join copertina c on libro.ID = c.libro
            where
                libro_cercato = libro.ID;
    commit;

end;

