package com.wipro.appverse.controller;

/*
 * Handles review APIs.
 */

import com.wipro.appverse.entity.Review;
import com.wipro.appverse.repository.ReviewRepository;
import com.wipro.appverse.service.SentimentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository repo;

    @Autowired
    private SentimentService sentimentService;

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        review.setSentiment(sentimentService.analyze(review.getComment()));
        return repo.save(review);
    }
}
