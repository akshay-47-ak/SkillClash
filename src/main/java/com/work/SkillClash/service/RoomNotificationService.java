package com.work.SkillClash.service;

import com.work.SkillClash.dto.RoomEvent;
import com.work.SkillClash.dto.RoomMemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomNotificationService {

    private final SimpMessagingTemplate messagingTemplate;

    public void memberJoined(
            String roomCode,
            String message,
            List<RoomMemberResponse> members) {

        RoomEvent event = RoomEvent.builder()
                .event("MEMBER_JOINED")
                .message(message)
                .members(members)
                .build();

        messagingTemplate.convertAndSend(
                "/topic/room/" + roomCode,
                event
        );
    }
}
