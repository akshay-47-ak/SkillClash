package com.work.SkillClash.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuestionsModel {

    private String id;
    private String questionText;
    private List<Options> optionsList;

    //We Have To Define a Logic For Ans
    private String answer;

}
