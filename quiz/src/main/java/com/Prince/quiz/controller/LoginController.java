package com.Prince.quiz.controller;

import com.Prince.quiz.dto.LoginRequest;
import com.Prince.quiz.entity.QuizQuestion;
import com.Prince.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    QuestionService questionService;

    // Hardcoded credentials for now
    private final String USERNAME="user";
    private final String PASSWORD="password";


    public String login(@RequestBody LoginRequest loginRequest)
    {
        if(USERNAME.equals(loginRequest.getUsername()) && PASSWORD.equals(loginRequest.getPassword()))
        {
            return "Login Successful";
        }
        else
        {
            return "Invalid Username or Password";
        }
    }

    @GetMapping("/questions")
    public List<QuizQuestion> getQuestions()
    {
        return questionService.getAllQuestions();
    }

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public QuizQuestion saveQuestion(@RequestBody QuizQuestion question)
    {
        return questionService.saveQuestion(question);
    }
}
