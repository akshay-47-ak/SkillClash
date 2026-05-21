package com.work.SkillClash.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;

   @OneToMany(mappedBy = "room",cascade = CascadeType.ALL,orphanRemoval = true)
   private List<RoomMember> roomMemberList;

    private String host;

}
