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
@Table(name = "options")
public class Option {
    @Id
    private String opId;

    private String optionText;

    @Column(name = "option_key", nullable = false)
    private String option_key;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id",nullable = false,foreignKey = @ForeignKey(name = "fk_question_id"))
    @JsonIgnore
    private Question question;

}
