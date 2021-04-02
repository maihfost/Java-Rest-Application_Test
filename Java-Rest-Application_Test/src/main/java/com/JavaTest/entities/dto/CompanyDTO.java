package com.JavaTest.entities.dto;

import com.JavaTest.entities.Company;

public class CompanyDTO {
    private Integer id;
    private String name;

    public CompanyDTO() {
    }
    
    public CompanyDTO(Company company) {
        this.id = company.getId();
        this.name = company.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
