package com.codecool.videorecommendationservice.repository;

import com.codecool.videorecommendationservice.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    public List<Recommendation> findAllByVideoId(Long videoId);

}
