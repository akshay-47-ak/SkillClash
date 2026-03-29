package com.work.SkillClash.service;

import com.work.SkillClash.dto.QuestionRequest;
import com.work.SkillClash.model.Options;
import com.work.SkillClash.model.QuestionsModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainOperationServiceImpl implements MainOperationService{

    List<QuestionRequest> listOfQue = new ArrayList<>();
    List<Options> options1 = List.of(
            new Options("A","Java Virtual Machine"),
            new Options("B","Java VISION MACHINE")
    );


    QuestionsModel questionsModel = QuestionsModel.builder()
            .id("q1")
            .questionText("What is JVM")
            .optionsList(options1)
            .answer("A")
            .build();

    @Override
    public List<QuestionRequest> generateQuestions() {


        QuestionRequest queRes = QuestionRequest.builder()
                .id(questionsModel.getId())
                .questionText(questionsModel.getQuestionText())
                .optionsList(questionsModel.getOptionsList())
                .build();

        listOfQue.add(queRes);

        return listOfQue;
    }

    @Override
    public boolean checkAnsCorrect(String ans) {
           String Correctans = questionsModel.getAnswer();
           if(ans.equals(Correctans)){
               return true;
           }
        return false;
    }
}
