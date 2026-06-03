package com.work.SkillClash.service;

import com.work.SkillClash.dto.JoinRequest;
import com.work.SkillClash.dto.RoomRequest;

import java.util.List;

public interface RoomService {
    String createRooms(RoomRequest roomRequest);

    String joinRoom(JoinRequest joinRequest);

    List<String> getRoomMembers(String roomId);
}
