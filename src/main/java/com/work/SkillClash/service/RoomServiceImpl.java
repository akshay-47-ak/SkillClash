package com.work.SkillClash.service;

import com.work.SkillClash.dto.JoinRequest;
import com.work.SkillClash.dto.RoomRequest;
import com.work.SkillClash.model.MemberRole;
import com.work.SkillClash.model.Room;
import com.work.SkillClash.model.RoomMember;
import com.work.SkillClash.model.RoomStatus;
import com.work.SkillClash.repository.RoomMemberRepository;
import com.work.SkillClash.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

        room = roomRepository.save(room);


              RoomMember host = RoomMember.builder()
                      .score(0)
                      .role(MemberRole.HOST)
                      .username(roomRequest.getUsername())
                      .room(room)
                      .build();

        host = roomMemberRepository.save(host);


        room.setHost(host.getId());
          roomRepository.save(room);


        return room.getId();
    }

    @Override
    public String joinRoom(JoinRequest joinRequest) {

      Room room = roomRepository.findById(joinRequest.getRoomId())
              .orElseThrow(()-> new RuntimeException("Room Not Found"));

           if(room.getStatus() != RoomStatus.WATTING){
               throw new RuntimeException("Room is Alredy Started");
           }

           boolean exist = roomMemberRepository.existsByRoomIdAndUsername(
                   joinRequest.getRoomId(),joinRequest.getUserName());

           if(exist){
               throw new RuntimeException("Room Member Already Joined");
           }

        RoomMember member = RoomMember.builder()
                .username(joinRequest.getUserName())
                .role(MemberRole.PLAYER)
                .score(0)
                .room(room)
                .build();

        roomMemberRepository.save(member);

        return room.getId();
    }
}
