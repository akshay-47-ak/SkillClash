package com.work.SkillClash.service;

import com.work.SkillClash.dto.QuestionResponse;
import com.work.SkillClash.model.Option;
import com.work.SkillClash.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
               List<Option> options = new ArrayList<>();

               for(Option op : q.getOptionList()){
                   Option option = Option.builder()
                           .option_key(op.getOption_key())
                           .optionText(op.getOptionText())
                           .question(question)
                           .build();
               }

            }



        }

        return false;
    }
}
