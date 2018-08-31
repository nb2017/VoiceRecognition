package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.Voice;


public interface voiceRepository extends JpaRepository<Voice, Integer> {

}
