package com.work.SkillClash.service;

import com.work.SkillClash.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class RoomCodeGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 6;

    private final SecureRandom random = new SecureRandom();
    private final RoomRepository roomRepository;

    public RoomCodeGenerator(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public String generateRoomCode() {

        String roomCode;

        do {
            StringBuilder code = new StringBuilder();

            for (int i = 0; i < CODE_LENGTH; i++) {
                int index = random.nextInt(CHARACTERS.length());
                code.append(CHARACTERS.charAt(index));
            }

            roomCode = code.toString();

        } while (roomRepository.existsByRoomCode(roomCode));

        return roomCode;
    }
}