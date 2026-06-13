package com.wipro.recommendation.service;

/*
 * Provides AI-based app recommendations.
 * This is part of the microservice.
 */

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RecommendationService {

    public List<String> getRecommendations(String category) {

        List<String> apps = new ArrayList<>();

        if (category.equalsIgnoreCase("Gaming")) {
            apps.add("Call of Duty");
            apps.add("PUBG");
            apps.add("Free Fire");
        }
        if (category.equalsIgnoreCase("Learning Platform")) {
            apps.add("Coursera");
            apps.add("Udemy");
        } 
        if (category.equalsIgnoreCase("Cosmetics")) {
            apps.add("Nykaa");
            apps.add("Lakme");
            apps.add("Sugar Cosmetics");
        }
        if (category.equalsIgnoreCase("Food")) {
            apps.add("Zomato");
            apps.add("Swiggy");
            apps.add("Uber Eats");
        }
        
        else {
            apps.add("Generic App 1");
            apps.add("Generic App 2");
        }

        return apps;
    }
}