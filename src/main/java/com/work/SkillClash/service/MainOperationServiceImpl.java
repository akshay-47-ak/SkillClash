package com.work.SkillClash.service;

import com.work.SkillClash.dto.QuestionRequest;
import com.work.SkillClash.model.Options;
import com.work.SkillClash.model.QuestionsModel;
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


    QuestionsModel questionsModel = QuestionsModel.builder()
            .id("q1")
            .questionText("What is JVM")
            .optionsList(options1)
            .answer("A")
            .build();
    QuestionsModel questionsModel1 = QuestionsModel.builder()
            .id("q2")
            .questionText("What is Integer")
            .optionsList(options2)
            .answer("A")
            .build();



    @Override
    public List<QuestionRequest> generateQuestions() {


        QuestionRequest queRes = QuestionRequest.builder()
                .id(questionsModel.getId())
                .questionText(questionsModel.getQuestionText())
                .optionsList(questionsModel.getOptionsList())
                .build();

        QuestionRequest queRes1 = QuestionRequest.builder()
                .id(questionsModel1.getId())
                .questionText(questionsModel1.getQuestionText())
                .optionsList(questionsModel1.getOptionsList())
                .build();


        listOfQue.add(queRes);

        return listOfQue;
    }

    @Override
    public boolean checkAnsCorrect(String qId,String ans) {
        ansMap.put(questionsModel.getId(),questionsModel.getAnswer());
        ansMap.put(questionsModel1.getId(),questionsModel1.getAnswer());
           String Correctans = ansMap.get(qId);
           if(ans.equals(Correctans)){
               return true;
           }
        return false;
    }
}
