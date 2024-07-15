package com.codeseek.dbindices.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;

    private String title;

    @JsonIgnore
    private AuthorProfileDTO author;

    private String genre;

    private int publishedYear;

    @JsonIgnore
    private String isbn;

    @JsonIgnore
    private int copies;
}
