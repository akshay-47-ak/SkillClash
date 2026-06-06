package com.work.SkillClash.service;

import com.work.SkillClash.dto.JoinRequest;
import com.work.SkillClash.dto.RoomMemberResponse;
import com.work.SkillClash.dto.RoomRequest;
import com.work.SkillClash.model.*;
import com.work.SkillClash.repository.AuthRepository;
import com.work.SkillClash.repository.RoomMemberRepository;
import com.work.SkillClash.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

  private final RoomRepository roomRepository;
  private final RoomMemberRepository roomMemberRepository;
  private final RoomCodeGenerator roomCodeGenerator;
  private final AuthRepository authRepository;

    @Override
    public String createRooms(RoomRequest roomRequest) {

        int temp = roomRepository.findAll().size()+1;
        String roomCode= String.format("RC%08d",temp);


        Room room = Room.builder()
                .roomCode(roomCodeGenerator.generateRoomCode())
                .status(RoomStatus.LIVE)
                .build();

        room = roomRepository.save(room);

        boolean userExist = authRepository.existsByUsername(roomRequest.getUsername());

        if(!userExist){
            throw new RuntimeException("User Not Found");
        }
        User user = authRepository.findUserByUsername(roomRequest.getUsername());

        if(user.getStatus()==UserStatus.DEACTIVE){
            throw new RuntimeException("User Not Activated Please Active The User!!");
        }

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
                   joinRequest.getRoomCode(),joinRequest.getUserName());

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

    @Override
    public List<RoomMemberResponse> getRoomMembers(String roomId) {

       List<RoomMember> listOfMembers = roomMemberRepository.findByRoomId(roomId);

       if(listOfMembers.isEmpty()){
           throw new RuntimeException("No Room Members Joined Yet.");
       }
       List<RoomMemberResponse> resultList = new ArrayList<>();

        for(RoomMember rm : listOfMembers){
            RoomMemberResponse rms = RoomMemberResponse.builder()
                    .id(rm.getId())
                    .username(rm.getUsername())
                    .role(rm.getRole())
                    .score(rm.getScore())
                    .build();
            resultList.add(rms);
        }

        return resultList;
    }
}
