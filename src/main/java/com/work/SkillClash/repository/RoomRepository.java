package com.work.SkillClash.repository;

import com.work.SkillClash.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,String> {
    boolean  existsByRoomCode(String roomCode);
}
