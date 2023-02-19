package com.messenger.service.messengerservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "telegramClient", url = "${clients.telegram.base-url}")
public interface TelegramClient {
    @PostMapping("/sendMessage")
    ResponseEntity<Void> sendMessage(@RequestParam("chat_id") String chatId,
                                     @RequestParam String text);
}
