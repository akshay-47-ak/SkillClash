package com.work.SkillClash.service;

import com.work.SkillClash.dto.RoomRequest;
import com.work.SkillClash.model.MemberRole;
import com.work.SkillClash.model.Room;
import com.work.SkillClash.model.RoomStatus;

import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService {



    @Override
    public String createRooms(RoomRequest roomRequest) {

        Room room = Room.builder()
                .status(RoomStatus.LIVE)
                .build();

        RoomMember rm = roomRequest.getRoomMemberList().get(0);
              RoomMember roomMember = RoomMember.builder()
                      .score(rm.getScore())
                      .role(MemberRole.HOST)
                      .username(rm.getUsername())
                      .room(room)
                      .build();


        room.setHost(roomMember);
        room.setRoomMemberList(List.of(roomMember));

       Room saveRoom = roomRepository.save(room);

        return "";
    }
}
