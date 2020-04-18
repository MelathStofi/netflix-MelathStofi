package com.codecool.videoservice.controller;

import com.codecool.videoservice.model.Recommendation;
import com.codecool.videoservice.service.Dao;
import com.codecool.videoservice.service.RecommendationserviceCaller;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class VideoControllerTest {

    @Mock
    private RecommendationserviceCaller recommendationserviceCaller;

    @InjectMocks
    private Dao dao;

    @Test
    public void addRecommendationTest() {
        Recommendation test = Recommendation.builder()
                .rating(5)
                .comment("test")
                .build();

        when(recommendationserviceCaller.saveRecommendation(1L, test)).thenReturn(HttpStatus.OK);

        assertThat(dao.addRecommendationToVideo(1L, test)).isEqualTo(HttpStatus.OK);

    }

}