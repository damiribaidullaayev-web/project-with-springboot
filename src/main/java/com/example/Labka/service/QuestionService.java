package com.example.Labka.service;

import com.example.Labka.dto.QuestionRequest;
import com.example.Labka.dto.QuestionResponse;
import com.example.Labka.entity.Question;
import com.example.Labka.repository.QuestionRepository;
import com.example.Labka.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import com.example.Labka.entity.Subject;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository repository;
    private final SubjectRepository subjectRepository;

    public QuestionService(QuestionRepository repository, SubjectRepository subjectRepository) {
        this.repository = repository;
        this.subjectRepository = subjectRepository;
    }


    // Получение всех вопросов с именем предмета
    public List<QuestionResponse> getAllQuestions() {
        return repository.findAll().stream().map(q -> {
            Subject subject = subjectRepository.findById(q.getSubjectId()).orElse(null);
            String subjectName = subject != null ? subject.getSubjectName() : "Unknown";
            return new QuestionResponse(
                    q.getQuestionId(),
                    q.getQuestionText(),
                    q.getType(),
                    q.getDifficulty(),
                    q.getImageUrl(),
                    q.getSubjectId(),
                    subjectName
            );
        }).toList();
    }


    // Добавление нового вопроса
    public Question addQuestion(QuestionRequest request) throws Exception {
        // Проверка что такой предмет существует
        if (subjectRepository.findById(request.getSubjectId()).isEmpty()) {
            throw new Exception("Subject not found");
        }

        Question q = new Question(
                request.getSubjectId(),
                request.getQuestionText(),
                request.getType(),
                request.getDifficulty(),
                request.getImageUrl()
        );
        return repository.save(q);
    }

    // Удаление вопроса
    public void deleteQuestion(Long id) {
        repository.deleteById(id);
    }

    // Обновление вопроса
    public Question updateQuestion(Long id, QuestionRequest request) throws Exception {
        Optional<Question> optional = repository.findById(id);
        if (optional.isEmpty()) throw new Exception("Question not found");
        Question q = optional.get();

        // Проверка предмета
        if (subjectRepository.findById(request.getSubjectId()).isEmpty()) {
            throw new Exception("Subject not found");
        }

        q.setQuestionText(request.getQuestionText());
        q.setType(request.getType());
        q.setDifficulty(request.getDifficulty());
        q.setImageUrl(request.getImageUrl());
        q.setSubjectId(request.getSubjectId());

        return repository.save(q);
    }
}
