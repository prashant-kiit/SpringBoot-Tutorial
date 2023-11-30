package com.example.demo2.security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepo extends JpaRepository<Authority, String> {

}
