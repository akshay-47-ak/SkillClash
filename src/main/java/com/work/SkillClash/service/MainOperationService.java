package com.work.SkillClash.service;

import com.work.SkillClash.dto.AnswerResponse;
import com.work.SkillClash.dto.QuestionRequest;
import com.work.SkillClash.dto.QuestionResponse;

import java.util.List;
import java.util.Map;

public interface MainOperationService {

    boolean generateQuestion(List<QuestionResponse> queResponse);

    int checkAnsCorrect(Map<String, String> ansMap);

}
