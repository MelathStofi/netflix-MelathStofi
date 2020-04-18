package com.codecool.videorecommendationservice.controller;

import com.codecool.videorecommendationservice.entity.Recommendation;
import com.codecool.videorecommendationservice.repository.RecommendationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/recommendations")
@Slf4j
public class RecommendationController {

    @Autowired
    private RecommendationRepository repo;

    @GetMapping("/{videoId}")
    public Set<Recommendation> getRecommendationsForVideoId(@PathVariable Long videoId) {
        log.info("Recommendations retrieved for video ID: " + videoId);
        return repo.findAllByVideoId(videoId);
    }

    @PostMapping("/{videoId}")
    public Recommendation saveRecommendation(@PathVariable Long videoId, @RequestBody Recommendation recommendation) {
        recommendation.setVideoId(videoId);
        Recommendation data = repo.save(recommendation);
        log.info("Recommendation saved to database: " + data.toString());
        return data;
    }

    @PutMapping("/{videoId}")
    public Recommendation updateRecommendation(@RequestBody Recommendation recommendation) {
        Recommendation data = repo.findById(recommendation.getId()).orElse(null);
        assert data != null;
        data.setRating(recommendation.getRating());
        data.setComment(recommendation.getComment());

        return data;
    }

}
