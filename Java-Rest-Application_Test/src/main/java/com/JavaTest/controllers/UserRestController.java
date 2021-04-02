package com.JavaTest.controllers;

/** User Controller has 6 endpoints.
 * 1. returns all users
 * 2. returns user by id
 * 3. returns all users per company_id
 * 4. inserts a user
 * 5. updates a user
 * 6. deletes a user
*/

import com.JavaTest.entities.Company;
import com.JavaTest.entities.User;
import com.JavaTest.entities.dto.UserDTO;
import com.JavaTest.services.Interfaces.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api/user"})
public class UserRestController {
    
    @Autowired
    IUserService userService;
    
    @CrossOrigin
    @Transactional 
    @GetMapping("/all")
    public List<UserDTO> showUsers() {
        return (userService.findAll());
    }
    
    @CrossOrigin
    @GetMapping("/id/{id}")
    public UserDTO showUser(@PathVariable int id) {
        return(userService.findByIdDTO(id));
    }
    
    @CrossOrigin
    @Transactional 
    @GetMapping("/company/id/{id}")
    public List<UserDTO> showUsersByCompanyId(@PathVariable int id) {
        return (userService.findUsersByCompanyId(id));
    }
    
    @CrossOrigin
    @Transactional 
    @PostMapping("/new")
        public ResponseEntity registerUser(@RequestBody User user){
          
        if(userService.save(user)) return (new ResponseEntity(HttpStatus.ACCEPTED));
        return (new ResponseEntity(HttpStatus.BAD_REQUEST));
    }
    
    @CrossOrigin
    @Transactional 
    @PutMapping("/update")
        public ResponseEntity updateUser(@RequestBody User user){
       
        User tempUser = updateCheck(user, userService.findById(user.getId()));
        
        if(userService.update(tempUser))  return (new ResponseEntity(HttpStatus.ACCEPTED));
        return (new ResponseEntity(HttpStatus.BAD_REQUEST));
    }
    
    @CrossOrigin
    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@RequestBody User user){
        User tempUser = userService.findById(user.getId());

        if(tempUser != null){
            userService.delete(tempUser);
            return (new ResponseEntity(HttpStatus.ACCEPTED));
        }
        return (new ResponseEntity(HttpStatus.BAD_REQUEST));
    }
    
    private User updateCheck(User user, User tempUser){
        if(user.getEmail() != null) tempUser.setEmail(user.getEmail());
        if(user.getName() != null) tempUser.setName(user.getName());
        if(user.getCompanyId() != null) tempUser.setCompanyId(user.getCompanyId());
        return(tempUser);
    }
}
