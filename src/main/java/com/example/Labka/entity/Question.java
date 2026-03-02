package com.example.Labka.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "QUESTION")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_ID")
    private Long questionId;

    @Column(name = "SUBJECT_ID", nullable = false)
    private Long subjectId;

    @Column(name = "QUESTION_TEXT", nullable = false)
    private String questionText;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DIFFICULTY")
    private String difficulty;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "CORRECT_ANSWER")
    private String correctAnswer;

    @Column(name = "SCORE")
    private Integer score;

    public Question() {}

    public Question(Long subjectId, String questionText, String type, String difficulty, String imageUrl) {
        this.subjectId = subjectId;
        this.questionText = questionText;
        this.type = type;
        this.difficulty = difficulty;
        this.imageUrl = imageUrl;
    }

    // Геттеры и сеттеры
    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }

    public Long getSubjectId() { return subjectId; }
    public void setSubjectId(Long subjectId) { this.subjectId = subjectId; }

    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    // Внутри класса Question

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


}
