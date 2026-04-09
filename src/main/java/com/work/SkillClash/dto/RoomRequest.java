package com.work.SkillClash.dto;

import com.work.SkillClash.model.RoomMember;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomRequest {

  private String username;

}
