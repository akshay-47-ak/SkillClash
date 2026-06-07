package com.work.SkillClash.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class LoginSession {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String sessionId;

    private String userCode;

    private String username;

    private UserStatus status;

    @CreationTimestamp
    private LocalDateTime loggedInAt;

    @UpdateTimestamp
    private LocalDateTime loggedOutAt;

}
