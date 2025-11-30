package dev.ngdangkietswe.try_spring_ai.config;

import com.google.genai.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ngdangkietswe
 * @since 11/30/2025
 */

@Configuration
public class GeminiConfig {

    @Value("${google.ai.api-key}")
    private String apiKey;

    @Bean
    public Client geminiClient() {
        return Client.builder()
                .apiKey(apiKey)
                .build();
    }
}
