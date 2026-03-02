package com.example.Labka.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EXAM_QUESTIONS")
@IdClass(ExamQuestionId.class) // Составной ключ
public class ExamQuestion {

    @Id
    @Column(name = "EXAM_ID")
    private Long examId;

    @Id
    @Column(name = "QUESTION_ID")
    private Long questionId;

    @Column(name = "ORDER_INDEX")
    private Integer orderIndex;

    public ExamQuestion() {}

    public ExamQuestion(Long examId, Long questionId, Integer orderIndex) {
        this.examId = examId;
        this.questionId = questionId;
        this.orderIndex = orderIndex;
    }

    // Геттеры и сеттеры
    public Long getExamId() { return examId; }
    public void setExamId(Long examId) { this.examId = examId; }

    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }

    public Integer getOrderIndex() { return orderIndex; }
    public void setOrderIndex(Integer orderIndex) { this.orderIndex = orderIndex; }
}
