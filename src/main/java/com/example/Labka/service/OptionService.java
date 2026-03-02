package com.example.Labka.service;

import com.example.Labka.dto.OptionRequest;
import com.example.Labka.entity.Option;
import com.example.Labka.repository.OptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionService {

    private final OptionRepository repository;

    public OptionService(OptionRepository repository) {
        this.repository = repository;
    }

    public List<Option> getAllOptions() {
        return repository.findAll();
    }

    public List<Option> getOptionsByQuestion(Long questionId) {
        return repository.findByQuestionId(questionId);
    }

    public Option addOption(OptionRequest request) {
        Option option = new Option(request.getQuestionId(), request.getOptionText(), request.getIsCorrect());
        return repository.save(option);
    }

    public Option updateOption(Long id, OptionRequest request) throws Exception {
        Optional<Option> optional = repository.findById(id);
        if (optional.isEmpty()) throw new Exception("Option not found");

        Option option = optional.get();
        option.setOptionText(request.getOptionText());
        option.setIsCorrect(request.getIsCorrect());
        option.setQuestionId(request.getQuestionId());

        return repository.save(option);
    }

    public void deleteOption(Long id) {
        repository.deleteById(id);
    }
}
