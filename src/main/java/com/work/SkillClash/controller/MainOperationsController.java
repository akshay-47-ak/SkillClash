package com.work.SkillClash.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainOperationsController {

    @PostMapping("/sendQues")
    public List<Object> sendQuestions(){

        return null;
    }


}
