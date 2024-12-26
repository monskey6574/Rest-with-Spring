package com.firstApp.demo1.service;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstApp.demo1.dto.UserDTO;
import com.firstApp.demo1.model.User;
import com.firstApp.demo1.repo.UserRepo;


@Service
@Transactional

public class UserService {

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private ModelMapper modelMapper;

  public List<UserDTO> getAllUsers() {
    List<User>userList = userRepo.findAll(); 
    return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    
  
}
  public UserDTO saveUser(UserDTO UserDTO){
    userRepo.save(modelMapper.map(UserDTO, User.class));
    return UserDTO;
  }


}
