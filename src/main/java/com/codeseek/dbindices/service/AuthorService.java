package com.codeseek.dbindices.service;

import com.codeseek.dbindices.dao.AuthorDAO;
import com.codeseek.dbindices.dto.AuthorDTO;
import com.codeseek.dbindices.entity.Author;
import com.codeseek.dbindices.mapper.AuthorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorService {
    private final AuthorDAO authorDAO;
    private final AuthorMapper authorMapper;

    public AuthorDTO getAuthorById(Integer id) {
        Author author = authorDAO.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Author not found ID=%d", id)));
        return authorMapper.toDTO(author);
    }
}

