package com.codeseek.dbindices.controller;

import com.codeseek.dbindices.dto.BookDTO;
import com.codeseek.dbindices.service.BookService;
import com.codeseek.dbindices.service.IndexManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<BookDTO>> getBooksByGenreYearAndAuthor(@RequestParam String genre,
                                                                      @RequestParam Integer year,
                                                                      @PathVariable Integer authorId) {
        return new ResponseEntity<>(bookService.getBooksByGenreYearAndAuthor(genre, year, authorId),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }
}
