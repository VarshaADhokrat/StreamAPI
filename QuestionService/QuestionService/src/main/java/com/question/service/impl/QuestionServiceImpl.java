package com.question.service.impl;

import com.question.entites.Question;
import com.question.repositories.QuestionRepository;
import com.question.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    private QuestionRepository questionRepository;
    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepository.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepository.findById(id).orElseThrow(()->new RuntimeException("Question Not Found"));
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
