package com.example.Labka.service;

import com.example.Labka.dto.ExamRequest;
import com.example.Labka.dto.QuestionDto;
import com.example.Labka.dto.OptionDto;
import com.example.Labka.entity.Exam;
import com.example.Labka.entity.ExamQuestion;
import com.example.Labka.entity.Question;
import com.example.Labka.entity.Option;
import com.example.Labka.repository.ExamRepository;
import com.example.Labka.repository.ExamQuestionRepository;
import com.example.Labka.repository.QuestionRepository;
import com.example.Labka.repository.OptionRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ExamService {

    private final ExamRepository repository;
    private final ExamQuestionRepository examQuestionRepository;
    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;

    public ExamService(ExamRepository repository,
                       ExamQuestionRepository examQuestionRepository,
                       QuestionRepository questionRepository,
                       OptionRepository optionRepository) {
        this.repository = repository;
        this.examQuestionRepository = examQuestionRepository;
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
    }

    // Список всех экзаменов
    public List<Exam> getAllExams() {
        return repository.findAll();
    }

    // Экзамены по предмету
    public List<Exam> getExamsBySubject(Long subjectId) {
        return repository.findBySubjectId(subjectId);
    }

    // Добавление экзамена
    public Exam addExam(ExamRequest request) {
        Exam exam = new Exam(
                request.getSubjectId(),
                request.getTitle(),
                request.getTimeLimit(),
                request.getDescription(),
                request.getRandomization()
        );
        return repository.save(exam);
    }

    // Обновление экзамена
    public Exam updateExam(Long id, ExamRequest request) throws Exception {
        Exam exam = repository.findById(id).orElseThrow(() -> new Exception("Exam not found"));
        exam.setTitle(request.getTitle());
        exam.setTimeLimit(request.getTimeLimit());
        exam.setDescription(request.getDescription());
        exam.setRandomization(request.getRandomization());
        exam.setSubjectId(request.getSubjectId());
        return repository.save(exam);
    }

    // Удаление экзамена
    public void deleteExam(Long id) {
        repository.deleteById(id);
    }

    // Получение вопросов для student.html
    public List<QuestionDto> getExamQuestions(Long examId) {
        List<ExamQuestion> examQuestions = examQuestionRepository.findByExamId(examId);
        List<QuestionDto> result = new ArrayList<>();
        for (ExamQuestion eq : examQuestions) {
            Question question = questionRepository.findById(eq.getQuestionId()).orElse(null);
            if (question == null) continue;

            List<Option> options = optionRepository.findByQuestionId(question.getQuestionId());
            List<OptionDto> optionDtos = new ArrayList<>();
            for (Option o : options) {
                optionDtos.add(new OptionDto(o.getOptionId(), o.getOptionText()));
            }

            QuestionDto qDto = new QuestionDto(question.getQuestionId(), question.getQuestionText(), optionDtos);
            result.add(qDto);
        }
        return result;
    }
}
