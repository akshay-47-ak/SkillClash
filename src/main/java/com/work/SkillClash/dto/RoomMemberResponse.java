package com.work.SkillClash.dto;
import com.work.SkillClash.model.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomMemberResponse {
    private String id;
    private String  username;
    private MemberRole role;
    private int score;

}
