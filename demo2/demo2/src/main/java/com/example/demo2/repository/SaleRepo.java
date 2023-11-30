package com.example.demo2.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.Query;
import com.example.demo2.entityDAO.Sale;

// This will be AUTO IMPLEMENTED by Spring into a Bean called saleRepo
// CRUD refers Create, Read, Update, Delete
// http://localhost:8081
// http://localhost:8081/sales
// http://localhost:8081/sales/1
// http://localhost:8081/sales/search
// http://localhost:8081/sales?page=0&size=20&sort=seller,desc
// @RepositoryRestResource(path="mysales")
public interface SaleRepo extends JpaRepository<Sale, Integer> {
	
	Iterable<Sale> findByDateOfSaleBetween(Date d1, Date d2);
	
	// http://localhost:8081/sales/search/findBySellerFirstLetter?ch=S
	@Query(value = "select * from Sale where seller like ?1%", nativeQuery = true)
	List<Sale> findBySellerFirstLetter(Character ch);
	
	// these method can be defined in another class(DAO) which 
	// implements SaleRepo Interface
}