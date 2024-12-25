package com.firstApp.demo1.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor

@Data
@AllArgsConstructor
public class User {
  @Id
  private Integer id;
  private String name;
  private String email;

  




  
}
