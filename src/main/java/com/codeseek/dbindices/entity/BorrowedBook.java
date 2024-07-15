package com.codeseek.dbindices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowedBook {
    private Long id;

    private Book book;

    private Borrower borrower;

    private LocalDate borrowDate;

    private LocalDate returnDate;
}
