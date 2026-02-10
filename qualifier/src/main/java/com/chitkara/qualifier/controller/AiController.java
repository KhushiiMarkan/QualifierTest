package com.chitkara.qualifier.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ai")
public class AiController {

    @GetMapping("/check")
    public Map<String, Object> aiCheck() {
        return Map.of(
                "ai_used", true,
                "model", "Google Gemini",
                "response", "Hello"
        );
    }
}
