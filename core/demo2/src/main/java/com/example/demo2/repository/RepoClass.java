package com.example.demo2.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

@Repository
public class RepoClass implements SaleRepoOther{
	EntityManager entityManager;
}
