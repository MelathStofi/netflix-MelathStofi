package com.codecool.videorecommendationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Recommendation {

    @Id
    @GeneratedValue
    private Long id;

    private int rating;

    private String comment;

    private Long videoId;
}
