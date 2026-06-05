package com.work.SkillClash.repository;

import com.work.SkillClash.model.RoomMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomMemberRepository extends JpaRepository<RoomMember,String> {
    RoomMember findByUsername(String userName);
    boolean existsByRoomIdAndUsername(String roomId ,String userName);

    List<RoomMember> findByRoomId(String roomId);
}
