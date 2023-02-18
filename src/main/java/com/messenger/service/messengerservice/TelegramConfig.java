package com.messenger.service.messengerservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "applications.telegram")
public class TelegramConfig {
    private String token;
    private String urlToken;
    private String chatId;
}
