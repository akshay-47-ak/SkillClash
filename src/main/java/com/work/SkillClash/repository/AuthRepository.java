package com.work.SkillClash.repository;

import com.work.SkillClash.model.Room;
import com.work.SkillClash.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User,String> {
    boolean  existsByUserCode(String roomCode);

    User findUserByUserCode(String userCode);

    User findUserByUsername(String userName);
}
