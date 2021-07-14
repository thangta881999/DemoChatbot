package com.TP.chatbot;
import com.github.messenger4j.MessengerPlatform;
import com.github.messenger4j.send.MessengerSendClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
public class ChatBotApplication {
    private static final Logger logger = LoggerFactory.getLogger(ChatBotApplication.class);

    /**
     * Initializes the {@code MessengerSendClient}.
     *
     * @param PAGE_ACCESS_TOKEN the generated {@code Page Access Token}
     */

//    @Bean
//    //@Autowired
//    public MessengerSendClient messengerSendClient(@Value("EAADHFIeBIwABAKPCKfhawzZCyBqS4FrGjC1sUkKCxZCOB1hZBuiP38HOEemBZCKWjIom4sDcHrdvvp5rJWGcBw7CihAuxUY045ygdTjnX8DzQ32JSZAEBoWScwsBEs2mNm5pQ6uNFXD5tSU1i1QXSmCZBWV9yAfNgeDNKS3Mz55CdZCYjNJR4X7QL2xrXO5vSgZD") String PAGE_ACCESS_TOKEN,
//                                                   @Value("5b151aac813b854bdacb026ae9c31772") final String APPSECRET,
//                                                   @Value("123456789") final String VERIFY_TOKEN) {
//        logger.debug("Initializing MessengerSendClient - PAGE_ACCESS_TOKEN: {}", PAGE_ACCESS_TOKEN,APPSECRET,VERIFY_TOKEN);
//        return MessengerPlatform.newSendClientBuilder(PAGE_ACCESS_TOKEN).build();
//    }

    @Bean
    @RequestMapping
    public MessengerSendClient messengerSendClient(@Value("EAACktZAjdwbUBAIA7hnUSAr6XWdGRpIZAOKvx7eoFfnRlEa64Is6bYeJdfcrZBlruTsdUTJK7exn3Ckg2tYkMbbyZARKTWnWHTf37BCjHh6v3GkFhDwkWpMa86Ee1rVExzZC1QqZBBZAb8Ul8OZBRgXTw1X0qtIZC4zi01WJjFtsJclnrMCByhBG12dIzZBEqXNg8ZD") String PAGE_ACCESS_TOKEN) {
        logger.debug("Initializing MessengerSendClient - PAGE_ACCESS_TOKEN: {}", PAGE_ACCESS_TOKEN);
        return MessengerPlatform.newSendClientBuilder(PAGE_ACCESS_TOKEN).build();
    }
}