package com.codecool.videorecommendationservice.controller;

import com.codecool.videorecommendationservice.entity.Recommendation;
import com.codecool.videorecommendationservice.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationRepository repo;

    @GetMapping("/{videoId}")
    public Set<Recommendation> getRecommendationsForVideoId(@PathVariable Long videoId) {
        return repo.findAllByVideoId(videoId);
    }

    @PostMapping("/{videoId}")
    public void saveRecommendation(@PathVariable Long videoId, @RequestBody Recommendation recommendation) {
        recommendation.setVideoId(videoId);
        repo.save(recommendation);
    }

}
