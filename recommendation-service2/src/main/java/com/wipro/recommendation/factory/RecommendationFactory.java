package com.wipro.recommendation.factory;

import com.wipro.recommendation.strategy.*;

public class RecommendationFactory {

    public static RecommendationStrategy getStrategy(String category) {

        if (category.equalsIgnoreCase("games")) {
            return new GamesRecommendation();
        }

        else if (category.equalsIgnoreCase("cosmetics")) {
            return new CosmeticsRecommendation();
        }

        else {
            return new DefaultRecommendation();
        }
    }
}