package com.codecool.videoservice.controller;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoRepository repo;

    @GetMapping("")
    public List<Video> getVideos() {
        return repo.findAll();
    }
}
