package com.work.SkillClash.dto;

import com.work.SkillClash.model.Options;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionResponse {

    private String id;
    private String questionText;
    private List<Options> optionsList;

}
