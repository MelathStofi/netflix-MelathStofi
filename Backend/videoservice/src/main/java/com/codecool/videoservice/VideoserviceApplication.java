package com.codecool.videoservice;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class VideoserviceApplication {

	@Autowired
	private VideoRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(VideoserviceApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	@Profile("production")
	public CommandLineRunner init() {
		return args -> {
			Video video1 = Video.builder()
					.name("Quick-sort with Hungarian (Küküllőmenti legényes) folk dance")
					.url("https://www.youtube.com/embed/ywWBy6J5gz8")
					.build();

			Video video2 = Video.builder()
					.name("KATICA ILLÉNYI theremin - O sole mio")
					.url("https://www.youtube.com/embed/Nfh6UuJuU-U")
					.build();

			Video video3 = Video.builder()
					.name("Gheorghe Zamfir - Frunzulita lemn adus (cantec de nunta)")
					.url("https://www.youtube.com/embed/toBhrnObFzE")
					.build();

			repo.saveAll(Arrays.asList(video1, video2, video3));
		};

	}

}
