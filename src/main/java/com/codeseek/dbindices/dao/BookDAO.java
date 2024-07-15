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
import java.util.Collection;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookDAO {
    private final Connection connection;

    public List<Book> getBooksByGenreYearAndAuthor(String genre, int year, int authorId) {
        List<Book> books = new ArrayList<>();
        String query = """
                SELECT b.id as book_id, b.title, b.genre, b.published_year, b.isbn, b.copies,
                       a.id as author_id, a.name as author_name, a.birth_year as author_birth_year
                FROM books b
                LEFT JOIN public.authors a ON a.id = b.author_id
                WHERE b.genre = ? AND b.published_year >= ? AND b.author_id = ?
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, genre);
            preparedStatement.setInt(2, year);
            preparedStatement.setInt(3, authorId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong("book_id"));
                book.setTitle(rs.getString("title"));
                book.setGenre(rs.getString("genre"));
                book.setPublishedYear(rs.getInt("published_year"));
                book.setIsbn(rs.getString("isbn"));
                book.setCopies(rs.getInt("copies"));

                Author author = new Author();
                author.setId(rs.getLong("author_id"));
                author.setName(rs.getString("author_name"));
                author.setBirthYear(rs.getInt("author_birth_year"));

                book.setAuthor(author);

                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        String query = """
                 SELECT b.id as book_id, b.title, b.genre, b.published_year, b.isbn, b.copies,
                       a.id as author_id, a.name as author_name, a.birth_year as author_birth_year
                FROM books b
                LEFT JOIN public.authors a ON a.id = b.author_id
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong("book_id"));
                book.setTitle(rs.getString("title"));
                book.setGenre(rs.getString("genre"));
                book.setPublishedYear(rs.getInt("published_year"));
                book.setIsbn(rs.getString("isbn"));
                book.setCopies(rs.getInt("copies"));

                Author author = new Author();
                author.setId(rs.getLong("author_id"));
                author.setName(rs.getString("author_name"));
                author.setBirthYear(rs.getInt("author_birth_year"));

                book.setAuthor(author);

                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
}
