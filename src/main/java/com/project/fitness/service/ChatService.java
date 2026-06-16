package com.project.fitness.service;

import com.google.api.client.util.Value;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final Client client;

    public String ask(String prompt) {
        GenerateContentResponse response=client.models.generateContent("gemini-2.5-flash",prompt,null);
        return  response.text();

    }
}
