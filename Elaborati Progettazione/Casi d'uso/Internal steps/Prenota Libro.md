# Prenota Libro

1. Il lettore richiede al sistema di creare una nuova prenotazione.
2. Il sistema carica le biblioteche registrate e le mostra.
3. Il lettore seleziona la biblioteca che desidera.
4. Il sistema crea una bozza di prenotazione associata al lettore verso la biblioteca selezionata.
5. Il sistema recupera il numero massimo per singola prenotazione impostato dalla biblioteca.n
6. Il lettore richiede l'aggiunta di un libro alla prenotazione.
7. Il lettore avvia <u>importa metadati libro()</u>.
8. Il sistema aggiunge il libro importato alla prenotazione.
9. Il sistema mostra la prenotazione aggiornata.
--si ripetono i passi 6,7,8 e 9 per ogni libro che il lettore desidera prenotare-- 
10. Il lettore conferma i libri inseriti.
11. Il sistema invia la prenotazione al bibliotecario. 
12. Il sistema invia una email di riepilogo contenente i dettagli della prenotazione al lettore.

## Estensioni

1-9a. Il lettore vuole interrompere l'operazione:
1. Il sistema elimina la bozza ed i dati correlati.
Il caso d'uso termina.

6a. Il lettore ha raggiunto il limite di libri per singola prenotazione:
1. Il sistema segnala il fatto all'utente.
2. Il sistema termina <u>importa metadati libro()</u>. 
Il caso d'uso riprende dal passo 8.

9a. Il lettore desidera rimuovere un libro dalla prenotazione:
1. Il lettore seleziona il libro e ne richiede l'eliminazione.
2. Il sistema elimina il libro dalla prenotazione.
Il caso d'uso riprende dal passo 8.

10a. La prenotazione non contiene libri: Il sistema impedisce la conferma della prenotazione.
Il caso d'uso riprende dal passo 9.

10b. Il sistema non riesce ad inviare la prenotazione:
1. Il sistema tenta nuovamente l'invio.
    1a. Il sistema fallisce nuovamente.
        1. Il sistema segnala l'errore al lettore.
        2. Il sistema salva la bozza.
        Il caso d'uso termina.
    1b. Il sistema riesce ad inviare la prenotazione: 
        Il caso d'uso riprende dal passo 12.