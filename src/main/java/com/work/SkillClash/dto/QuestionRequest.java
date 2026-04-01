package com.work.SkillClash.dto;

import com.work.SkillClash.model.Option;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionRequest {

    private String id;
    private String questionText;
    private List<Option> optionList;

}
