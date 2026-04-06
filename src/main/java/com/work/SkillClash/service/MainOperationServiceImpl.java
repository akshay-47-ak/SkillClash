package com.work.SkillClash.service;

import com.work.SkillClash.dto.QuestionResponse;
import com.work.SkillClash.model.Option;
import com.work.SkillClash.model.Question;
import com.work.SkillClash.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MainOperationServiceImpl implements MainOperationService{

    @Autowired
    MainRepository mainRepository;

    @Override
    public List<QuestionResponse> generateQuestion(List<QuestionResponse> queResponse) {

        List<QuestionResponse> listResp = new ArrayList<>();

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
          Question savedQues = mainRepository.save(question);

          QuestionResponse queResp = mapToResponse(savedQues);

          listResp.add(queResp);
        }

        return listResp;
    }

    private QuestionResponse mapToResponse(Question savedQues) {

        QuestionResponse questionResponse =QuestionResponse.builder()
                .id(savedQues.getId())
                .questionText(savedQues.getQuestionText())
                .optionList(savedQues.getOptionList())
                .answer(savedQues.getAnswer())
                .build();

        return questionResponse;
    }


    @Override
    public int checkAnsCorrect(Map<String, String> ansMap) {
        return 0;
    }

}
