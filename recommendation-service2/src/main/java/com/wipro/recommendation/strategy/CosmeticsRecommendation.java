package com.wipro.recommendation.strategy;

import java.util.List;

public class CosmeticsRecommendation implements RecommendationStrategy {

    @Override
    public List<String> recommend() {
        return List.of("Nykaa", "Lakme", "Sugar Cosmetics");
    }
}