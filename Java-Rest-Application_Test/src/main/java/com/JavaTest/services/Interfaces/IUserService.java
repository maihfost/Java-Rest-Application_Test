package com.JavaTest.services.Interfaces;

import com.JavaTest.entities.User;
import com.JavaTest.entities.dto.UserDTO;
import java.util.List;

public interface IUserService {

    public User findById(int id);

    public UserDTO findByIdDTO(int id);
    
    public List<UserDTO> findAll();

    public boolean save(User user);

    public boolean update(User user);

    public boolean delete(User user);
    
    public List<UserDTO> findUsersByCompanyId(int companyId);

}
