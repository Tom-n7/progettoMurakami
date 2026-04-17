# Prenota Libro

1. Il sistema carica le biblioteche registrate. 
2. Il sistema crea una bozza di prenotazione associata al lettore.
3. Il lettore seleziona la biblioteca che desidera.
4. Il sistema carica i dati della biblioteca e la associa alla prenotazione.
5. Il sistema mostra i dettagli della prenotazione. 
6. Il lettore richiede l'aggiunta di un libro. 
7. Il sistema avvia <u>importa metadati libro()</u>. 
8. Il sistema aggiunge il libro alla prenotazione. <n>
 --si ripetono i passi 5,6,7 e 8 per ogni libro che il lettore desidera prenotare-- 
9. Il lettore conferma i libri inseriti. 
10. Il sistema finalizza e salva la prenotazione. 
11. Il sistema richiede al servizio mail l'invio di un messaggio di riepilogo contenente i dettagli della prenotazione al lettore.

## Estensioni

3-8a. Il lettore vuole interrompere l'operazione: Il sistema elimina la bozza ed i dati correlati.
Il caso d'uso termina.

5b. La prenotazione contiene almeno un libro ed il lettore vuole eliminarne uno:
1. Il lettore seleziona il libro e ne richiede l'eliminazione.
2. Il sistema elimina il libro dalla prenotazione.
Il caso d'uso riprende dal passo 7.

5c. La prenotazione contiene almeno un libro ed il lettore vuole modificare i dati di uno dei libri:
1. Il lettore seleziona il libro
2. Il sistema mostra i dettagli del libro selezionato.
3. Il lettore modifica i dati che desidera del libro.
4. Il lettore conferma le modifiche.
5. Il sistema aggiorna la prenotazione
Il caso d'uso riprende dal passo 5

9a. La prenotazione non contiene libri: Il sistema impedisce la conferma.
   Il caso d’uso riprende dal passo 7.

9b. La prenotazione contiene un numero di libri superiore al limite stabilito dalla biblioteca per singola prenotazione: 
1. Il sistema comunica il numero di libri in eccesso.
2. Il sistema impedisce la conferma.
   Il caso d'uso riprende dal passo 7.

10a. Errore persistenza:
1. Il sistema notifica il lettore del fallimento
    1a. Il lettore richiede un nuovo tentativo: Il caso d'uso riprende dal passo 9.
    1b. Il lettore rinuncia a prenotare: Il sistema elimina la bozza e termina il caso d'uso.