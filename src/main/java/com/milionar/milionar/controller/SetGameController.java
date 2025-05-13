package com.milionar.milionar.controller;


import com.milionar.milionar.dto.QuestionFormDTO;
import com.milionar.milionar.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/setgame")
public class SetGameController {

    private final QuestionService questionService;

    public SetGameController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("questionForm", new QuestionFormDTO());
        return "setgame";
    }

    @PostMapping
    public String saveQuestion(@ModelAttribute("questionForm") QuestionFormDTO dto, Model model) {
        questionService.saveQuestionFromForm(dto);
        model.addAttribute("success", true);
        model.addAttribute("questionForm", new QuestionFormDTO());
        return "setgame";
    }
}

