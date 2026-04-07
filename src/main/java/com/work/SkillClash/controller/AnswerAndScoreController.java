package com.work.SkillClash.controller;

import com.work.SkillClash.dto.AnswerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnswerAndScoreController {

    public ResponseEntity<String> sendAnswer(
            @RequestBody List<AnswerResponse> listAns
     ){

        return new ResponseEntity<>("Ans", HttpStatus.OK);
    }


}
