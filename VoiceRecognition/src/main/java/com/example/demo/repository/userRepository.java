package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.User;


public interface userRepository extends JpaRepository<User, Integer> {

}
