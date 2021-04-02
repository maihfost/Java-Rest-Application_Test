package com.JavaTest.controllers;

/** Company Controller has 1 endpoint that returns all the Companies of the Database
*/

import com.JavaTest.entities.dto.CompanyDTO;
import com.JavaTest.services.Interfaces.ICompanyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api/company"})
public class CompanyRestController {
    @Autowired
    ICompanyService companyService;
    
    @CrossOrigin
    @Transactional 
    @GetMapping("/all")
    public List<CompanyDTO> showCompanies() {
        return (companyService.findAll());
    }
}
