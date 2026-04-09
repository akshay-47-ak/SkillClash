package com.work.SkillClash.service;

import com.work.SkillClash.dto.RoomRequest;
import com.work.SkillClash.model.MemberRole;
import com.work.SkillClash.model.Room;
import com.work.SkillClash.model.RoomMember;
import com.work.SkillClash.model.RoomStatus;

import java.util.List;

public class RoomServiceImpl implements RoomService {



    @Override
    public String createRooms(RoomRequest roomRequest) {

        Room room = Room.builder()
                .status(RoomStatus.LIVE)
                .build();

              roomRepository.save(room);


              RoomMember roomMember = RoomMember.builder()
                      .score(0)
                      .role(MemberRole.HOST)
                      .username(roomRequest.getUsername())
                      .room(room)
                      .build();

              roomMemberRepository.save(roomMember);


        room.setHost(roomMember.getId());
        roomRepository.save(room);


        return room.getId();
    }
}
