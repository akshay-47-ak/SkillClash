package com.work.SkillClash.controller;

import com.work.SkillClash.model.QuestionsModel;
import com.work.SkillClash.service.MainOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainOperationsController {

    @Autowired
    MainOperationService mainOperationService;

/*
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers(){
        List<Player> list = playerService.getAllPlayers();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
*/

    @GetMapping("/getQue")
    public ResponseEntity<List<QuestionsModel>> getQuestions(){

       List<QuestionsModel> listQue = mainOperationService.generateQuestions();
        return null;
    }


}
