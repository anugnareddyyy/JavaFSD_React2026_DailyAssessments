package com.wipro.recommendation.strategy;

import java.util.List;

public class DefaultRecommendation implements RecommendationStrategy {

    @Override
    public List<String> recommend() {
        return List.of("Generic App 1", "Generic App 2");
    }
}