package com.JavaTest.services.Interfaces;

import com.JavaTest.entities.Company;
import com.JavaTest.entities.dto.CompanyDTO;
import java.util.List;

public interface ICompanyService {
    public Company findById(int id);

    public List<CompanyDTO> findAll();
}
