package com.example.pms.Repository;

import com.example.pms.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findBystudentName(String name);
}
