package com.work.SkillClash.controller;

import com.work.SkillClash.dto.StartQuizReq;
import com.work.SkillClash.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {

/*
3 Apis - StartQuiz
    Rquest -
    RoomCode
    MemberId
    */

    @Autowired
    QuizService quizService;


    @PostMapping("/startQuiz")
    public ResponseEntity<String> startQuiz(
            @RequestBody StartQuizReq startQuizReq
            ){

        String roomMemberId = startQuizReq.getRoomMemberId();

        String roomCode = startQuizReq.getRoomCode();
         if(roomMemberId == null && roomMemberId.isEmpty()){
             throw new RuntimeException("RoomMemberId Is Null");
         }
        if(roomCode == null && roomCode.isEmpty()){
            throw new RuntimeException("RoomCode  Is Null");
        }

        String startQuizRes = quizService.StartQuizService(roomCode,roomMemberId);

            return ResponseEntity.ok(startQuizRes);
    }

}
