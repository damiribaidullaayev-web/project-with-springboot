package com.example.Labka.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SUBJECTS")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBJECT_ID")
    private Long subjectId;

    @Column(name = "SUBJECT_NAME", nullable = false, unique = true)
    private String subjectName;

    @Column(name = "TEACHER_ID")
    private Long teacherId; // привязка к USERS.USER_ID

    public Subject() {}

    public Subject(String subjectName, Long teacherId) {
        this.subjectName = subjectName;
        this.teacherId = teacherId;
    }

    public Long getSubjectId() { return subjectId; }
    public void setSubjectId(Long subjectId) { this.subjectId = subjectId; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }
}
