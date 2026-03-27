package com.work.SkillClash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionsModel {

    private String id;
    private String questionText;
    private List<Options> optionsList;
    private String answer;

}
