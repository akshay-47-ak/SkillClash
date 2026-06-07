package com.work.SkillClash.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomEvent {

    private String event;

    private String message;

    private List<RoomMemberResponse> members;
}
