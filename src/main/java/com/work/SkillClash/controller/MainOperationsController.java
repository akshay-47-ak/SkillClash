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
    public ResponseEntity<Integer> sendAns(@RequestBody List<AnswerResponse> answerResponse){



        int isCorrect = mainOperationService.checkAnsCorrect(answerResponse);
        if(isCorrect>0){
            return new ResponseEntity(isCorrect,HttpStatus.OK);
        }

        return new ResponseEntity(0,HttpStatus.OK);
    }

}
