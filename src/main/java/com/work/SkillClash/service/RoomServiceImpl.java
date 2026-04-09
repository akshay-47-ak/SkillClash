package com.work.SkillClash.service;

import com.work.SkillClash.dto.RoomRequest;
import com.work.SkillClash.model.MemberRole;
import com.work.SkillClash.model.Room;
import com.work.SkillClash.model.RoomMember;
import com.work.SkillClash.model.RoomStatus;
import com.work.SkillClash.repository.RoomMemberRepository;
import com.work.SkillClash.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

  private final RoomRepository roomRepository;
  private final RoomMemberRepository roomMemberRepository;

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
