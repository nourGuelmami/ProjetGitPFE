package com.bri.guide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bri.guide.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {

}
