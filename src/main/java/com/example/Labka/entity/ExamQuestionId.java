package com.example.Labka.entity;

import java.io.Serializable;
import java.util.Objects;

public class ExamQuestionId implements Serializable {

    private Long examId;
    private Long questionId;

    public ExamQuestionId() {}

    public ExamQuestionId(Long examId, Long questionId) {
        this.examId = examId;
        this.questionId = questionId;
    }

    public Long getExamId() { return examId; }
    public void setExamId(Long examId) { this.examId = examId; }

    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        ExamQuestionId that = (ExamQuestionId) o;
        return Objects.equals(examId, that.examId) && Objects.equals(questionId, that.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examId, questionId);
    }
}
