package com.firstApp.demo1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firstApp.demo1.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
  
}
