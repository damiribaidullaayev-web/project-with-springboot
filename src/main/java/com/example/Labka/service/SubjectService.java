package com.example.Labka.service;

import com.example.Labka.entity.Subject;
import com.example.Labka.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository repository;

    public SubjectService(SubjectRepository repository) {
        this.repository = repository;
    }

    public List<Subject> getAllSubjects() {
        return repository.findAll();
    }

    public Subject addSubject(Subject subject) {
        return repository.save(subject);
    }

    public void deleteSubject(Long id) {
        repository.deleteById(id);
    }

    public Subject updateSubject(Long id, String newName, Long teacherId) throws Exception {
        Optional<Subject> optional = repository.findById(id);
        if (optional.isEmpty()) throw new Exception("Subject not found");
        Subject subject = optional.get();
        subject.setSubjectName(newName);
        if (teacherId != null) subject.setTeacherId(teacherId);
        return repository.save(subject);
    }
}
