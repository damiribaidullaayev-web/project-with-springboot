package com.example.Labka.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EXAM")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EXAM_ID")
    private Long examId;

    @Column(name = "SUBJECT_ID", nullable = false)
    private Long subjectId;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "TIME_LIMIT")
    private Integer timeLimit;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "RANDOMIZATION", length = 1)
    private String randomization; // 'Y' или 'N'

    public Exam() {}

    public Exam(Long subjectId, String title, Integer timeLimit, String description, String randomization) {
        this.subjectId = subjectId;
        this.title = title;
        this.timeLimit = timeLimit;
        this.description = description;
        this.randomization = randomization;
    }

    // Геттеры и сеттеры
    public Long getExamId() { return examId; }
    public void setExamId(Long examId) { this.examId = examId; }

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
