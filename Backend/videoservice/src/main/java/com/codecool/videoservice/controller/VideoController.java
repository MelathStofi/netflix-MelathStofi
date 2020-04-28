package com.codecool.videoservice.controller;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.model.Recommendation;
import com.codecool.videoservice.repository.VideoRepository;
import com.codecool.videoservice.service.Dao;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/{videoId}")
    public HttpStatus updateVideo(@PathVariable Long videoId, @RequestBody VideoWithRecommendations video) {
        String name = video.getName();
        String url = video.getUrl();
        return dao.updateVideoById(videoId, name, url);
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

    @PutMapping("/recommendation/{videoId}")
    public HttpStatus updateRecommendation(@PathVariable Long videoId, @RequestBody Recommendation recommendation) {
        return dao.updateRecommendation(videoId, recommendation);
    }

    @PostMapping("/recommendation/{videoId}")
    public HttpStatus addRecommendation(@PathVariable Long videoId, @RequestBody Recommendation recommendation) {
        System.out.println("=====" + recommendation.toString() + "=====");
        return dao.addRecommendationToVideo(videoId, recommendation);
    }

    @Data
    @AllArgsConstructor
    private static class VideoWithRecommendations {
        private Long id;
        private String name;
        private String url;
        private Set<Recommendation> recommendations;
    }
}
