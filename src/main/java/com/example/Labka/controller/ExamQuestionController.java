package com.example.Labka.controller;

import com.example.Labka.dto.ExamQuestionRequest;
import com.example.Labka.entity.ExamQuestion;
import com.example.Labka.service.ExamQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exam-questions")
public class ExamQuestionController {

    private final ExamQuestionService service;

    public ExamQuestionController(ExamQuestionService service) {
        this.service = service;
    }

    @GetMapping
    public List<ExamQuestion> getAll() {
        return service.getAll();
    }

    @GetMapping("/exam/{examId}")
    public List<ExamQuestion> getByExam(@PathVariable Long examId) {
        return service.getByExamId(examId);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody ExamQuestionRequest request) {
        return ResponseEntity.ok(service.add(request));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ExamQuestionRequest request) {
        try {
            return ResponseEntity.ok(service.update(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{examId}/{questionId}")
    public ResponseEntity<?> delete(@PathVariable Long examId, @PathVariable Long questionId) {
        service.delete(examId, questionId);
        return ResponseEntity.ok("Deleted");
    }
}
