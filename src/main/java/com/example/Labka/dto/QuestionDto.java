package com.example.Labka.dto;

import java.util.List;

public class QuestionDto {
    private Long questionId;
    private String questionText;
    private List<OptionDto> options;

    public QuestionDto() {}

    public QuestionDto(Long questionId, String questionText, List<OptionDto> options) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.options = options;
    }

    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }

    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }

    public List<OptionDto> getOptions() { return options; }
    public void setOptions(List<OptionDto> options) { this.options = options; }
}
