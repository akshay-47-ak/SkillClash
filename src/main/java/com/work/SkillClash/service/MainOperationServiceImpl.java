package com.work.SkillClash.service;

import com.work.SkillClash.model.Options;
import com.work.SkillClash.model.QuestionsModel;

import java.util.ArrayList;
import java.util.List;

public class MainOperationServiceImpl implements MainOperationService{

    Options options1 = Options.builder()
            .option1("java virtual machine")
            .option2("java Vision Machine")
            .build();

    QuestionsModel questionsModel =  QuestionsModel.builder()
            .id("q1")
            .questionText("What is JVM")
            .optionsList((List<Options>) options1)
            .build();

    @Override
    public List<QuestionsModel> generateQuestions() {
        List<QuestionsModel> listOfQue = new ArrayList<>();

        listOfQue.add(questionsModel);

        return listOfQue;
    }
}
