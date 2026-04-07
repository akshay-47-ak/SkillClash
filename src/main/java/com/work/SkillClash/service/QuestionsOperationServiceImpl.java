package com.work.SkillClash.service;

import com.work.SkillClash.dto.QuestionRequest;
import com.work.SkillClash.dto.QuestionResponse;
import com.work.SkillClash.model.Option;
import com.work.SkillClash.model.Question;
import com.work.SkillClash.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionsOperationServiceImpl implements QuestionsOperationService {

    @Autowired
    QuestionsRepository questionsRepository;

    @Override
    public List<QuestionResponse> generateQuestion(List<QuestionRequest> queResponse) {

        List<QuestionResponse> listResp = new ArrayList<>();

        for(QuestionRequest q : queResponse){

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

                   options.add(option);
               }

               question.setOptionList(options);
            }
          Question savedQues = questionsRepository.save(question);

          QuestionResponse queResp = mapToResponse(savedQues);

          listResp.add(queResp);
        }

        return listResp;
    }

    @Override
    public List<QuestionResponse> getQuestions() {

        List<Question> listQues = questionsRepository.findAll();

        List<QuestionResponse> listResp = new ArrayList<>();

        for (Question que: listQues){
            QuestionResponse questionResponse = QuestionResponse.builder()
                    .id(que.getId())
                    .questionText(que.getQuestionText())
                    .optionList(que.getOptionList())
                    .build();

            listResp.add(questionResponse);
        }

        return listResp;
    }

    private QuestionResponse mapToResponse(Question savedQues) {

        QuestionResponse questionResponse =QuestionResponse.builder()
                .id(savedQues.getId())
                .questionText(savedQues.getQuestionText())
                .optionList(savedQues.getOptionList())
                .build();

        return questionResponse;
    }



}
