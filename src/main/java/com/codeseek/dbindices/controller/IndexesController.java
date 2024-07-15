package com.codeseek.dbindices.controller;

import com.codeseek.dbindices.service.IndexManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/indexes")
public class IndexesController {
    private final IndexManager indexManager;

    @PostMapping
    public ResponseEntity<String[]> indexesOn() {
        return new ResponseEntity<>(indexManager.createIndexes(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String[]> indexesOff() {
        return new ResponseEntity<>(indexManager.dropIndexes(), HttpStatus.OK);
    }
}
