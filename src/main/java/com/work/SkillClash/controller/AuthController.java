package com.work.SkillClash.controller;

import com.work.SkillClash.dto.UserRequest;
import com.work.SkillClash.dto.UserResponse;
import com.work.SkillClash.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

 @PostMapping("/user/register")
public ResponseEntity<UserResponse> createUser(
        @RequestBody UserRequest userRequest
        ){

     UserResponse ur = authService.registerUser(userRequest);

     return ResponseEntity.ok(ur);
}


}
