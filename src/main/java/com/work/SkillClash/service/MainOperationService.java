package com.work.SkillClash.service;

import com.work.SkillClash.dto.QuestionRequest;

import java.util.List;

public interface MainOperationService {
    List<QuestionRequest> generateQuestions();

    boolean checkAnsCorrect(String ans);
}
