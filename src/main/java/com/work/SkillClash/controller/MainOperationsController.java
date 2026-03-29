package com.work.SkillClash.controller;

import com.work.SkillClash.dto.AnswerResponse;
import com.work.SkillClash.dto.QuestionRequest;
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
    public ResponseEntity<List<QuestionRequest>> getQuestions(){
       List<QuestionRequest> listQue = mainOperationService.generateQuestions();
        return new ResponseEntity<>(listQue,HttpStatus.OK);
    }

    @PostMapping("/sendAns")
    public ResponseEntity<String> sendAns(@RequestBody AnswerResponse answerResponse){

              String ans = answerResponse.getAns();

        boolean isCorrect = mainOperationService.checkAnsCorrect(ans);
        if(isCorrect){
            return new ResponseEntity("Correct",HttpStatus.OK);
        }

        return new ResponseEntity("Wrong",HttpStatus.NOT_FOUND);
    }

}
