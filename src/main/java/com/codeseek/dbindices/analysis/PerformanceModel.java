package com.codeseek.dbindices.analysis;

import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
public class PerformanceModel {
    private long avgTimeWithoutIndex;
    private long avgTimeWithIndex;
    private String explainOutput;
    private long executionTime;
}
