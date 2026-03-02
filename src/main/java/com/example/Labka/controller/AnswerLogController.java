package com.example.Labka.controller;

import com.example.Labka.entity.AnswerLog;
import com.example.Labka.service.AnswerLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answer-log")
@CrossOrigin
public class AnswerLogController {

    private final AnswerLogService answerLogService;

    public AnswerLogController(AnswerLogService answerLogService) {
        this.answerLogService = answerLogService;
    }

    @GetMapping
    public List<AnswerLog> getAll() {
        return answerLogService.getAll();
    }

    @PostMapping
    public AnswerLog create(@RequestBody AnswerLog log) {
        return answerLogService.save(log);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        answerLogService.delete(id);
    }
}
