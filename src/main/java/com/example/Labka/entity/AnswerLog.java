package com.example.Labka.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ANSWER_LOG")
public class AnswerLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOG_ID")
    private Long logId;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "EXAM_ID", nullable = false)
    private Long examId;

    @Column(name = "QUESTION_ID", nullable = false)
    private Long questionId;

    @Column(name = "ANSWER_TEXT")
    private String answerText;

    @Column(name = "SELECTED_OPTION_ID")
    private Long selectedOptionId;

    @Column(name = "TIME_TAKEN")
    private Integer timeTaken;

    @Column(name = "IS_CORRECT")
    private String isCorrect; // 'Y' or 'N'

    public AnswerLog() {}

    public AnswerLog(Long userId, Long examId, Long questionId, String answerText,
                     Long selectedOptionId, Integer timeTaken, String isCorrect) {
        this.userId = userId;
        this.examId = examId;
        this.questionId = questionId;
        this.answerText = answerText;
        this.selectedOptionId = selectedOptionId;
        this.timeTaken = timeTaken;
        this.isCorrect = isCorrect;
    }

    // Getters and Setters

    public Long getLogId() { return logId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getExamId() { return examId; }
    public void setExamId(Long examId) { this.examId = examId; }

    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }

    public String getAnswerText() { return answerText; }
    public void setAnswerText(String answerText) { this.answerText = answerText; }

    public Long getSelectedOptionId() { return selectedOptionId; }
    public void setSelectedOptionId(Long selectedOptionId) { this.selectedOptionId = selectedOptionId; }

    public Integer getTimeTaken() { return timeTaken; }
    public void setTimeTaken(Integer timeTaken) { this.timeTaken = timeTaken; }

    public String getIsCorrect() { return isCorrect; }
    public void setIsCorrect(String isCorrect) { this.isCorrect = isCorrect; }
}
