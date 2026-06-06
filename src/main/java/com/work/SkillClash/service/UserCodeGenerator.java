package com.work.SkillClash.service;

import com.work.SkillClash.repository.AuthRepository;
import com.work.SkillClash.repository.RoomRepository;

import java.security.SecureRandom;

public class UserCodeGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 6;

    private final SecureRandom random = new SecureRandom();
    private final AuthRepository authRepository;

    public UserCodeGenerator(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public String generateUserCode() {

        String userCode;

        do {
            StringBuilder code = new StringBuilder();

            for (int i = 0; i < CODE_LENGTH; i++) {
                int index = random.nextInt(CHARACTERS.length());
                code.append(CHARACTERS.charAt(index));
            }

            userCode = code.toString();

        } while (authRepository.existsByUserCode(userCode));

        return userCode;
    }



}
