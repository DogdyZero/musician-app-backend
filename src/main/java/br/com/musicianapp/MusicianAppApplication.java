package br.com.musicianapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("br.com.musicianapp.domain")

@ComponentScan("br.com.musicianapp")
@EnableJpaRepositories("br.com.musicianapp.repository")
@SpringBootApplication
public class MusicianAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicianAppApplication.class, args);
	}

}
