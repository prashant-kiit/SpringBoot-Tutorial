package com.example.demo2.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo2.dto.SaleDto;
import com.example.demo2.entityDAO.Sale;
import com.example.demo2.repository.SaleRepo;

@Service
public class ServiceImpl implements ServiceInterface {

	@Autowired
	SaleRepo saleRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<Sale> findBySellerFirstLetterService(Character ch) {
		return saleRepo.findBySellerFirstLetter(ch);
	}

	@Override
	@Transactional
	public void updateEntityByDto(SaleDto saleDto) {
		Sale sale = modelMapper.map(saleDto, Sale.class);
		sale.setSaleId(saleDto.getSaleId());
		// System.out.println(sale.toString());
		saleRepo.save(sale);		
	}
}
