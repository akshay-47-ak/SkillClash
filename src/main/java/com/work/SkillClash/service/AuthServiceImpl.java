package com.work.SkillClash.service;

import com.work.SkillClash.dto.QuestionResponse;
import com.work.SkillClash.dto.UserRequest;
import com.work.SkillClash.dto.UserResponse;
import com.work.SkillClash.model.User;
import com.work.SkillClash.model.UserStatus;
import com.work.SkillClash.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserCodeGenerator userCodeGenerator;
    private final AuthRepository authRepository;

    @Override
    public UserResponse registerUser(UserRequest userRequest) {

        User user = User.builder()
                .email(userRequest.getEmail())
                .userCode(userCodeGenerator.generateUserCode())
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .status(UserStatus.ACTIVE)
                .build();

      User savedUser = authRepository.save(user);

        UserResponse queResp = mapToResponse(savedUser);

        return queResp;
    }

    public UserResponse mapToResponse(User savedUser){
        UserResponse userResponse = UserResponse.builder()
                .username(savedUser.getUsername())
                .userCode(savedUser.getUserCode())
                .status(savedUser.getStatus())
                .build();

        return userResponse;
    }

}
