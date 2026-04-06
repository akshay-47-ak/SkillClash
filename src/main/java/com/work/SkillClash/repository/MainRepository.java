package com.work.SkillClash.repository;

import com.work.SkillClash.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends JpaRepository<Question,String> {

}
