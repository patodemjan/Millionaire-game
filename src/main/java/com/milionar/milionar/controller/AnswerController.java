package com.milionar.milionar.controller;

import com.milionar.milionar.model.Answer;
import com.milionar.milionar.service.AnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping
    public List<Answer> getAllAnswers() {
        return answerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable Long id) {
        return answerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Answer createAnswer(@RequestBody Answer answer) {
        return answerService.save(answer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long id) {
        answerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
