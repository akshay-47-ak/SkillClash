package com.work.SkillClash.service;

import com.work.SkillClash.dto.RoomRequest;
import com.work.SkillClash.model.Room;
import com.work.SkillClash.model.RoomMember;
import com.work.SkillClash.model.RoomStatus;

public class RoomServiceImpl implements RoomService {
    @Override
    public String createRooms(RoomRequest roomRequest) {

        Room room = Room.builder()
                .status(RoomStatus.LIVE)
                .build();



        return "";
    }
}
