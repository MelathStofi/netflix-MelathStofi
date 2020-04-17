package com.codecool.videoservice.service;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.model.Recommendation;
import com.codecool.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class Dao {

    @Autowired
    private VideoRepository repo;

    @Autowired
    private RecommendationserviceCaller recommendationService;

    public List<Video> getAllVideos() {
        return repo.findAll();
    }

    public Video getVideoById(Long id) {
        return repo.findById(id).orElse(null);

    }

    public void addRecommendationToVideo(Long videoId, Recommendation recommendation) {
        recommendationService.saveRecommendation(videoId, recommendation);
    }

    public Set<Recommendation> getRecommendationByVideoId(Long videoId) {
        return recommendationService.getRecommendations(videoId);
    }
}
