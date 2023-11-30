package com.example.demo2.dto;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.example.demo2.entityDAO.Sale;

@Mapper(componentModel = "spring")
public interface SaleMapper {
	SaleMapper MAPPER = Mappers.getMapper(SaleMapper.class);
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateSale(SaleDto saleDto, @MappingTarget Sale sale);	
}
