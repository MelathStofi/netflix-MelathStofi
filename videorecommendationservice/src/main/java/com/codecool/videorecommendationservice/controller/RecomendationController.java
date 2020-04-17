package com.codecool.videorecommendationservice.controller;

import com.codecool.videorecommendationservice.entity.Recommendation;
import com.codecool.videorecommendationservice.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendation")
public class RecomendationController {

    @Autowired
    private RecommendationRepository repo;

    @GetMapping("/{videoId}")
    public List<Recommendation> getRecommendationsForVideoId(@PathVariable Long videoId) {
        return repo.findAllByVideoId(videoId);
    }

}
