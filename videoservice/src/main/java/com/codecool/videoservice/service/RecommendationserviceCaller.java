package com.codecool.videoservice.service;

import com.codecool.videoservice.model.Recommendation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class RecommendationserviceCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${recommendationservice.url}")
    private String recUrl;

    public Set<Recommendation> getRecommendations(Long videoId) {
        Recommendation[] responseBody =
                restTemplate.getForEntity(recUrl + videoId, Recommendation[].class).getBody();
        assert responseBody != null;
        System.out.println(responseBody[0]);
        Set<Recommendation> recommendations = new HashSet<>(Arrays.asList(responseBody));
        log.info("== Recommendations retrieved for video with id " + videoId + " ==");
        log.info(recommendations.toString());
        return recommendations;

    }

    public void saveRecommendation(Long videoId, Recommendation recommendation) {
        HttpEntity<Recommendation> request = new HttpEntity<>(recommendation);
        restTemplate.postForEntity(recUrl + videoId, request, Recommendation.class);
    }
}
