package com.work.SkillClash.repository;

import com.work.SkillClash.model.RoomMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomMemberRepository extends JpaRepository<RoomMember,String> {
}
