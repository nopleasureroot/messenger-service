package com.messenger.service.messengerservice.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.messenger.service.messengerservice.model.Message;
import com.messenger.service.messengerservice.services.Sender;
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
    Sender senderService;

    public ConsumerMessenger(Sender senderService) {
        this.senderService = senderService;
    }

    @KafkaListener(topics="analyzed-messages")
    public void msgListener(String msg) throws IOException {
        //ObjectMapper mapper = new ObjectMapper();
       // Message message = mapper.readValue(msg, Message.class);
        senderService.send(msg);
    }

}
