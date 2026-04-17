# Prenota Libro

1. Il sistema carica le biblioteche registrate. 
2. Il sistema crea una bozza di prenotazione associata al lettore.
3. Il lettore seleziona la biblioteca che desidera.
4. Il sistema carica i dati della biblioteca e la associa alla prenotazione.
5. Il lettore richiede l'aggiunta di un libro 
6. Il sistema avvia <u>importa metadati libro()</u>. 
7. Il sistema aggiunge il libro e mostra la prenotazione aggiornata. <n>
 --si ripetono i passi 5,6 e 7 per ogni libro che il lettore desidera prenotare-- 
8. Il lettore conferma i libri inseriti. 
9. Il sistema finalizza e salva la prenotazione. 
10. Il sistema richiede al servizio mail l'invio di un messaggio di riepilogo contenente i dettagli della prenotazione al lettore.

## Estensioni

3-7a. Il lettore vuole interrompere l'operazione: Il sistema elimina la bozza ed i dati correlati.
Il caso d'uso termina.

7b. Il lettore desidera rimuovere un libro dalla prenotazione:
1. Il lettore seleziona il libro e ne richiede l'eliminazione.
2. Il sistema elimina il libro dalla prenotazione.
Il caso d'uso riprende dal passo 7.

8a. La prenotazione non contiene libri: Il sistema impedisce la conferma.
   Il caso d’uso riprende dal passo 7.

8b. La prenotazione contiene un numero di libri superiore al limite stabilito dalla biblioteca per singola prenotazione: 
1. Il sistema comunica il numero di libri in eccesso.
2. Il sistema impedisce la conferma.
   Il caso d'uso riprende dal passo 7.

9a. Errore persistenza:
1. Il sistema notifica il lettore del fallimento
    1a. Il lettore richiede un nuovo tentativo: Il caso d'uso riprende dal passo 9.
    1b. Il lettore rinuncia a prenotare: Il sistema elimina la bozza e termina il caso d'uso.