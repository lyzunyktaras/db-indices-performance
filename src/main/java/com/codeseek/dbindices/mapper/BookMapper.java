package com.codeseek.dbindices.mapper;

import com.codeseek.dbindices.dto.BookDTO;
import com.codeseek.dbindices.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMapper {
    private final AuthorMapper authorMapper;

    public Book toEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(book.getId());
        book.setTitle(bookDTO.getTitle());
        book.setIsbn(bookDTO.getIsbn());
        book.setGenre(bookDTO.getGenre());
        book.setCopies(bookDTO.getCopies());
        book.setPublishedYear(bookDTO.getPublishedYear());
        book.setAuthor(authorMapper.toEntity(bookDTO.getAuthor()));
        return book;
    }

    public BookDTO toDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setCopies(book.getCopies());
        bookDTO.setPublishedYear(book.getPublishedYear());
        bookDTO.setAuthor(authorMapper.toProfileDTO(book.getAuthor()));
        return bookDTO;
    }
}
