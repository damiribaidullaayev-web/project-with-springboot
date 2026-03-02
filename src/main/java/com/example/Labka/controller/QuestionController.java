package com.example.Labka.controller;

import com.example.Labka.dto.QuestionRequest;
import com.example.Labka.dto.QuestionResponse;
import com.example.Labka.entity.Question;
import com.example.Labka.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }

    // Возвращаем список QuestionResponse вместо Question
    @GetMapping
    public List<QuestionResponse> getAllQuestions() {
        return service.getAllQuestions();
    }

    @PostMapping
    public ResponseEntity<?> addQuestion(@RequestBody QuestionRequest request) {
        try {
            Question saved = service.addQuestion(request);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long id) {
        try {
            service.deleteQuestion(id);
            return ResponseEntity.ok("Deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateQuestion(@PathVariable Long id, @RequestBody QuestionRequest request) {
        try {
            Question updated = service.updateQuestion(id, request);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
