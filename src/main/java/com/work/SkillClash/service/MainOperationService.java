package com.work.SkillClash.service;

import com.work.SkillClash.model.QuestionsModel;

import java.util.List;

public interface MainOperationService {
    List<QuestionsModel> generateQuestions();

    boolean checkAnsCorrect(String qId, String ans);
}
