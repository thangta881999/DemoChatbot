package com.TP.chatbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.messenger4j.Messenger;


@Configuration
public class ChatBotApplication {
    @Bean
    public Messenger messenger(@Value("EAACktZAjdwbUBAIGZBtgmOQBjWhN5QHuOmI6FD9dyvxS6Yr735vGeIS5SNtauIpX0A54Cof45cZBAEywq6XZBMi1iZAcOwZBuZAKaZAIqyJv7HgNjr6TrMXLTFAxjLAeW2blUyhGCYZAjN9qlZCRjAkiXtfzpRtSdvXwnQwEzofkqcnjbDHZCfYMnjY863JuEZAQgwYZD")  String PAGE_ACCESS_TOKEN,
                               @Value("f8d3af2e47cfd338a64541f9ea0aa308")  final String APPSECRET,
                               @Value("$123456789") final String VERIFY_TOKEN) {
        return Messenger.create(PAGE_ACCESS_TOKEN, APPSECRET, VERIFY_TOKEN);
    }
}