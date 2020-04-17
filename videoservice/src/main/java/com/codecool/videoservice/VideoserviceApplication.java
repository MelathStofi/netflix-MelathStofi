package com.codecool.videoservice;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
public class VideoserviceApplication {

	@Autowired
	private VideoRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(VideoserviceApplication.class, args);
	}

	@Bean
	@Profile("production")
	public CommandLineRunner init() {
		return args -> {
			Video video1 = Video.builder()
					.name("Quick-sort with Hungarian (Küküllőmenti legényes) folk dance")
					.url("https://www.youtube.com/watch?v=ywWBy6J5gz8")
					.build();

			Video video2 = Video.builder()
					.name("Shell-sort with Hungarian (Székely) folk dance")
					.url("https://www.youtube.com/watch?v=CmPA7zE8mx0")
					.build();

			Video video3 = Video.builder()
					.name("Gheorghe Zamfir - Frunzulita lemn adus (cantec de nunta)")
					.url("https://www.youtube.com/watch?v=toBhrnObFzE")
					.build();

			repo.saveAll(Arrays.asList(video1, video2, video3));
		};

	}

}
