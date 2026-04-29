# Prenota Libro



1. Il lettore inserisce i criteri di ricerca. 
2. Il sistema carica le biblioteche conformi ai criteri. 
3. Il lettore seleziona la biblioteca che desidera. 
4. Il sistema crea una bozza di prenotazione associata al lettore verso la biblioteca. 
5. Il lettore richiede l'aggiunta di un libro. 
6. Il sistema avvia <u>importa metadati libro()</u>. 
7. Il sistema aggiunge il libro alla prenotazione. <n>
 --si ripetono i passi 6, 7 e 8 per ogni libro che il lettore desidera prenotare-- 
8. Il lettore conferma i libri inseriti. 
9. Il sistema valida la prenotazione. 
10. Il sistema salva la prenotazione. 
11. Il sistema notifica il bibliotecario. 
12. Il sistema richiede al servizio mail l'invio di un messaggio di riepilogo contenente i dettagli della prenotazione al lettore.

## Estensioni

1-8a. Il lettore vuole interrompere l'operazione: Il sistema elimina la bozza ed i dati correlati.
Il caso d'uso termina.

6b. La prenotazione contiene almeno un libro ed il lettore vuole eliminarne uno:
1. Il lettore richiede di eliminare un libro.
2. Il sistema permette la selezione di libri della prenotazione. 
3. Il lettore seleziona il libro desiderato 
4. Il sistema elimina il libro dalla prenotazione.
   Il caso d'uso riprende dal passo 6.

9a. La prenotazione non contiene libri: Il sistema impedisce la conferma.
   Il caso d’uso riprende dal passo 6.

9b. La prenotazione contiene un numero di libri superiore al limite stabilito dalla biblioteca per singola prenotazione: 
1. Il sistema comunica il numero di libri in eccesso.
2. Il sistema impedisce la conferma.
   Il caso d'uso riprende dal passo 6.

10a. Errore persistenza:
1. Il sistema notifica il lettore del fallimento
    1a. Il lettore richiede un nuovo tentativo: Il caso d'uso riprende dal passo 11.
    1b. Il lettore rinuncia a prenotare: Il sistema elimina la bozza e termina il caso d'uso.