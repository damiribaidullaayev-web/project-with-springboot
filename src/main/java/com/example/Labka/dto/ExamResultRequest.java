package com.example.Labka.dto;

import java.util.List;

public class ExamResultRequest {

    private Long userId;
    private Long examId;
    private Integer score;
    private List<StudentAnswerRequest> answers; // добавлено

    // геттеры и сеттеры
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getExamId() { return examId; }
    public void setExamId(Long examId) { this.examId = examId; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }

    public List<StudentAnswerRequest> getAnswers() { return answers; }
    public void setAnswers(List<StudentAnswerRequest> answers) { this.answers = answers; }
}
