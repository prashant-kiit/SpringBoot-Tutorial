package com.example.demo2.dto;

import java.util.Date;

public class SaleDto {

	private Integer saleId;	
	private String seller;
	private String buyer;
	private Date dateOfSale;
	
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public Date getDateOfSale() {
		return dateOfSale;
	}
	public void setDateOfSale(Date dateOfSale) {
		this.dateOfSale = dateOfSale;
	}
	@Override
	public String toString() {
		return "SaleDto [saleId=" + saleId + ", seller=" + seller + ", buyer=" + buyer + ", dateOfSale=" + dateOfSale
				+ "]";
	}
	
	
}
