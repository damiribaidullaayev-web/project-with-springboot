package com.example.Labka.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SCORE")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCORE_ID")
    private Long id;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "EXAM_ID", nullable = false)
    private Long examId;

    @Column(name = "SCORE")
    private Integer score;

    @Column(name = "START_TIME")
    private LocalDateTime startTime;

    @Column(name = "END_TIME")
    private LocalDateTime endTime;

    public Score() {}

    // ===== Геттеры =====
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getExamId() {
        return examId;
    }

    public Integer getScore() {
        return score;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    // ===== Сеттеры =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
