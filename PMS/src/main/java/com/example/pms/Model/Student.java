package com.example.pms.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String studentName;
    private String universityName;
    private String collegeName;
    private Double cgpa;
    private String preferredRole;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNumber;
    private Double preferredSalary;
    Boolean isPlaced;
}