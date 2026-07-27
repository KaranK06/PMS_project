package com.example.pms.Controller;


import com.example.pms.Business.CompanyService;
import com.example.pms.Business.InfoUpdate;
import com.example.pms.Model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/Company")
public class CompanyController {

    @Autowired
    CompanyService companyService;
    @GetMapping
    ResponseEntity<List<Company>>getAllCompanies(){
        List<Company>Companies = companyService.findAll();
        return new ResponseEntity<>(Companies, HttpStatus.OK);
    }
    @PostMapping
    ResponseEntity<String>saveCompany(Company company){
        companyService.save(company);
        return new ResponseEntity<>("Company Saved",HttpStatus.OK);
    }
    @GetMapping("/{companyId}")
    ResponseEntity<Company> getCompany(@PathVariable Long companyId){
        Optional<Company> companyObject = companyService.findById(companyId);
       Company company = new Company();
       company =  companyObject.get();
        return new ResponseEntity<>(company, HttpStatus.OK);
    }
    @GetMapping("/companyName")
    ResponseEntity<Company> getCompany(InfoUpdate info){
        Optional<Company>companyObject = companyService.findBycompanyName(info.companyName);
        Company company = new Company();
        company =  companyObject.get();
        return new  ResponseEntity<>(company, HttpStatus.OK);
    }
    @DeleteMapping("/{Id}")
    ResponseEntity<String> deleteCompany(@PathVariable Long Id){
    String message = companyService.deleteCompanyById(Id);
    return new  ResponseEntity<>(message, HttpStatus.OK);
    }
    @DeleteMapping("/companyName")
    ResponseEntity<String> deleteCompany(InfoUpdate info){
        String message = companyService.deleteCompanyByName(info.companyName);
        return new  ResponseEntity<>(message, HttpStatus.OK);
    }
}
