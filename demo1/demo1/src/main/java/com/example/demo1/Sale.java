package com.example.demo1;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;

@Entity
public class Sale {
	@Id
	private int saleId;
	private String seller;
	private String buyer;
	private String dateOfSale;
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
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
	public String getDateOfSale() {
		return dateOfSale;
	}
	public void setDateOfSale(String dateOfSale) {
		this.dateOfSale = dateOfSale;
	}
	@Override
	public String toString() {
		return "Sale [saleId=" + saleId + ", seller=" + seller + ", buyer=" + buyer + ", dateOfSale=" + dateOfSale
				+ "]";
	}
	
	
}
