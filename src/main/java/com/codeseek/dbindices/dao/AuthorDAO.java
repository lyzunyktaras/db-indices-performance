package com.codeseek.dbindices.dao;

import com.codeseek.dbindices.entity.Author;
import com.codeseek.dbindices.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AuthorDAO {
    private final Connection connection;

    public Optional<Author> findById(int id) {
        String query = """
                SELECT a.id AS author_id, a.name AS author_name, a.birth_year, b.id AS book_id, b.title, b.genre, b.published_year, b.isbn, b.copies
                FROM authors a LEFT JOIN books b ON a.id = b.author_id
                WHERE a.id = ?
                """;

        Author author = null;
        List<Book> books = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                if (author == null) {
                    author = new Author();
                    author.setId(rs.getLong("author_id"));
                    author.setName(rs.getString("author_name"));
                    author.setBirthYear(rs.getInt("birth_year"));
                }

                long bookId = rs.getLong("book_id");
                if (bookId > 0) {
                    Book book = new Book();
                    book.setId(bookId);
                    book.setTitle(rs.getString("title"));
                    book.setGenre(rs.getString("genre"));
                    book.setPublishedYear(rs.getInt("published_year"));
                    book.setIsbn(rs.getString("isbn"));
                    book.setCopies(rs.getInt("copies"));
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (author != null) {
            author.setBooks(books);
        }

        return Optional.of(author);
    }
}
