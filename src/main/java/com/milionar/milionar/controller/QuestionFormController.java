package com.milionar.milionar.controller;

import com.milionar.milionar.model.Question;
import com.milionar.milionar.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class QuestionFormController {

    private final QuestionService questionService;

    public QuestionFormController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // Zobraziť formulár na pridanie otázky
    @GetMapping("/add-question")
    public String showAddQuestionForm(Model model) {
        model.addAttribute("question", new Question());
        return "add-question"; // náš HTML súbor
    }

    // Spracovať odoslanie formulára
    @PostMapping("/add-question")
    public String addQuestion(@ModelAttribute Question question) {
        questionService.save(question); // uložíme otázku do databázy
        return "redirect:/"; // presmerovanie na domovskú stránku po uložení otázky
    }
}
