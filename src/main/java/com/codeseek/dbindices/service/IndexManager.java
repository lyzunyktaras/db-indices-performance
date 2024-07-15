package com.codeseek.dbindices.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
@RequiredArgsConstructor
@Slf4j
public class IndexManager {
    private final Connection connection;

    public String[] createIndexes() {
        String[] queries = {
                "CREATE INDEX IF NOT EXISTS idx_books_genre_published_year_author ON books (genre, published_year, author_id);",
                "CREATE INDEX IF NOT EXISTS idx_books_title ON books (title);",
                "CREATE INDEX IF NOT EXISTS idx_books_isbn ON books (isbn);",

                "CREATE INDEX IF NOT EXISTS idx_authors_id ON authors (id);",

                "CREATE INDEX IF NOT EXISTS idx_borrowers_name ON borrowers (name);",
                "CREATE INDEX IF NOT EXISTS idx_borrowers_email ON borrowers (email);",

                "CREATE INDEX IF NOT EXISTS idx_borrowed_books_dates ON borrowed_books (borrow_date, return_date);",
                "CREATE INDEX IF NOT EXISTS idx_borrowed_books_book_id ON borrowed_books (book_id);",
                "CREATE INDEX IF NOT EXISTS idx_borrowed_books_borrower_id ON borrowed_books (borrower_id);"
        };
        executeBatch(queries);
        return queries;
    }

    public String[] dropIndexes() {
        String[] queries = {
                "DROP INDEX IF EXISTS idx_books_genre_published_year_author;",
                "DROP INDEX IF EXISTS idx_books_title;",
                "DROP INDEX IF EXISTS idx_books_isbn;",

                "DROP INDEX IF EXISTS idx_authors_id;",

                "DROP INDEX IF EXISTS idx_borrowers_name;",
                "DROP INDEX IF EXISTS idx_borrowers_email;",

                "DROP INDEX IF EXISTS idx_borrowed_books_dates;",
                "DROP INDEX IF EXISTS idx_borrowed_books_book_id;",
                "DROP INDEX IF EXISTS idx_borrowed_books_borrower_id;"
        };
        executeBatch(queries);
        return queries;
    }

    private void executeBatch(String[] queries) {
        try (
                Statement stmt = connection.createStatement()) {
            for (String query : queries) {
                stmt.addBatch(query);
            }
            stmt.executeBatch();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }
}
