package com.bri.guide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bri.guide.model.Newsletter;

public interface NewsletterRepository extends JpaRepository<Newsletter, Integer> {

}
