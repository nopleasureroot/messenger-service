package com.messenger.service.messengerservice.service;

import com.messenger.service.messengerservice.model.MessageEvent;
import org.springframework.messaging.handler.annotation.Payload;

public interface Sender {
    void send(@Payload MessageEvent msg);
}
