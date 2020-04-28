package com.codecool.videorecommendationservice.repository;

import com.codecool.videorecommendationservice.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    public Set<Recommendation> findAllByVideoId(Long videoId);

}
