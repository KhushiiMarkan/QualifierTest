package com.chitkara.qualifier.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> response = new HashMap<>();
        response.put("official_email", "khushi1955.be23@chitkara.edu.in");
        response.put("is_success", true);
        return response;
    }
}
