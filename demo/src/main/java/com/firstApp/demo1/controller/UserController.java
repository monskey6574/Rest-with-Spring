package com.firstApp.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.firstApp.demo1.dto.UserDTO;
import java.util.List;

import com.firstApp.demo1.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/")
public class UserController {
    @Autowired
    private  UserService userService;


    @GetMapping("/users")
    public List<UserDTO> getUser() {
        
        return userService.getAllUsers();

    }

    @PostMapping("/adduser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @PutMapping("user/{id}")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }
    @DeleteMapping("user/{id}")
    public String deleteUser(@RequestBody UserDTO userDTO){
        return userService.deleteUser(userDTO);
    }


    
    



  
}
