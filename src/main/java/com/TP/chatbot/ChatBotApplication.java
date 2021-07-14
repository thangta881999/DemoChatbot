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
     * @param pageAccessToken the generated {@code Page Access Token}
     */

//    @Bean
//    //@Autowired
//    public MessengerSendClient messengerSendClient(@Value("EAADHFIeBIwABAKPCKfhawzZCyBqS4FrGjC1sUkKCxZCOB1hZBuiP38HOEemBZCKWjIom4sDcHrdvvp5rJWGcBw7CihAuxUY045ygdTjnX8DzQ32JSZAEBoWScwsBEs2mNm5pQ6uNFXD5tSU1i1QXSmCZBWV9yAfNgeDNKS3Mz55CdZCYjNJR4X7QL2xrXO5vSgZD") String pageAccessToken,
//                                                   @Value("5b151aac813b854bdacb026ae9c31772") final String appSecret,
//                                                   @Value("123456789") final String verifyToken) {
//        logger.debug("Initializing MessengerSendClient - pageAccessToken: {}", pageAccessToken,appSecret,verifyToken);
//        return MessengerPlatform.newSendClientBuilder(pageAccessToken).build();
//    }

    @Bean
    @RequestMapping
    public MessengerSendClient messengerSendClient(@Value("EAACktZAjdwbUBAMXbjZCEUXJTGGhV904x5v9f4VUX623a0qdraK3sSCumCffMwO83UhqCZBeGmW8eDLqdwb6vztwIAOs0x7kUlgvbvcPybEWSm5u1uAGYtqEgcrFLGXf5uGLNyeR1EBFk8GLngdrBma6t66LutmPFNlGhyMnUWvZAwkgIP4D4LCjuTeD7N0ZD") String pageAccessToken) {
        logger.debug("Initializing MessengerSendClient - pageAccessToken: {}", pageAccessToken);
        return MessengerPlatform.newSendClientBuilder(pageAccessToken).build();
    }
}
