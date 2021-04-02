package com.JavaTest.dao;

import com.JavaTest.entities.Company;
import com.pcedu.blackbooks.dao.AbstractDao;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("companyDao")
@Transactional
public class CompanyDao extends AbstractDao<Integer, Company>{
    
    public List<Company> findAll() {
         Criteria criteria = createEntityCriteria();
         System.out.println(criteria.list());
         return(criteria.list());
    }
    
    public Company findById(int id) {
        Company u = getByKey(id);
        if(u != null) {
            return u;
        }
        return null;
    }
}
