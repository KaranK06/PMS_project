package com.example.pms.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    private String companyName;
    @Column(unique = true)
    private String branchName;
    private List<String> roles;
    private Integer seats;
    @Column(unique = true)
    private String contactEmail;
    @Column(unique = true)
    private String contactNumber;

}
