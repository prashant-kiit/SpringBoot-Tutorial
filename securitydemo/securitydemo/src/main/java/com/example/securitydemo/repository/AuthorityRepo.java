package com.example.securitydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.securitydemo.entity.Authority;

public interface AuthorityRepo extends JpaRepository<Authority, String>{

}
