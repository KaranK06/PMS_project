package com.example.pms.Repository;

import com.example.pms.Model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application,Long> {
     Optional<Application> findBystudentName(String studentName);
}
