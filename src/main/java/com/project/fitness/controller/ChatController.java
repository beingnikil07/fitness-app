package com.project.fitness.controller;

import com.project.fitness.dto.ChatRequest;
import com.project.fitness.dto.ChatResponse;
import com.project.fitness.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/ask")
    public ChatResponse chat(@RequestBody ChatRequest request){
        String answer=chatService.ask(request.getMessage());
        return new ChatResponse(answer);
    }
}
