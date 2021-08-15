package io.schuberty.dio.checkpointapi.system.utils;

import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;

public final class MessageResponse {

    public static MessageResponseDTO create(String message) {
        return MessageResponseDTO
            .builder()
            .message(message)
            .build();
    }
}