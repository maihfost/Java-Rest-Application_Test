package com.JavaTest.dao;

import com.JavaTest.entities.User;
import com.pcedu.blackbooks.dao.AbstractDao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDao")
@Transactional
public class UserDao extends AbstractDao<Integer, User> {
    
    public User findById(int id) {
        User u = getByKey(id);
        if(u != null) {
            return u;
        }
        return null;
    }
    
    public List<User> findAll() {
         Criteria criteria = createEntityCriteria();
         return(criteria.list());
    }
    
    public List<User> findUsersByCompanyId(int companyId) {
        Criteria criteria = createEntityCriteria();
        criteria.createCriteria("companyId").add(Restrictions.eq("id", companyId));
        return (criteria.list());  
    }
    
    public boolean save(User user) {
        return(persist(user));
    }
    
    public boolean update(User user) {
        if(findById(user.getId()) != null) return(save(user));
        return(false);
    }
    
    public boolean deleteUser(User user) {
        if(user != null) {
            delete(user);
            return(true);
        }
        return(false);
    }
}
