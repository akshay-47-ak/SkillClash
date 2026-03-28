package com.work.SkillClash.controller;

import com.work.SkillClash.model.QuestionsModel;
import com.work.SkillClash.service.MainOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainOperationsController {

    @Autowired
    MainOperationService mainOperationService;

    @GetMapping("/getQue")
    public ResponseEntity<List<QuestionsModel>> getQuestions(){
       List<QuestionsModel> listQue = mainOperationService.generateQuestions();
        return new ResponseEntity<>(listQue,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> sendAns(@RequestBody String qId,String ans){

        boolean isCorrect = mainOperationService.checkAnsCorrect(qId,ans);

        return new ResponseEntity("Correct",HttpStatus.OK);
    }

}
