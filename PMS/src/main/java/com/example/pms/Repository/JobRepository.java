package com.example.pms.Repository;

import com.example.pms.Model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByjobRole(String jobRole);
    List<Job> findBycompanyName(String companyName);
}
