package com.example.securitydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securitydemo.entity.Userdetail;

public interface UserdetailRepo extends JpaRepository<Userdetail, String>{

}
