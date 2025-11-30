package dev.ngdangkietswe.try_spring_ai.service.impl;

import com.google.genai.Client;
import dev.ngdangkietswe.try_spring_ai.service.AiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author ngdangkietswe
 * @since 11/30/2025
 */

@Service
@RequiredArgsConstructor
public class AiServiceImpl implements AiService {
    private final Client client;

    @Override
    public String chatWithAi(String prompt) {
        var resp = client.models.generateContent(
                "gemini-2.5-flash",
                prompt,
                null
        );
        return resp.text();
    }
}
