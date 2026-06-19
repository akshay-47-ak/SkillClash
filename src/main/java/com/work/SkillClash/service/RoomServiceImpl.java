package com.work.SkillClash.service;

import com.work.SkillClash.dto.JoinRequest;
import com.work.SkillClash.dto.RoomMemberResponse;
import com.work.SkillClash.dto.RoomRequest;
import com.work.SkillClash.model.*;
import com.work.SkillClash.repository.AuthRepository;
import com.work.SkillClash.repository.RoomMemberRepository;
import com.work.SkillClash.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

  private final RoomRepository roomRepository;
  private final RoomMemberRepository roomMemberRepository;
  private final RoomCodeGenerator roomCodeGenerator;
  private final AuthRepository authRepository;
 private final RoomNotificationService roomNotificationService;
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
            throw new RuntimeException("User Not Found with UserName: " + roomRequest.getUsername());
        }
        User user = authRepository.findUserByUsername(roomRequest.getUsername());

        if(user.getStatus()==UserStatus.INACTIVE){
            throw new RuntimeException("User Not Activated Please Active " +
                    "The User With Username!!" +roomRequest.getUsername());
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


        return room.getRoomCode();
    }

    @Override
    public String joinRoom(JoinRequest joinRequest) {

      Room room = roomRepository.findRoomByRoomCode(joinRequest.getRoomCode());

            if(room == null){
                throw  new RuntimeException("Room Does not Exist by RoomCode :" + joinRequest.getRoomCode());
            }

           if(room.getStatus() != RoomStatus.WATTING){
               throw new RuntimeException("Room is Alredy Started With RoomCode :" +joinRequest.getRoomCode());
           }

           boolean exist = roomMemberRepository.existsByRoomIdAndUsername(
                   joinRequest.getRoomCode(),joinRequest.getUserName());

           if(exist){
               throw new RuntimeException("Room Member Already Joined With UserName :"+joinRequest.getUserName());
           }

        RoomMember member = RoomMember.builder()
                .username(joinRequest.getUserName())
                .role(MemberRole.PLAYER)
                .score(0)
                .room(room)
                .build();

        roomMemberRepository.save(member);

        List<RoomMemberResponse> members =
                getRoomMembers(room.getId());

        roomNotificationService.memberJoined(
                room.getRoomCode(),
                joinRequest.getUserName() + " joined room",
                members
        );

        return room.getRoomCode();
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
