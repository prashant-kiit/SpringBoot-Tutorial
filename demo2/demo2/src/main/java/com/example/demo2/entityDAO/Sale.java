package com.example.demo2.entityDAO;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
// @JsonInclude(Include.NON_NULL)
public class Sale {
	// dimensions
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer saleId;	
	private String seller;
	private String buyer;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
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
		return "Sale [saleId=" + saleId + ", seller=" + seller + ", buyer=" + buyer + ", dateOfSale=" + dateOfSale
				+ "]";
	}	
	
	
}
