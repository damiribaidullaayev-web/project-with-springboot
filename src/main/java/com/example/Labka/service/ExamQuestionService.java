package com.example.Labka.service;

import com.example.Labka.dto.ExamQuestionRequest;
import com.example.Labka.entity.ExamQuestion;
import com.example.Labka.entity.ExamQuestionId;
import com.example.Labka.repository.ExamQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamQuestionService {

    private final ExamQuestionRepository repository;

    public ExamQuestionService(ExamQuestionRepository repository) {
        this.repository = repository;
    }

    public List<ExamQuestion> getAll() {
        return repository.findAll();
    }

    public List<ExamQuestion> getByExamId(Long examId) {
        return repository.findByExamId(examId);
    }

    public ExamQuestion add(ExamQuestionRequest request) {
        ExamQuestion eq = new ExamQuestion(request.getExamId(), request.getQuestionId(), request.getOrderIndex());
        return repository.save(eq);
    }

    public ExamQuestion update(ExamQuestionRequest request) throws Exception {
        ExamQuestionId id = new ExamQuestionId(request.getExamId(), request.getQuestionId());
        Optional<ExamQuestion> optional = repository.findById(id);
        if(optional.isEmpty()) throw new Exception("ExamQuestion not found");
        ExamQuestion eq = optional.get();
        eq.setOrderIndex(request.getOrderIndex());
        return repository.save(eq);
    }

    public void delete(Long examId, Long questionId) {
        repository.deleteById(new ExamQuestionId(examId, questionId));
    }
}
