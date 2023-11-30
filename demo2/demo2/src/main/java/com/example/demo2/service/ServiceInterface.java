package com.example.demo2.service;

import java.util.List;

import com.example.demo2.dto.SaleDto;
import com.example.demo2.entityDAO.Sale;

public interface ServiceInterface {
	List<Sale> findBySellerFirstLetterService(Character ch);
	void updateEntityByDto(SaleDto saleDto);
}
