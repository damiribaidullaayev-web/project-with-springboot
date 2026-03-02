package com.example.Labka.controller;

import com.example.Labka.dto.ExamRequest;
import com.example.Labka.entity.Exam;
import com.example.Labka.service.ExamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    private final ExamService service;

    public ExamController(ExamService service) {
        this.service = service;
    }

    @GetMapping
    public List<Exam> getAllExams() {
        return service.getAllExams();
    }

    @GetMapping("/subject/{subjectId}")
    public List<Exam> getExamsBySubject(@PathVariable Long subjectId) {
        return service.getExamsBySubject(subjectId);
    }

    @PostMapping
    public ResponseEntity<?> addExam(@RequestBody ExamRequest request) {
        try {
            Exam saved = service.addExam(request);
            return ResponseEntity.ok(saved);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExam(@PathVariable Long id, @RequestBody ExamRequest request) {
        try {
            Exam updated = service.updateExam(id, request);
            return ResponseEntity.ok(updated);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExam(@PathVariable Long id) {
        try {
            service.deleteExam(id);
            return ResponseEntity.ok("Deleted");
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
