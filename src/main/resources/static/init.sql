CREATE TABLE authors
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    birth_year INT
);

CREATE TABLE books
(
    id             SERIAL PRIMARY KEY,
    title          VARCHAR(255) NOT NULL,
    author_id      INT REFERENCES authors (id),
    genre          VARCHAR(255),
    published_year INT,
    isbn           VARCHAR(20),
    copies         INT
);

CREATE TABLE borrowers
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(255)        NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE borrowed_books
(
    id          SERIAL PRIMARY KEY,
    book_id     INT REFERENCES books (id),
    borrower_id INT REFERENCES borrowers (id),
    borrow_date DATE,
    return_date DATE
);
