package com.mahmoud.ordermanagement.orderservice.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Value;




public class CreateOrderDTO {
	
	private String itemType;
	private String currency;
	private BigDecimal price;
	
	
	public void setPrice(BigDecimal price) {
		this.price=price;
	}


	public String getItemType() {
		return itemType;
	}


	public void setItemType(String itemType) {
		this.itemType = itemType;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public BigDecimal getPrice() {
		return price;
	}
	
	

}
