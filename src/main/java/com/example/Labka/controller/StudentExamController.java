package com.example.Labka.controller;

import com.example.Labka.dto.*;
import com.example.Labka.entity.Exam;
import com.example.Labka.entity.Score;
import com.example.Labka.service.ExamService;
import com.example.Labka.service.ScoreCalculationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/student")
public class StudentExamController {

    private final ExamService examService;
    private final ScoreCalculationService scoreService;

    public StudentExamController(ExamService examService, ScoreCalculationService scoreService) {
        this.examService = examService;
        this.scoreService = scoreService;
    }

    @GetMapping("/exam/{examId}")
    public List<QuestionDto> getExamQuestions(@PathVariable Long examId) {
        List<QuestionDto> questions = examService.getExamQuestions(examId);
        if (questions.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exam not found or no questions");
        }
        return questions;
    }

    @GetMapping("/exams")
    public List<ExamDto> getAllExams() {
        List<Exam> exams = examService.getAllExams();
        List<ExamDto> dtos = new ArrayList<>();
        for (Exam e : exams) {
            ExamDto dto = new ExamDto();
            dto.setExamId(e.getExamId());
            dto.setTitle(e.getTitle());
            dto.setTimeLimit(e.getTimeLimit());
            dto.setDescription(e.getDescription());
            dtos.add(dto);
        }
        return dtos;
    }

    @PostMapping("/submit")
    public Score submitExam(@RequestBody List<StudentAnswerRequest> answers) {
        if (answers == null || answers.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Answers cannot be empty");
        }

        ExamResultRequest request = new ExamResultRequest();
        request.setUserId(answers.get(0).getUserId());
        request.setExamId(answers.get(0).getExamId());
        request.setAnswers(answers);

        return scoreService.calculateAndSaveScore(request);
    }
}
