package com.work.SkillClash.controller;

import com.work.SkillClash.dto.JoinRequest;
import com.work.SkillClash.dto.RoomMemberResponse;
import com.work.SkillClash.dto.RoomRequest;
import com.work.SkillClash.model.RoomMember;
import com.work.SkillClash.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping("/create")
    public ResponseEntity<String> createRoom(
            @RequestBody RoomRequest roomRequest
            ){

            String roomId = roomService.createRooms(roomRequest);

            return new ResponseEntity<>(roomId, HttpStatus.OK);
    }

    @PostMapping("/join")
    public ResponseEntity<String> joinRoom(
            @RequestBody JoinRequest joinRequest
            ){

        String status = roomService.joinRoom(joinRequest);

        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @GetMapping("/{roomId}/members")
    public ResponseEntity<List<RoomMemberResponse>> getListOfRoomMember(
            @PathVariable String roomId) {

        List<RoomMemberResponse> listOfRoomMembers = roomService.getRoomMembers(roomId);

        return  ResponseEntity.ok(listOfRoomMembers);
    }
}
