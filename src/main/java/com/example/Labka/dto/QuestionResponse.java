package com.example.Labka.dto;

public class QuestionResponse {

    private Long questionId;
    private String questionText;
    private String type;
    private String difficulty;
    private String imageUrl;
    private Long subjectId;
    private String subjectName; // чтобы фронт видел название предмета

    public QuestionResponse() {}

    public QuestionResponse(Long questionId, String questionText, String type, String difficulty, String imageUrl,
                            Long subjectId, String subjectName) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.type = type;
        this.difficulty = difficulty;
        this.imageUrl = imageUrl;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    // Геттеры
    public Long getQuestionId() { return questionId; }
    public String getQuestionText() { return questionText; }
    public String getType() { return type; }
    public String getDifficulty() { return difficulty; }
    public String getImageUrl() { return imageUrl; }
    public Long getSubjectId() { return subjectId; }
    public String getSubjectName() { return subjectName; }

    // Сеттеры
    public void setQuestionId(Long questionId) { this.questionId = questionId; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }
    public void setType(String type) { this.type = type; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setSubjectId(Long subjectId) { this.subjectId = subjectId; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }
}
