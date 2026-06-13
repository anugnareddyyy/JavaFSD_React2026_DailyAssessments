package com.wipro.recommendation.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.wipro.recommendation.factory.RecommendationFactory;
import com.wipro.recommendation.strategy.RecommendationStrategy;

@Service
public class RecommendationService {

    public List<String> getRecommendations(String category) {

        RecommendationStrategy strategy =
                RecommendationFactory.getStrategy(category);

        return strategy.recommend();
    }
}