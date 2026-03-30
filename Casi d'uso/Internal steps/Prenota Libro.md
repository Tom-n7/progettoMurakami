# Prenota Libro

1. Il lettore richiede al sistema di creare una nuova prenotazione.
2. Il sistema carica le biblioteche registrate e le mostra.
3. Il lettore seleziona la biblioteca che desidera.
4. Il sistema crea una bozza di prenotazione associata al lettore verso la biblioteca selezionata.
5. Il sistema controlla il numero massimo di libri per singola prenotazione impostato dalla biblioteca e lo mostra al lettore.
6. Il lettore avvia <u>importa metadati libro()<u>.
7. Il sistema aggiunge il libro importato alla prenotazione.
8. Il sistema mostra la prenotazione aggiornata.
--si ripetono i passi 6,7 e 8 per ogni libro che il lettore desidera prenotare--
9. Il sistema crea la prenotazione e la salva.
10. Il sistema invia una notifica alla biblioteca.
11. Il sistema invia una email contenete i dettagli della prenotazione al lettore.

## Estensioni

1a. Il lettore vuole creare una prenotazione a partire da una bozza:
1. Il sistema carica le bozze di prenotazione salvate localmente e le mostra.
2. Il lettore seleziona una bozza.
Il caso d'uso riprende dal passo 8

6a. Il lettore ha raggiunto il limite di libri per singola prenotazione:
1. Il sistema segnala il fatto all'utente.
2. Il sistema termina <u>importa metadati libro()<u>. 
Il caso d'uso riprende dal passo 8.

8a. Il lettore desidera rimuovere un libro dalla prenotazione:
1. Il lettore seleziona il libro e ne richiede l'eliminazione.
2. Il sistema elimina il libro dalla prenotazione.
Il caso d'uso riprende dal passo 8.

9a. Il sistema non è connesso a internet:
1. Il sistema segnala l'errore al lettore.
2. Il sistema salva localmente la bozza della prenotazione.
Il caso d'uso termina.