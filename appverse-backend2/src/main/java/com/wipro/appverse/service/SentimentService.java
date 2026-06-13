package com.wipro.appverse.service;

/*
 * This class performs sentiment analysis.
 */

import org.springframework.stereotype.Service;

@Service
public class SentimentService {

    public String analyze(String comment) {

        if (comment == null) {
            return "NEUTRAL";
        }

        comment = comment.toLowerCase();

        if (comment.contains("good") || comment.contains("best") || comment.contains("excellent")) {
            return "POSITIVE";
        } 
        else if (comment.contains("bad") || comment.contains("worst")) {
            return "NEGATIVE";
        } 
        else {
            return "NEUTRAL";
        }
    }
}
