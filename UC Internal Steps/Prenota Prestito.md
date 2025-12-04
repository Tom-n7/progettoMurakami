# Prenota Prestito

1. Il Lettore esegue il [login](), poi esegue [cerca libro](), trova il libro che vuole chiedere in prestito e seleziona "Cerca in Biblioteca"
2. Il Sistema registra i dati del libro selezionato e mostra lo strumento di ricerca delle biblioteche
3. Il Lettore esegue [cerca biblioteca]() e seleziona la biblioteca in cui desidera recarsi per prendere in prestito il libro.
4. Il Sistema invia alla biblioteca selezionata, in una richiesta composta da nome, cognome e username del lettore, insieme ai metadati del libro richiesto e la rende visibile nella sezione richieste in attesa della biblioteca e del lettore.
5. Il Bibliotecario seleziona la richiesta del Lettore
6. Il sistema mostra la richiesta e la data in cui è stata effettuata.
7. Il Bibliotecario verifica la disponibilità del libro oggetto di richiesta e conferma al sistema che il libro è disponibile, inserisce la data a partire dal quale il Lettore può recarsi a prenderlo ed il giorno di scadenza della prenotazione,
8. Il sistema trasferisce la richiesta nella sezione "Prenotazioni" del bibliotecario, lo fa anche per il lettore che viene notificato.
9. Il cliente si reca in biblioteca entro la data di scadenza, il bibliotecario seleziona la prenotazione e la termina.
10. Il sistema elimina tale prenotazione dalle rispettive sezioni del bibliotecario e del lettore.