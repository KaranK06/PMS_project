package com.example.pms.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Job {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long jobId;
        private String companyName;
        private Integer seats;
        private String experience;
        private String jobRole;
        private Double salaryPackage;
        private String expectedJoiningPeriod;
        private String workMode;
        private String workingHours;

}
