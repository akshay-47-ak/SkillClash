package com.work.SkillClash.service;

import com.work.SkillClash.dto.AnswerResponse;
import com.work.SkillClash.dto.QuestionRequest;

import java.util.List;
import java.util.Map;

public interface MainOperationService {
    List<QuestionRequest> generateQuestions();

    int checkAnsCorrect(Map<String,String> ansMap);
}
