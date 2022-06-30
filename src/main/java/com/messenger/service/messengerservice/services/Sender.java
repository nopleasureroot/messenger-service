package com.messenger.service.messengerservice.services;

import java.io.IOException;

public interface Sender {

    void send(String msg) throws IOException;
}
