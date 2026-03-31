package com.work.SkillClash.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String questionText;
    @OneToMany(mappedBy = "questions", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<Options> optionsList;

    //We Have To Define a Logic For Ans
    private String answer;

}
