create table writers (
  id INTEGER NOT NULL,
  writers_name varchar(100) NOT NULL
);


create table books (
  id INTEGER NOT NULL,
  books_name varchar(100) NOT NULL,
  year varchar(100) NOT NULL
);


CREATE TABLE writers_books (
  id_writers INTEGER REFERENCES writers(id_writers) ON UPDATE CASCADE ON DELETE CASCADE,
  id_books INTEGER REFERENCES books (id_books) ON UPDATE CASCADE,
    CONSTRAINT writers_books_pkey PRIMARY KEY  (id_writers, id_books));

INSERT INTO writers (id_writers, writers_name) VALUES (1,'Pushkin');
INSERT INTO writers (id_writers, writers_name) VALUES (2,'lermontov');
INSERT INTO writers (id_writers, writers_name) VALUES (3,'Block');
INSERT INTO writers (id_writers, writers_name) VALUES (4,'Kupala');
INSERT INTO books (id_books,books_name, year) VALUES (1,'Day', 1992);
INSERT INTO books (id_books,books_name, year) VALUES (2,'May', 1993);
INSERT INTO books (id_books,books_name, year) VALUES (3,'Say', 1994);
INSERT INTO books (id_books,books_name, year) VALUES (4,'Hay', 1995);

INSERT INTO writers_books (id_writers,id_books) VALUES (1,3);
INSERT INTO writers_books (id_writers,id_books) VALUES (1,2);
INSERT INTO writers_books (id_writers,id_books) VALUES (2,4);
INSERT INTO writers_books (id_writers,id_books) VALUES (3,1);