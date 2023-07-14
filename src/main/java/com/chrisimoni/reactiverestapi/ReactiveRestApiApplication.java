package com.chrisimoni.reactiverestapi;

import com.chrisimoni.reactiverestapi.entity.Student;
import com.chrisimoni.reactiverestapi.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveRestApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(StudentRepository repository) {
		return args -> {
			for (int i = 0; i < 100; i++) {
				repository.save(
						Student.builder()
								.firstName("Test" + i)
								.lastName("test" + i)
								.age(i)
								.build()
				).subscribe();
			}
		};
	}

}
