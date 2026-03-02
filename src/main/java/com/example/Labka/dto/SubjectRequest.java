package com.example.Labka.dto;

public class SubjectRequest {
    private String subjectName;
    private Long teacherId; // ID учителя

    // Геттеры и сеттеры
    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }
}
