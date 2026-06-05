package com.work.SkillClash.service;


import com.work.SkillClash.model.MemberRole;
import com.work.SkillClash.model.RoomMember;
import com.work.SkillClash.repository.RoomMemberRepository;
import com.work.SkillClash.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

   private final RoomRepository roomRepository;
   private final RoomMemberRepository roomMemberRepository;

    @Override
    public String StartQuizService(String roomCode , String memberId) {

         boolean isRoomExist = roomRepository.existsByRoomCode(roomCode);

         if(!isRoomExist){
             throw new RuntimeException("Room Dose Not Exists");
         }
        RoomMember roomMember = roomMemberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Room member not found"));

         if(roomMember.getRole() != MemberRole.HOST){
             throw new RuntimeException("Only HOST Can Start The Quiz");
         }

        return "Quiz Started";
    }
}
