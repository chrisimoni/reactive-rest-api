package com.chrisimoni.reactiverestapi.repository;

import com.chrisimoni.reactiverestapi.entity.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {
    Flux<Student> findAllByFirstnameContainingIgnoreCase(String firstname);
}
