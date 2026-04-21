# Prenota Libro

1. Il sistema permette la ricerca di biblioteche.
2. Il lettore inserisce i criteri di ricerca.
3. Il sistema carica le biblioteche conformi ai criteri.
4. Il lettore seleziona la biblioteca che desidera. 
5. Il sistema crea una bozza di prenotazione associata al lettore. 
6. Il sistema carica i dati della biblioteca e li associa alla prenotazione. 
7. Il lettore richiede l'aggiunta di un libro. 
8. Il sistema avvia <u>importa metadati libro()</u>. 
9. Il sistema aggiunge il libro alla prenotazione. <n>
 --si ripetono i passi 7, 8 e 9 per ogni libro che il lettore desidera prenotare-- 
10. Il lettore conferma i libri inseriti. 
11. Il sistema valida la prenotazione.
12. Il sistema salva la prenotazione. 
13. Il sistema richiede al servizio mail l'invio di un messaggio di riepilogo contenente i dettagli della prenotazione al lettore.

## Estensioni

1-7a. Il lettore vuole interrompere l'operazione: Il sistema elimina la bozza ed i dati correlati.
Il caso d'uso termina.



7c. La prenotazione contiene almeno un libro ed il lettore vuole modificare i dati di uno dei libri:
1. Il lettore seleziona il libro
2. Il sistema mostra i dettagli del libro selezionato.
3. Il sistema avvia <u>importa metadati libro</u>.
4. Il lettore conferma le modifiche.
5. Il sistema aggiorna la prenotazione
Il caso d'uso riprende dal passo 5

10a. La prenotazione non contiene libri: Il sistema impedisce la conferma.
   Il caso d’uso riprende dal passo 7.

10b. La prenotazione contiene almeno un libro ed il lettore vuole eliminarne uno:
1. Il lettore richiede di eliminare un libro.
2. Il sistema permette la selezione di libri della prenotazione.
3. Il lettore seleziona il libro che desidera eliminare.
4. Il sistema mostra i dettagli del libro.
5. Il lettore conferma la scelta.
6. Il sistema elimina il libro dalla prenotazione.
   Il caso d'uso riprende dal passo 7.

11a. La prenotazione contiene un numero di libri superiore al limite stabilito dalla biblioteca per singola prenotazione: 
1. Il sistema comunica il numero di libri in eccesso.
2. Il sistema impedisce la conferma.
   Il caso d'uso riprende dal passo 7.

12a. Errore persistenza:
1. Il sistema notifica il lettore del fallimento
    1a. Il lettore richiede un nuovo tentativo: Il caso d'uso riprende dal passo 11.
    1b. Il lettore rinuncia a prenotare: Il sistema elimina la bozza e termina il caso d'uso.