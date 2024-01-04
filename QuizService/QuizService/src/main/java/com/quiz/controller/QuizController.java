package com.quiz.controller;

import com.quiz.entites.Quiz;
import com.quiz.services.QuizServices;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    public QuizServices quizServices;

    public QuizController(QuizServices quizServices) {
        this.quizServices = quizServices;
    }

    //create
    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        return quizServices.add(quiz);
    }
    //get All
    @GetMapping()
    public List<Quiz> get()
    {
        return quizServices.get();
    }


    @GetMapping("/{id}")
    public Quiz getOne(@PathVariable Long id){
        return quizServices.get(id);
    }









}
