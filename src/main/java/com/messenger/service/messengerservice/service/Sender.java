package com.messenger.service.messengerservice.service;

import org.springframework.messaging.handler.annotation.Payload;

import com.messenger.service.messengerservice.model.DataConsumerEvent;

public interface Sender {
    void send(@Payload DataConsumerEvent msg);
}
