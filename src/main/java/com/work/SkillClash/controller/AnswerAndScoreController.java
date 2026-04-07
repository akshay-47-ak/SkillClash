package com.work.SkillClash.controller;

import com.work.SkillClash.dto.AnswerResponse;
import com.work.SkillClash.service.AnswerAndScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnswerAndScoreController {

    @Autowired
    AnswerAndScoreService answerAndScoreService;

    public ResponseEntity<String> sendAnswer(
            @RequestBody List<AnswerResponse> listAns
     ){
        Map<String,String> ansMap = new HashMap<>();

        for(AnswerResponse ar : listAns){
           ansMap.put(ar.getQId(),ar.getAns());
        }


        String score = answerAndScoreService.getCalculateScore(ansMap);

        return new ResponseEntity<>("Ans", HttpStatus.OK);
    }


}
