package com.work.SkillClash.controller;

import com.work.SkillClash.dto.AnswerResponse;
import com.work.SkillClash.dto.QuestionRequest;
import com.work.SkillClash.dto.QuestionResponse;
import com.work.SkillClash.service.MainOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/main")
public class MainOperationsController {

    @Autowired
    MainOperationService mainOperationService;

    @PostMapping("/generateQuestion")
    public ResponseEntity<String> generateQuestions(
            @RequestBody List<QuestionResponse> queResponse
    ){

        boolean generated = mainOperationService.generateQuestion(queResponse);

        return new ResponseEntity<>("Question Genereated",HttpStatus.OK);
    }

    @GetMapping("/getQue")
    public ResponseEntity<List<QuestionRequest>> getQuestions(){
       List<QuestionRequest> listQue = mainOperationService.getQuestions;
        return new ResponseEntity<>(listQue,HttpStatus.OK);
    }

    @PostMapping("/sendAns")
    public ResponseEntity<Integer> sendAns(@RequestBody List<AnswerResponse> answerResponse){
        Map<String,String> ansMap = new HashMap<>();
        for (AnswerResponse ansRes: answerResponse){
                   ansMap.put(ansRes.getQId(),ansRes.getAns());
        }


        int isCorrect = mainOperationService.checkAnsCorrect(ansMap);
        if(isCorrect>0){
            return new ResponseEntity(isCorrect,HttpStatus.OK);
        }

        return new ResponseEntity(0,HttpStatus.OK);
    }

}
