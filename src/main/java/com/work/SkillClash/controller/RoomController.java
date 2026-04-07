package com.work.SkillClash.controller;

import com.work.SkillClash.dto.RoomRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {

    public ResponseEntity<String> createRoom(
            @RequestBody RoomRequest roomRequest
            ){

               }

}
