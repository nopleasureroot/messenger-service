package com.messenger.service.messengerservice.kafka;

import com.messenger.service.messengerservice.services.telegram.TelegramSenderImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@EnableKafka
@Component
@Slf4j
public class ConsumerMessenger {
    final
    TelegramSenderImpl telegramSenderService;

    public ConsumerMessenger(TelegramSenderImpl telegramSenderService) {
        this.telegramSenderService = telegramSenderService;
    }

    @KafkaListener(topics="analyzed-messages")
    public void msgListener(String msg) throws IOException {
        telegramSenderService.send(msg);
    }

}
