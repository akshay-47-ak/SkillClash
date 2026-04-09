package com.work.SkillClash.service;


import com.work.SkillClash.model.Question;
import com.work.SkillClash.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AnswerAndScoreServiceImpl implements AnswerAndScoreService{

    @Autowired
    QuestionsRepository questionsRepository;

    @Override
    public String getCalculateScore(Map<String, String> ansMap) {

        List<Question> listofQue = questionsRepository.findAll();
            int score= 0;
        for(Question que: listofQue){
            if(ansMap.get(que.getId()).equals(que.getAnswer()) ){
                score++;
            }
        }
        return String.valueOf(score);
    }
}
