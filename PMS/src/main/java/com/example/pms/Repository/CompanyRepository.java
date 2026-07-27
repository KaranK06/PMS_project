package com.example.pms.Repository;

import com.example.pms.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company>findBycompanyName(String companyName);
    public void deleteCompanyBycompanyName(String companyName);
}
