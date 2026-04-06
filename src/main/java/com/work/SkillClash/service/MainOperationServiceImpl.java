package com.work.SkillClash.service;

import com.work.SkillClash.dto.QuestionResponse;
import com.work.SkillClash.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainOperationServiceImpl implements MainOperationService{


    @Override
    public boolean generateQuestion(List<QuestionResponse> queResponse) {

        for(QuestionResponse q : queResponse){

            Question question = Question.builder()
                    .questionText(q.getQuestionText())
                    .answer(q.getAnswer())
                    .build();

            if(q.getOptionList() !=null){

            }

        }

        return false;
    }
}
