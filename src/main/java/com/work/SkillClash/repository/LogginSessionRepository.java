package com.work.SkillClash.repository;

import com.work.SkillClash.model.LoginSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogginSessionRepository extends JpaRepository<LoginSession,String> {
}
