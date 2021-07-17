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
    public Messenger messenger(@Value("EAAFAKBgZBjYoBAAoocBlQxhxPkd5goXnbPEZB9p9woghEAyCGJbJI3xIjZCXhgtbhxejOBiwsM0HIt3AT1uBgiZBXMKcPCtk8J73zvtv3Af4uUKbz1Jn3QNRqGxZB9ZBSebpWS8LgSnzfv5ZBGDh4KxnXKMq8IfMASiS9VL4y79tiUuGs58JvJj")  String PAGE_ACCESS_TOKEN,
                               @Value("bdf0d1c562b9b5bf90dedeb82126efe5")  final String APPSECRET,
                               @Value("$123456789") final String VERIFY_TOKEN) {
        return Messenger.create(PAGE_ACCESS_TOKEN, APPSECRET, VERIFY_TOKEN);
    }
}