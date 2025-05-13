package com.milionar.milionar.service;

import com.milionar.milionar.dto.QuestionFormDTO;
import com.milionar.milionar.model.Question;
import com.milionar.milionar.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final Random random = new Random();

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Optional<Question> getRandomQuestion(String language) {
        List<Question> questions = questionRepository.findByLanguage(language);
        if (questions.isEmpty()) return Optional.empty();
        return Optional.of(questions.get(random.nextInt(questions.size())));
    }

    public Question saveQuestionFromForm(QuestionFormDTO dto) {
        Question question = new Question();
        question.setText(dto.getText());
        question.setOptionA(dto.getOptionA());
        question.setOptionB(dto.getOptionB());
        question.setOptionC(dto.getOptionC());
        question.setOptionD(dto.getOptionD());
        question.setCorrectOption(dto.getCorrectOption());
        question.setLanguage(dto.getLanguage());

        return questionRepository.save(question);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public void delete(Long id) {
        questionRepository.deleteById(id);
    }
}
