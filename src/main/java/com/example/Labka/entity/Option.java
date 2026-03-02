package com.example.Labka.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "OPTIONS")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_ID")
    private Long optionId;

    @Column(name = "QUESTION_ID", nullable = false)
    private Long questionId;

    @Column(name = "OPTION_TEXT")
    private String optionText;

    @Column(name = "IS_CORRECT", length = 1)
    private String isCorrect; // 'Y' или 'N'

    public Option() {}

    public Option(Long questionId, String optionText, String isCorrect) {
        this.questionId = questionId;
        this.optionText = optionText;
        this.isCorrect = isCorrect;
    }

    // Геттеры и сеттеры
    public Long getOptionId() { return optionId; }
    public void setOptionId(Long optionId) { this.optionId = optionId; }

    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }

    public String getOptionText() { return optionText; }
    public void setOptionText(String optionText) { this.optionText = optionText; }

    public String getIsCorrect() { return isCorrect; }
    public void setIsCorrect(String isCorrect) { this.isCorrect = isCorrect; }
}
