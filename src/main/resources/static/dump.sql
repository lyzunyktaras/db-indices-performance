INSERT INTO authors (name, birth_year)
SELECT 'Author ' || i, 1950 + (i % 50)
FROM generate_series(1, 1000) AS s(i);

INSERT INTO books (title, author_id, genre, published_year, isbn, copies)
SELECT 'Book ' || i,
       (i % 1000) + 1,
       CASE (i % 5)
           WHEN 0 THEN 'Science Fiction'
           WHEN 1 THEN 'Fantasy'
           WHEN 2 THEN 'Mystery'
           WHEN 3 THEN 'Romance'
           ELSE 'Horror'
           END,
       2000 + (i % 21),
       '1234567890' || LPAD(i::text, 5, '0'),
       (i % 10) + 1
FROM generate_series(1, 1000000) AS s(i);

INSERT INTO borrowers (name, email)
SELECT 'Borrower ' || i, 'borrower' || i || '@example.com'
FROM generate_series(1, 10000) AS s(i);

INSERT INTO borrowed_books (book_id, borrower_id, borrow_date, return_date)
SELECT (i % 1000000) + 1,
       (i % 10000) + 1,
       '2020-01-01'::date + (i % 365),
       '2020-01-01'::date + (i % 365) + (i % 30)
FROM generate_series(1, 5000000) AS s(i);
