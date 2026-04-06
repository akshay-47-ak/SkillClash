package com.work.SkillClash.controller;

import com.work.SkillClash.dto.QuestionRequest;
import com.work.SkillClash.dto.QuestionResponse;
import com.work.SkillClash.service.QuestionsOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class QuestionsOperationController {

    @Autowired
    QuestionsOperationService questionsOperationService;

    @PostMapping("/generateQuestion")
    public ResponseEntity<List<QuestionResponse>> generateQuestions(
            @RequestBody List<QuestionRequest> queRequest
    ){

   List<QuestionResponse> questionList = questionsOperationService.generateQuestion(queRequest);

        return new ResponseEntity<>(questionList,HttpStatus.OK);
    }

    @GetMapping("/getQue")
    public ResponseEntity<List<QuestionResponse>> getQuestions(){
        List<QuestionResponse> listQue = questionsOperationService.getQuestions();
        return new ResponseEntity<>(listQue,HttpStatus.OK);
    }

/*    @PostMapping("/sendAns")
    public ResponseEntity<Integer> sendAns(@RequestBody List<AnswerResponse> answerResponse){
        Map<String,String> ansMap = new HashMap<>();
        for (AnswerResponse ansRes: answerResponse){
                   ansMap.put(ansRes.getQId(),ansRes.getAns());
        }


        int isCorrect = questionsOperationService.checkAnsCorrect(ansMap);
        if(isCorrect>0){
            return new ResponseEntity(isCorrect,HttpStatus.OK);
        }

        return new ResponseEntity(0,HttpStatus.OK);
    }*/

}
