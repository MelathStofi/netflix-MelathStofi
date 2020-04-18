package com.codecool.videoservice.service;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.model.Recommendation;
import com.codecool.videoservice.repository.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
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

    public HttpStatus addRecommendationToVideo(Long videoId, Recommendation recommendation) {
        return recommendationService.saveRecommendation(videoId, recommendation);
    }

    public Set<Recommendation> getRecommendationByVideoId(Long videoId) {
        return recommendationService.getRecommendations(videoId);
    }

    public HttpStatus updateRecommendation(Long videoId, Recommendation recommendation) {
        return recommendationService.updateRecommendation(videoId, recommendation);
    }

    public HttpStatus updateVideoById(Long videoId, String name, String url) {
        Video video = repo.findById(videoId).orElse(null);
        assert video != null;
        video.setName(name);
        video.setUrl(url);
        log.info("Updated video: " + video.toString() );
        return HttpStatus.OK;
    }
}
