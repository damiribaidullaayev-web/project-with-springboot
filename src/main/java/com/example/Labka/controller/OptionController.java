package com.example.Labka.controller;

import com.example.Labka.dto.OptionRequest;
import com.example.Labka.entity.Option;
import com.example.Labka.service.OptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/options")
public class OptionController {

    private final OptionService service;

    public OptionController(OptionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Option> getAllOptions() {
        return service.getAllOptions();
    }

    @GetMapping("/question/{questionId}")
    public List<Option> getOptionsByQuestion(@PathVariable Long questionId) {
        return service.getOptionsByQuestion(questionId);
    }

    @PostMapping
    public ResponseEntity<?> addOption(@RequestBody OptionRequest request) {
        try {
            Option saved = service.addOption(request);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOption(@PathVariable Long id, @RequestBody OptionRequest request) {
        try {
            Option updated = service.updateOption(id, request);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOption(@PathVariable Long id) {
        try {
            service.deleteOption(id);
            return ResponseEntity.ok("Deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
