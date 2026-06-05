## 4. Testing

In fase di testing, si è deciso di valutare il comportamento del controller applicativo del caso d'uso sviluppato, e di come questo si integra con i componenti che responsabili della persistenza dei dati.

**PrenotaControllerTest**

Il primo test svolto attraverso il metodo "testCaricamentoBibliotecheRegistrate()" serve ad assicurarsi che, dato un tipo di persistenza supportato dal sistema, il numero di biblioteche registrate ed un filtro neutro, il sistema riesca a recuperare tutte le biblioteche registrate.

Il secondo test viene serve a verificare che il passaggio di validazione della prenotazione sia svolto correttamente. Per farlo, viene creata una bozza di prenotazione valida, poi si processa tale prenotazione con "validaPrenotazione()" e si verifica che lo stato sia "VERIFICATA".