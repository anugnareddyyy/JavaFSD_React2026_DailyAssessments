package com.wipro.recommendation.strategy;

import java.util.List;

public class GamesRecommendation implements RecommendationStrategy {

    @Override
    public List<String> recommend() {
        return List.of("PUBG", "Call of Duty", "Free Fire");
    }
}