package com.work.SkillClash.controller;

import com.work.SkillClash.dto.UserLoginRequest;
import com.work.SkillClash.dto.UserRequest;
import com.work.SkillClash.dto.UserResponse;
import com.work.SkillClash.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

@PostMapping("/user/login")
 public ResponseEntity<String>userLoginRequest(
        @RequestBody UserLoginRequest userLoginRequest
        ){

     String loginRes = authService.loginUser(userLoginRequest);

     return ResponseEntity.ok(loginRes);

}

}
