package com.messenger.service.messengerservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
@Configuration
@ConfigurationProperties(prefix = "applications.telegram")
public class TelegramProperties {
    @NotNull private String token;
    @NotNull private String chatId;
}
