package com.example.rest.Repositories;

import com.example.rest.Entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {
}
