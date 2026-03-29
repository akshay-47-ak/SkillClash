package com.work.SkillClash.service;

import com.work.SkillClash.dto.QuestionResponse;
import com.work.SkillClash.model.QuestionsModel;

import java.util.List;

public interface MainOperationService {
    List<QuestionResponse> generateQuestions();

    boolean checkAnsCorrect(String qId, String ans);
}
