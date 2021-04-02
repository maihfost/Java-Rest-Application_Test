package com.JavaTest.services;

import com.JavaTest.services.Interfaces.IUserService;
import com.JavaTest.dao.UserDao;
import com.JavaTest.entities.User;
import com.JavaTest.entities.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserService implements IUserService{
    
    @Autowired
    UserDao userDao;
    
    @Override
    public List<UserDTO> findAll(){
        List<User> users = userDao.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(new UserDTO(user));
        }
        return(userDTOs);
    }
    
    @Override
    public List<UserDTO> findUsersByCompanyId(int companyId){
        List<User> users = userDao.findUsersByCompanyId(companyId);
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        for (User user : users) {
            userDTOs.add(new UserDTO(user));
        }
        return(userDTOs);
    }
    
    

    @Override
    public User findById(int id){
        return(userDao.findById(id));
    }
    
    @Override
    public UserDTO findByIdDTO(int id){
        User user = findById(id);
        return(new UserDTO(user));
    } 


    @Override
    public boolean save(User user) {
        boolean result = false;
        result = userDao.save(user);
        return (result);
    }
    
    @Override
    public boolean update(User user) {
        boolean result = false;
        result = userDao.update(user);
        return (result);
    }
    
    @Override
    public boolean delete(User user){
        boolean result = false;
        result = userDao.deleteUser(user);
        return (result);
    }


    
}
