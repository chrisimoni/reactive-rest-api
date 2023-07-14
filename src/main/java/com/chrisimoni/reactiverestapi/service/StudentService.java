package com.chrisimoni.reactiverestapi.service;

import com.chrisimoni.reactiverestapi.entity.Student;
import com.chrisimoni.reactiverestapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public Flux<Student> findAll() {
        return repository.findAll()
                .delayElements(Duration.ofSeconds(1));
    }

    public Mono<Student> findById(Integer id) {
        return repository.findById(id);
    }

    public Mono<Student> save(Student student) {
        return repository.save(student);
    }

    public Flux<Student> findByFirstname(String firstname) {
        return repository.findAllByFirstNameContainingIgnoreCase(firstname);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id).subscribe();
    }
}
