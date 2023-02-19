package com.messenger.service.messengerservice.service.telegram;

import com.messenger.service.messengerservice.client.TelegramClient;
import com.messenger.service.messengerservice.config.TelegramProperties;
import com.messenger.service.messengerservice.service.Sender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramSenderImpl implements Sender {

    private final TelegramProperties config;
    private final TelegramClient telegramClient;

    @KafkaListener(topics = "analyzed-messages")
    public void send(String msg) {
        telegramClient.sendMessage(config.getChatId(), msg);
    }
}

