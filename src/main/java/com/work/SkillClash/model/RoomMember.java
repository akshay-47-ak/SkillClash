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
    @JoinColumn(name = "member_id",nullable = false,foreignKey = @ForeignKey(name = "fk_room_id"))
    @JsonIgnore
    private Room room;

    private String  username;

    @Enumerated(EnumType.STRING)
    private String role;

    private String score;

    @CreationTimestamp
    private LocalDateTime joinedAt;


}
