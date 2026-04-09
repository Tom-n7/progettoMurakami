# Prenota Libro

1. Il lettore richiede al sistema di creare una nuova prenotazione.
2. Il sistema carica le biblioteche registrate e le mostra.
3. Il lettore seleziona la biblioteca che desidera.
4. Il sistema crea una bozza di prenotazione associata al lettore verso la biblioteca selezionata.
5. Il sistema recupera il numero massimo per singola prenotazione impostato dalla biblioteca.
6. Il lettore avvia <u>importa metadati libro()</u>.
7. Il sistema aggiorna la prenotazione.
8. Il sistema mostra la prenotazione aggiornata. <n>
 --si ripetono i passi 6,7 e 8 per ogni libro che il lettore desidera prenotare--  
9. Il lettore conferma i libri inseriti.
10. Il sistema finalizza e salva la prenotazione. 
11. Il sistema richiede invio email di riepilogo contenente i dettagli della prenotazione al lettore.

## Estensioni

1-8a. Il lettore vuole interrompere l'operazione: Il sistema elimina la bozza ed i dati correlati.
Il caso d'uso termina.

6a. Il lettore ha raggiunto il limite di libri per singola prenotazione:
1. Il sistema segnala il fatto all'utente.
2. Il sistema non consente l'aggiunta del libro. 
Il caso d'uso riprende dal passo 8.

8a. Il lettore desidera rimuovere un libro dalla prenotazione:
1. Il lettore seleziona il libro e ne richiede l'eliminazione.
2. Il sistema elimina il libro dalla prenotazione.
Il caso d'uso riprende dal passo 8.

9a. La prenotazione non contiene libri: Il sistema impedisce l'operazione al lettore.
Il caso d'uso riprende dal passo 8.

10a. Errore persistenza:
1. Il sistema notifica il lettore del fallimento
    1a. Il lettore richiede un nuovo tentativo: Il caso d'uso riprende dal passo 9.
    1b. Il lettore rinuncia a prenotare: Il sistema elimina la bozza e termina il caso d'uso.