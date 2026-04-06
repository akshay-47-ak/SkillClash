package com.work.SkillClash.service;

import com.work.SkillClash.dto.QuestionRequest;
import com.work.SkillClash.dto.QuestionResponse;

import java.util.List;

public interface QuestionsOperationService {

    public List<QuestionResponse> generateQuestion(List<QuestionRequest> queResponse);

    public List<QuestionResponse> getQuestions();

}
