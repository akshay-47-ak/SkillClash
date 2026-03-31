package com.work.SkillClash.service;

import com.work.SkillClash.dto.QuestionRequest;
import com.work.SkillClash.model.Options;
import com.work.SkillClash.model.Questions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MainOperationServiceImpl implements MainOperationService{

    List<QuestionRequest> listOfQue = new ArrayList<>();

    Map<String,String> ansMap = new HashMap<>();

    List<Options> options1 = List.of(
            new Options("A","Java Virtual Machine"),
            new Options("B","Java VISION MACHINE")
    );
    List<Options> options2 = List.of(
            new Options("A","Wrapper Class"),
            new Options("B","DataType")
    );

    List<Questions> queList = List.of(
            new Questions("q1","What is JVM",options1,"A"),
            new Questions("q2","What is Integer",options2,"B")

    );


    @Override
    public List<QuestionRequest> generateQuestions() {

        for(Questions que : queList){
            QuestionRequest req = new QuestionRequest();
            req.setId(que.getId());
            req.setQuestionText(que.getQuestionText());
            req.setOptionsList(que.getOptionsList());

            listOfQue.add(req);
        }

        return listOfQue;
    }

    @Override
    public int checkAnsCorrect(Map<String,String> ansMap) {

        int count =0;
        for(Questions que: queList){
           String ans =  ansMap.get(que.getId());
           if(que.getAnswer().equals(ans)){
               count++;
           }
        }


    /*     for( Questions que: queList){
             for(AnswerResponse ans : listAns){
                 String que1 = ans.getQId().toString();
                 String ans1 = ans.getAns().toString();
                 if(que1.equals(que.getId())){
                     if(ans1.equals(que.getAnswer())){
                         count++;
                     }
                 }
             }
         }*/

        return count;
    }
}
