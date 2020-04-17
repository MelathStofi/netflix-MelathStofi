package com.codecool.videorecommendationservice.repository;

import com.codecool.videorecommendationservice.entity.Recommendation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
class RecommendationRepositoryTest {

    @Autowired
    private RecommendationRepository repo;

    @Test
    public void findByVideoId() {
        Recommendation test1 = Recommendation.builder()
                .comment("Test 1")
                .rating(1)
                .videoId(1L)
                .build();

        Recommendation test2 = Recommendation.builder()
                .comment("Test 2")
                .rating(1)
                .videoId(2L)
                .build();


        repo.saveAll(Stream.of(test1, test2).collect(Collectors.toSet()));

        assertThat(repo.findAllByVideoId(1L)).hasSize(1).containsOnly(test1);
    }

}