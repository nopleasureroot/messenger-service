package com.messenger.service.messengerservice.bot.telegram;

import com.messenger.service.messengerservice.config.property.TelegramProperty;
import com.pengrad.telegrambot.TelegramBot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@RequiredArgsConstructor
public class Bot {
    private final TelegramProperty config;
    private TelegramBot bot;

    @PostConstruct
    public void init() {
        bot = new TelegramBot(config.getToken());
    }

    public TelegramBot getBot() {
        return bot;
    }
}
