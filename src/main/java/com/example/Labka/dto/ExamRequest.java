package com.example.Labka.dto;

public class ExamRequest {
    private Long subjectId;
    private String title;
    private Integer timeLimit;
    private String description;
    private String randomization; // 'Y' или 'N'

    public Long getSubjectId() { return subjectId; }
    public void setSubjectId(Long subjectId) { this.subjectId = subjectId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getTimeLimit() { return timeLimit; }
    public void setTimeLimit(Integer timeLimit) { this.timeLimit = timeLimit; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getRandomization() { return randomization; }
    public void setRandomization(String randomization) { this.randomization = randomization; }
}
