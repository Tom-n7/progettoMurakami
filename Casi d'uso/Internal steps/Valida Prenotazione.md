# Valida Prenotazione
        
1. Il lettore mostra il codice della prenotazione al bibliotecario.
2. Il bibliotecario inserisce il codice nel sistema.
3. Il sistema verifica la presenza di una prenotazione accettata e non scaduta presso la biblioteca associata al codice.
4. Il sistema mostra i dettagli del libro oggetto della prenotazione e i dati dell'account associato al lettore.
5. Il bibliotecario conferma al sistema l'avvenuto prestito. 
6. Il sistema cambia lo stato della prenotazione in "completata con successo". 
7. Il sistema invia una email al lettore contenete le informazioni della biblioteca, la data di inizio del prestito e i dettagli del libro ricevuto.

## EXTENDS

* 3a. Non esistono prenotazioni associate al codice:
1. Il sistema segnala il fatto al bibliotecario.
2. Il bibliotecario richiede al sistema lo strumento di ricerca prenotazione tramite username.
3. Il bibliotecario chiede al lettore lo username con cui è registrato nel sistema e lo inserisce.
4. Il sistema mostra tutte le prenotazione associate all'utente presso la biblioteca in ordine cronologico. 
5. Il bibliotecario individua la prenotazione.
Il caso d'uso riprende dal passo 4.

* 3b. La prenotazione associata al codice è scaduta:
1. Il sistema rileva che la prenotazione è scaduta.
2. Il sistema segnala il fatto al bibliotecario.
Il caso d'uso termina.

* 4a. Il libro riservato non coincide con quello richiesto dal lettore: 
1. Il bibliotecario segnala al sistema che il prestito non è avvenuto 
2. Il sistema cambia lo stato della prenotazione in "fallita". 
Il caso d'uso riprende dal passo 8. 