package com.example.Labka.dto;

public class OptionDto {
    private Long optionId;
    private String text;

    public OptionDto() {}

    public OptionDto(Long optionId, String text) {
        this.optionId = optionId;
        this.text = text;
    }

    public Long getOptionId() { return optionId; }
    public void setOptionId(Long optionId) { this.optionId = optionId; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}
