# OortWeb
Web Project

## BibliOorteca Login
Admin   
cf: admin  
pw: admin

User:    
cf: paolino  
pw: paperino

## Riempi i db
    BEGIN;
    insert into prestiti (data_inizio, id_libro, cf_utente) values
    ('2008-01-01', '10', 'paolino');
    insert into autori (nome, cognome) values
    ('autore', 'diLibri');
    insert into libri (titolo)
    values ('le mille e una notte');
    insert into editori (nome, descrizione) VALUES
    ('editor', 'editorrrr');
    COMMIT;
    
## Finito
Login: Admin e Utente. Admin fa tutto, Utente per ora guarda solo i suoi prestiti
Ricerca: Autore, Libro
Visualizza: Tutto
Aggiungi: Tutto
Modifica: Autore e Libro, funziona al 100% ma ho rotto il css (c'è una matita nella sezione visualizza accanto all'oggetto)