package com.wipro.recommendation.controller;

/*
   Exposes API for recommendations.*/

import com.wipro.recommendation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendationController {

    @Autowired
    private RecommendationService service;

    @GetMapping("/{category}")
    public List<String> getApps(@PathVariable String category){
        return service.getRecommendations(category);
    }
}
