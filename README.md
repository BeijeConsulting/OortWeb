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