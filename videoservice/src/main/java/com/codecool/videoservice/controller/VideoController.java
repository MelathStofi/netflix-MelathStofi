package com.codecool.videoservice.controller;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.model.Recommendation;
import com.codecool.videoservice.repository.VideoRepository;
import com.codecool.videoservice.service.Dao;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private Dao dao;

    @GetMapping("")
    public List<Video> getVideos() {
        return dao.getAllVideos();
    }

    @GetMapping("/{videoId}")
    public VideoWithRecommendations getDetailedPageOfVideo(@PathVariable Long videoId) {
        Video video = dao.getVideoById(videoId);
        Set<Recommendation> recommendations = dao.getRecommendationByVideoId(videoId);

        return new VideoWithRecommendations(
                video.getId(),
                video.getName(),
                video.getUrl(),
                recommendations
        );
    }

    @PostMapping("/{videoId}")
    public void addRecommendation(@PathVariable Long videoId, @RequestBody Recommendation recommendation) {
        dao.addRecommendationToVideo(videoId, recommendation);
    }

    @Data
    @AllArgsConstructor
    private class VideoWithRecommendations {
        private Long id;
        private String name;
        private String url;
        private Set<Recommendation> recommendations;
    }
}
