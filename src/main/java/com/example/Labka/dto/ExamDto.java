package com.example.Labka.dto;

public class ExamDto {
    private Long examId;
    private String title;
    private Integer timeLimit;
    private String description; // обязательно

    public Long getExamId() { return examId; }
    public void setExamId(Long examId) { this.examId = examId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getTimeLimit() { return timeLimit; }
    public void setTimeLimit(Integer timeLimit) { this.timeLimit = timeLimit; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
