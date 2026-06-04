package com.work.SkillClash.service;

import com.work.SkillClash.dto.JoinRequest;
import com.work.SkillClash.dto.RoomMemberResponse;
import com.work.SkillClash.dto.RoomRequest;
import com.work.SkillClash.model.RoomMember;

import java.util.List;

public interface RoomService {
    String createRooms(RoomRequest roomRequest);

    String joinRoom(JoinRequest joinRequest);

    List<RoomMemberResponse> getRoomMembers(String roomId);
}
