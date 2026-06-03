package com.work.SkillClash.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomMember {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id",nullable = false,foreignKey = @ForeignKey(name = "fk_memeber_roomid"))
    @JsonIgnore
    private Room room;

    private String  username;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    private int score;

    @CreationTimestamp
    private LocalDateTime joinedAt;


}
