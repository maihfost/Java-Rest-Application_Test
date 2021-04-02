package com.JavaTest.services;

import com.JavaTest.services.Interfaces.ICompanyService;
import com.JavaTest.dao.CompanyDao;
import com.JavaTest.entities.Company;
import com.JavaTest.entities.dto.CompanyDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("companyService")
@Transactional
public class CompanyService implements ICompanyService{

    @Autowired
    CompanyDao companyDao;
    
    @Override
    public Company findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CompanyDTO> findAll() {
        List<Company> companies = companyDao.findAll();
        List<CompanyDTO> companyDTOs = new ArrayList<CompanyDTO>();
        for (Company company : companies) {
            companyDTOs.add(new CompanyDTO(company));
        }
        return(companyDTOs);
    }
    
}
