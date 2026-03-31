package com.work.SkillClash.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String opId;

    private String optionText;

    private String option_key;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questions_id",nullable = false,foreignKey = @ForeignKey(name = "fk_questions_id "))
    @JsonIgnore
    private Questions questions;

}
