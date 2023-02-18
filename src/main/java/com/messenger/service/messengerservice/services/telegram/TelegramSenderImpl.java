package com.messenger.service.messengerservice.services.telegram;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.messenger.service.messengerservice.TelegramConfig;
import com.messenger.service.messengerservice.services.Sender;

@Service
public class TelegramSenderImpl implements Sender {

    private final TelegramConfig config;

    private static HttpURLConnection con;

    private final String CHAT_ID = "chat_id=";
    private final String TEXT = "&text=";
    public TelegramSenderImpl(TelegramConfig config) {
        this.config = config;
    }

    public void send(String msg) throws IOException {

        String urlParameters = CHAT_ID+config.getChatId()+TEXT+msg;
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

        try {

            URL url = new URL(config.getUrlToken());
            con = (HttpURLConnection) url.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Java upread.ru client");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postData);
            }

            StringBuilder content;

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String line;
                content = new StringBuilder();

                while ((line = br.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            System.out.println(content.toString());

        } finally {
            con.disconnect();
        }
    }
}

