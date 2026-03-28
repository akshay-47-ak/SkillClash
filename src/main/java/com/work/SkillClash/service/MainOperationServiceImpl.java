package com.work.SkillClash.service;

import com.work.SkillClash.model.Options;
import com.work.SkillClash.model.QuestionsModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainOperationServiceImpl implements MainOperationService{


    List<Options> options1 = List.of(
            new Options("A","Java Virtual Machine"),
            new Options("B","Java VISION MACHINE")
    );


    QuestionsModel questionsModel = QuestionsModel.builder()
            .id("q1")
            .questionText("What is JVM")
            .optionsList(options1)
            .build();

    @Override
    public List<QuestionsModel> generateQuestions() {
        List<QuestionsModel> listOfQue = new ArrayList<>();

        listOfQue.add(questionsModel);

        return listOfQue;
    }

    @Override
    public boolean checkAnsCorrect(String qId, String ans) {
        return false;
    }
}
