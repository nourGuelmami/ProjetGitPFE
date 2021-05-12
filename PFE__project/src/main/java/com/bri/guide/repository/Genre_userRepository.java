package com.bri.guide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bri.guide.model.Genre_user;

public interface Genre_userRepository extends JpaRepository<Genre_user, Integer> {
  
}
