# Prenota Libro

1. Il Lettore esegue il [login](), poi esegue [cerca libro](), trova il libro che vuole chiedere in prestito e seleziona "Cerca in Biblioteca"
2. Il Sistema registra i dati del libro selezionato e mostra lo strumento di ricerca delle biblioteche
3. Il Lettore seleziona la biblioteca in cui desidera recarsi per prendere in prestito il libro.
4. Il Sistema invia alla biblioteca selezionata la richiesta del lettore.
5. Il Bibliotecario seleziona la richiesta del Lettore
6. Il sistema mostra la richiesta e la data in cui è stata effettuata.
7. Il Bibliotecario verifica la disponibilità del libro e conferma al sistema che il libro è disponibile, inserisce la data a partire dal quale il Lettore può recarsi a prenderlo ed il giorno di scadenza della prenotazione.
8. Il sistema trasferisce la richiesta nella sezione "Prenotazioni" del bibliotecario, lo fa anche per il lettore che viene notificato.
9. Il cliente si reca in biblioteca entro la data di scadenza e mostra la prenotazione al bibliotecario
10. Il bibliotecario identifica la prenotazione, notifica il sistema dell'avvenuta consegna e presta il libro al lettore.
11. Il sistema marca le richiesta come completa.


estensioni:
1a) Il libro cercato dal lettore non è presente nel catalogo del sistema:
1. Il sistema avvisa il lettore e mostra il modulo dati libro.
2. Il lettore inserisce i dati del libro che desidera.

1b) Il database dei libri non risponde: 
1. Il sistema avvisa il lettore e mostra il modulo dati libro.
2. Il lettore inserisce i dati del libro che desidera.


1-3a): Il lettore cambia idea e non vuole prenotare il libro: il sistema elimina i dati legati alla richiesta e mostra la libreria personale del lettore.


7a) Il bibliotecario non trova il libro oggetto di prenotazione:

1. Il bibliotecario segnala al sistema che il libro non è disponibile.
2. Il sistema marca la richiesta come completa e lo notifica al bibliotecario ed al lettore.

9a) Il cliente non si reca alla biblioteca entro la data di scadenza: