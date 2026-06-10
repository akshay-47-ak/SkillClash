package com.work.SkillClash.service;

import com.work.SkillClash.dto.UserLoginRequest;
import com.work.SkillClash.dto.UserRequest;
import com.work.SkillClash.dto.UserResponse;

public interface AuthService {

    UserResponse registerUser(UserRequest userRequest);

    String loginUser(UserLoginRequest userLoginRequest);

    String logoutUser(String username);
}
