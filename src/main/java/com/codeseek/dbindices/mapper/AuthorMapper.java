package com.codeseek.dbindices.mapper;

import com.codeseek.dbindices.dto.AuthorBookDTO;
import com.codeseek.dbindices.dto.AuthorDTO;
import com.codeseek.dbindices.dto.AuthorProfileDTO;
import com.codeseek.dbindices.dto.BookDTO;
import com.codeseek.dbindices.entity.Author;
import com.codeseek.dbindices.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorMapper {

    public Author toEntity(AuthorProfileDTO authorProfileDTO) {
        Author author = new Author();
        author.setId(authorProfileDTO.getId());
        author.setName(authorProfileDTO.getName());
        author.setBirthYear(authorProfileDTO.getBirthYear());
        return author;
    }

    public AuthorDTO toDTO(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        authorDTO.setBirthYear(author.getBirthYear());

        List<AuthorBookDTO> books = new ArrayList<>();
        for (Book book : author.getBooks()) {
            AuthorBookDTO authorBookDTO = new AuthorBookDTO();
            authorBookDTO.setId(book.getId());
            authorBookDTO.setTitle(book.getTitle());
            authorBookDTO.setIsbn(book.getIsbn());
            authorBookDTO.setGenre(book.getGenre());
            authorBookDTO.setCopies(book.getCopies());
            authorBookDTO.setPublishedYear(book.getPublishedYear());
            books.add(authorBookDTO);
        }

        authorDTO.setBooks(books);
        return authorDTO;
    }

    public AuthorProfileDTO toProfileDTO(Author author) {
        AuthorProfileDTO authorProfileDTO = new AuthorProfileDTO();
        authorProfileDTO.setId(author.getId());
        authorProfileDTO.setName(author.getName());
        authorProfileDTO.setBirthYear(author.getBirthYear());
        return authorProfileDTO;
    }
}
