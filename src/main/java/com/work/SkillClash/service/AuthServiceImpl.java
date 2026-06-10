package com.work.SkillClash.service;

import com.work.SkillClash.dto.QuestionResponse;
import com.work.SkillClash.dto.UserLoginRequest;
import com.work.SkillClash.dto.UserRequest;
import com.work.SkillClash.dto.UserResponse;
import com.work.SkillClash.model.LoginSession;
import com.work.SkillClash.model.User;
import com.work.SkillClash.model.UserStatus;
import com.work.SkillClash.repository.AuthRepository;
import com.work.SkillClash.repository.LogginSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserCodeGenerator userCodeGenerator;
    private final AuthRepository authRepository;
    private final LogginSessionRepository logginSessionRepository;

    @Override
    public UserResponse registerUser(UserRequest userRequest) {

        String username = userRequest.getUsername();

        if (authRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already exists with username : "+username);
        }

        User user = User.builder()
                .email(userRequest.getEmail())
                .userCode(userCodeGenerator.generateUserCode())
                .username(username)
                .password(userRequest.getPassword())
                .status(UserStatus.ACTIVE)
                .build();

      User savedUser = authRepository.save(user);

        UserResponse queResp = mapToResponse(savedUser);

        return queResp;
    }

    @Override
    public String loginUser(UserLoginRequest userLoginRequest) {

        String username = userLoginRequest.getUsername();
        String password = userLoginRequest.getPassword();

        if(username==null && username.isEmpty()){
            throw new NullPointerException("Username is Null");
        }
        if(password==null && password.isEmpty()){
            throw new NullPointerException("password is Null");
        }

        boolean isExist = authRepository.existsByUsername(username);

        if(!isExist){
            throw new RuntimeException("UserName Is Incorrect Or Not A Valid User Please Check!!");
        }

        User user = authRepository.findUserByUsername(username);

        if(user.getStatus()==UserStatus.INACTIVE){
            throw new RuntimeException("User Is Not Active Please Contact With Admin");
        }

        LoginSession loginSession = LoginSession.builder()
                .username(username)
                .userCode(user.getUserCode())
                .status(UserStatus.ONLINE)
                .build();

        LoginSession ls = logginSessionRepository.save(loginSession);

        return  user.getUsername();
    }

    @Override
    public String logoutUser(String username) {

        LoginSession loginSession =
                logginSessionRepository.findTopByUsernameOrderByLoggedInAtDesc(username);
        if(loginSession==null){
            throw new RuntimeException("LoginSession is not present");
        }
        loginSession.setStatus(UserStatus.OFFLINE);
       loginSession = logginSessionRepository.save(loginSession);

        return "User Logout Successfully";
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
