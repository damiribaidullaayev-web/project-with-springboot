package com.example.Labka.service;

import com.example.Labka.entity.AnswerLog;
import com.example.Labka.repository.AnswerLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerLogService {

    private final AnswerLogRepository answerLogRepository;

    public AnswerLogService(AnswerLogRepository answerLogRepository) {
        this.answerLogRepository = answerLogRepository;
    }

    public AnswerLog save(AnswerLog log) {
        return answerLogRepository.save(log);
    }

    public List<AnswerLog> getAll() {
        return answerLogRepository.findAll();
    }

    public void delete(Long id) {
        answerLogRepository.deleteById(id);
    }
}
