package com.example.pms.Business;

import com.example.pms.Model.Company;
import com.example.pms.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    private ApplicationService applicationService;
    public List<Company> findAll() {
        return companyRepository.findAll();
    }
    public Company save(Company company) {
        return companyRepository.save(company);
    }
    public Optional<Company> findById(Long companyId) {
        return companyRepository.findById(companyId);
    }
    public Optional<Company> findBycompanyName(String companyName) {
        return companyRepository.findBycompanyName(companyName);
    }
    public String deleteCompanyById(Long companyId) {
        companyRepository.deleteById(companyId);
        return "Company deleted";
    }
    public String deleteCompanyByName(String companyName) {
        companyRepository.deleteCompanyBycompanyName(companyName);
        return "Company deleted";
    }

}
