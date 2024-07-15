package com.codeseek.dbindices.service;

import com.codeseek.dbindices.analysis.MeasurePerformance;
import com.codeseek.dbindices.dao.BookDAO;
import com.codeseek.dbindices.dto.BookDTO;
import com.codeseek.dbindices.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookDAO bookDAO;
    private final BookMapper bookMapper;

    @MeasurePerformance
    public List<BookDTO> getBooksByGenreYearAndAuthor(String genre, int year, int authorId) {
        return bookDAO.getBooksByGenreYearAndAuthor(genre, year, authorId)
                .stream()
                .map(bookMapper::toDTO)
                .toList();
    }

    @MeasurePerformance
    public List<BookDTO> findAll() {
        return bookDAO.findAll()
                .stream()
                .map(bookMapper::toDTO)
                .toList();
    }
}
