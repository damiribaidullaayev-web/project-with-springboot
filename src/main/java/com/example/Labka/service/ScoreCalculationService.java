package com.example.Labka.service;

import com.example.Labka.dto.ExamResultRequest;
import com.example.Labka.dto.StudentAnswerRequest;
import com.example.Labka.entity.Option;
import com.example.Labka.entity.Question;
import com.example.Labka.entity.Score;
import com.example.Labka.repository.OptionRepository;
import com.example.Labka.repository.QuestionRepository;
import com.example.Labka.repository.ScoreRepository;
import org.springframework.stereotype.Service;

@Service
public class ScoreCalculationService {

    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;
    private final ScoreRepository scoreRepository;

    public ScoreCalculationService(QuestionRepository questionRepository,
                                   OptionRepository optionRepository,
                                   ScoreRepository scoreRepository) {
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
        this.scoreRepository = scoreRepository;
    }

    public Score calculateAndSaveScore(ExamResultRequest request) {
        int totalScore = 0;

        for (StudentAnswerRequest ans : request.getAnswers()) {
            Question question = questionRepository.findById(ans.getQuestionId()).orElse(null);
            if (question == null) continue;

            if (ans.getSelectedOptionId() != null) {
                Option selected = optionRepository.findById(ans.getSelectedOptionId()).orElse(null);
                if (selected != null && "Y".equals(selected.getIsCorrect())) {
                    totalScore += question.getScore() != null ? question.getScore() : 1;
                }
            }
        }

        Score score = new Score();
        score.setUserId(request.getUserId());
        score.setExamId(request.getExamId());
        score.setScore(totalScore);
        return scoreRepository.save(score);
    }
}
