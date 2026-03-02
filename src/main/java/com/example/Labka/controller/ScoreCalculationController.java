package com.example.Labka.controller;

import com.example.Labka.dto.ExamResultRequest;
import com.example.Labka.entity.Score;
import com.example.Labka.service.ScoreCalculationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scores")
public class ScoreCalculationController {

    private final ScoreCalculationService scoreService;

    public ScoreCalculationController(ScoreCalculationService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<Score> calculateScore(@RequestBody ExamResultRequest request) {
        Score score = scoreService.calculateAndSaveScore(request);
        return ResponseEntity.ok(score);
    }
}
