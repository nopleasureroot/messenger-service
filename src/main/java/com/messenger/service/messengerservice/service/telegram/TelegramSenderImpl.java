package com.messenger.service.messengerservice.service.telegram;

import com.messenger.service.messengerservice.bot.telegram.Bot;
import com.messenger.service.messengerservice.config.property.TelegramProperty;
import com.messenger.service.messengerservice.model.MessageEvent;
import com.messenger.service.messengerservice.service.Sender;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramSenderImpl implements Sender {
    private final Bot bot;
    private final TelegramProperty telegramProperty;

    @KafkaListener(topics = "analyzed-messages", groupId = "${spring.kafka.consumer.group-id}",
        containerFactory = "kafkaMessageContainerFactory")
    public void send(MessageEvent msg) {
        SendMessage message = new SendMessage(telegramProperty.getChatId(), msg.message());

        bot.getBot().execute(message);
    }
}

