package com.example.Labka.dto;

public class OptionRequest {
    private Long questionId;
    private String optionText;
    private String isCorrect; // 'Y' или 'N'

    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }

    public String getOptionText() { return optionText; }
    public void setOptionText(String optionText) { this.optionText = optionText; }

    public String getIsCorrect() { return isCorrect; }
    public void setIsCorrect(String isCorrect) { this.isCorrect = isCorrect; }
}
